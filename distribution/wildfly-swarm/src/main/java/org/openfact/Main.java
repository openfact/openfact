package org.openfact;

import java.net.URL;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.keycloak.Secured;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

public class Main {

    static String driverModule;

    public static void main(String[] args) throws Exception {
        ClassLoader cl = Main.class.getClassLoader();
        URL stageConfig = cl.getResource("project-defaults.yml");

        Swarm swarm = new Swarm(false).withConfig(stageConfig);

        String userDB = System.getProperty("swarm.user.db", "h2");

        // Configure the Datasources subsystem with a driver and a datasource
        switch (userDB.toLowerCase()) {
            case "h2":
                swarm.fraction(datasourceWithH2());
                driverModule = "com.h2database.h2";
                break;
            case "postgresql":
                swarm.fraction(datasourceWithPostgresql());
                driverModule = "org.postgresql";
                break;
            case "mysql":
                swarm.fraction(datasourceWithMysql());
                driverModule = "com.mysql";
                break;
            default:
                swarm.fraction(datasourceWithH2());
                driverModule = "com.h2database.h2";
        }

        swarm.start();

        JAXRSArchive appDeployment = ShrinkWrap.create(JAXRSArchive.class);

        appDeployment.as(Secured.class)
                .protect("/*")
                .withMethod("GET", "POST", "PUST", "DELETE")
                .withRole("admin", "organization-manager", "organization-user");

        appDeployment.addPackage("org.openfact")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAllDependencies();

        // Deploy your app
        swarm.deploy(appDeployment);
    }

    private static DatasourcesFraction datasourceWithH2() {
        return new DatasourcesFraction().jdbcDriver("h2", (d) -> {
            d.driverClassName("org.h2.Driver");
            d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
            d.driverModuleName("com.h2database.h2");
        }).dataSource("ExampleDS", (ds) -> {
            ds.driverName("h2");
            ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
            ds.userName("sa");
            ds.password("sa");
        });
    }

    private static DatasourcesFraction datasourceWithPostgresql() {
        return new DatasourcesFraction().jdbcDriver("org.postgresql", (d) -> {
            d.driverClassName("org.postgresql.Driver");
            d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
            d.driverModuleName("org.postgresql");
        }).dataSource("ExampleDS", (ds) -> {
            ds.driverName("org.postgresql");
            ds.connectionUrl("jdbc:postgresql://localhost:5432/postgres");
            ds.userName("postgres");
            ds.password("postgres");
        });
    }

    private static DatasourcesFraction datasourceWithMysql() {
        return new DatasourcesFraction().jdbcDriver("com.mysql", (d) -> {
            d.driverClassName("com.mysql.jdbc.Driver");
            d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
            d.driverModuleName("com.mysql");
        }).dataSource("ExampleDS", (ds) -> {
            ds.driverName("com.mysql");
            ds.connectionUrl("jdbc:mysql://localhost:3306/mysql");
            ds.userName("root");
            ds.password("root");
        });
    }

}