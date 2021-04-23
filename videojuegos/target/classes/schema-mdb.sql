drop table if exists videojuego;
drop table if exists distribuidor;

create table videojuego (
    id int primary key auto_increment,
    nombre varchar(200) not null,
    descripcion varchar(3000),
    imagen_url varchar(500)
);

insert into videojuego(id, nombre, descripcion, imagen_url) values
(1, 'Halo Infinite', 
'videojuego de disparos en primera persona próximo a estrenarse de la 
franquicia de videojuegos de ciencia ficción creada por Bungie Studios 
y continuada por 343 Industries y Sperasoft',
'https://media.vandal.net/m/82244/halo-infinite-202072216173826_2.jpg'),
(2,'Assassins Creed: Valhalla',
'videojuego desarrollado por Ubisoft Montreal y publicado por Ubisoft.
 Es el decimosegundo en importancia y el vigesimosegundo lanzado dentro 
de la saga de Assassin Creed,y sucesor al juego del 2018 Assassins Creed Odyssey',
'https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/1200/public/media/image/2020/04/caratula-assassins-creed-valhalla-1931677.jpg'),
(3, 'Spider-Man: Miles Morales',
'videojuego de acción y aventuras desarrollado por Insomniac Games y publicado 
por Sony Interactive Entertainment para PlayStation 4 y PlayStation 5. 
Está basado en el superhéroe de Marvel Comics Miles Morales',
'https://preventas.knowherecollectibles.com.ar/wp-content/uploads/2020/11/PD1605154630j05.jpg'),
(4, 'Cyberpunk 2077',
'videojuego desarrollado y publicado por CD Projekt, que se lanzó para Microsoft
 Windows, PlayStation 4, y Xbox One el 10 de diciembre de 2020, 
y posteriormente en PlayStation 5, Xbox Series X|S y Google Stadia',
'https://sm.ign.com/ign_es/game/c/cyberpunk-/cyberpunk-2077_ygyu.jpg');


create table distribuidor (
    id int primary key auto_increment,
    nombre varchar(200) not null,
    sitio_web varchar(500)
);

insert into distribuidor (id, nombre, sitio_web) values
('1', 'Xbox Game Studios', ''),
('2', 'Ubisoft Entertainment', ''),
('3', 'Thekla', 'null'),
('4', 'Number One', 'null');



alter table videojuego
add column distribuidor_id int, 
add foreign key(distribuidor_id) references distribuidor(id); 

update videojuego set distribuidor_id = 1 where id in (1, 4);
update videojuego set distribuidor_id = 2 where id in (2);
update videojuego set distribuidor_id = 3 where id in (3);

alter table videojuego
modify distribuidor_id int not null;

