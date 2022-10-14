package com.example.demo.repository;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Asignatura;
import org.springframework.stereotype.Service;

@Service
public interface AsignaturaRepository extends CrudRepository<Asignatura, Integer> {
}
