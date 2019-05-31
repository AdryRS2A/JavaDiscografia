package eu.NegozioDiscografico.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.NegozioDiscografico.Exeption.NotFoundException;
import eu.NegozioDiscografico.Model.Autore;
import eu.NegozioDiscografico.Repository.AutoreRepository;
@Service
public class AutoreService {

	@Autowired
	AutoreRepository autoreRep;

	@Transactional
	public List<Autore> getAllAutore() {
		return autoreRep.findAll();
	}

	@Transactional
	public Autore getOneAutoreById(Long idAutore) {

		return autoreRep.findById(idAutore)
				.orElseThrow(() -> new NotFoundException("Autore", "Id dell'Autore", idAutore));

	}

	@Transactional
	public Autore newAutore(Autore newAutore) {

		return autoreRep.save(newAutore);
	}

	@Transactional
	public void deleteAutore(Long idAutore) {

		Autore aut = autoreRep.findById(idAutore)
				.orElseThrow(() -> new NotFoundException("Autore", "Id dell'Autore", idAutore));
		autoreRep.delete(aut);
	}

	@Transactional
	public Autore modifyAutore(Long idAutore, Autore autoreDaCopiare) {

		Autore autoreRicercato = autoreRep.findById(idAutore)
				.orElseThrow(() -> new NotFoundException("Autore", "Id dell'Autore", idAutore));
		autoreRicercato.setAlbumIncisi(autoreDaCopiare.getAlbumIncisi());
		autoreRicercato.setLingua(autoreDaCopiare.getLingua());
		autoreRicercato.setNome(autoreDaCopiare.getNome());
		Autore autoreNew = autoreRep.save(autoreRicercato);

		return autoreNew;

	}
}
