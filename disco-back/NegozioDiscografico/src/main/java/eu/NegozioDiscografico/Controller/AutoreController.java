package eu.NegozioDiscografico.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.NegozioDiscografico.Model.Autore;
import eu.NegozioDiscografico.Service.AutoreService;

@RestController
@RequestMapping("/api")
public class AutoreController {

	@Autowired
	AutoreService autSer;

	
	@GetMapping("/autori")
	public List<Autore> allAutore() {

		return autSer.getAllAutore();

	}

	@GetMapping("/autori{id}")
	public Autore OneAutore(@PathVariable(value="id") Long idAut) {

		return autSer.getOneAutoreById(idAut);

	}

	@PostMapping("/autori")
	public Autore creaAutore(@Valid @RequestBody Autore autore) {

		return autSer.newAutore(autore);

	}

	@PutMapping("/autori{id}")
	public Autore putAutore(@PathVariable(value="id")Long idAutore,@Valid @RequestBody Autore autore) {

		return autSer.modifyAutore(idAutore, autore);

	}

	@DeleteMapping("/autori{id}")
	public void deleteAutore(@PathVariable(value="id")Long idAutore) {

		autSer.deleteAutore(idAutore);

	}
}
