FROM jboss/keycloak-adapter-wildfly

# JBOSS
USER jboss
RUN ${JBOSS_HOME}/bin/add-user.sh admin admin

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]