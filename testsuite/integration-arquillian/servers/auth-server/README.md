# Openfact Arquillian Integration TestSuite - Test Servers - Auth Server

- [Openfact Arquillian Integration TestSuite](../../README.md)
- [Openfact Arquillian Integration TestSuite - Test Servers](../README.md)
- Openfact Arquillian Integration TestSuite - Test Servers - Auth Server
- [Openfact Arquillian Integration TestSuite - Test Servers - App Servers](../app-server/README.md)

## Auth Server - JBoss

Common configurations of Openfact server on JBoss-based container (Wildfly/EAP).

### Submodules

#### `wildfly` Wildfly 10
 - Builds openfact server on top of latest Wildfly.
 - Activated by __`-Pauth-server-wildfly`__

#### `eap` EAP 7
 - Builds openfact server on top of latest EAP.
 - Activated by __`-Pauth-server-eap`__
 - Requires access to product repo.
 - Requires additional properties:
  - `product.version`
  - `product.unpacked.folder.name`

### Server dist vs overlay

By default `openfact-server-dist` artifact is used for the build.
By setting `-Dserver-overlay=true` you can switch to server overlay instead. See profile `server-overlay`.

### JPA

Configures Openfact JDBC datasource in `standalone.xml`. See profile `jpa`.

### SSL

Configures SSL in `standalone.xml`. See profile `ssl`.

### Cluster

Configures in `standalone-ha.xml`:
- h2 datasource over TCP
- parameters of Openfact Infinispan caches

See profile `auth-server-cluster`.

## Auth Server - Undertow

Arquillian extension for running Openfact server in embedded Undertow.
