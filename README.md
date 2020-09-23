# Repeat-Sequence

Dada una secuencia de alfanumérica, desarrollar un algoritmo que permita eliminar secuencias
repetidas retornando otra secuencia de esas repeticiones.

Por ejemplo:
- malayalam: mym
- rotomotor: rmr
- anana: a

----------------------------------------------------------------------

###### Versión 
- java: 1.8
- spring: 2.3.4
- swagger: 2.9.2

## Spring Boot Application - REST API 

### Endpoints:

#### Check status: 
#### GET -> http://localhost:8080/api/health
##### Response: 

> {
> "Estado":  "OK",
>"DateTime":  "2020-09-23T09:23:50.573"
> }

#### Remove repeat sequence: 
#### POST -> http://localhost:8080/api/remove-seq-repeat
##### Body: 

> {
> "sequence" : "malayalam"
> }

##### Response:

>{
>    "success": true,
>    "data": "mym",
>    "message": null,
>    "date": "2020-09-23 09:28:55",
>    "errores": null
>}

##### Otras respuestas:

>Body: {
>    "sequence" : ""
>}
>
>Response: {
>    "success": false,
>    "data": null,
>    "message": "The sequence cannot be empty or null",
>    "date": "2020-09-23 09:31:34",
>    "errores": [
>        "The sequence cannot be empty or null"
>    ]
>}


>Body: {
>    "sequence" : "jcabrera"
>}
>
>Response: {
>    "success": false,
>    "data": null,
>    "message": "jcabrera is not a palindrome",
>    "date": "2020-09-23 09:31:34",
>    "errores": [
>        "jcabrera is not a palindrome"
>    ]
>}

-----------------------------------------------------------------

### Swagger UI -> http://localhost:8080/swagger-ui.html#/


