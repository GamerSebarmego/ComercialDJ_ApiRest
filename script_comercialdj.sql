drop database comercialdj;
use comercialdj;
select * from trabajador;
INSERT INTO `comercialdj`.`trabajador` (`codtrabajador`, `correo`, `direccion`, `nombretrabajador`, `telefono`) VALUES ('T0001', 'sebarmego@gmail.com', 'Lima, San Juan de Miraflores', 'Felipe Sebastian', '966370467');
INSERT INTO `comercialdj`.`trabajador` (`codtrabajador`, `correo`, `direccion`, `nombretrabajador`, `telefono`) VALUES ('T0002', 'otrotrabajador@example.com', 'Lima, Miraflores', 'Otro Trabajador', '987654321');
INSERT INTO `comercialdj`.`trabajador` (`codtrabajador`, `correo`, `direccion`, `nombretrabajador`, `telefono`) VALUES ('T0003', 'tercertrabajador@example.com', 'Lima, San Isidro', 'Tercer Trabajador', '912345678');
INSERT INTO `comercialdj`.`trabajador` (`codtrabajador`, `correo`, `direccion`, `nombretrabajador`, `telefono`) VALUES ('T0004', 'cuartotrabajador@example.com', 'Lima, La Molina', 'Cuarto Trabajador', '923456789');
INSERT INTO `comercialdj`.`trabajador` (`codtrabajador`, `correo`, `direccion`, `nombretrabajador`, `telefono`) VALUES ('T0005', 'quintotrabajador@example.com', 'Lima, Surco', 'Quinto Trabajador', '934567890');
INSERT INTO `comercialdj`.`trabajador` (`codtrabajador`, `correo`, `direccion`, `nombretrabajador`, `telefono`) VALUES ('T0006', 'sextotrabajador@example.com', 'Lima, Barranco', 'Sexto Trabajador', '945678901');
select * from pedidocompra;
INSERT INTO `comercialdj`.`pedidocompra` (`idpedido`, `codtrabajador`, `fechapedido`, `numbercompra`) VALUES ('1', 'T0001', '2023-08-07', '1');
select * from categoriaproducto;
INSERT INTO `comercialdj`.`categoriaproducto` (`idcategoria`, `descripcion`, `estado`) VALUES ('1', 'Gaseosas', 1);
INSERT INTO `comercialdj`.`categoriaproducto` (`idcategoria`, `descripcion`, `estado`) VALUES ('2', 'Snacks', 1);
INSERT INTO `comercialdj`.`categoriaproducto` (`idcategoria`, `descripcion`, `estado`) VALUES ('3', 'Bebidas Alcohólicas', 1);
INSERT INTO `comercialdj`.`categoriaproducto` (`idcategoria`, `descripcion`, `estado`) VALUES ('4', 'Lácteos', 1);
INSERT INTO `comercialdj`.`categoriaproducto` (`idcategoria`, `descripcion`, `estado`) VALUES ('5', 'Bebidas minerales', 1);
select * from producto;
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0001', 'Gaseosa Personal de 500ml', '1', 'Coca Cola', 'Gaseosa Personal Coca Cola', '1.50', '2.00');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0002', 'Papas Fritas 100g', '2', 'Lay\'s', 'Papas Fritas Lay\'s', '0.75', '1.50');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0003', 'Cerveza Lager 355ml', '3', 'Corona', 'Cerveza Corona Lager', '2.50', '3.75');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0004', 'Yogur de Frutas 150g', '4', 'Danone', 'Yogur de Frutas Danone', '0.60', '1.20');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0005', 'Agua Mineral 500ml', '5', 'San Luis', 'Agua Mineral San Luis', '0.40', '0.80');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0006', 'Chocolate con Leche 100g', '4', 'Nestlé', 'Chocolate con Leche Nestlé', '1.20', '2.50');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0007', 'Whisky 750ml', '3', 'Johnnie Walker', 'Whisky Johnnie Walker', '20.00', '30.00');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0008', 'Jugo de Naranja 200ml', '2', 'Tropicana', 'Jugo de Naranja Tropicana', '0.80', '1.75');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0009', 'Galletas de Vainilla 150g', '2', 'Gamesa', 'Galletas de Vainilla Gamesa', '0.50', '1.00');
INSERT INTO `comercialdj`.`producto` (`codproducto`, `descripcion`, `idcategoria`, `marcaproducto`, `nombreproducto`, `preciocompra`, `precioventa`) VALUES ('P0010', 'Leche Descremada 1L', '4', 'Laive', 'Leche Descremada Laive', '1.00', '2.20');
select * from detallepedidocompra;
INSERT INTO `comercialdj`.`detallepedidocompra` (`iddetalle`, `cantidadproductos`, `codproducto`, `idpedido`) VALUES ('1', '8', 'P0009', '1');
INSERT INTO `comercialdj`.`detallepedidocompra` (`iddetalle`, `cantidadproductos`, `codproducto`, `idpedido`) VALUES ('2', '5', 'P0005', '1');
INSERT INTO `comercialdj`.`detallepedidocompra` (`iddetalle`, `cantidadproductos`, `codproducto`, `idpedido`) VALUES ('3', '3', 'P0002', '1');
INSERT INTO `comercialdj`.`detallepedidocompra` (`iddetalle`, `cantidadproductos`, `codproducto`, `idpedido`) VALUES ('4', '10', 'P0008', '1');
INSERT INTO `comercialdj`.`detallepedidocompra` (`iddetalle`, `cantidadproductos`, `codproducto`, `idpedido`) VALUES ('5', '2', 'P0003', '1');
Select * from Vista;
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('1', 'P0001', true, 'https://drive.google.com/file/d/1smn_95fHNqON6tZk-iBT2jdwpN1MzoAw/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('2', 'P0002', true, 'https://drive.google.com/file/d/1ZSQrSjU4KqCqJ5rFJKGWX_G2KQlVPBgS/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('3', 'P0003', true, 'https://drive.google.com/file/d/1W08DbLnAOCJnjnMsrZTV142yfmaUVO55/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('4', 'P0004', true, 'https://drive.google.com/file/d/1tU4RT4Pa9UFEDi4qFRdbL7TazY80VJRx/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('5', 'P0005', true, 'https://drive.google.com/file/d/1i1CeKVirPTTjqSh5HFIu2NPbI6etm3pc/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('6', 'P0006', true, 'https://drive.google.com/file/d/1uLMcMc0Xes2PCYGriVHIHlsGGXspBxrW/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('7', 'P0007', true, 'https://drive.google.com/file/d/1Xi7TyTJEdPdogCzlpBOiIizb_6MUU944/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('8', 'P0008', true, 'https://drive.google.com/file/d/1cqqxFLmF7uQwktUfc7UTXhNK7PEGdIlz/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('9', 'P0009', true, 'https://drive.google.com/file/d/1o7ySZPSomci-EmhVyzMof0TeYvuqrYS7/view?usp=drive_link');
INSERT INTO `comercialdj`.`Vista` (`codvista`, `codproducto`, `estado`, `imagen`) VALUES ('10', 'P0010', true, 'https://drive.google.com/file/d/1s22FIcMgMOCGeVyMmIZJBlJOgXw_rOPu/view?usp=drive_link');
Select * from proveedor;
INSERT INTO `comercialdj`.`proveedor` (`ruc`, `correo`, `direccion`, `razonsocial`, `representante`, `telefono`) VALUES ('1071381049', 'sebarmego@gmail.com', 'Lima, San Juan de Miraflores', 'Nerf', 'Felipe Sebastian', '966370467');
INSERT INTO `comercialdj`.`proveedor` (`ruc`, `correo`, `direccion`, `razonsocial`, `representante`, `telefono`) VALUES ('2056789012', 'otroproveedor@example.com', 'Lima, Miraflores', 'Otro Proveedor', 'Otra Persona', '987654321');
INSERT INTO `comercialdj`.`proveedor` (`ruc`, `correo`, `direccion`, `razonsocial`, `representante`, `telefono`) VALUES ('3012345678', 'tercerproveedor@gmail.com', 'Lima, Surco', 'Tercer Proveedor', 'Tercera Persona', '912345678');
INSERT INTO `comercialdj`.`proveedor` (`ruc`, `correo`, `direccion`, `razonsocial`, `representante`, `telefono`) VALUES ('4087654321', 'cuartoproveedor@ejemplo.com', 'Lima, La Molina', 'Cuarto Proveedor', 'Cuarta Persona', '978654321');
INSERT INTO `comercialdj`.`proveedor` (`ruc`, `correo`, `direccion`, `razonsocial`, `representante`, `telefono`) VALUES ('5098765432', 'quintoproveedor@example.com', 'Lima, San Isidro', 'Quinto Proveedor', 'Quinta Persona', '945678912');
Select * from guiasingreso;
INSERT INTO `comercialdj`.`guiasingreso` (`idguia`, `fecha`, `numeroguia`, `ruc`) VALUES ('1', '2023-10-15', '012', '1071381049');
INSERT INTO `comercialdj`.`guiasingreso` (`idguia`, `fecha`, `numeroguia`, `ruc`) VALUES ('2', '2023-10-16', '013', '2056789012');
INSERT INTO `comercialdj`.`guiasingreso` (`idguia`, `fecha`, `numeroguia`, `ruc`) VALUES ('3', '2023-10-17', '014', '3012345678');
INSERT INTO `comercialdj`.`guiasingreso` (`idguia`, `fecha`, `numeroguia`, `ruc`) VALUES ('4', '2023-10-18', '015', '4087654321');
INSERT INTO `comercialdj`.`guiasingreso` (`idguia`, `fecha`, `numeroguia`, `ruc`) VALUES ('5', '2023-10-19', '016', '5098765432');
select * from detalleguiaingreso;
INSERT INTO `comercialdj`.`detalleguiaingreso` (`idguiaingreso`, `cantidad`, `codproducto`, `idguia`) VALUES ('1', '15', 'P0002', '1');
INSERT INTO `comercialdj`.`detalleguiaingreso` (`idguiaingreso`, `cantidad`, `codproducto`, `idguia`) VALUES ('2', '20', 'P0003', '1');
INSERT INTO `comercialdj`.`detalleguiaingreso` (`idguiaingreso`, `cantidad`, `codproducto`, `idguia`) VALUES ('3', '10', 'P0004', '1');
INSERT INTO `comercialdj`.`detalleguiaingreso` (`idguiaingreso`, `cantidad`, `codproducto`, `idguia`) VALUES ('4', '8', 'P0001', '1');
INSERT INTO `comercialdj`.`detalleguiaingreso` (`idguiaingreso`, `cantidad`, `codproducto`, `idguia`) VALUES ('5', '12', 'P0005', '1');
select * from cliente;
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('71381049', 'Barco Mego', 'sebarmego@gmail.com', 'Lima, San Juan de Miraflores', '23-10-15', 'Felipe Sebastian', 'Colegio Fe y Alegria Nº 65', '966370467');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('87654321', 'Pérez Gómez', 'perez@example.com', 'Lima, Miraflores', '2023-07-31', 'María', 'Calle Los Pinos Nº 123', '987654321');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('98765432', 'López Rodríguez', 'lopez@example.com', 'Lima, San Isidro', '2023-07-31', 'Carlos', 'Avenida Principal Nº 456', '912345678');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('56789012', 'García Martínez', 'garcia@example.com', 'Lima, Surco', '2023-07-31', 'Laura', 'Urbanización Los Álamos', '945678912');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('45678901', 'Martínez Pérez', 'martinez@example.com', 'Lima, La Molina', '2023-07-31', 'Javier', 'Condominio Las Palmas', '978654321');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('12345678', 'Vargas Sánchez', 'vargas@example.com', 'Lima, San Borja', '2023-07-31', 'Ana', 'Av. Los Pájaros Nº 789', '901234567');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('23456789', 'Ramírez López', 'ramirez@example.com', 'Lima, Lince', '2023-07-31', 'Luis', 'Jirón Los Rosales Nº 456', '890123456');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('34567890', 'Gómez Fernández', 'gomez@example.com', 'Lima, Jesús María', '2023-07-31', 'Elena', 'Calle Los Lirios Nº 567', '789012345');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('45678902', 'Fernández García', 'fernandez@example.com', 'Lima, Magdalena', '2023-07-31', 'Juan', 'Calle Las Flores Nº 678', '678901234');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('56789010', 'López Martínez', 'lopez@example.com', 'Lima, San Miguel', '2023-07-31', 'Carolina', 'Av. Los Laureles Nº 789', '567890123');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('67890123', 'Pérez Gómez', 'perez@example.com', 'Lima, La Victoria', '2023-07-31', 'Andrés', 'Jirón Los Jazmines Nº 890', '456789012');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('78901234', 'Ramírez Sánchez', 'ramirez@example.com', 'Lima, Callao', '2023-07-31', 'Mariana', 'Av. Los Cerezos Nº 901', '345678901');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('89012345', 'García López', 'garcia@example.com', 'Lima, Independencia', '2023-07-31', 'Santiago', 'Calle Los Olivos Nº 012', '234567890');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('90123456', 'Fernández Martínez', 'fernandez@example.com', 'Lima, Chorrillos', '2023-07-31', 'Valentina', 'Av. Los Pinos Nº 123', '123456789');
INSERT INTO `comercialdj`.`cliente` (`dni`, `apellido`, `correo`, `direccion`, `fechaingreso`, `nombre`, `referencia`, `telefono`) VALUES ('01234567', 'Martínez Gómez', 'martinez@example.com', 'Lima, Barranco', '2023-07-31', 'Mateo', 'Calle Las Palmeras Nº 234', '012345678');
select * from reclamos;
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('1', 'imagen no especificada', 'falta de atencion', 'Ever need to create some filler text in your Word document or PowerPoint presentation to test formatting and layout? Microsoft Office can quickly create this dummy text for you with lorem ipsum Latin or random sentences in English.', '71381049', '23-08-09');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('2', 'imagen1.jpg', 'producto defectuoso', 'Received a faulty product. Need a replacement as soon as possible.', '87654321', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('3', 'documento.pdf', 'envío retrasado', 'I ordered a product a week ago and it has not been delivered yet. Please provide an update.', '23456789', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('4', 'imagen2.png', 'facturación incorrecta', 'The invoice I received does not match the products I ordered. Please rectify the issue.', '34567890', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('5', 'imagen3.jpg', 'problema con el servicio', 'I have been facing issues with the customer support service. Need assistance to resolve my queries.', '45678901', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('6', 'documento2.pdf', 'producto dañado en el envío', 'Received a product with visible damage. Need a replacement or refund.', '56789012', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('7', 'imagen4.png', 'pedido incompleto', 'I received my order, but some items are missing. Please send the missing items.', '67890123', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('8', 'imagen5.jpg', 'problema con la cuenta', 'I am unable to log in to my account. Please assist me in resetting my password.', '78901234', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('9', 'imagen6.png', 'información incorrecta en el sitio web', 'The product description on the website is inaccurate. The product I received is different from what was described.', '89012345', '2023-07-31');
INSERT INTO `comercialdj`.`reclamos` (`idreclamo`, `adjuntos`, `asunto`, `cuerporeclamo`, `dni`, `fechareclamo`) VALUES ('10', 'documento3.pdf', 'problema con la devolución', 'I returned a product for a refund, but I haven\'t received the refund yet. Please look into the matter.', '90123456', '2023-07-31');
select * from rol;
INSERT INTO `comercialdj`.`rol` (`idrol`, `descripcion`, `estado`, `permisos`) VALUES ('1', 'Administracion', true, 'ADMIN');
INSERT INTO `comercialdj`.`rol` (`idrol`, `descripcion`, `estado`, `permisos`) VALUES ('2', 'Supervisor', true, 'SUPERVISOR');
INSERT INTO `comercialdj`.`rol` (`idrol`, `descripcion`, `estado`, `permisos`) VALUES ('3', 'Empleado', true, 'EMPLEADO');
INSERT INTO `comercialdj`.`rol` (`idrol`, `descripcion`, `estado`, `permisos`) VALUES ('4', 'Usuario', true, 'USUARIO');
select * from usuario;
-- Usuario para el cliente 'Felipe Barco'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('1', '9846532asd', '71381049', true, '23-08-09', '1', 'gamersebarmego');
-- Usuario para el cliente 'Pérez Gómez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('2', 'pass123', '87654321', true, '2023-07-31', '2', 'mariaperez');
-- Usuario para el cliente 'López Rodríguez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('3', 'carlospass', '98765432', true, '2023-07-31', '3', 'carloslopez');
-- Usuario para el cliente 'García Martínez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('4', 'laurapass', '56789012', true, '2023-07-31', '4', 'lauragarcia');
-- Usuario para el cliente 'Martínez Pérez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('5', 'javierpass', '45678901', true, '2023-07-31', '4', 'javiermartinez');
-- Usuario para el cliente 'Vargas Sánchez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('6', 'anapass', '12345678', true, '2023-07-31', '4', 'anavargas');
-- Usuario para el cliente 'Ramírez López'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('7', 'luispass', '23456789', true, '2023-07-31', '4', 'luisramirez');
-- Usuario para el cliente 'Gómez Fernández'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('8', 'elenapass', '34567890', true, '2023-07-31', '4', 'elenagomez');
-- Usuario para el cliente 'Fernández García'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('9', 'juanpass', '45678902', true, '2023-07-31', '4', 'juanfernandez');
-- Usuario para el cliente 'López Martínez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('10', 'carolinapass', '56789010', true, '2023-07-31', '4', 'carolinalopez');
-- Usuario para el cliente 'Pérez Gómez' (con diferente DNI)
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('11', 'andrespass', '67890123', true, '2023-07-31', '4', 'andresperez');
-- Usuario para el cliente 'Ramírez Sánchez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('12', 'marianapass', '78901234', true, '2023-07-31', '4', 'marianaramirez');
-- Usuario para el cliente 'García López'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('13', 'santiagopass', '89012345', true, '2023-07-31', '4', 'santiagogarcia');
-- Usuario para el cliente 'Fernández Martínez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('14', 'valentinapass', '90123456', true, '2023-07-31', '4', 'valentinafernandez');
-- Usuario para el cliente 'Martínez Gómez'
INSERT INTO `comercialdj`.`usuario` (`idusuario`, `contrasenia`, `dni`, `estado`, `fecharegistro`, `idrol`, `nombreusuario`) VALUES ('15', 'mateopass', '01234567', true, '2023-07-31', '4', 'mateomartinez');
select * from tipopago;
INSERT INTO `comercialdj`.`tipopago` (`idpago`, `nombre`) VALUES ('1', 'Tarjeta de Crédito');
INSERT INTO `comercialdj`.`tipopago` (`idpago`, `nombre`) VALUES ('2', 'Transferencia Bancaria');
INSERT INTO `comercialdj`.`tipopago` (`idpago`, `nombre`) VALUES ('3', 'Pago en Efectivo');
INSERT INTO `comercialdj`.`tipopago` (`idpago`, `nombre`) VALUES ('4', 'PayPal');
INSERT INTO `comercialdj`.`tipopago` (`idpago`, `nombre`) VALUES ('5', 'Cheque');
select * from ventacliente;
INSERT INTO `comercialdj`.`ventacliente` (`idventa`, `fechaventa`, `idpago`, `idusuario`, `numerocomprobante`) VALUES ('1', '2023-08-09', '2', '14', '00001');
select * from detalleventacliente;
INSERT INTO `comercialdj`.`detalleventacliente` (`iddetalle`, `cantidadproductos`, `codproducto`, `idventa`, `importetotal`) VALUES ('1', '2', 'P0001', '1', '2.5');
INSERT INTO `comercialdj`.`detalleventacliente` (`iddetalle`, `cantidadproductos`, `codproducto`, `idventa`, `importetotal`) VALUES ('2', '3', 'P0002', '1', '4.2');
INSERT INTO `comercialdj`.`detalleventacliente` (`iddetalle`, `cantidadproductos`, `codproducto`, `idventa`, `importetotal`) VALUES ('3', '1', 'P0003', '1', '1.8');
INSERT INTO `comercialdj`.`detalleventacliente` (`iddetalle`, `cantidadproductos`, `codproducto`, `idventa`, `importetotal`) VALUES ('4', '5', 'P0004', '1', '7.5');
INSERT INTO `comercialdj`.`detalleventacliente` (`iddetalle`, `cantidadproductos`, `codproducto`, `idventa`, `importetotal`) VALUES ('5', '2', 'P0005', '1', '3.0');
INSERT INTO `comercialdj`.`detalleventacliente` (`iddetalle`, `cantidadproductos`, `codproducto`, `idventa`, `importetotal`) VALUES ('6', '4', 'P0006', '1', '5.6');