create database bibliotecabasedatos2;
use bibliotecabasedatos2;
create table clientes(
idCliente int auto_increment not null primary key,
login varchar(25),
pass varchar(25),
nombre varchar(25),
apellido varchar(25),
tipoCliente int

);
select * from clientes;

create table libros(
idLibro int auto_increment not null primary key,
titulo varchar(45),
autor varchar(45),
paginas int,
estado int
);

select * from libros;

create table descargas(
idDescargas int auto_increment not null primary key,
id_Libro int not null,
id_Cliente int not null,
fechaDescarga date,
foreign key (id_Libro) references libro (idLibro),
foreign key (id_Usuario) references clientes(idCliente)

)