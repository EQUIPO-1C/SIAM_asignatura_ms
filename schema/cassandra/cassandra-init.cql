CREATE KEYSPACE IF NOT EXISTS asignatura WITH REPLICATION = { 'class' : 'NetworkTopologyStrategy', 'datacenter1' : 1 };
CREATE TABLE asignatura.asignatura (
    codigoasignatura int,
    creditos int,
    cupos int,
    descripcion text,
    duracion text,
    fechafinal text,
    fechainicio text,
    horario text,
    jornada text,
    idEdificio int,
    nombreasignatura text,
    idProfesor int,
    programa frozen<list<text>>,
    nivelDeEstudio text,
    sede text,
    tipologia text,
    prerequisitos map<int, text>,
    PRIMARY KEY ((codigoasignatura), idProfesor,idEdificio,programa)

);

CREATE TABLE asignatura.profesores(
idProfesor int PRIMARY KEY,
primerNombre text,
segundoNombre text,
primerApellido text,
segundoApellido text
);

CREATE TABLE  asignatura.lugar(
idEdificio int PRIMARY KEY,
facultad text,
Salon text,
);

INSERT INTO asignatura.profesores(idProfesor,primerNombre,segundoNombre,primerApellido,segundoApellido) VALUES(1,'Brayan','Sebastian','Yepes','Garcia');
INSERT INTO asignatura.lugar(idEdificio,facultad,Salon) VALUES(1,'Ingenieria','203');
INSERT INTO asignatura.asignatura 
(codigoasignatura,creditos,cupos,descripcion,duracion,fechafinal,fechainicio,horario,jornada,idEdificio,nombreasignatura,idProfesor,programa,nivelDeEstudio,sede,tipologia, 
prerequisitos) VALUES(1,3,30,'Arquitectura de software','Semestral','2022-12-01','2022-08-01','14-16','Diurna',1,'Arquitectura de software',1,['1','Ingeniera de Sistemas','Bogota 
Facultad de ingenieria'],'Pregrado','Bogota','Optativa',{1:'Ingenieria del software'});
