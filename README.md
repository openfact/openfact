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