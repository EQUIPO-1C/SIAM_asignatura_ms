package com.lankydan.cassandra.person;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.Row;
import com.google.common.reflect.TypeToken;



import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.*;

import com.datastax.driver.core.TupleValue;


@AllArgsConstructor
@Getter @Setter
@Table("asignatura")

public class Asignatura {
	//@PrimaryKey
	/*
	private @NonNull int codigoasignatura;
	private @NonNull int creditos;
	private @NonNull int cupos;
	private @NonNull String descripcion;
	private @NonNull String duracion;
	private @NonNull String fechaFinal;
	private @NonNull String fechaInicio;
	//private @NonNull List<String> grupos;
	private @NonNull String jornada;
	private @NonNull String nombreAsignatura;
	//private @NonNull List<String> prerequisitos;
	//private @NonNull List<String> programa;
	private @NonNull String sede;
	private @NonNull String tipologia;
*/
	@PrimaryKey
	private @NonNull int codigoasignatura;
	private int creditos;
	private int cupos;
	private String descripcion;
	private String duracion;
	private String fechaFinal;
	private String fechaInicio;
	private String horario;
	private String jornada;
	private Integer idEdificio;
	private String nombreAsignatura;
	private Integer idProfesor;
	private List<String> programa;
	private String nivelDeEstudio;
	private String sede;
	private String tipologia;
	private Map<Integer,String> prerequisitos;


}