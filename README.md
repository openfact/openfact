# openfact

# Openfact rest-api documentation

execute mvn package
open $root-project/services-api/target/miredot/index.html

# Openfact deploy

mvn package && java -jar distribution/wildfly-swarm/target/openfact-wildfly-swarm.jar

# Openfact generate changelog from liquibase
mvn install #for resolve dependency problems
mvn liquibase:generateChangeLog -pl model/jpa
mvn liquibase:diff -pl model/jpa

mvn help:describe -Dplugin=liquibase -Ddetail


java -jar distribution/wildfly-swarm/target/openfact-swarm.jar -Dswarm.http.port=8081




# Testsuite purposes
mvn -f testsuite/integration/pom.xml exec:java -Popenfact-server -Dimport=/**/demo-organization.json

# Quickstart for Developers
There 2 steps to start the Openfact server on development mode:
1. Run Keycloak Server
2. Run Openfact Server on Test mode

**1. RUN KEYCLOAK SERVER**
 - You should build the docker provided image using the command:
 `mvn clean install -Pdocker-keycloak-server`
 
 - After that is necesary to start the docker image using the command:
 `docker run -p 8080:8080 -p 9990:9990 openfact/testsuite-keycloak-server`
 
 - If You need to access to your docker container:
 `docker exec -it CONTAINER_ID /bin/bash`