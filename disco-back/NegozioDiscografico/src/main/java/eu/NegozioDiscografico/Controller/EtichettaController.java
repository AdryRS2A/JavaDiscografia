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

import eu.NegozioDiscografico.Model.Etichetta;
import eu.NegozioDiscografico.Service.EtichettaService;

@RestController
@RequestMapping("/api")
public class EtichettaController {
	
	@Autowired
	EtichettaService etServ;

	@GetMapping("/etichette")
	public List<Etichetta> dammiTutteLeEtichette(){
		
		return etServ.getAll();
	}
	@GetMapping("/etichette{id}")
	public Etichetta dammiUnaEtichetta(@PathVariable(value="id") String pIva) {
		
		return etServ.findOneById(pIva);
		
	}
	@PostMapping("/etichette")
	public Etichetta CreaEtichetta(@Valid @RequestBody Etichetta et) {
		
		return etServ.creaEtichetta(et);
		
	}
	@PutMapping("/etichette{id}")
	public Etichetta modificaEtic(@PathVariable(value="id") String pIva, String ragioneSociale) {
		
		return etServ.modifyEtichetta(pIva, ragioneSociale);
		
	}
	@DeleteMapping("/etichette{id}")
	public void cancellaEtichetta(@PathVariable(value="id") String pIva) {
		
		etServ.deleteEtichetta(pIva);
	}
}
