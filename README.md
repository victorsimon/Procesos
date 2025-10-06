# Gestión de Procesos Concurrentes

## Origen del Proyecto

Este proyecto es una prueba técnica desarrollada para Inditex. La solución inicial fue implementada durante una sesión en directo de 1 hora, y posteriormente evolucionada con mejoras y funcionalidades adicionales.

## Estructura del Desarrollo

- **Commit inicial**: La implementación básica realizada durante la prueba técnica en directo (segundo commit del repositorio)
- **Rama de evolución**: Desarrollo posterior con mejoras y funcionalidades extendidas en una rama separada

## Descripción Original de la Prueba Técnica

**Prueba Técnica: Gestión de Procesos Concurrentes**

**Duración**: 1 hora  
**Modalidad**: Online con pantalla compartida  
**Objetivo**: Evaluar conocimientos prácticos en Java, Spring Boot, arquitectura, buenas prácticas y patrones.

### Contexto del Ejercicio

Se desea desarrollar un sistema para gestionar la ejecución en paralelo de diferentes procesos. Cada proceso tiene una fecha de inicio y una fecha de fin.

### Requisitos Técnicos

#### CRUD de Procesos
Implementar un controlador REST que permita:
- Crear un proceso
- Listar todos los procesos
- Implementar Test Unitarios método POST

Cada proceso debe tener:
- ID
- Nombre
- Fecha de inicio
- Fecha de fin

#### Consulta de estadísticas de los procesos
Implementar un endpoint adicional:
- `GET /procesos/statistics?inicio=YYYY-MM-DDTHH:mm&fin=YYYY-MM-DDTHH:mm`

Este endpoint debe devolver:
- Número total de procesos
- Número de procesos activos (fecha entre inicio y fin)
- Agrupación por nombre con cantidad de procesos por grupo
- Rango de fechas

### Aspectos a Evaluar

| Área | Detalles |
|------|----------|
| Java & Spring Boot | Uso correcto de anotaciones, estructura del proyecto |
| Arquitectura Hexagonal | Separación de capas, uso de puertos y adaptadores |
| SOLID & Clean Code | Legibilidad, mantenibilidad, testabilidad |
| Spring Data | Uso de repositorios, consultas |
| Programación Funcional | Uso de streams, lambdas, manejo de fechas |
| Patrones de Diseño | Aplicación adecuada (por ejemplo, Strategy para cálculo de concurrencia) |
| Buenas Prácticas | Validaciones, manejo de errores, claridad del código |
| Testing | Generar test unitarios que cubran el 100% de una de las clases implementadas |
| Mensajería Asíncrona (Bonus) | Simulación de evento "ProcesoCreado" enviado a una cola ficticia |

### Formato de la Prueba

- El candidato comparte pantalla y explica brevemente su enfoque antes de comenzar.
- Puede usar su IDE preferido.
- Se permite buscar documentación online.
- El entrevistador puede hacer preguntas durante el desarrollo para evaluar razonamiento.

## Características de la Implementación

Esta solución incluye:
- API REST completa para gestión de procesos
- Endpoint de estadísticas con agrupaciones y filtros temporales
- Arquitectura hexagonal bien definida
- Tests unitarios comprensivos
- Validaciones y manejo de errores
- Uso de programación funcional donde aplica

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- JUnit/Mockito para testing
- Maven/Gradle
