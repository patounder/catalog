#Products Catalog 

##Description

Application to create new products, update, delete and retrieve by sku (id) or list all of them. Product information is:

| Field        | Description   |
| ------------- |-------------|
| **sku**      | *Internal stock-keeping unit. It is the candidate identifier of a product* |
| **name**      | *Short description of the product*      |
| **brand** | *Name of brand*     |
| **size** | *Size of product*      |
| **price** |  *Price of product* |
| **principal image** | *URL of the principal image of the product* |
| **other images** | *Other images about the product* |

##Application RESTFul API

This application is based on the REST pattern, implemented with the following technologies:
+ Java 11
+ Springboot 2.6
+ Maven 3.6
+ H2 Database
+ Framework ORM Hibernate

The election about database H2, it was decided not to depend on an external database and to keep it in memory. For other hand, 
selected Hibernate given its usefulness for handling entity-object mapping. Finally, with finally, given the Springboot features,
it followed the guidelines to build an MVC application defining the controller, service and repository on products.

###Endpoints

The main services REST are:

####1 - Get Product

`curl -X GET http://localhost:8080/catalog/products/FAL-8818985`

####2 - Get All Products

`curl -X GET http://localhost:8080/catalog/products`

####3 - Create Product

`curl -X POST -H "Content-Type: application/json" -d '{"sku":"FAL-124987","name":"TV 42 pulgadas", "brand": "LG", "size": "42", "price": "300000", "images":[{"principal": true, "url": "https://imagen_tv_1"},{"principal": false, "url": "https://imagen_tv_2"}]}' http://localhost:8080/catalog/products`

####4 - Update Product

`curl -X PUT -H "Content-Type: application/json" -d '{"sku":"FAL-124987","name":"TV 42 pulgadas", "brand": "LG", "size": "42", "price": "450000", "images":[{"principal": true, "url": "https://imagen_tv_1"},{"principal": false, "url": "https://imagen_tv_2"}]}' http://localhost:8080/catalog/products/FAL-124987`

####5 - Delete Product

`curl -X DELETE http://localhost:8080/catalog/products/FAL-124987`

##Build
Once the repo is downloaded, go to the root of the project (where the README file is) and execute this command:
`mvn clean compile package`

The result of the previous command is to generate the `catalog-0.0.1-SNAPSHOT.jar` artifact in the `target` folder.

##Run
Once the application is built, execute the following command: `java -jar target/catalog-0.0.1-SNAPSHOT.jar`. With this, 
the application is ready to listen for requests on `http://localhost:8080`.

##TODO List
It is possible to continue to improve the application, so the next steps could be to:

- Add logger with thresholds (i.e. Log4j)
- Add Swagger (API documentation)
- Check preconditions (i.e. use Guava)
- Add Integration testing
