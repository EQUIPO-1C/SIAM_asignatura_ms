package com.lankydan.cassandra.person.repository;


import com.lankydan.cassandra.person.Lugar;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service

public interface LugarRepository extends CrudRepository<Lugar, Integer> {
}
