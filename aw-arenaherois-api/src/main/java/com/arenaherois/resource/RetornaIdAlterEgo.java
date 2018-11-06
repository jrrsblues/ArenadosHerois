package com.arenaherois.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arenaherois.model.Heroi;
import com.arenaherois.service.HeroiService;

@CrossOrigin("*")
@RestController
@RequestMapping("/idalteregos")
public class RetornaIdAlterEgo {
	
	@Autowired
	private HeroiService heroiService;
	
	@GetMapping
	public List<Heroi> retornaIdAlterEgo(){
		return heroiService.listaridalterego();
	}

}
