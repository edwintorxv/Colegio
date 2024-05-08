create database prueba_gh;
use prueba_gh;

create table departamento(
cod int primary key,
nombre varchar(255)
);

INSERT INTO departamento VALUES(5,'MEDELLÍN');
INSERT INTO departamento VALUES(8,'BARRANQUILLA');
INSERT INTO departamento VALUES(11,'BOGOTÁ');
INSERT INTO departamento VALUES(13,'CARTAGENA');
INSERT INTO departamento VALUES(15,'TUNJA');
INSERT INTO departamento VALUES(17,'MANIZALES');
INSERT INTO departamento VALUES(18,'FLORENCIA');
INSERT INTO departamento VALUES(19,'POPAYÁN');
INSERT INTO departamento VALUES(20,'VALLEDUPAR');
INSERT INTO departamento VALUES(23,'MONTERÍA');
INSERT INTO departamento VALUES(25,'AGUA DE DIOS');
INSERT INTO departamento VALUES(27,'QUIBDÓ');
INSERT INTO departamento VALUES(41,'NEIVA');
INSERT INTO departamento VALUES(44,'RIOHACHA');
INSERT INTO departamento VALUES(47,'SANTA MARTA');
INSERT INTO departamento VALUES(50,'VILLAVICENCIO');
INSERT INTO departamento VALUES(52,'PASTO');
INSERT INTO departamento VALUES(54,'CÚCUTA');
INSERT INTO departamento VALUES(63,'ARMENIA');
INSERT INTO departamento VALUES(66,'PEREIRA');
INSERT INTO departamento VALUES(68,'BUCARAMANGA');
INSERT INTO departamento VALUES(70,'SINCELEJO');
INSERT INTO departamento VALUES(73,'IBAGUÉ');
INSERT INTO departamento VALUES(76,'CALI');
INSERT INTO departamento VALUES(81,'ARAUCA');
INSERT INTO departamento VALUES(85,'YOPAL');
INSERT INTO departamento VALUES(86,'MOCOA');
INSERT INTO departamento VALUES(88,'SAN ANDRÉS');
INSERT INTO departamento VALUES(91,'LETICIA');
INSERT INTO departamento VALUES(94,'INÍRIDA');
INSERT INTO departamento VALUES(95,'SAN JOSÉ DEL GUAVIARE');
INSERT INTO departamento VALUES(97,'MITÚ');
INSERT INTO departamento VALUES(99,'PUERTO CARREÑO');


create table sede(
id int auto_increment primary key,
nombre varchar(255)
);

INSERT INTO SEDE VALUES(NULL,'NORTE');
INSERT INTO SEDE VALUES(NULL,'CENTRO');
INSERT INTO SEDE VALUES(NULL,'SUR');

create table curso(
id int auto_increment primary key,
nombre varchar(255)
);

INSERT INTO CURSO VALUES(NULL, 'PRIMERO');
INSERT INTO CURSO VALUES(NULL, 'SEGUNDO');
INSERT INTO CURSO VALUES(NULL, 'TERCERO');
INSERT INTO CURSO VALUES(NULL, 'CUARTO');
INSERT INTO CURSO VALUES(NULL, 'QUINTO');
INSERT INTO CURSO VALUES(NULL, 'SEXTO');
INSERT INTO CURSO VALUES(NULL, 'SEPTIMO');
INSERT INTO CURSO VALUES(NULL, 'OCTAVO');
INSERT INTO CURSO VALUES(NULL, 'NOVENO');
INSERT INTO CURSO VALUES(NULL, 'DECIMO');
INSERT INTO CURSO VALUES(NULL, 'DECIMO PRIMERO');

select *
 from curso;

create table estudiante(
id int auto_increment primary key,
fk_departamento_cod int,
fk_sede_id int,
fk_curso_id int,
nombre varchar(255),
apellido varchar(255),
numero_identificacion varchar(10),
foreign key (fk_departamento_cod) references departamento(cod),
foreign key (fk_sede_id) references sede(id),
foreign key (fk_curso_id) references curso(id)
);

select * from estudiante;


select * 
from estudiante
where fk_curso_id = 1
and fk_sede_id = 1
and fk_departamento_cod = 11;
