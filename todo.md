Todo
---
* Add test cases for customer controller, service, and repositories. Start with customer repository since that might be easiest.
* How do we bootstrap the database via jpa in a Spring Boot project?
* Create some products (ten to fifteen) in the database. These will be the actual Rickshaw parts that a customer can order.
* Create project documentation and ERD diagram.

Questions
---
* Should methods like delete and insert etc, when invoked via the controller's endpoints return certain http codes
as well as textual responses to indicate success or failure of the requested operations? For example should the delete
method in the customer dao return a boolean to indicate successful deletion of the requested record? And if so, should
this be propagated towards the presentation layer via the service and the controller's calling methods and hence
be seen as a response in something like Postman while testing? Also in case of errors what is a good design for exception
indication to the front end.
* For updating an existing customer via Postman, is it better practice to provide the target customer's id as a url
parameter, or as part of the posted JSON body?
* More generally, what is the difference between using CrudRepository interface methods vs. using an entity manager?
* What should the response be when asking for the orders of a customer id that doesn't exist? Empty set doesn't make
sense because that is the same as an existing customer that doesn't have any orders. Should an exception be used here?
* How can Swagger be used to document the API for Rickshaw?
* Domain classes should obviously be commented using Javadoc but what about repositories, since
they implement the CrudRepository interface, do they inherit those comments? Do I need to comment 
any methods I define therein like as in OrderRepository.findByCustomer?
* Returning List vs Set in CustomerService, which is better? More of a good practice?
* When you bring up the spring context or get autowire a repository in a unit test, does it become an
integration test? If so, where do we place integration tests as in what files?
* How do we bootstrap the database via jpa in a Spring Boot project?
* Should orders have their own controller or should I access them via the customer controller? Which is
better design?
* List vs collection what to return?

Fun stuff
---
* See what app looks like in jvisualvm.
* How do we get our objects to show up in jconsole, as they currently don't.
* Experiment with Spring Boot's actuator to monitor the Rickshaw application.
