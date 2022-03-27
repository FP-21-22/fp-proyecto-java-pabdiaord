# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: Pablo Diaz Ordoñez   uvus:pabdiaord




## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  	* **\<fp.clinico\>**: Paquete que contiene los tipos record Paciente, PacienteEstudio y Persona, junyo con el enumerado TipoResidencia.
  	* **\<fp.farmaceutico.test\>**: Paquete que contiene las clases de test de fp.farmaceutico.
  	* **\<fp.farmaceutico\>**: Paquete que contiene los tipos Medicamento y FactoriaMedicamento (clases) y el enumerado TipoMedicamento.
	* **\<fp.vacunas\>**: Paquete que contiene el tipo Vacunacion (clase).
  	* **\<fp.utiles\>**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<dataset1.csv\>**: Añade una descripción genérica del dataset.
    * **\<dataset2.csv\>**: Añade una descripción del resto de datasets que puedas tener.
* **/doc**: Contiene el documento o documentos de información de cómo realizar el proyecto.
	* **Proyecto de laboratorio de Java_SUBGRUPO_IS2_3.pdf**: Añade la descripción de realización de la entrega 1.
    
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por \<N\> columnas, con la siguiente descripción:

* **\<columna 1>**: de tipo \<tipo\>, representa....
* **\<columna 2>**: de tipo \<tipo\>, representa....
....

## Tipos implementados

Describe aquí los tipos que usas en tu proyecto.

### Tipo Persona
Implementado con un Record en fp.clinico.

**Propiedades**:

- nombre, de tipo String, consultable. 
- apellidos, de tipo String, consultable. 
- dni, de tipo String, consultable.
- fechaNacimiento, de tipo LocalDate, consultable.

 
**Constructores**: 

- El que aporta el record.
- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.


**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual.
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra.

**Representación como cadena**: por defecto asociado al record.

**Criterio de igualdad**: Describir el criterio de igualdad. El que da el record

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay). Por el dni

**Otras operaciones**:
 
-	sonDigitos: Método que dada una cadena, devuelve true o false si cumple la condición de ser todos sus caracteres digitos.
-   edad: Propiedad derivada que devulve la edad de la persona.
-	of: recibe nombre, apellidos, dni y fecha de nacimiento y devuelve una persona.
-	parse: Recibe una cadena con un formato específico y devuelve una persona.

### Tipo Paciente
Implementado con un Record en fp.clinico.

**Propiedades**:

- persona, de tipo Persona, consultable. 
- codigoIngreso, de tipo String, consultable. 
- fechaHoraIngreso, de tipo LocalDateTime, consultable.


 
**Constructores**: 

- El que aporta por defecto el record.


**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha actual.

**Representación como cadena**: por defecto asociado al record.

**Criterio de igualdad**: Describir el criterio de igualdad. El que aporta por defecto el record

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay). No hay.

**Otras operaciones**:
 
-	fechaIngreso: Propiedad derivada que a partir de fechaHoraIngreso devuelve la fecha de ingreso de tipo LocalDate .
-   horaIngreso: Propiedad derivada que a partir de fechaHoraIngreso devuelve la hora de ingreso de tipo String.
-	of: recibe nombre, apellidos, dni, fecha de nacimiento, código y fecha y hora de
	ingreso y devuelve un paciente.
-	of: recibe un objeto persona, un código y una fecha y hora de ingreso y devuelve
	un paciente.

### Tipo PacienteEstudio
Implementado con un Record en fp.clinico.

**Propiedades**:

- id, de tipo String, consultable. 
- genero, de tipo String, consultable. 
- edad, de tipo Double, consultable.
- hipertension, de tipo Boolean, consultable.
- enfermedadCorazon, de tipo Boolean, consultable.
- tipoResidencia, de TipoResidencia(enumerado que puede coger los valores rural o urbana), consultable.
- nivelMedioGlucosa, de tipo Double, consultable.

 
**Constructores**: 

- El que aporta por defecto el record.



**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130.
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero.

**Representación como cadena**: informa del id y la edad del paciente.

**Criterio de igualdad**: Describir el criterio de igualdad. Por defecto asociado al record

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay). Según la edad y el id.

**Otras operaciones**:
 
-	factorDeRiesgo: Propiedad derivada que determina si un paciente es factor de riesgo o no(si tiene hipertensión y más de 40 años).
-   esBooleano: Método auxiliar para parsear una cadena a Boolean.
- 	tipo: Método auxiliar para parsear una cadena a uno de los posibles valores del enumerado TipoResidencia.
-	of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
-	parse: recibe una cadena con un formato especificado y y devuelve un objeto del
	tipo.

### Tipo Vacunacion
Implementado con un Record en fp.vacunas.

**Propiedades**:

- fecha, de tipo LocalDate, consultable. 
- comunidad, de tipo String, consultable. 
- pfizer, de tipo Integer, consultable.
- moderna, de tipo Integer, consultable.
- astrazeneca, de tipo Integer, consultable.
- janssen, de Integer, consultable.
- numeroPersonas, de tipo Integer, consultable.

 
**Constructores**: 

- El que aporta por defecto el record.



**Restricciones**:
 
- R1: La fecha de debe ser posterior al 01/02/2021.


**Representación como cadena**: por defecto asociado al record.

**Criterio de igualdad**: Describir el criterio de igualdad. Por defecto asociado al record

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay). Por comunidad y en caso de igualdad por fecha.

**Otras operaciones**:
 
-	numeroTotal: Propiedad derivada que determina el total de dosis de vacunas.
-	of: recibe valores para cada propiedad básica y devuelve un objeto del tipo.
-	parse: recibe una cadena con un formato específico y devuelve un objeto del tipo.

### Tipo Medicamento
Implementado con una clase en fp.farmaceutico.

**Propiedades**:

- nombreMedicamento, de tipo String, consultable. 
- tipoMedicamento, de tipo TipoMedicamento(enumerado que puede coger los valores anatómico, químico y terapéutico), consultable. 
- codigoEnfermedad, de tipo String, consultable.
- farmaceutica, de tipo String, consultable.
- puntuacion, de tipo Double, consultable.
- indiceSomatico, de tipo Integer, consultable.
- fechaCatalogo, de tipo LocalDate, consultable y modificable.
 
**Constructores**: 

- C1: A partir de cada una de las propiedades básicas, se crea un constructor del tipo Medicamento.


**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero.
- R2: El índice somático tiene que ser mayor o igual que 1000.
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015.

**Representación como cadena**: según el nombre del medicamento y de la farmaceutica.

**Criterio de igualdad**: por nombre del medicamento y farmacéutica.

**Criterio de ordenación**: por nombre del medicamento y en caso de igualdad por la farmacéutica.

**Otras operaciones**:
 
-	tratarEnfermedad: Propiedad derivada de tipo Boolean que será cierta si el código de la enfermedad es igual
						al parámetro de tipo cadena que se recibe.

#### Tipos auxiliares
Descripción de los tipos auxiliares que sean necesarios añadir al proyecto.
- Se ha creado una clase de nombre TestFactoriaMedicamentos en un paquete de nombre fp.farmaceutico.test
para comprobar el funcionamiento del método parseaMedicamento entre otras cosas.

### FactoriaMedicamentos
Descripción breve de la factoría.

- 	parseaMedicamento: recibe una cadena con un formato específico y devuelve un objeto de tipo Medicamento.
-	tipo: Dada una cadena, realiza el parseo de esa cadena al tipo correspondiente del enumerado TipoMedicamento.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
