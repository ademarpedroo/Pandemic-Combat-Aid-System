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
import com.example.projetophoebus.model.Recurso;
import com.example.projetophoebus.repository.RecursoRepository;

import io.swagger.annotations.Api;

@RestController	
@RequestMapping("/recurso")
@Api(value="Api Rest Hospital")
@CrossOrigin(origins="*")
public class RecursoResource {

	@Autowired
	private RecursoRepository recursoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Recurso> listar() {
		return recursoRepository.findAll();
	}

	@GetMapping("/{id_recurso}")
	public Recurso buscarPeloCodigo(@PathVariable Long id_recurso) {
		return this.recursoRepository.findById(id_recurso).orElse(null);
	}
	
	@DeleteMapping("/{id_recurso}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id_recurso) {
		recursoRepository.deleteById(id_recurso);
	}
	
	@PostMapping
	public ResponseEntity<Recurso> criar(@Valid @RequestBody Recurso recurso,HttpServletResponse response) {
		Recurso recursoSalvo = recursoRepository.save(recurso);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, recursoSalvo.getId_recurso()));
		return ResponseEntity.status(HttpStatus.CREATED).body(recursoSalvo);
	}
	
	@PutMapping("/{id_recurso}")
	public Recurso atualizar (@PathVariable Long id_recurso, @Valid @RequestBody Recurso recurso){
		Optional<Recurso> recursoOptional = this.recursoRepository.findById(id_recurso);
		if(recursoOptional.isPresent()) { 
			Recurso recursoSalvo= recursoOptional.get();
			BeanUtils.copyProperties (recurso,recursoSalvo, "id_recurso");
			this.recursoRepository.save(recursoSalvo);
			return recursoSalvo;
		}
		else return null;
	}
	
}
