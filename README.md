# springboot-hibernate-criteria-envers
A simple Spring-Boot rest application with hibernate criteria for consults per filter, hibernate envers for auditable logs, swagger, and tests integration with cucumber.

To run: 

mvn clean install

mvn spring-boot:run

Endpoints

* http://localhost:9090/tasks/v1/{id} (GET) get by id
* http://localhost:9090/tasks/v1/ (GET) get all
* http://localhost:9090/tasks/v1/?name=teste (GET) find by filter
* http://localhost:9090/tasks/v1/ (POST) insert. json= {"name":"name", "startDate":"15/05/2017"}
* http://localhost:9090/tasks/v1/ (PUT) update. json= {"id":"1", "name":"name updated", "startDate":"16/05/2017", "version":"0"}
* http://localhost:9090/tasks/v1/{id} (DELETE) delete by id

* http://localhost:9090/tasks/v1/revisions/{id} (GET) get all revisions of tasks entitys.
 
 
 RevType - Type revisions standard of hibernate envers.
* RevType 0 = Insert
* RevType 1 = Update
* RevType 2 = Delete

Swagger
 * http://localhost:9090/swagger-ui.html/ Access to api documentation.

#### TODO
* update database properties in application.properties (main and test)
* implement internacionalization
