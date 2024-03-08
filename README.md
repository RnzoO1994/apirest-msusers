Proyecto msusers
API Rest for Creating Users

Requisitos
JDK  1.8.0_202
Spring Framework 2.5.3
Maven 3.8
port 8085
Pasos para levantar el proyecto:
1. Clonar el repositorio utilizando el siguiente comando:

git clone https://github.com/RnzoO1994/apirest-msusers.git
(Es preferible crear una carpeta donde se desee clonar el repositorio y utilizar la consola de git)ss

2. Ir a la carpeta principal del proyecto y abrir una ventana de comandos. Ejecutar el siguiente comando:
mvn clean install

3. Ejecutar en la misma ventana de comandos el siguiente comando:

java -jar target/msusers-0.0.1.jar

4. Acceder a la aplicación:
Copiar la siguiente ruta en el navegador:  http://localhost:8085/swagger-ui.html

5. Probar el servicio create-user. Se adjunta un JSON de prueba. Modificar los datos y enviar la petición.

{
  "name": "Usuario nuevo",
  "email": "newuser14@dominio.cl",
  "password": "pasword12",
  "phones": [
    {
      "number": "85214",
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
6. También se puede probar utilizando Postman, para ello se debe importar la collecion. En la carpeta raíz del proyecto, se adjunta el archivo : Prueba msusers.postman_collection.json
