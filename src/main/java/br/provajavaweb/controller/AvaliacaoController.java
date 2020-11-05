package br.provajavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.provajavaweb.domain.Avaliacao;
import br.provajavaweb.service.AlunoService;
import br.provajavaweb.service.AvaliacaoService;
import br.provajavaweb.service.MateriaService;

@Controller
@RequestMapping("avaliacao")
public class AvaliacaoController {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	MateriaService materiaService;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAvaliacao() {
		ModelAndView mv = new ModelAndView("avaliacao/cadastrar");
		mv.addObject("aluno", alunoService.findAll());
		mv.addObject("materia", materiaService.findAll());
		mv.addObject("avaliacao", new Avaliacao());
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarAvaliacao() {
		ModelAndView mv = new ModelAndView("avaliacao/listar");
		mv.addObject("avaliacao", avaliacaoService.findAll());
		return mv;
	}
	
	@PostMapping("/salvar")
	public String salvarAvaliacao(@ModelAttribute("avaliacao") Avaliacao avaliacao) {
		avaliacao.getAlunoMateria().setAluno(alunoService.findById(avaliacao.getAlunoMateria().getAluno().getAlunoId()));
		avaliacao.getAlunoMateria().setMateria(materiaService.findById(avaliacao.getAlunoMateria().getMateria().getMateriaId()));
		avaliacaoService.save(avaliacao);
		return "redirect:/avaliacao/listar";
	} 
	
	@GetMapping
	public ModelAndView chamaPagina() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	@GetMapping("/botao")
	public ModelAndView botao() {
		ModelAndView mv = new ModelAndView("botao");
		return mv;
	}
	@GetMapping("/cards")
	public ModelAndView cards() {
		ModelAndView mv = new ModelAndView("cards");
		return mv;
	}
	@GetMapping("/cores")
	public ModelAndView cores() {
		ModelAndView mv = new ModelAndView("cores");
		return mv;
	}
	@GetMapping("/bordas")
	public ModelAndView bordas() {
		ModelAndView mv = new ModelAndView("bordas");
		return mv;
	}
	@GetMapping("/animacoes")
	public ModelAndView animacoes() {
		ModelAndView mv = new ModelAndView("animacoes");
		return mv;
	}
}
