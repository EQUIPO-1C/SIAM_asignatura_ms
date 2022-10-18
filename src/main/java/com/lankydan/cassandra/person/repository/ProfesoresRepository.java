package com.lankydan.cassandra.person.repository;

import com.lankydan.cassandra.person.Profesores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public interface ProfesoresRepository extends CrudRepository<Profesores, Integer> {
}
