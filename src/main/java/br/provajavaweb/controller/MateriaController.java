package br.provajavaweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.provajavaweb.domain.Materia;
import br.provajavaweb.domain.Turma;
import br.provajavaweb.service.MateriaService;
import br.provajavaweb.service.ModuloService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("materia")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private ModuloService moduloService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarMateria() {
		ModelAndView mv = new ModelAndView("materia/cadastrar");
		mv.addObject("turma", new Turma());
		mv.addObject("materia", new Materia());
		mv.addObject("modulo", moduloService.findAll());
		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarMateria() {
		ModelAndView mv = new ModelAndView("materia/listar");
		mv.addObject("materia",  new Materia());
		mv.addObject("materia", materiaService.findAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvarMateria(Materia materia) {
		materiaService.materiaSalvar(materia);
		return "redirect:/materia/listar";
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarMateria(@PathVariable("id") Integer id) {
		materiaService.Excluir(id);
		return listarMateria();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarMateria(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("materia/alterar");
		mv.addObject("materia", materiaService.findById(id));
		mv.addObject("modulo", moduloService.findAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Materia materia) throws ObjectNotFoundException {
		materiaService.Editar(materia);
		return listarMateria();
	}
}
