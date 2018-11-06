package com.arenaherois.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arenaherois.model.Heroi;
import com.arenaherois.model.Heroi_copy;
import com.arenaherois.model.Oponentes;
import com.arenaherois.model.Vencedor;
import com.arenaherois.repository.Herois;
import com.arenaherois.repository.Herois_copy;
import com.arenaherois.repository.Vencedores;
import com.arenaherois.resource.HeroiResources;

@Service
public class HeroiService {
	
	@Autowired
	Optional<Heroi> heroi;
	
	@Autowired
	Herois herois;
	
	@Autowired
	HeroiResources heroiResources;
	
	@Autowired
	Herois_copy herois_copy;
	
	@Autowired
	Vencedores vencedores;
	
	Random gerador = new Random();
	
	@PersistenceContext
	private EntityManager em;
	
	public Oponentes geraOponentes() {
		int totalHeroi = heroiResources.listar().size();
		long idHeroi = 3;
		Heroi oponente = new Heroi();
		Oponentes oponentes = new Oponentes();
		while(idHeroi==3 || idHeroi==0) {
			idHeroi = geradorRandomico(totalHeroi);
		}
		oponente = retornaHeroiAleatorio(idHeroi);
		oponentes.setId1(oponente.getId());
		oponentes.setOponente1(oponente.getAlterego());
		oponentes.setPontuacao1(oponente.getPontos());
		oponentes.setCaminhofigura1(oponente.getCaminhofigura());
		idHeroi = 3;
		while(idHeroi==3 || idHeroi==0) {
			idHeroi = geradorRandomico(totalHeroi);
		}
		oponente = retornaHeroiAleatorio(idHeroi);
		oponentes.setId2(oponente.getId());
		oponentes.setOponente2(oponente.getAlterego());
		oponentes.setPontuacao2(oponente.getPontos());
		oponentes.setCaminhofigura2(oponente.getCaminhofigura());
		return oponentes;
	}
	
	public Oponentes gerarResultadoCombate(Oponentes oponentes) {
		Oponentes combatentes = new Oponentes();
		combatentes.setPontuacao1((int)geradorRandomico(99));
		combatentes.setPontuacao2((int)geradorRandomico(99));
		Heroi lutador = new Heroi();
		lutador = retornaHeroi(oponentes.getId1());
		combatentes.setOponente1(lutador.getAlterego());
		lutador.setPontos(combatentes.getPontuacao1() + lutador.getPontos());
		combatentes.setPontuacao1(combatentes.getPontuacao1() + lutador.getPontos());
		alterar(lutador);
		lutador = retornaHeroi(oponentes.getId2());
		combatentes.setOponente2(lutador.getAlterego());
		lutador.setPontos(combatentes.getPontuacao2() + lutador.getPontos());
		combatentes.setPontuacao2(combatentes.getPontuacao2() + lutador.getPontos());
		alterar(lutador);
		Vencedor vencedor = new Vencedor();
		if(combatentes.getPontuacao1()>combatentes.getPontuacao2()){
			vencedor.setAlterego(combatentes.getOponente1());
			vencedor.setPontos(combatentes.getPontuacao1());
		   }else {
			vencedor.setAlterego(combatentes.getOponente2());
			vencedor.setPontos(combatentes.getPontuacao2());
		}
		vencedores.deleteAll();
		vencedores.save(vencedor);
		return combatentes;
	}
	
	public Heroi retornaHeroi(long id) {
		heroi = herois.findById(id);
		herois_copy.deleteAll();
		Heroi_copy heroy_copy = new Heroi_copy();
		heroy_copy.setId(heroi.get().getId()) ;
		heroy_copy.setAlterego(heroi.get().getAlterego());
		heroy_copy.setCaminhofigura(heroi.get().getCaminhofigura());
		heroy_copy.setCores(heroi.get().getCores());
		heroy_copy.setCriador(heroi.get().getCriador());
		heroy_copy.setDatacriacao(heroi.get().getDatacriacao());
		heroy_copy.setNemesis(heroi.get().getNemesis());
		heroy_copy.setNome(heroi.get().getNome());
		heroy_copy.setSinopse(heroi.get().getSinopse());
		heroy_copy.setPoder(heroi.get().getPoder());
		heroy_copy.setUniverso(heroi.get().getUniverso());
		herois_copy.save(heroy_copy);
		return heroi.get();
	}
	
	public Vencedor retornaVencedor() {
		Vencedor vencedor = new Vencedor();
		List<Vencedor> pegavencedor = new ArrayList<>();
		pegavencedor = vencedores.findAll();
		vencedor.setChave(pegavencedor.get(0).getChave());
		vencedor.setAlterego(pegavencedor.get(0).getAlterego());
		vencedor.setPontos(pegavencedor.get(0).getPontos());
		return vencedor;
	}
	
	public Heroi retornaHeroiAleatorio(long id) {
		heroi = herois.findById(id);
		return heroi.get();
	}

	public Heroi cadastrar(Heroi heroi) {
		heroi.setCaminhofigura(heroi.getAlterego().toLowerCase());
		return herois.save(heroi);
	}
	
	public Heroi alterar(Heroi heroi) {
		return herois.save(heroi);
	}
	
	@SuppressWarnings("unchecked")
	public List<Heroi> listar(){
		Query query = em.createQuery("Select c.universo FROM Heroi c GROUP BY c.universo");
	    return query.getResultList();
	   
	}
	
	@SuppressWarnings("unchecked")
	public List<Heroi> listaridalterego(){
		Query query = em.createQuery("Select c.id FROM Heroi c GROUP BY c.id");
		return query.getResultList();
	}
    
    private long geradorRandomico(int valor){ 
         return gerador.nextInt(valor) + 1;
    }
}
