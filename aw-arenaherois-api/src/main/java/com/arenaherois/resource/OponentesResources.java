package com.arenaherois.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arenaherois.model.Oponentes;
import com.arenaherois.service.HeroiService;

@CrossOrigin("*")
@RestController
@RequestMapping("/oponentes")
public class OponentesResources {
   
	@Autowired
	HeroiService heroiService;
	
	@PostMapping
	public Oponentes combate(@RequestBody @Valid Oponentes oponentes) {
		return heroiService.gerarResultadoCombate(oponentes);
	}
	
	@GetMapping
	public Oponentes listar(){
		return heroiService.geraOponentes();
	}
	
}
