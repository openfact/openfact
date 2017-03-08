#!/bin/bash -e

if [ $1 == "old" ]; then
    mvn test -B -f testsuite/integration
fi
