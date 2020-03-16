# TDD Testing

Trying out TDD approach in spring. This project is using Reactive Spring Web, blocking is a waste. 


## Setup
- Install the needed technologies
    - git
    - Java 8
    - Maven
    - (_Optional - will only need if you want to run the full application not just tests_) - Docker
- Clone the repo
    - Navigate to a location on your computer you want to store the code - _This will be refered to as BASE_DIR_
    - Run the following `git clone https://github.com/Quinn-Donnelly/tdd-contact.git`
- _Your ready to go_

## Running

### Run the tests
To run the tests simply run through the steps in [Setup](#Setup) then run `mvn test` inside of BASE_DIR and the tests
will execute. 

### Run the application
To run the application you will need the optional dependancies in [Setup](#Setup) run
`docker run --rm -d -p 27017:17017 mongo` then `mvn spring-boot:run` 
    