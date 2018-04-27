#!/usr/bin/env bash

mvn clean -Dtest=$1 -Dmaven.surefire.debug -Dswarm.debug.port=5005 test
