# planner-backend

This project is a backend for the planner-client project (https://github.com/afconsult-south/planner-client). It's based on SpringBoot (https://spring.io/projects/spring-boot) and currently using an in-memory database called H2 (http://www.h2database.com/html/main.html).

## Quickstart

Clone this repo, import the project to you preferred editor, run the application to start the server.
To access the in-memory database go to (http://localhost:8080/h2).
The login credentials are:
  - username: admin
  - password: admin

To access the endpoints go to (http://localhost:8080/info/1) for example, for more endpoints see the code!

## Todo
- Exchange the database from H2 to a MySQL or NOSQL database
- Add functionality to send mail when an application has been done by a user.
