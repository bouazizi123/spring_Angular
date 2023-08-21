package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Demande;
import net.javaguides.springboot.repository.DemandeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DemandeController {

	@Autowired
	private DemandeRepository demandeRepository;
	
	// get all employees
	@GetMapping("/demandes")
	public List<Demande> getAllDemandes(){
		return demandeRepository.findAll();
	}		
	

	@PostMapping("/add-demande")
    public ResponseEntity<?> createDemande(@RequestBody Demande demande) {
        if (demande.isValidIce()) {
            Demande createdDemande = demandeRepository.save(demande);
            return ResponseEntity.ok(createdDemande);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid ICE value");
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
	
	// get employee by id rest api
	@GetMapping("/demande/{id}")
	public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("demande not exist with id :" + id));
		return ResponseEntity.ok(demande);
	}
	
	// update 
	
	@PutMapping("/demande-update/{id}")
	public ResponseEntity<?> updateDemande(@PathVariable Long id, @RequestBody Demande demandeDetails) {
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Demande not exist with id :" + id));
		
		demande.setTypeContact(demandeDetails.getTypeContact());
		demande.setPrenom(demandeDetails.getPrenom());
		demande.setNom(demandeDetails.getNom());
		demande.setRaisanSociale(demandeDetails.getRaisanSociale());

		Long updatedIce = demandeDetails.getICE();
		if (updatedIce != null && updatedIce >= 111111111111111L && updatedIce <= 999999999999999L) {
			demande.setICE(updatedIce);
		} else {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", "Invalid ICE value");
			return ResponseEntity.badRequest().body(errorResponse);
		}

		demande.setAdresse(demandeDetails.getAdresse());
		demande.setTelephone(demandeDetails.getTelephone());
		demande.setMobile(demandeDetails.getMobile());
		demande.setEmail(demandeDetails.getEmail());
		demande.setTypeDemande(demandeDetails.getTypeDemande());
		demande.setDescription(demandeDetails.getDescription());

		Demande updatedDemande = demandeRepository.save(demande);
		return ResponseEntity.ok(updatedDemande);
	}

	
	// delete 
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDemande(@PathVariable Long id){
		Demande demande = demandeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("demande not exist with id :" + id));
		
		demandeRepository.delete(demande);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
