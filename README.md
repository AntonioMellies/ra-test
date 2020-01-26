# RESTful API - Customers complaints

RESTful API to query information on customers complaints about services provided by companies

## Used Technologies :

- **Spring Boot**
- **Maven**
- **Lombok**
- **Microservices**
- **Eureka Server / Client**
- **Zuul Proxy**
- **Swagger 2**
- **MongoDb**
- **MongoDb Geospatial**
- **Docker**

 
## Description

This project was developed using a microservice structure, in which each module has specific functionality to make the solution scalable.

Are they:

   - **Discovery:** Responsible for making available the status of all registered microservices  
        
   - **Gateway:** Responsible for routing requests from microservices

   - **Consumers:** API - Operations pertaining to consumer
        
   - **Complaints:** API - Operations pertaining to complaint

   - **Companies:** API - Operations pertaining to company

The project has a **domain** module. This module is common across the project and the entities, DTOs and exceptions are stored there.

## Build & Run

To Build projects:
```shell script
mvn clean install
```

To run:
```shell script
docker-compose up -d --build
```

To stop:
```shell script
docker-compose down
```


### EndPoints information and documentation (Swagger)
  
The configuration of the swagger was performed centrally, so that it is possible to consult the documentation of all APIs accessing only a single URL.

URI for swagger: http://localhost:8662/swagger-ui.html

### Observations

  * Lombok
  
    This project was developed using the [Lombok](https://projectlombok.org/) library focusing on productivity and code reduction. 
    Therefore, for everything to work correctly at the development level, it is necessary to install a plugin in your IDE.
    Instructions for this are on the official website. [website](https://projectlombok.org/)
    
### Authors
[Antonio Frederico Mellies Neto](https://antoniomellies.github.io/)
