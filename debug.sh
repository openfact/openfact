#!/usr/bin/env bash

rm -rf org.openfact.*
mvn clean package -DskipTests
java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 target/openfact-*-swarm.jar -Dopenfact.pe.organizaciones.master.import="$(pwd)/organization.json"
