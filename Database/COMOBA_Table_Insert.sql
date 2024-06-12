USE COMOBA;

-- Inserció de dates a la taula Usuari
INSERT INTO Usuari (
    `idUsuari`, `Nom`, `Cognom`, `Correu`, `Telèfon`, `Data_alta`, `Rol`, `Contrasenya`, `Categoria_client`, `Entitat`, `Doc_client_logo`
) VALUES 
(1, 'Jordi', 'Gali', 'jordi@comoba.org', 123456789, '2024-01-15', 'Administrador', 'Socadmin2029', NULL, NULL, NULL),
(2, 'MariaElisa', 'Ojeda', 'mariaelisa@comoba.org', 987654321, '2024-02-20', 'Administrador', 'contrasenya456', NULL, NULL, NULL),
(3, 'Anna', 'Sanchez', 'anna.sanchez@example.com', 112233445, '2024-03-25', 'Usuari', 'contrasenya789', 'Bàsic', 'Empresa3', NULL);

-- Inserción de un administrador en la tabla Admin
INSERT INTO Admin (`Usuari_idUsuari`) VALUES (1);

-- Inserció de dades a la taula Servei
INSERT INTO Servei (
  `idServei`, `Nom_servei`, `Categoria_servei`, `Descripcio_servei`, `Document_servei`, `Admin_Usuari_idUsuari`
) VALUES 
(1, 'Estrategies de mobilitat sostenible', 'Urbanisme ciclista', 'Servei de consultoria en estratègies de mobilitat sostenible.', NULL, 1),
(2, 'Infraestructures de mobilitat activa', 'Infraestructures', 'Servei de disseny i execució d\'infraestrctures de mobilitat activa.', NULL, 1),
(3, 'Formació, promoció i comunicació', 'Formació', 'Servei de formació, promoció i comunicació sobre mobilitat activa.', NULL, 1),
(4, 'Projectes de Ciclologística', 'Ciclologistica', 'Servei de desenvolupament de projectes sobre ciclologistica.', NULL, 1);

-- Inserción de datos en la tabla DocTecnic
INSERT INTO DocTecnic (
  `idDoc_tecnic`, `Nom_doctecnic`, `Categoria_doctecnic`, `Descripcio_doctecnic`, `Link_doctecnic`, `Document_tecnic`, `Admin_Usuari_idUsuari`
) VALUES 
(1, 'Manual de disseny', 'CROW2024', 'Documentació tècnica holandesa per al disseny d\'infraestructures ciclistes.', 'http://example.com/api-doc', NULL, 1),
(2, 'Manual d\'usuari', 'Manual', 'Manual d\'usuari per al sistema de gestió.', 'http://example.com/user-manual', NULL, 1),
(3, 'Guia d\'instal·lació', 'Guia', 'Guia detallada per a la instal·lació del software.', 'http://example.com/install-guide', NULL, 1);

-- Inserción de datos en la tabla Projecte
INSERT INTO Projecte (
  `idProjecte`, `Titol`, `Descripció`, `Categoria`, `Data_projecte`, `Data_creació`, `Localitzacio`, `Document_projecte`, `Usuari_idUsuari`, `Admin_Usuari_idUsuari`
) VALUES 
(1, 'PEMAG', 'Pla Estrategic de Mobilitat Activa de Guissona.', 'Planificació Urbana', '2019-06-01', '2024-06-01', 'Guissona', NULL,  4, 1),
(2, 'Consultoria Bicivia', 'Desenvolupament i seguiment de la xarxa de carrils bici de l\'AMB.', 'Infraestructura ciclista', '2022-07-15', '2024-06-01', 'AMB', NULL,  5, 1),
(3, 'Microhub', 'Projecte executiu d\'espais de micro distribució amb bicicletes de càrrega.', 'Ciclologistica', '2014-09-10', '2024-06-01', 'Area Metropolitana de Barcelona', NULL,  6, 1);

INSERT INTO Usuari (
    `idUsuari`, `Nom`, `Cognom`, `Correu`, `Telèfon`, `Data_alta`, `Rol`, `Contrasenya`, `Categoria_client`, `Entitat`, `Doc_client_logo`
) VALUES 
(4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Administració Pública',  'Ajuntament de Guissona', NULL),
(5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Administració Pública',  'Area Metropolitana de Barcelona', NULL),
(6, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Administració Pública',  'Ajuntament de Barcelona', NULL);


-- Inserción de datos en la tabla Document_Projecte
INSERT INTO Document_Projecte (
  `idDocument_Projecte`, `Nom_doc`, `Tipus_doc`, `Descripcio_doc`, `Data_doc`, `Projecte_idProjecte`, `Projecte_Usuari_idUsuari`, `Projecte_Admin_Usuari_idUsuari`
) VALUES 
(1, 'Especificacions Tècniques', 'Especificació', 'Document amb les especificacions tècniques del projecte.', '2024-06-10', 1, 1, 1),
(2, 'Informe de Progrés', 'Informe', 'Informe detallat del progrés del projecte.', '2024-06-15', 2, 2, 1);

