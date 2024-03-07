# Proyecto msusers

Api Rest for Creating Users
## Requisitos
- JDK 17
- Spring Framework 3.2.3
- Maven 3.8

Pasos para levantar el proyecto:

1. Clonar el repositorio utilizando el siguiente comando [ git clone https://github.com/RnzoO1994/apirest-msusers.git]
(de preferencia crear una carpeta donde se desee clonar el repositorio, utilizar la consola de git)
2. ir a la carpeta principal del proyecto y abrir una ventana de comandos. Ejecutar el siguiente comando : mvn clean install
3. Ejecutar en la misma ventana de comandos, el siguiente comando: 
java -jar target/msusers-0.0.1.jar
4. Acceder a la aplicacion:
copiar la siguiente ruta en el navegador: http://localhost:8080/doc/swagger-ui/index.html
5. Probar el servicio create-user. Adjunto un json de prueba. Modificar los datos y enviar la petición.
{
  "name": "Usuario nuevo",
  "email": "newUser12334@dominio.cl",
  "password": "123456ab",
  "phones": [
    {
      "number": "123456",
      "cityCode": "1",
      "countryCode": "60"
    },
        {
      "number": "1234567",
      "cityCode": "2",
      "countryCode": "5734"
    }
  ]
}
5. Tambien se puede probar utilizando postman, en la raiz del proyecto adjunto la coleccion.






