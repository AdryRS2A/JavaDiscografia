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

import eu.NegozioDiscografico.Model.Canzone;
import eu.NegozioDiscografico.Repository.CanzoneRepository;
import eu.NegozioDiscografico.Service.CanzoneService;

@RestController
@RequestMapping("/api")
public class CanzoneController {
	
	@Autowired
	CanzoneService cSer;
	
	@GetMapping("/canzoni")
	public List<Canzone> getAllCanzone(){
		
		return cSer.allCanzoni();
		
	}
	
	@GetMapping("/canzoni{id}")
	public Canzone unaCanzone(@PathVariable(value="id")Long idCanzone) {
		
		return cSer.getOneCanzoneById(idCanzone);
		
	}

	@PostMapping("/canzoni")
	public Canzone creaCanzone(@Valid @RequestBody Canzone canzoneNew) {
		
		return cSer.CreateNewCanzone(canzoneNew);
		
	}
	
	@PutMapping("/canzoni{id}")
	public Canzone putCanzone(@PathVariable(value="id")Long idCanzone, @Valid @RequestBody Canzone canzone) {
		
		return cSer.modifyCanzone(idCanzone, canzone);
		
	}
	
	@DeleteMapping("/canzoni{id}")
	public void deleteCanzone(@PathVariable(value="id")Long idCanzone) {
		
		 cSer.deleteCanzone(idCanzone);
		
	}
	@GetMapping("/canzoni/title{title}")
	public List <Canzone> findByTitle(@PathVariable (value="title")String title) {
		
		return cSer.findByTitle(title);
		
	}
}
