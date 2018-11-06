package com.arenaherois.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arenaherois.model.Vencedor;
import com.arenaherois.service.HeroiService;

@CrossOrigin("*")
@RestController
@RequestMapping("/vencedor")
public class VencedorResources {
	
	@Autowired
	HeroiService heroiService;
	
	@GetMapping
	public Vencedor listar(){
		return heroiService.retornaVencedor();
	}

}
