
# GovTech Assignment by Peter Lee

A mini Angular + Spring Boot project to allow user add restaurant and draw random restaurant.

## Backend Requirement

For building and running the application you need:

- [JDK 1.8](https://www.oracle.com/sg/java/technologies/javase/javase8-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Frontend Requirement

- [Node.js](https://nodejs.org/en)

## Running the application locally

This section describe how to run the application locally, which include 2 parts: Backend (Spring Boot) and Frontend (Angular)

### Backend (Spring Boot)

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.govtech.demo.DemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) and run the following command on `demo` directory (a.k.a same directory as `pom.xml`):

```shell
mvn spring-boot:run
```

### Frontend (Angular)

Run the following command on `random-restaurant-generator` directory (a.k.a same directory as `package.json`) to install the project dependencies

```shell
npm install
```
Once intall, run the following command to start the application

```shell
ng serve
```

## Links

You can access the following links once you have successfully started the application

- [Webpage](http://localhost:4200/)
- [Swagger UI](http://localhost:8080/swagger-ui/index.html)
