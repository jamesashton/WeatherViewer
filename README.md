# README #

This is a simple application for viewing current weather data.  It allows the user to select a city and view various aspects of the weather for that city.

There is a pure HTML viewer and a JS viewer written using React. 

NOTE: Bower and Maven are required to build the solution. In case you are unable to easily run bower, I have included a zipped version of the "Bower_Components" folder which must be placed in #project-root#/weather-server/src/main/resources/static/js


# INSTRUCTIONS #

1. Run the following in #project-root#/weather-server/src/main/resources/static/js to install the JavaScript dependencies:

> bower install

2. Run Maven on the parent project to resolve Java dependencies, run unit tests and compile:

> cd parent
> mvn clean install

3. Start the application by changing directory to 

> cd ../weather-server
> mvn spring-boot:run

4. View the application by pointing your browser to http://localhost:8080