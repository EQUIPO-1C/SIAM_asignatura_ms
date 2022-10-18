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

