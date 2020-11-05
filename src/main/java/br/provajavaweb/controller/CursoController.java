package br.provajavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.provajavaweb.domain.Curso;
import br.provajavaweb.service.CursoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrarCurso() {
		ModelAndView mv = new ModelAndView("curso/cadastrar");
		mv.addObject("curso", new Curso());
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarCursos() {
		ModelAndView mv = new ModelAndView("curso/listar");
		mv.addObject("curso", cursoService.findAll());
		return mv;
	}
	
	@GetMapping("/listarindex")
	public ModelAndView listarIndex() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("curso", cursoService.findAll());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarCurso(Curso curso) {
		cursoService.cursoSalvar(curso);
		return listarCursos();
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarCurso(@PathVariable("id") Integer id) {
		cursoService.Excluir(id);
		return listarCursos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCurso(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("curso/alterar");
		mv.addObject("curso", cursoService.findById(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Curso curso) throws ObjectNotFoundException {
		cursoService.Editar(curso);
		return listarCursos();
	}
}
