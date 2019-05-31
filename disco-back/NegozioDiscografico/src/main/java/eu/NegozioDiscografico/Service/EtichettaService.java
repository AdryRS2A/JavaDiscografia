package eu.NegozioDiscografico.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eu.NegozioDiscografico.Exeption.NotFoundException;
import eu.NegozioDiscografico.Model.Etichetta;
import eu.NegozioDiscografico.Repository.AlbumRepository;
import eu.NegozioDiscografico.Repository.EtichettaRepository;

public class EtichettaService {

	@Autowired
	private EtichettaRepository etichettaRep;

	@Transactional
	public List<Etichetta> getAll() {

		return etichettaRep.findAll();

	}

	@Transactional
	public Etichetta findOneById(String pIva) {

		return etichettaRep.findById(pIva).orElseThrow(() -> new NotFoundException("Etichetta", "Partita Iva", pIva));

	}

	@Transactional
	public void deleteEtichetta(String pIva) {

		Etichetta ff = etichettaRep.findById(pIva)
				.orElseThrow(() -> new NotFoundException("Etichetta", "Partita Iva", pIva));

		etichettaRep.delete(ff);
	}

	// questo metodo è utile se vuoi creare una nuova etichetta in back-end
	@Transactional
	public Etichetta newEtichetta(String pIva, String ragioneSociale) {

		Etichetta etc = new Etichetta();
		etc.setPartitaIva(pIva);
		etc.setRagioneSociale(ragioneSociale);
		return etichettaRep.save(etc);
	}

	// questo metodo serve per creare una nuova etichetta che però sarà settata in
	// front-end
	@Transactional
	public Etichetta creaEtichetta(Etichetta etNew) {

		return etichettaRep.save(etNew);

	}

	// per modificare etichetta in back-END
	@Transactional
	public Etichetta modifyEtichetta(String pIva, String ragioneSociale) {

		Etichetta roar = etichettaRep.findById(pIva)
				.orElseThrow(() -> new NotFoundException("Etichetta", "Partita Iva", pIva));

		roar.setRagioneSociale(ragioneSociale);

		return etichettaRep.save(roar);
	}

}
