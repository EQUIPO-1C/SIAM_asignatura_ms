package com.example.demo.repository;
import com.example.demo.model.Profesores;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public interface ProfesoresRepository extends CrudRepository<Profesores, Integer> {
}
