# Sistema de Microservicios SOAP - Proyecto Java

Este proyecto consiste en un sistema de bodega desarrollado en Java, el cual implementa microservicios SOAP para la gestión de productos. Está diseñado para una "Integración" con una tienda online que tambien esta en proceso de mejora, permitiendo el consumo de servicios a través de WSDL.

## Tecnologías utilizadas

- **Java**
- **Apache Tomcat**
- **NetBeans**
- **SOAP (JAX-WS)**
- **Oracle Database**
- **SOAP UI** para pruebas de servicios

## Funcionalidades

- CRUD de productos
- Conexión con base de datos Oracle
- Exposición de servicios SOAP
- Consumo de WSDL desde una aplicación externa (tienda online en Django)

## Estructura del proyecto

- `src/java/modelo`: contiene clases como `Producto`, `ProductoDao` y `Conexion`.
- `nbproject`: configuración del proyecto en NetBeans.
- `web`: archivos relacionados al despliegue web.
- `.gitignore`: excluye carpetas innecesarias del repositorio.

## Próximas mejoras

- Agregar más entidades y relaciones a la base de datos (usuarios, categorías, stock, etc.)
- Validaciones y manejo de errores
- Control de calidad con herramientas como Selenium y MantisBT
- Documentación técnica más detallada

## Comandos para arrancar el proyecto

1.- Clona en repositorio
2.- Abre Netbeans
3.- Configura la conexión a Oracle
4.- Ejecuta el servicio desde Apache Tomcat

## Autor

Pablo Toro - Ingeniero en Informática  
Este proyecto forma parte de mí experiencia profesional y está en constante mejora.

