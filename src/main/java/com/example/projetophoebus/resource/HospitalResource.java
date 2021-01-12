package com.example.projetophoebus.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetophoebus.event.RecursoCriadoEvent;
import com.example.projetophoebus.model.Hospital;
import com.example.projetophoebus.repository.HospitalRepository;

import io.swagger.annotations.Api;

@RestController	
@RequestMapping("/hospital")
@Api(value="Api Rest Hospital")
@CrossOrigin(origins="*")


public class HospitalResource {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@GetMapping
	public List<Hospital> listar() {
		return hospitalRepository.findAll();
	}

	@GetMapping("/{id_hospital}")
	public Hospital buscarPeloCodigo(@PathVariable Long id_hospital) {
		return this.hospitalRepository.findById(id_hospital).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Hospital> criar(@Valid @RequestBody Hospital hospital,HttpServletResponse response) {
		Hospital hospitalSalvo = hospitalRepository.save(hospital);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, hospitalSalvo.getId_hospital()));
		return ResponseEntity.status(HttpStatus.CREATED).body(hospitalSalvo);
	}
	
	@PutMapping("/{id_hospital}")
	public Hospital atualizar (@PathVariable Long id_hospital, @Valid @RequestBody Hospital hospital){
		Optional<Hospital> hospitalOptional = this.hospitalRepository.findById(id_hospital);
		if(hospitalOptional.isPresent()) { 
			Hospital hospitalSalvo= hospitalOptional.get();
			BeanUtils.copyProperties (hospital,hospitalSalvo, "id_hospital");
			this.hospitalRepository.save(hospitalSalvo);
			return hospitalSalvo;
		}
		else return null;
	}
	@DeleteMapping("/{id_hospital}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id_hospital) {
		hospitalRepository.deleteById(id_hospital);	
	}
}
