# base_vehiculo

Microservicio de gestión de vehículos hecho con Spring Boot y PostgreSQL.

## Requisitos

- Java 21
- Maven
- PostgreSQL

## Configurar la base de datos

1. Entra a PostgreSQL con el usuario `postgres`:

   ```bash
   psql -U postgres
   ```

2. Crea la base de datos:

   ```sql
   CREATE DATABASE vehicles;
   ```

Las tablas no hace falta crearlas, porque Hibernate las crea al arrancar la aplicación.

La conexión está en `src/main/resources/application-dev.properties`. La contraseña se toma de la variable de entorno `DB_PASSWORD`; si no la defines, se usa `postgres`.

## Ejecutar

Git Bash, Linux o Mac:

```bash
DB_PASSWORD=tu_contraseña sh run.sh
```

PowerShell:

```powershell
$env:DB_PASSWORD="tu_contraseña"; mvn spring-boot:run "-Dspring-boot.run.profiles=dev"
```

Cuando arranque, en la consola aparece `Tomcat started on port 8081`. La API queda disponible en `http://localhost:8081`. Para detenerla, presiona `Ctrl+C`.

## Endpoints

| Método | URL                                   | Descripción                  |
|--------|---------------------------------------|------------------------------|
| GET    | `http://localhost:8081/vehicles`      | Lista todos los vehículos    |
| GET    | `http://localhost:8081/vehicles/{id}` | Busca un vehículo por id     |
| POST   | `http://localhost:8081/vehicles`      | Crea un vehículo             |

Ejemplo de body para `POST /vehicles`:

```json
{
  "id": "veh-001",
  "plate": "ABC-1234",
  "model": "EcoTruck EV",
  "batteryStatusPercentage": 85,
  "engineStatus": "OK",
  "lastLatitude": 19.4326,
  "lastLongitude": -99.1332,
  "lastMaintenance": "2026-09-01"
}
```

Validaciones:

- `id`, `plate` y `model` son obligatorios.
- `batteryStatusPercentage` debe estar entre 0 y 100.
- `engineStatus` solo puede ser `OK`, `WARNING` o `FAILURE`.

## Estructura del proyecto

```
src/main/java/base_vehiculo/
├── BaseVehiculoApplication.java   # Punto de entrada
├── controller/VehicleController   # Endpoints REST
├── dto/VehicleDto                 # Datos que entran y salen de la API
├── model/Vehicle                  # Entidad JPA (tabla vehicles)
├── repository/VehicleRepository   # Acceso a la base de datos
└── service/VehicleService         # Lógica de negocio
```
