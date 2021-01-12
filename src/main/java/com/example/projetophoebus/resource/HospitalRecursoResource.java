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
import com.example.projetophoebus.model.HospitalRecurso;
import com.example.projetophoebus.repository.HospitalRecursoRepository;

import io.swagger.annotations.Api;

@RestController	
@RequestMapping("/hospital_recurso")
@Api(value="Api Rest Hospital")
@CrossOrigin(origins="*")
public class HospitalRecursoResource{
	
	@Autowired
	private HospitalRecursoRepository hospitalRecursoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<HospitalRecurso> listar() {
		return hospitalRecursoRepository.findAll();
	}
	@GetMapping("/{id_hosp_rec}")
	public HospitalRecurso buscarPeloCodigo(@PathVariable Long id_hosp_rec) {
		return this.hospitalRecursoRepository.findById(id_hosp_rec).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<HospitalRecurso> criar(@Valid @RequestBody HospitalRecurso hospitalrecurso,HttpServletResponse response) {
		HospitalRecurso hospitalSalvo = hospitalRecursoRepository.save(hospitalrecurso);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, hospitalSalvo.getId_hosp_rec()));
		return ResponseEntity.status(HttpStatus.CREATED).body(hospitalSalvo);
	}
	@PutMapping("/{id_hosp_rec}")
	public HospitalRecurso atualizar (@PathVariable Long id_hosp_rec, @Valid @RequestBody HospitalRecurso hospitalrecurso){
		Optional<HospitalRecurso> hospitalRecursolOptional = this.hospitalRecursoRepository.findById(id_hosp_rec);
		if(hospitalRecursolOptional.isPresent()) { 
			HospitalRecurso hospitalSalvo= hospitalRecursolOptional.get();
			BeanUtils.copyProperties (hospitalrecurso,hospitalSalvo, "id_hosp_rec");
			this.hospitalRecursoRepository.save(hospitalSalvo);
			return hospitalSalvo;
		}
		else return null;
	}
	
	@DeleteMapping("/{id_hosp_rec}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id_hosp_rec) {
		hospitalRecursoRepository.deleteById(id_hosp_rec);
	}
}
