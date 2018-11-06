package com.arenaherois.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arenaherois.model.Heroi;
import com.arenaherois.repository.Herois;
import com.arenaherois.service.HeroiService;

@CrossOrigin("*")
@RestController
@RequestMapping("/herois")
public class HeroiResources {

	@Autowired
	private Herois herois;	
	
	@Autowired
	private HeroiService heroiService;
	
	@GetMapping
	public List<Heroi> listar(){
		return herois.findAll();
	}
	
	@PostMapping
	public Heroi cadastro(@RequestBody @Valid Heroi heroi) {
		return heroiService.cadastrar(heroi);
	}
	
	@PutMapping
	public Heroi alterar(@RequestBody @Valid Heroi heroi) {
		return heroiService.alterar(heroi);
	}
	
}
