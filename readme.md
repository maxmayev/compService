Design and implement client-server application using JPA/Spring/SpringMVC (or Spring-Boot) with frontend (ThymeLeaf) and REST API.

The task is:

Build a customer accounting system for the Computer service organization.

	-Implement the ability to register and log in.

	-Implement the ability to add customers and store their orders.

	-Show a table of available customers with a list of orders for each. 

	-Provide for the possibility of deleting clients.


Implemented:

	-Login and storing accounts in the database (Spring Security)

	-Persistence of customers and their orders (Spring Data JPA & MySQL)

	-Frontend (template engine Thymeleaf)

	-REST API :

			- Recent orders (size) : /rest/orders/recent?size={size}
			- Find all orders : /rest/orders/all
			- Order by id (id) : /rest/orders{id}
			- Add new order : /orders/new
			- Save or update consumer : /rest/consumer/{id}
			- Delete order : /rest/orders/{id}
			- Delete consumer : /rest/consumers/{id}
       
-Implementation REST by JPA with full functionality and HATEOAS
