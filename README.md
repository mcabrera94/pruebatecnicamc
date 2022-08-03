# PruebaTecnicaMC
PruebaTecnicaMC es un proyecto Maven desarrollado con Spring boot para su 
posterior Evaluación por parte de Ionix SpA.

## Instalación
Debe contar con:
* Maven
* Java 8
* MySQL 5.7.25

Antes de correr el proyecto crea el SCHEMA y la TABLA que se requiere,
para ello en la carpeta resources encontras el script necesario; ejecuta cada query del script create_schema_and_table.sql.

Una vez configurado el SCHEMA y la TABLA, corre el siguiente comando:
```
mvn clean install
```
Esto descargara y compilará todas las dependencias que componen el proyecto.
Una vez obtengas BUILD SUCCESS ya podras correrlo.

## Documentación
Una vez que tengas el proyecto corriendo en el puerto 8080, dirigite a la
siguiente url

JsonDoc API [http://localhost:8080/jsondoc-ui.html#](http://localhost:8080/jsondoc-ui.html#).

Para loguearte usa:

| user  | password |
|----------|----------|
| admin    | admin    |

En el JsonDoc API encontrarás toda la documentación de cada servicio que integra el proyecto.
Algunos servicios usan Basic Authentication, en ese caso el usuario coincide con el de logueo.

## Versión
1.0
