EventMasterPro

EventMasterPro es una aplicación de escritorio desarrollada en Java con Swing para gestionar eventos y la venta de entradas (tickets). El sistema permite crear eventos, asignar tickets, realizar compras, validar entradas y consultar historial.

Funcionalidades principales:
- Gestión de eventos: Crear y modificar eventos con nombre, fecha y ubicación.
- Asignación de tickets: Cargar diferentes tipos de entradas con su precio y cantidad.
- Compra de tickets: Ver disponibilidad y realizar compras individuales.
- Validación de entradas: Confirmar la validez de un ticket comprado.
- Historial: Consultar las compras hechas por cada asistente.

Tecnologías utilizadas:
- Lenguaje: Java 8+ con JDK 17.0.5
- Interfaz gráfica: Java Swing
- Base de datos: MySQL
- Conexión: JDBC (mysql-connector-java)

Componentes principales_
- CreateEvent.java: Ventana para crear eventos.
- ModifyEvent.java: (Opcional) Modificación de eventos existentes.
- CreateTicketsForEvent.java: Crear tickets para eventos específicos.
- BuyTickets.java: Comprar tickets disponibles.
- TicketValidator.java: Validar tickets comprados.
- History.java: Mostrar historial de tickets por asistente.
- DBConnection.java: Conexión a base de datos.

Requisitos: 
- Java 8 o superior
- Java JDK en su version 17, preferiblemente 17.0.5
- Servidor MySQL en funcionamiento
- Base de datos eventmasterpro con las siguientes tablas:
    artist, artistrecord, assistant, event, eventartist, history, location, prueba, record, ticket
    notas: se adjunta un archivo .sql de la base de datos en: EventMasterPro\src\main\java\Connection\eventmasterpro.sql
  
Instrucciones para ejecutar:
1. Clonar el proyecto o copiar los archivos fuente.
2. Configurar la conexión a MySQL en DBConnection.java.
3. Compilar y ejecutar desde tu IDE preferido (NetBeans, IntelliJ, Eclipse).
4. Interactuar con la interfaz para administrar eventos y tickets.

Autor:
Kevin Alejandro Rios
Estudiante de Ingeniería en Software
Medellín, Colombia
