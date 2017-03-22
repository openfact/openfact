FROM jboss/keycloak-adapter-wildfly

ENV KEYCLOAK_VERSION 2.5.5.Final
ARG KEYCLOAK_ADMIN_USER=admin
ARG KEYCLOAK_ADMIN_PASWORD=admin

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin

ADD https://downloads.jboss.org/keycloak/$KEYCLOAK_VERSION/keycloak-overlay-$KEYCLOAK_VERSION.tar.gz /opt/jboss/wildfly/
USER root
RUN chown -R jboss /opt/jboss/wildfly/
RUN chmod -R 700 /opt/jboss/wildfly/
RUN tar -xvzf /opt/jboss/wildfly/keycloak-overlay-$KEYCLOAK_VERSION.tar.gz -C /opt/jboss/wildfly/ && rm -R /opt/jboss/wildfly/keycloak-overlay-$KEYCLOAK_VERSION.tar.gz
RUN /opt/jboss/wildfly/bin/jboss-cli.sh --file=/opt/jboss/wildfly/bin/keycloak-install.cli
RUN /opt/jboss/wildfly/bin/add-user-keycloak.sh -u ${KEYCLOAK_ADMIN_USER} -p ${KEYCLOAK_ADMIN_PASWORD}

ADD openfact-realm.json /opt/jboss/wildfly/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-Dkeycloak.import=/opt/jboss/wildfly/openfact-realm.json"]