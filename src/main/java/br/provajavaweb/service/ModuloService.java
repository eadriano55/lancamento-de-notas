package br.provajavaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.provajavaweb.domain.Modulo;
import br.provajavaweb.repository.ModuloRepository;

@Service
public class ModuloService {

	@Autowired
	private ModuloRepository repository;

	public List<Modulo> findAll() {
		return repository.findAll();
	}

	public Modulo findById(Integer moduloId) {
		return repository.findById(moduloId).get();
	}

	public Modulo moduloSalvar(Modulo modulo) {
		return repository.save(modulo);
	}

	public void excluirModulo(Integer id) {
		repository.deleteById(id);

	}

	public Modulo editar(Modulo modulo) {
		Modulo moduloAntigo = findById(modulo.getModuloId());
		moduloAntigo.setNome(modulo.getNome());
		return moduloSalvar(moduloAntigo);
	}
}
