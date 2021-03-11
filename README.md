## Cielo Payments - API

#### Tecnolgies

```aidl
 Java 8
 Spring Boot
 Hibernate
 JPA
 Docker
 PostgreSQL
 H2 Database
 Lombok
 JUnit
```

### Documentation Swagger

Project Running

http://localhost:8082/swagger-ui.html#/

### Requirements

```aidl
PostgreSQL installed
Java 8 installed
Docker installed
```

### Clone project
```
git clone https://github.com/MarLubanco/cielo-payments-api.git
cd cielo-payments-api
```

### Practices and Architecture

```
Clean Code
Clean Architecture
TDD
```

### Run project

```dockerfile
docker pull marthome/cielo-payments-api:1.0

docker run --name cielo-payments -e USER_DATABASE=<user> -e PASSWORD_DATABASE=<password> -p 8082:8082 marthome/cielo-payments-api:1.2
```
