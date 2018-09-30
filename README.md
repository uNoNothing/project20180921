# how to run from command line (terminal)
- in a terminal, navigate to root directory: project20180921 and run
`mvn clean install`
- in 2nd terminal, navigate to config-server directory: project20180921/config-server and run
`mvn spring-boot:run`
- in 3rd terminal,  navigate to db-migration directory: project20180921/db-migration and run
`mvn spring-boot:run -Dspring-boot.run.profiles=local`
- in 4th terminal, navigate to user-mgmt directory: project20180921/user-mgmt and run
`mvn spring-boot:run -Dspring-boot.run.profiles=local`

# swagger ui
localhost:7002/swagger-ui.html

# code version
localhost:7000/actuator/info

# to-do
- user search by username, name, phone number, email address, address
- eureka and zuul
- other services

# to build only one package
- in root directory, run
`mvn package -pl user-mgmt -am`