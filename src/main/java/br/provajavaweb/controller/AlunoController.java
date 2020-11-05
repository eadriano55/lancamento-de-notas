package br.provajavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.provajavaweb.domain.Aluno;
import br.provajavaweb.service.AlunoService;
import br.provajavaweb.service.TurmaService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAluno() {
		ModelAndView mv = new ModelAndView("aluno/cadastrar");
		mv.addObject("aluno", new Aluno());
		mv.addObject("turma", turmaService.findAll());
		return mv;
	}
	@GetMapping("/listar")
	public ModelAndView listarAluno() {
		ModelAndView mv = new ModelAndView("aluno/listar");
		mv.addObject("aluno", alunoService.findAll());
		return mv;
	}
	@PostMapping("/salvar")
	public String salvarAluno(Aluno aluno) {
		alunoService.alunoSalvar(aluno);
		return "redirect:/aluno/listar";
	}
	@GetMapping("/deletar/{id}")
	public ModelAndView deletarAluno(@PathVariable("id") Integer id) {
		alunoService.excluirAluno(id);
		return listarAluno();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("aluno/alterar");
		mv.addObject("aluno", alunoService.findById(id));
		mv.addObject("turma", turmaService.findAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) throws ObjectNotFoundException {
		alunoService.editarAluno(aluno);
		return listarAluno();
	}
}
