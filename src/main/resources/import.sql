INSERT INTO `estudiante` (`noIdentificacion`, `tipoIdentificacion`, `nombres`, `apellidos`, `fechaIngreso`) VALUES ('1111', 'CC', 'Juan', 'perez', '2022-11-09 00:00:00');

INSERT INTO `direcciones` (`numeroTelefono`, `tipoTelefono`, `idPersona`) VALUES ('3207719034', 'Celular', 1);

INSERT INTO `telefono` (`tipo`, `numero`, `idPersona`) VALUES ('Celular', '3207719034', 1);

INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Solarte', '1061813423', 'Juan', 'CC', '2022-11-28 01:51:17.000000');
INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Marino', '1061818923', 'Clouse', 'CC', '2022-11-28 01:51:17.000000');
INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Melina', '10618143923', 'Andrea', 'CC', '2022-11-28 01:51:17.000000');
INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Medina', '10618134323', 'Jiliana', 'CC', '2022-11-28 01:51:17.000000');
INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Andrade', '4324234444', 'Melissa', 'CC', '2022-11-28 01:51:17.000000');
INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Diaz', '1061814323', 'Luis', 'CC', '2022-11-28 01:51:17.000000');
INSERT INTO `estudiante` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `fechaIngreso`) VALUES (NULL, 'Andrade', '432424433', 'Melissa', 'CC', '2022-11-28 01:51:17.000000');

INSERT INTO `docente` (`idPersona`, `apellidos`, `noIdentificacion`, `nombres`, `tipoIdentificacion`, `salario`, `tipoDocente`, `universidad`) VALUES (null, 'Rojas', '10801080123', 'Pedro', 'CC', 2500000, 'Planta', 'Unicauca');
INSERT INTO `asignaturas`(`idAsignatura`, `nombre`) VALUES(null, 'ASAE');
INSERT INTO `docente_asignatura`(`idPersona`, `idAsignatura`) VALUES(1, 1);
