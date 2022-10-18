package com.lankydan.cassandra.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@AllArgsConstructor
@Getter
@Setter
@Table("profesores")
public class Profesores {
    @PrimaryKey
    private @NonNull int idProfesor;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
}
