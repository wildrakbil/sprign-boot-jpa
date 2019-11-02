package com.springboot.app.controllers;

import com.springboot.app.models.entity.Cliente;
import com.springboot.app.models.service.IClienteService;
import com.springboot.app.util.paginator.PageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService iClienteService;
	
	@RequestMapping(value="/listar",method=RequestMethod.GET)
	public String  listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page,5);
		Page<Cliente> clientes = iClienteService.finAll(pageRequest);
		PageRender<Cliente>  pageRender = new PageRender<>("/listar",clientes);
		model.addAttribute("titulo","listado de clientes");
		model.addAttribute("clientes",clientes);
		model.addAttribute("page",pageRender);
		return "listar";
	}

}
