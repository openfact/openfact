# Openfact
Openfact is a Open source Wildfly based server that helps you to save and process xml documents based on UBL (Universal Bussiness Language).

Openfact could help you to:

- Save Xml UBL documents.
- Sign the xml documents and then send it to your customer.
- Offers you the oportunity to extend the server based on your country/own necesities.
- **Keycloak** integration for OpenID and oAuth2 security.

# Building

Ensure you have JDK 8 (or newer), Maven 3.1.1 (or newer) and Git installed

Clone the Openfact repository:

    git clone https://github.com/openfact/openfact.git
    cd openfact

To build Openfact run:

    mvn install

This will build all modules and run the testsuite.

To build the distribution run:

    mvn install -Pdistribution

Once completed you will find distribution archives in distribution folder.

# Quick start using Openfact

**DEVELOPMENT MODE.**

There are two steps to start using Openfact server on development mode:

1. Start a Keycloak Server.
2. Start Openfact

**Start a Keycloak server**

You can start Keycloak server how you prefer. However, to start a preconfigured Keycloak server run:

    mvn clean install -Pdocker-keycloak-server
    
After that, is necesary to start the docker image using the command:

    docker run -p 8080:8080 openfact/testsuite-keycloak-server
     
If you need to access to your keycloak docker container run:
    
    docker exec -it CONTAINER_ID /bin/bash

**Start a Openfact server**

First build as specified on **Building** part, then run:
    
    mvn -f testsuite/integration/pom.xml exec:java -Popenfact-server
    
You can also import a organization running:

    mvn -f testsuite/integration/pom.xml exec:java -Popenfact-server -Dimport=demo-organization.json


To start Openfact from the appliance distribution.

First build the distribution as specified on **Building** part, then run:
 
    tar xfz distribution/appliance-dist/target/openfact-appliance-dist-all-<VERSION>.tar.gz
    cd openfact-appliance-dist-all-<VERSION>/openfact
    bin/standalone.sh

To stop the server press `Ctrl + C`


# Web Services specification

Openfact uses miredot to documentate the Jax-rs end points. To check the documentation first run:

    execute mvn package

Then open the file `openfact/services/target/miredot/index.html`
 
 
 # Openfact generate changelog from liquibase
 mvn install #for resolve dependency problems
 mvn liquibase:generateChangeLog -pl model/jpa
 mvn liquibase:diff -pl model/jpa
 
 mvn help:describe -Dplugin=liquibase -Ddetail
 
 
 java -jar distribution/wildfly-swarm/target/openfact-swarm.jar -Dswarm.http.port=8081
