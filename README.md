# Rest API to create/update/query server 




# Building jar and testing


 1. Change to the directory where you down loaded the source.
 
 2. In the first window, build the application using `mvn clean package`
 
 3. In the same window run: `java -jar target/rackspace-web-services-1.0-SNAPSHOT.jar`
 
 4. In postman app select GET - use link: [localhost:8080/api/serverinfo/] to information about all servers.
 
 5. In postman app select GET - use link: [localhost:8080/api/serverinfo/{id}]  to get information about specific server.
 
 6. In postman app select POST - use link: [localhost:8080/api/serverinfo/]
 	Paste information below to add new server
 	{"name":"newRackspaceServer","cpus":8,"ram":8, "status":"Running","diskspace":80}
 	Run Step 4 again to verify that server is added.
 	
 7. In postman app select DELETE - use link: [localhost:8080/api/serverinfo/{id}] 
 	Run Step 4 again to verify that server is deleted.
 	
 8. In postman app select PUT - use link: [localhost:8080/api/serverinfo/{id}]
 	{"id":2,"name":"newtestServer","cpus":6,"ram":12,"status":"Building","diskspace":120}
 	Run Step 4 again to verify that ram and diskspace for server 2 are updated.
 
 NOTE : Test cases are created to test business logic, haven't wrote test cases to test controller.

