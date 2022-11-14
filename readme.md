# Integrador 5 
 ### Alumnos : 
 - Bedrossian Agustina
 - Blanco Lucía
 - Casado Horacio

----
### Consignas :

Tome como punto de partida el ejercicio integrador del TP3
1) Documentar los endpoints REST con Swagger (OpenAPI).
2) Realizar un informe de 2 páginas que describa el diseño de la aplicación, e incluye los diagramas
   que considere adecuados. Incluya qué cambios haría para una transición del sistema a
   microservicios.
3) Despliegue la aplicación en el sistema Heroku.
   a. Documente cómo testear la aplicación desplegada.


## Testeo de la aplicación

### Postman
La api se puede testear utilizando la colección de Postman entregada en el tp3 utilizando el siguiente enlace como url base:

https://integrador5-arq-web-tudai.herokuapp.com

Algunos ejemplos de endpoints son:
- https://integrador5-arq-web-tudai.herokuapp.com/students
- https://integrador5-arq-web-tudai.herokuapp.com/students?sortBy=name
- https://integrador5-arq-web-tudai.herokuapp.com/careers?withStudents=true&sortBy=enrolledAmount
- https://integrador5-arq-web-tudai.herokuapp.com/inscription/reports

### Swagger
También es posible realizar el testing a través de la documentación de Swagger siguiendo el siguiente enlace:

https://integrador5-arq-web-tudai.herokuapp.com/swagger-ui/#/

1. Se tiene que expandir uno de los grupos de endpoints, por ejemplo los del tag **Estudiantes**
2. Hacer click en uno de los servicios por ejemplo **POST /students**
3. Presionarl el botón **Try it out** para hacer una petición
4. Ingresar el body de la petición por ejemplo los siguientes datos:
5.  {
  "city": "Tandil",
  "documentNumber": 12345678,
  "gender": "male",
  "name": "Javi",
  "surname": "Dottori"
}
6. Presional el botón **Execute**
7. Debajo se va a visualizar el código de estado y el body de de la respuesta, de está forma se crea un estudiante con número de libreta 1, por ser el primero
8. A continuación se puede utilizar el servido **GET /students/{id}** para buscar el estudiante creado
9. Si se pone un 1 en el campo id, te busca el estudiando con número libreta 1, que se va a corresponder con el creado previamente


