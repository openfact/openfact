package org.openfact;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.spi.api.config.Resolver;

public class Main {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm(args);

        // Configure the Datasources subsystem with a driver
        // and a datasource
        String useDB = swarm.configView().resolve("swarm.use.db").withDefault("h2").getValue();

        Resolver<String> connectionUrl = swarm.configView().resolve("swarm.ds.connection.url");
        Resolver<String> username = swarm.configView().resolve("swarm.ds.username");
        Resolver<String> password = swarm.configView().resolve("swarm.ds.password");
        switch (useDB.toLowerCase()) {
            case "h2":
                swarm.fraction(datasourceWithH2(connectionUrl, username, password));
                break;
            case "postgresql":
                swarm.fraction(datasourceWithPostgresql(connectionUrl, username, password));
                break;
            case "mysql":
                swarm.fraction(datasourceWithMysql(connectionUrl, username, password));
                break;
            default:
                swarm.fraction(datasourceWithH2(connectionUrl, username, password));
        }

        // Start the swarm and deploy the default war
        swarm.start().deploy();
    }

    private static DatasourcesFraction datasourceWithH2(Resolver<String> connectionUrl, Resolver<String> username, Resolver<String> password) {
        return new DatasourcesFraction()
                .jdbcDriver("h2", (d) -> {
                    d.driverClassName("org.h2.Driver");
                    d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
                    d.driverModuleName("com.h2database.h2");
                })
                .dataSource("OpenfactDS", (ds) -> {
                    ds.driverName("h2");
                    ds.connectionUrl(connectionUrl.withDefault("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE").getValue());
                    ds.userName(username.withDefault("sa").getValue());
                    ds.password(password.withDefault("sa").getValue());
                });
    }

    private static DatasourcesFraction datasourceWithPostgresql(Resolver<String> connectionUrl, Resolver<String> username, Resolver<String> password) {
        return new DatasourcesFraction()
                .jdbcDriver("org.postgresql", (d) -> {
                    d.driverClassName("org.postgresql.Driver");
                    d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
                    d.driverModuleName("org.postgresql");
                })
                .dataSource("OpenfactDS", (ds) -> {
                    ds.driverName("org.postgresql");
                    ds.connectionUrl(connectionUrl.withDefault("jdbc:postgresql://localhost:5432/postgres").getValue());
                    ds.userName(username.withDefault("postgres").getValue());
                    ds.password(password.withDefault("postgres").getValue());
                });
    }

    private static DatasourcesFraction datasourceWithMysql(Resolver<String> connectionUrl, Resolver<String> username, Resolver<String> password) {
        return new DatasourcesFraction()
                .jdbcDriver("com.mysql", (d) -> {
                    d.driverClassName("com.mysql.jdbc.Driver");
                    d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
                    d.driverModuleName("com.mysql");
                })
                .dataSource("OpenfactDS", (ds) -> {
                    ds.driverName("com.mysql");
                    ds.connectionUrl(connectionUrl.withDefault("jdbc:mysql://localhost:3306/mysql").getValue());
                    ds.userName(username.withDefault("root").getValue());
                    ds.password(password.withDefault("root").getValue());
                });
    }

}