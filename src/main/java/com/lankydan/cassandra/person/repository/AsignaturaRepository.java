package com.lankydan.cassandra.person.repository;
import org.springframework.data.repository.CrudRepository;
import com.lankydan.cassandra.person.Asignatura;
import org.springframework.stereotype.Service;

@Service
public interface AsignaturaRepository extends CrudRepository<Asignatura, Integer> {
}
