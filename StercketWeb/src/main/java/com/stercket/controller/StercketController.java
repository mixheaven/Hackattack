package com.stercket.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.stercket.entity.Stercket;
import com.stercket.repository.StercketRepository;


@Controller
public class StercketController {
	
	@Autowired
	StercketRepository stercketRepository;
	
	@GetMapping("/stercket/create")
	public String displayStercketForm(Model model) {
		Stercket stercket = new Stercket();
		model.addAttribute("stercket", stercket);
		return "stercket_form";
	}
	
	@PostMapping("/stercket/create")
	public String createStercket(@Valid Stercket stercket,BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "stercket_form";
		}
		stercketRepository.save(stercket);
		return "show_stercket";
	}
	
	@RequestMapping("/stercket/{id}")
	public String displayStercket(@PathVariable long id, Model model) {
		Optional<Stercket> result = stercketRepository.findById(id);
		if(!result.isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stercket not found");
		}
		model.addAttribute("stercket", result.get());
		return "show_stercket";
	}
	

}
