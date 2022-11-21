INSERT INTO asignatura.profesores(idProfesor,primerNombre,segundoNombre,primerApellido,segundoApellido) VALUES(1,'Brayan','Sebastian','Yepes','Garcia');
INSERT INTO asignatura.lugar(idEdificio,facultad,Salon) VALUES(1,'Ingenieria','203');
INSERT INTO asignatura.asignatura 
(codigoasignatura,creditos,cupos,descripcion,duracion,fechafinal,fechainicio,horario,jornada,idEdificio,nombreasignatura,idProfesor,programa,nivelDeEstudio,sede,tipologia, prerequisitos) 
VALUES(1,3,30,'Arquitectura de software','Semestral','2022-12-01','2022-08-01','14-16','Diurna',1,'Arquitectura de software',1,['1','Ingeniera de Sistemas','Bogota Facultad de 
ingenieria'],'Pregrado','Bogota','Optativa',{1:'Ingenieria del software'});

