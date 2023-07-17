# SurveyApiRest
REST Api de Encuestas de estilos Musicales favoritos

# Objetivo
Se propone el levantamiento de una encusta a realizar por medio de 2 proyectos, uno de ellos es un REST Api
que un usuario se contecte y pueda ingresar su estilo de musica favorito, seleccionado en un DDL (Drop Down List)
la musica y ingresado un correo electronico.

# Descripcion
Por defecto la aplicacion se levanta en el puerto :8080 que levanta una base de datos H2 en Embedded(Incorporado) 
usando capa de persistencia JPA, el cual tiene a dispocicion 2 tablas TA_MUSICSTYLE y TA_SURVEYMUSICFAV que se alimentan
de datos ingresados para realizar distintas pruebas (Test Unitarios).
Dispone de 3 servicios REST para consumir:

1: ESTILOS MUSICALES
PATH : /api/musicstyle/get
METHOD : GET
Descripcion : Retorna una lista(Array) de JSON de que contiene las Musicas que puede seleccionar el usuario durante la encuensta 

2: ENVIAR ENCUSTA
PATH : /api/survey-music/
METHOD : POST
Descripcion : Resive un JSON que contiene el Id del estilo de musica elegido y el correo electronico de la persona, retorna un booleano
verdadero(true) cuando fue ingresado exitosamente y falso(false) cuando hubo algun error durante la transaccion.

3: ESTADISTICA
PATH : /api/musicstyle/chart
METHOD : GET
Descripcion : Retorna una lista, que muesta las cantidades de encuestas realizas por musicas seleccioandas, para ser mostrados por Grafico en la Front-end.
