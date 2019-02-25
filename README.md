# FeatureFlagsService

## Steps to run – 
- Clone the project
- mvn clean install
- mvn spring-boot:run
- http://localhost:8080/home - This should take you to the home page and user can perform save / cancel actions
- The in-memory database can be viewed with the console - http://localhost:8080/h2-console/ (Please use following jdbc url to connect - "jdbc:h2:mem:testdb")


## Sample POST request - 
{
        "id": 1,
        "country": "Asia",
        "value": 1
}
