Requirements to run
    Java 8
    mvn

To build and run test
    mvn clean install

To start app
     mvn spring-boot:run

App will run on port 8080, can be changed in application.properties

Assumption is values of area input will positive, if not the case CleanupUtil.isPositionInsideArea will need to be updated

Key point of implementation is size of area can be [5,5] or [500000000,500000000] will make no impact on memory footprint