package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Asignatura;
import com.example.demo.repository.AsignaturaRepository;

@RestController
public class AsignaturaController
{
	@Autowired
	AsignaturaRepository asignaturaRepository;

	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck()
	{
		return "{ \"isWorking\" : true }";
	}

	@GetMapping("/asignaturas")
	public List<Asignatura> getAsignaturas()
	{
		Iterable<Asignatura> result = asignaturaRepository.findAll();
		List<Asignatura> asignaturaList = new ArrayList<Asignatura>();
		result.forEach(asignaturaList::add);
		return asignaturaList;
	}

	@GetMapping("/asignatura/{id}")
	public Optional<Asignatura> getAsignatura(@PathVariable Integer id)
	{
		Optional<Asignatura> emp = asignaturaRepository.findById(id);
		return emp;
	}

	@PutMapping("/asignatura/{id}")
	public Optional<Asignatura> updateAsignatura(@RequestBody Asignatura newAsignatura, @PathVariable Integer id)
	{
		Optional<Asignatura> optionalEmp = asignaturaRepository.findById(id);
		if (optionalEmp.isPresent()) {
			Asignatura emp = optionalEmp.get();
			emp.setIdProfesor(newAsignatura.getIdProfesor());
			emp.setIdEdificio(newAsignatura.getIdEdificio());
			emp.setPrograma(newAsignatura.getPrograma());
			emp.setCreditos(newAsignatura.getCreditos());
			emp.setCupos(newAsignatura.getCupos());
			emp.setDescripcion(newAsignatura.getDescripcion());
			emp.setDuracion(newAsignatura.getDuracion());
			emp.setFechaFinal(newAsignatura.getFechaFinal());
			emp.setFechaInicio(newAsignatura.getFechaInicio());
			emp.setHorario(newAsignatura.getHorario());
			emp.setJornada(newAsignatura.getJornada());
			emp.setNivelDeEstudio(newAsignatura.getNivelDeEstudio());
			emp.setNombreAsignatura(newAsignatura.getNombreAsignatura());
			emp.setPrerequisitos(newAsignatura.getPrerequisitos());
			emp.setSede(newAsignatura.getSede());
			emp.setTipologia(newAsignatura.getTipologia());
			asignaturaRepository.save(emp);
		}
		return optionalEmp;
	}

	@DeleteMapping(value = "/asignatura/{id}", produces = "application/json; charset=utf-8")
	public String deleteEmployee(@PathVariable Integer id) {
		Boolean result = asignaturaRepository.existsById(id);
		asignaturaRepository.deleteById(id);
		return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	}


	@PostMapping("/asignatura")
	public Asignatura addEmployee(@RequestBody Asignatura newAsignatura)
	{
		Integer id = Integer.valueOf(new Random().nextInt());
		Asignatura emp = new Asignatura(id, newAsignatura.getCreditos(), newAsignatura.getCupos(), newAsignatura.getDescripcion(),newAsignatura.getDuracion(),newAsignatura.getFechaFinal(),newAsignatura.getFechaInicio(),newAsignatura.getHorario(),newAsignatura.getJornada(),newAsignatura.getIdEdificio(),newAsignatura.getNombreAsignatura(),newAsignatura.getIdProfesor(),newAsignatura.getPrograma(),newAsignatura.getNivelDeEstudio(),newAsignatura.getSede(),newAsignatura.getTipologia(),newAsignatura.getPrerequisitos());
		asignaturaRepository.save(emp);
		return emp;
	}


}
