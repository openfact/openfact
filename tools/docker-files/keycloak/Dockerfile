FROM jboss/keycloak:2.5.5.Final

ARG KEYCLOAK_ADMIN_USER=admin
ARG KEYCLOAK_ADMIN_PASWORD=admin
RUN /opt/jboss/keycloak/bin/add-user-keycloak.sh -u ${KEYCLOAK_ADMIN_USER} -p ${KEYCLOAK_ADMIN_PASWORD}

ADD openfact-realm.json /opt/jboss/keycloak/

ENTRYPOINT [ "/opt/jboss/docker-entrypoint.sh" ]

CMD ["-b", "0.0.0.0", "-Dkeycloak.import=/opt/jboss/keycloak/openfact-realm.json"]
