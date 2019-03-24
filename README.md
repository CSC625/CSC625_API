# CSC625_API

Steps to run the API:

1)  Clone this project to your computer.
2)  Download IntelliJ, Postman, and MySQLWorkbench.
3)  Make sure you have the DB created.  If you don't the DB creation script is under the https://github.com/CSC625/CSC625 project in the DB folder.  Run ths script as an admin on your MySQL DB you created.
4)  Import API project into IntelliJ
5)  Once the project is imported create a new Run/Debug configuration in IntelliJ.  The "Working Directory" field should be wherever you saved the project.  It should default to the correct value.  You need to set the "Command Line" field = spring-boot:run
6)  Once the config is create Debug the project.  There will be a BUG icon in the upper right hand corner of IntelliJ that will run and debug the API.
7) If the API starts up correct you should see something like: Started OrbitApiApplication in 7.033 seconds (JVM running for 7.6) (**It's called Orbit because that was our old project where I copied from.)
8) Open Postman
9) Find the Postman Collection inside of the https://github.com/CSC625/CSC625 project in the API_TEST folder.  It will be called CSC625_API.postman_collection.json.  You need to import this collection into Postman.
10) Once imported the collection will give you the All Users request.  Open the request and click send.  This should return all Users currently in the database.  If you don't see any result returned the go to the DB, add some default users in the User table, and try the request again.
