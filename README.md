# openfact

# Openfact rest-api documentation

execute mvn package
open $root-project/services-api/target/miredot/index.html

# Openfact deploy

mvn package && java -jar distribution/wildfly-swarm/target/openfact-wildfly-swarm.jar