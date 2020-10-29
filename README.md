# kanbanbackend

This is the backend for kanbanboard based on SpringBoot and MySQL Database, the login function is implemented using shiro, and an Hruser table is used
for storing user information. The login function is already tested with Postman, the frontend login part is still being
implemented now.

The other basic function including rating, commenting applicants has already been implemented.

The service is already deloyed onto AWS. The public Address is http://54.242.195.155:8080/, you could access the server page by inputing the IP Address into
your chrome

To Install backend on your local machine, you need to have springboot environment and mysql. Please set mysql database root user's password to be 'admin',
Then execute the init.sql file. Backend part should be set and started before the frontend part.
