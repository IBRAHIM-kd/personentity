Java Springboot framework REST API to expose CRUD operation on a "person" entity. Application

- Dev spec install is Java JDK 11

- Apache Maven 3.6.3

- MYSQL Database 

To runs perform below Steps ...... :- 

git clone https://github.com/IBRAHIM-kd/personentity.git

cd personentity

mvn clean install

mvn spring-boot:run


THAN RUN WITH curl command TO RUN THE ENDPOINTS.

Steps to runs the endpoints are : --- 

// Create a Person 

1 -  curl -H "Content-Type: application/json" -X POST -d '{"name": "musa","surname": "ibb","age": "333","sex": "male","birthday": "1977-08-05","phone": "0835593999","email": "ibro2@gmail.com","contacts": "ibro"}' http://localhost:8080/person


// Get all Person

2 - curl  -v  http://localhost:8080/person


// Save or update Person

3 - curl -H "Content-Type: application/json" -X PUT -d '{"name": "kloop","surname": "pulp","age": "90","sex": "male","birthday": "1977-08-05","phone": "0835593999","email": "ibro2@gmail.com","contacts": "ibro"}' http://localhost:8080/person
 http://localhost:8080/person/1


// Delete Person

3 - curl -X "DELETE" http://localhost:8080/person/1


// Get all Person list Pageable 

4 - curl -v  http://localhost:8080/listPageable?page=1&size=5



