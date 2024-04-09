# HDT8

Este proyecto consiste en un sistema de gestión de prioridades para pacientes en una emergencia médica. Utiliza dos enfoques diferentes: uno implementado manualmente utilizando un Vector como base (en el archivo `Main.java`), y otro utilizando la clase `PriorityQueue` del Java Collections Framework (en el archivo `Prior.java`).

## Descripción de los archivos

- `Main.java`: Contiene una implementación de un VectorHeap para gestionar las prioridades de los pacientes.
- `Prior.java`: Utiliza la clase `PriorityQueue` del Java Collections Framework para lo mismo.
- `Paciente.java`: Clase que define la estructura de un paciente.
- `pacientes.txt`: Archivo de texto que contiene la lista de pacientes y su información.

## Ejecución del proyecto

### Prerrequisitos
- Java JDK instalado en el sistema.

### Pasos para ejecutar
1. Clonar el repositorio: `git clone https://github.com/tuusuario/tuproyecto.git`
2. Compilar el proyecto: `javac Main.java` o `javac Prior.java`
3. Ejecutar el proyecto: `java Main` o `java Prior`

## Detalles de implementación

- `Main.java` implementa un VectorHeap manualmente para gestionar las prioridades de los pacientes.
- `Prior.java` utiliza la clase `PriorityQueue` del Java Collections Framework para lo mismo, lo que simplifica el código.
- Ambos archivos leen la lista de pacientes desde el archivo `pacientes.txt` y los procesan según su código de emergencia.
