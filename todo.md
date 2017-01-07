Todo
---
* Find out how to work Lombok properly. Currently we have constructors declared which I think we shouldn't if we know
how to control Lombok properly.
* Finish hibernate work on customer repository, start order repository and finish the customer and order relationship.
* Fix the controller and service code to work with the new repositories as they currently work with the old DAOs.
* Add test cases for customer controller, service, and repositories. Start with customer repository since that might be easiest.
* How do we bootstrap the database via jpa?

Questions
---
* Should methods like delete and insert etc, when invoked via the controller's endpoints return certain http codes
as well as textual responses to indicate success or failure of the requested operations? For example should the delete
method in the customer dao return a boolean to indicate successful deletion of the requested record? And if so, should
this be propagated towards the presentation layer via the service and the controller's calling methods and hence
be seen as a response in something like Postman while testing?
* For updating an existing customer via Postman, is it better practice to provide the target customer's id as a url
parameter, or as part of the posted JSON body?
* More generally, what is the difference between using CrudRepository interface methods vs. using an entity manager?

Fun stuff
---
* See what app looks like in jvisualvm.
* How do we get our objects to show up in jconsole, as they currently don't.
