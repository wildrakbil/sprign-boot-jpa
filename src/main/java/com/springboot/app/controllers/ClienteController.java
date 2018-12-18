package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.app.models.dao.IClienteDao;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	@Autowired
	@Qualifier("ClienteDaoJPA") //selecciona el bean concreto a usar
	private IClienteDao clienteDao;
	
	@RequestMapping(value="/lsitar",method=RequestMethod.GET)
	public String  listar(Model model) {
		model.addAttribute("titulo","listado de clientes");
		model.addAttribute("Clientes",clienteDao.findAll());
		return "listar";
	}

}
