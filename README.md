# Plataforma de Microservicios Bancarios

## Descripción General

Este repositorio contiene un **sistema bancario en desarrollo**, diseñado bajo una **arquitectura de microservicios** utilizando **Java y Spring Boot**. El objetivo del proyecto es demostrar habilidades de backend a nivel profesional, alineadas con los estándares utilizados por consultoras y entidades financieras.

El enfoque principal está en **seguridad, arquitectura limpia y lógica de negocio real**, evitando ejemplos simplificados o puramente CRUD.

---

## Arquitectura

La plataforma está compuesta por servicios independientes que se comunican vía HTTP:

* **Auth Service** – Autenticación y autorización mediante JWT
* **Account Service** – Gestión de cuentas y consultas de saldo
* **Transaction Service** – Operaciones monetarias y lógica transaccional
* **Audit Service** – Registro centralizado de eventos y trazabilidad (opcional)
* **Frontend (JavaScript)** – Cliente simple que consume las APIs

```
[ Frontend JS ]
       ↓
[ Auth Service ]  → Seguridad JWT
       ↓
[ Account Service ]
       ↓
[ Transaction Service ]
       ↓
[ Audit Service ]
       ↓
[ MySQL ] + [ Redis ]
```

---

## Estado Actual del Proyecto

Actualmente, el **Auth Service** se encuentra implementado y funcional, mientras que los demás servicios están en desarrollo.

### Funcionalidades ya implementadas

* Arquitectura de microservicios definida y estructurada
* Seguridad stateless con **Spring Security + JWT**
* Control de acceso basado en roles
* Persistencia con **MySQL** usando **Spring Data JPA**
* Validaciones a nivel de aplicación y base de datos
* Validaciones personalizadas (por ejemplo, evitar duplicidad de usuarios con `@UsernameUnique`)
* Gestión global de excepciones con respuestas JSON profesionales
* **Documentación interactiva con Swagger (OpenAPI 3)**
* Ejecución del entorno de base de datos mediante **Docker**

Los servicios de Account, Transaction y Audit se encuentran estructurados y serán implementados progresivamente.

---

## Tecnologías Utilizadas

* Java 17+
* Spring Boot
* Spring Security
* JWT (JSON Web Tokens)
* Spring Data JPA
* Maven
* MySQL
* Docker
* Redis (planificado)
* Swagger / OpenAPI 3
* JavaScript (frontend, planificado)

---

## Ejecución del Proyecto

Cada microservicio es una aplicación Spring Boot independiente.

Ejemplo (Auth Service):

```bash
cd auth-service
mvn spring-boot:run
```

Los servicios utilizan las siguientes configuraciones de puertos:

* Auth Service: 8081
* Account Service: 8082
* Transaction Service: 8083
* Audit Service: 8084

La base de datos MySQL se ejecuta mediante Docker.

---

## Propósito del Proyecto

Este proyecto fue desarrollado como **proyecto de portafolio profesional**, con el objetivo de demostrar:

* Desarrollo backend con Java y Spring Boot
* Diseño de APIs seguras
* Arquitectura basada en microservicios
* Manejo de transacciones y lógica de negocio real
* Documentación profesional de APIs
* Preparación para entornos empresariales

---

## Próximos Pasos

* Implementación completa de Account Service
* Desarrollo del Transaction Service con lógica transaccional
* Integración de Redis para caching y sesiones
* Implementación del Audit Service
* Desarrollo de un frontend en JavaScript que consuma las APIs

---

## Autor

Desarrollado por **Dayro Rojas**
