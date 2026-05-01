# SurveyApiRest

API REST para registrar encuestas sobre estilos musicales favoritos y consultar resultados agregados para graficos.

## Objetivo

Este proyecto expone los servicios backend de una encuesta musical. Permite:

- Consultar los estilos musicales disponibles.
- Registrar el estilo musical favorito de una persona junto con su correo electronico.
- Obtener estadisticas agrupadas por estilo musical para consumirlas desde un frontend.

## Stack principal

- Java 8
- Spring Boot 2.7.13
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database en memoria
- Maven Wrapper
- JUnit 5, Mockito y Testcontainers para pruebas

## Ejecucion local

Desde la raiz del proyecto:

```bash
./mvnw spring-boot:run
```

La aplicacion se levanta por defecto en:

```text
http://localhost:8080/Survey
```

El contexto base `/Survey` esta configurado en `src/main/resources/application.properties`.

## Base de datos

La API usa una base H2 en memoria configurada con:

```properties
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false;MODE=PostgreSQL
spring.datasource.name=sa
spring.datasource.password=
```

Las tablas se crean desde `src/main/resources/schema.sql`:

- `TA_MUSICSTYLE`: catalogo de estilos musicales.
- `TA_SURVEYMUSICFAV`: encuestas registradas.

Los datos iniciales se cargan desde `src/main/resources/data.sql`.

Con la aplicacion corriendo, la consola H2 queda disponible en:

```text
http://localhost:8080/Survey/h2-console
```

Datos de conexion:

- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: vacio

## Endpoints

Todos los endpoints usan como base:

```text
http://localhost:8080/Survey
```

### Obtener estilos musicales activos

```http
GET /api/musicstyle/get
```

Retorna los estilos musicales con `activado = true`.

Ejemplo de respuesta:

```json
[
  {
    "id": 1,
    "nombre": "Rock",
    "activado": true
  },
  {
    "id": 2,
    "nombre": "Pop",
    "activado": true
  }
]
```

### Registrar encuesta

```http
POST /api/survey-music/
Content-Type: application/json
```

Body:

```json
{
  "email": "usuario@example.com",
  "idMusicStyle": 1
}
```

El servicio asigna automaticamente `fechaCreacion` y normaliza el correo a minusculas antes de guardar.

Respuesta exitosa:

```json
true
```

### Obtener encuestas registradas

```http
GET /api/survey-music/get
```

Retorna las encuestas almacenadas en la base H2.

Ejemplo de respuesta:

```json
[
  {
    "id": 1,
    "fechaCreacion": "01-05-2026 10:30:00",
    "email": "random@gmail.com",
    "idMusicStyle": 5
  }
]
```

### Obtener datos para grafico

```http
GET /api/survey-music/chart
```

Retorna la cantidad de encuestas agrupadas por estilo musical. La respuesta usa las propiedades `name` y `value` para facilitar su consumo desde componentes de graficos.

Ejemplo de respuesta:

```json
[
  {
    "name": "Rock",
    "value": 3
  },
  {
    "name": "Pop",
    "value": 1
  }
]
```

## Pruebas

Para ejecutar los tests:

```bash
./mvnw test
```

Las pruebas cubren principalmente:

- Filtro de estilos musicales activos.
- Registro de una encuesta via `POST /api/survey-music/`.
- Consulta de datos agregados para el grafico.

## Construccion

El proyecto esta configurado con empaquetado `war`.

```bash
./mvnw clean package
```

El artefacto generado queda en `target/`.
