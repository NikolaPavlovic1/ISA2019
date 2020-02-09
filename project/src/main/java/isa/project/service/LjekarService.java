package isa.project.service;

import java.util.ArrayList;
import java.util.List;

import isa.project.dto.PretragaLjekaraDTO;
import isa.project.model.Ljekar;
import isa.project.repository.LjekarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LjekarService {

	@SuppressWarnings("unused")
	@Autowired
	private LjekarRepository ljekarRepository;

	public List<Ljekar> pretragaLjekara(PretragaLjekaraDTO pom) {
		ArrayList<Ljekar> lista = new ArrayList<>();
		lista.addAll(pom.getLjekari());

		if (pom.getIme() != "") {
			lista.removeIf(n -> (!n.getIme().equalsIgnoreCase(pom.getIme())));
		}

		if (pom.getPrezime() != "") {
			lista.removeIf(n -> (!n.getPrezime().equalsIgnoreCase(
					pom.getPrezime())));
		}

		if (pom.getOcjena() != 0) {
			lista.removeIf(n -> (n.getOcjena() > pom.getOcjena()));
		}

		return lista;
	}
	
	public Ljekar findLjekarById(long id) {
		return ljekarRepository.findOneById(id);
	}
	
	public void saveLjekar(Ljekar lj) {
		ljekarRepository.save(lj);
	}

}
