package com.example.demo.controller;

import com.example.demo.model.Profesores;
import com.example.demo.repository.ProfesoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class ProfesoresController {


        @Autowired
        ProfesoresRepository profesorRepository;

        @GetMapping(value = "/healthcheckProfesores", produces = "application/json; charset=utf-8")
        public String getHealthCheck()
        {
            return "{ \"isWorking\" : true }";
        }

        @GetMapping("/profesores")
        public List<Profesores> getProfesores()
        {
            Iterable<Profesores> result = profesorRepository.findAll();
            List<Profesores> profesorList = new ArrayList<Profesores>();
            result.forEach(profesorList::add);
            return profesorList;
        }

        @GetMapping("/profesor/{id}")
        public Optional<Profesores> getProfesor(@PathVariable Integer id)
        {
            Optional<Profesores> emp = profesorRepository.findById(id);
            return emp;
        }

        @PutMapping("/profesor/{id}")
        public Optional<Profesores> updateProfesor(@RequestBody Profesores newProfesor, @PathVariable Integer id)
        {
            Optional<Profesores> optionalEmp = profesorRepository.findById(id);
            if (optionalEmp.isPresent()) {
                Profesores emp = optionalEmp.get();
                emp.setPrimerNombre(newProfesor.getPrimerNombre());
                emp.setSegundoNombre(newProfesor.getSegundoNombre());
                emp.setPrimerApellido(newProfesor.getPrimerApellido());
                emp.setSegundoApellido(newProfesor.getSegundoApellido());
                profesorRepository.save(emp);
            }
            return optionalEmp;
        }

        @DeleteMapping(value = "/profesor/{id}", produces = "application/json; charset=utf-8")
        public String deleteProfesor(@PathVariable Integer id) {
        Boolean result = profesorRepository.existsById(id);
        profesorRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";
    }


	@PostMapping("/profesor")
	public Profesores addProfesor(@RequestBody Profesores newProfesor)
	{
		Integer id = Integer.valueOf(new Random().nextInt());
		Profesores emp = new Profesores(id, newProfesor.getPrimerNombre(),newProfesor.getSegundoNombre(),newProfesor.getPrimerApellido(),newProfesor.getSegundoApellido());
		profesorRepository.save(emp);
		return emp;
	}


    }
