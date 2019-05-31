package eu.NegozioDiscografico.Service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eu.NegozioDiscografico.Exeption.NotFoundException;
import eu.NegozioDiscografico.Model.Album;
import eu.NegozioDiscografico.Repository.AlbumRepository;
import eu.NegozioDiscografico.Repository.AutoreRepository;
import eu.NegozioDiscografico.Repository.CanzoneRepository;
import eu.NegozioDiscografico.Repository.EtichettaRepository;

public class AlbumService {

	@Autowired
	EtichettaRepository etRep;

	@Autowired
	AutoreRepository autRep;

	@Autowired
	CanzoneRepository CanzoneRep;

	@Autowired
	AlbumRepository albumRep;

	@Transactional
	public List<Album> getAllAlbum() {

		List<Album> coll = albumRep.findAll();
		coll.stream().forEach(index -> Hibernate.initialize(index.getAutoreAlbum()));
		coll.stream().forEach(index -> Hibernate.initialize(index.getEtichettaAlbum()));
		return coll;

	}
	@Transactional
	public Album getAlbumFindId(Long idAlbum) {

		Album riceviAlbum = albumRep.findById(idAlbum)
				.orElseThrow(() -> new NotFoundException("In Album: ", "non trovato codice con ID ", idAlbum));

		Hibernate.initialize(riceviAlbum.getAutoreAlbum());
		Hibernate.initialize(riceviAlbum.getEtichettaAlbum());
		return riceviAlbum;
	}
	@Transactional
	public Album createNewAlbum(Album albumNew) {

		Hibernate.initialize(albumNew.getEtichettaAlbum());
		Hibernate.initialize(albumNew.getEtichettaAlbum());
		return albumRep.save(albumNew);
	}
	@Transactional
	public Album putAlbum(Long idAlbum, Album copiaAlbum) {

		Album ricercaAlbum = albumRep.findById(idAlbum)
				.orElseThrow(() -> new NotFoundException("In Album: ", "non trovato codice con ID ", idAlbum));
		ricercaAlbum.setAutoreAlbum(copiaAlbum.getAutoreAlbum());
		ricercaAlbum.setDataPubblicazione(copiaAlbum.getDataPubblicazione());
		ricercaAlbum.setDurataAlbum(copiaAlbum.getDurataAlbum());
		ricercaAlbum.setEtichettaAlbum(copiaAlbum.getEtichettaAlbum());
		ricercaAlbum.setGenereAlbum(copiaAlbum.getGenereAlbum());
		ricercaAlbum.setnCd(copiaAlbum.getnCd());
		ricercaAlbum.setNomeAlbum(copiaAlbum.getNomeAlbum());
		ricercaAlbum.setPrezzoAlbum(copiaAlbum.getPrezzoAlbum());

		Album albumNew = albumRep.save(ricercaAlbum);
		Hibernate.initialize(albumNew.getEtichettaAlbum());
		Hibernate.initialize(albumNew.getAutoreAlbum());
		return albumNew;

	}
	@Transactional
	public void deleteAlbum(Long idAlbum) {
		
		Album cc=albumRep.findById(idAlbum).orElseThrow(() -> new NotFoundException("In Album: ", "non trovato codice con ID ", idAlbum));
		albumRep.delete(cc);
	}
}
