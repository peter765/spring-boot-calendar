# spring-boot-calendar
sample calendar/event tracking API using spring boot

## Requirements
MySQL Server running on port 3306. configure in application.properties

## How To Run
Using Java 1.8 and IntelliJ IDEA... 

Import as Maven Project using pom.xml

Create a configuration for a Maven project to run the program using
`spring-boot:run`


**OR**

go to the root directory and run

`mvn spring-boot:run`

The service will be running at localhost:8080.

## Currently Implemented(sort of..)

`/api/Events/`
- GET gives a list of all events
- POST posts new events to the database

# TODO 
**Events**
- adjust model to incorporate all required fields

**Calendar**
- create calendar model
- design calendar model to return events associated to calendar


**User**
- create user model
- design user model to construct attendee lists, find events by user

**Other Features**
- Scheduled Reminders based on added events
- Token-based security
- Unit Tests


