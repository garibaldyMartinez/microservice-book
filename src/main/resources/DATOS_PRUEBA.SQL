
-- insertar autores --------------------------------------------------------------------------------------------
INSERT INTO db_bravo.autores
(id_autor, fecha_nacimiento, fecha_creacion, nombre_completo, apellido, nombre, nacionalidad)
VALUES(52, '1975-09-09', '2023-10-09 18:59:28.204290', 'Gabriel Garcia', 'Garcia', 'Gabriel', 'Canadian');
INSERT INTO db_bravo.autores
(id_autor, fecha_nacimiento, fecha_creacion, nombre_completo, apellido, nombre, nacionalidad)
VALUES(53, '1975-09-09', '2023-10-09 19:00:23.041327', 'Juaquin Balaguer', 'Balaguer', 'Juaquin', 'Dominican');
INSERT INTO db_bravo.autores
(id_autor, fecha_nacimiento, fecha_creacion, nombre_completo, apellido, nombre, nacionalidad)
VALUES(54, '1975-09-09', '2023-10-09 19:00:57.600476', 'Pedro Henrriquez', 'Henrriquez', 'Pedro', 'Dominican');

--- insertar generos----------------------------------------------------------------------------------------------
INSERT INTO db_bravo.genereros
(id_genero, fecha_creacion, descripcion, tipo_genero, nombre)
VALUES(1, '2023-10-09 19:09:54.403019', 'Horror Description', 'NOVEL', 'Horror');
INSERT INTO db_bravo.genereros
(id_genero, fecha_creacion, descripcion, tipo_genero, nombre)
VALUES(2, '2023-10-09 19:10:15.455428', 'Fantasy Description', 'NOVEL', 'Fantasy');
INSERT INTO db_bravo.genereros
(id_genero, fecha_creacion, descripcion, tipo_genero, nombre)
VALUES(3, '2023-10-09 19:10:37.214388', 'Comedy Description', 'NOVEL', 'Comedy');
------ insertar libros ---------------------------------------------------------------------------------------
INSERT INTO db_bravo.libros
(id_libro, disponible, fecha_creacion, fecha_publicacion, descripcion, editora, cantidad, titulo)
VALUES(1, 1, '2023-10-09 19:19:24.448609', '1966-12-25', 'Relata la vida en los campos', 'Zael de la manza', 10, 'La ilida');
INSERT INTO db_bravo.libros
(id_libro, disponible, fecha_creacion, fecha_publicacion, descripcion, editora, cantidad, titulo)
VALUES(4, 1, '2023-10-09 19:22:22.870086', '1966-12-25', 'Relata la vida en los campos', 'Zael de la manza', 10, 'Amor en tiempos de colera');
INSERT INTO db_bravo.libros
(id_libro, disponible, fecha_creacion, fecha_publicacion, descripcion, editora, cantidad, titulo)
VALUES(52, 1, '2023-10-09 19:23:46.618833', '1966-12-25', 'Relata la vida en los campos', 'Zael de la manza', 10, 'Cien años de soledad');
INSERT INTO db_bravo.libros
(id_libro, disponible, fecha_creacion, fecha_publicacion, descripcion, editora, cantidad, titulo)
VALUES(102, 1, '2023-10-09 19:32:12.388919', '1966-12-25', 'Relata la vida en los campos', 'Zael de la manza', 10, 'La herfana de mi barrio');
