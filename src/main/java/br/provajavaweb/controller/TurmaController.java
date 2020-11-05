package br.provajavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.provajavaweb.domain.Turma;
import br.provajavaweb.service.CursoService;
import br.provajavaweb.service.ModuloService;
import br.provajavaweb.service.TurmaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private ModuloService moduloService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastrar");
		mv.addObject("turma", new Turma());
		mv.addObject("curso", cursoService.findAll());
		mv.addObject("modulo", moduloService.findAll());
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarTurma() {
		ModelAndView mv = new ModelAndView("turma/listar");
		mv.addObject("turma", turmaService.findAll());
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvarTurma(Turma turma) {
		turmaService.turmaSalvar(turma);
		return "redirect:/turma/listar";
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarTurma(@PathVariable("id") Integer id) {
		turmaService.excluirTurma(id);
		return listarTurma();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarTurma(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("turma/alterar");
		mv.addObject("turma", turmaService.findById(id));
		mv.addObject("curso", cursoService.findAll());
		mv.addObject("modulo", moduloService.findAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Turma turma) throws ObjectNotFoundException {
		turmaService.editarTurma(turma);
		return listarTurma();
	}

}
