package com.arenaherois.resource;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arenaherois.model.Heroi;
import com.arenaherois.model.Heroi_copy;
import com.arenaherois.repository.Herois_copy;
import com.arenaherois.service.HeroiService;

@CrossOrigin("*")
@RestController
@RequestMapping("/alteregos")
public class IdAlterEgoResource {
	
	@Autowired
	private HeroiService heroiService;
	
	@Autowired
	private Herois_copy herois_copy;
	
	@GetMapping
	public Heroi listar(){
		List<Heroi_copy> lista = new ArrayList<Heroi_copy>();
		lista = herois_copy.findAll();
		Heroi heroi = new Heroi();
		for (int x=0 ; x< lista.size() ; x++) {
			 heroi.setId(lista.get(x).getId());
			 heroi.setAlterego(lista.get(x).getAlterego());
			 heroi.setNome(lista.get(x).getNome());
			 heroi.setPoder(lista.get(x).getPoder());
			 heroi.setCores(lista.get(x).getCores());
			 heroi.setCriador(lista.get(x).getCriador());
			 heroi.setDatacriacao(lista.get(x).getDatacriacao());
			 heroi.setSinopse(lista.get(x).getSinopse());
			 heroi.setUniverso(lista.get(x).getUniverso());
			 heroi.setCaminhofigura(lista.get(x).getCaminhofigura());
			 heroi.setNemesis(lista.get(x).getNemesis());
        }
		return heroi;
	}
	
	@PostMapping
	public Heroi retornaheroi(@RequestBody @Valid Heroi heroi) {
		return heroiService.retornaHeroi(heroi.getId());
	}

}
