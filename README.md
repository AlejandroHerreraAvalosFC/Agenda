
# Agenda Electronica

Una agenda electronica la cual te permite crear resgistros de personas, eliminarlos, modificarlos y consultarlos además de que te permite imprimir un calendario del mes y año deseado.

## Como ejecutarlo
Con el comando se compila:
```
javac AgendaElectronica.java
```
Y se ejecuta con el comando:
```
java AgendaElectronica
```
Con esta opción tambien se crean los .class de los demás archivos, si no se llegaran a crear se deben compilar. Pero por defecto al compilar AgendaElectronica se crean por defecto.
```
javac AgendaElectronica.java
javac Calendario.java
javac Cita.java
javac Nota.java
javac Persona.java
```

## Opciones
1. Añadir registro:
Guardar una nueva persona en la agenda, con todos sus datos correspondientes y opcionalmenmte cita(s) y nota(s).

2. Buscar registro:
Imprime los datos de una persona registrada en nuestra agenda, se localiza usando sus nombre, apellido paterno y apellido materno.

3. Eliminar registro:
Elimina los datos de una persona registrada en nuestra agenda, se localiza usando sus nombre, apellido paterno y apellido materno.

4. Modificar registro:
Modifica los datos (excepto notas y citas) de una persona registrada en nuestra agenda, se localiza usando sus nombre, apellido paterno y apellido materno.

5. Imprime calendario:
Imprime el calendario del mes y año deseado.

## Requisitos
+ Contar con Java 17.

Diseñado en Java 17 por Herrera Avalos Julio Alejandro 321170293 para la clase de Bases de Datos.