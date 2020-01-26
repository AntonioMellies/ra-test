# RESTful API - Customers complaints

### Introducion
RESTful API to query information on customers complaints about services provided by companies

---
### Technologies

- Spring Boot
- Maven
- Lombok
- Microservices
- Eureka Server / Cllint
- Zuul Proxy
- Swagger
- MongoDb
- MongoDb Geospatial
- Docker

 
### Description

This project was developed using a microservice structure, in which each module has specific functionality to make the solution scalable.

Are they:

   - #####Discovery
        - Responsible for making available the status of all registered microservices  
        
   - #####Gateway
        - Responsible for routing requests from microservices

   - #####Consumers
        - API - Operations pertaining to consumer
        
   - #####Complaints
        - API - Operations pertaining to complaint

   - #####Companies
        - API - Operations pertaining to company

The project has a module called Domains. This module is common across the project and the entities, DTOs and exceptions are stored there.


### Getting Started

 * #####Create database
    
    ```docker
    docker-compose up -d
    ```
  * #####Lombok
  
    This project was developed using the [Lombok](https://projectlombok.org/) library focusing on productivity and code reduction. 
    Therefore, for everything to work correctly at the development level, it is necessary to install a plugin in your IDE.
    Instructions for this are on the official website. [website](https://projectlombok.org/)
    
  * #####Build
  
    There is no sequence to build the microservices, but when the discovery and gateway services are started after the API's, a few seconds are needed to use the endpoints.
    
  * #####Swagger
  
    The configuration of the swagger was performed centrally, so that it is possible to access the documentation of all APIs by accessing only a single URL.    
    http://localhost:8662/swagger-ui.html
    
### Authors
[Antonio Frederico Mellies Neto](https://antoniomellies.github.io/)