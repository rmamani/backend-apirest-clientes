# backend-apirest-clientes
Api´sRest para la evaluacion de accesibilidad de clientes
# herramientas utlizadas
- Para la implementación de la solucion se utilizó las siguientes versiones:
		Spring boot 3.2.4
		lenguaje java
		proyecto maven
		java 17
- Servidor embebido para iniciar la aplicación
- Al iniciar la aplicacion se crea una BD en H2, se creó un archivo data.sql para insertar 1 registro de persona y 1 de cliente
- El inicio de Base de datos no depende de ninguna instalacion adicional, se crea internamente al iniciar el proyecto
- puerto habilitado 8080
# servicios
- GET localhost:8080/personas - Listado de personas
- POST localhost:8080/personas - Registrar una persona
{      
    "nombre": "Micaela",
    "apellidoPaterno": "Gallardo",
    "apellidoMaterno": "Gonzales",
    "fechaNacimiento": "1990-08-20",
    "direccion": "Zona Cementerio avenida 23 nro 43",
    "ci": "16161616"
}
- GET http://localhost:8080/clientes - Listado de clientes
- POST http://localhost:8080/clientes - Registrar cliente
{
        "email": "cliente@correo.com.bo",
        "telefono": "2863656",
        "ocupacion": "Consultor independiente",
        "persona": 
          { 
            "nombre": "Thiago",
            "apellidoPaterno": "Bedoya",
            "apellidoMaterno": "Martinez",
            "fechaNacimiento": "1990-03-23",
            "direccion": "Av. Buenos Aires calle Gallardo Nro 234",
            "ci": "23231000"}
        
}
- POST http://localhost:8080/referencia - adicionar referencia de un cliente, debemos ingresar el id del cliente
{      
    "idCliente": "1",
    "referenciaList": [
        {   "nombre": "Pedro Daniel",
            "apellidoPaterno": "Morales",
            "apellidoMaterno": "Tejada",
            "fechaNacimiento": "1985-08-20",
            "direccion": "Alamos nro 34",
            "ci": "212121"}
    ]
}

- GET http://localhost:8080/referencia
- DELETE http://localhost:8080/referencia/1  - Se pasa como parametro el Id de referencia en caso de no existir muestra el mensaje ID NO ENCONTRADO
# Ejecución del proyecto
- Clonar el proyecto y ejecutar como un proyecto spring
- Para IntelliJ
1.  Desde el IntellyJ abrimos el proyecto File/Open
2. Seleccionamos la pestaña run y vamos a Edit Configurations
3.  Seleccionamos el signo + y luego vamos a maven
4. En el campo run , seleccionamos "spring-boot:run"
y hacer click en OK

GET http://localhost:8080/clientes/1 - Lista la accesibilidad del cliente
# Manejo de excepciones
- Las exepciones se personalizaron en el siguiente paquete
- com.gestion.clientes.exception

