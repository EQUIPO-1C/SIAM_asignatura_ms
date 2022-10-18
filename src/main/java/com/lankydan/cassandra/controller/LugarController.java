package com.lankydan.cassandra.controller;
import com.lankydan.cassandra.person.Lugar;

import com.lankydan.cassandra.person.repository.LugarRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class LugarController {
    @Autowired
    LugarRepository lugarRepository;

    @GetMapping(value = "/healthcheckLugar", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"isWorking\" : true }";
    }

    @GetMapping("/lugar")
    public List<Lugar> getLugar()
    {
        Iterable<Lugar> result = lugarRepository.findAll();
        List<Lugar> lugarList = new ArrayList<Lugar>();
        result.forEach(lugarList::add);
        return lugarList;
    }

    @GetMapping("/lugar/{id}")
    public Optional<Lugar> getLugar(@PathVariable Integer id)
    {
        Optional<Lugar> emp = lugarRepository.findById(id);
        return emp;
    }

    @PutMapping("/lugar/{id}")
    public Optional<Lugar> updateLugar(@RequestBody Lugar newLugar, @PathVariable Integer id)
    {
        Optional<Lugar> optionalEmp = lugarRepository.findById(id);
        if (optionalEmp.isPresent()) {
            Lugar emp = optionalEmp.get();
            emp.setFacultad(newLugar.getFacultad());
            emp.setSalon(newLugar.getSalon());
            lugarRepository.save(emp);
        }
        return optionalEmp;
    }

    @DeleteMapping(value = "/lugar/{id}", produces = "application/json; charset=utf-8")
    public String deleteLugar(@PathVariable Integer id) {
        Boolean result = lugarRepository.existsById(id);
        lugarRepository.deleteById(id);
        return "{ \"success\" : "+ (result ? "true" : "false") +" }";
    }


    @PostMapping("/lugar")
    public Lugar addLugar(@RequestBody Lugar newLugar)
    {
        //Integer id = Integer.valueOf(new Random().nextInt());
        Lugar emp = new Lugar(newLugar.getIdEdificio(), newLugar.getFacultad(),newLugar.getSalon());
        lugarRepository.save(emp);
        return emp;
    }


}
