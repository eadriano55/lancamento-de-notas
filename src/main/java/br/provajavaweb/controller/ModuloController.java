package br.provajavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.provajavaweb.domain.Modulo;
import br.provajavaweb.service.CursoService;
import br.provajavaweb.service.ModuloService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("modulo")
public class ModuloController {

	@Autowired
	private ModuloService moduloService;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarModulo() {
		ModelAndView mv = new ModelAndView("modulo/cadastrar");
		mv.addObject("modulo", new Modulo());
		mv.addObject("curso", cursoService.findAll());
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarModulo() {
		ModelAndView mv = new ModelAndView("modulo/listar");
		mv.addObject("modulo", moduloService.findAll());
		return mv;
	}
	@PostMapping("/salvar")
	public String salvarModulo(Modulo modulo) {
		moduloService.moduloSalvar(modulo);
		return "redirect:/modulo/listar";
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarModulo(@PathVariable("id") Integer id) {
		moduloService.excluirModulo(id);
		return listarModulo();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarModulo(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("modulo/alterar");
		mv.addObject("modulo", moduloService.findById(id));
		mv.addObject("curso", cursoService.findAll());
		return mv;
	}
	@PostMapping("/alterar")
	public ModelAndView alterar(Modulo modulo) throws ObjectNotFoundException {
		moduloService.editar(modulo);
		return listarModulo();
	}
}
