package org.openfact;

import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.datasources.DatasourcesFraction;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

/**
 * @author Bob McWhirter
 */
public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Running " + Main.class.getCanonicalName() + ".main");

        Swarm swarm = new Swarm();

        String stageFile = System.getProperty("swarm.project.stage.file");
        String stageName = System.getProperty("swarm.project.stage", "default");

        // Configure stage
        if (stageFile != null) {
            swarm.withConfig(new URL(stageFile));
        } else {
            ClassLoader classLoader = Main.class.getClassLoader();

            URL stageConfig;
            switch (stageName.toLowerCase()) {
                case "default":
                    stageConfig = classLoader.getResource("project-defaults.yml");
                    break;
                case "development":
                    stageConfig = classLoader.getResource("project-development.yml");
                    break;
                default:
                    stageConfig = classLoader.getResource("project-defaults.yml");
            }
            swarm.withConfig(stageConfig);
        }

        String useDB = System.getProperty("swarm.use.db", "h2");

        // Configure the Datasources subsystem with a driver
        // and a datasource
        switch (useDB.toLowerCase()) {
            case "h2":
                swarm.fraction(datasourceWithH2());
                break;
            case "postgresql":
                swarm.fraction(datasourceWithPostgresql());
                break;
            case "mysql":
                swarm.fraction(datasourceWithMysql());
                break;
            default:
                swarm.fraction(datasourceWithH2());
        }

        // Start the swarm and deploy the default war
        swarm.start().deploy();
    }

    private static DatasourcesFraction datasourceWithH2() {
        return new DatasourcesFraction()
                .jdbcDriver("h2", (d) -> {
                    d.driverClassName("org.h2.Driver");
                    d.xaDatasourceClass("org.h2.jdbcx.JdbcDataSource");
                    d.driverModuleName("com.h2database.h2");
                })
                .dataSource("ExampleDS", (ds) -> {
                    ds.driverName("h2");
                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
                    ds.userName("sa");
                    ds.password("sa");
                });
    }

    private static DatasourcesFraction datasourceWithPostgresql() {
        return new DatasourcesFraction()
                .jdbcDriver("org.postgresql", (d) -> {
                    d.driverClassName("org.postgresql.Driver");
                    d.xaDatasourceClass("org.postgresql.xa.PGXADataSource");
                    d.driverModuleName("org.postgresql");
                })
                .dataSource("ExampleDS", (ds) -> {
                    ds.driverName("org.postgresql");
                    ds.connectionUrl("jdbc:postgresql://localhost:5432/postgres");
                    ds.userName("postgres");
                    ds.password("postgres");
                });
    }

    private static DatasourcesFraction datasourceWithMysql() {
        return new DatasourcesFraction()
                .jdbcDriver("com.mysql", (d) -> {
                    d.driverClassName("com.mysql.jdbc.Driver");
                    d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
                    d.driverModuleName("com.mysql");
                })
                .dataSource("ExampleDS", (ds) -> {
                    ds.driverName("com.mysql");
                    ds.connectionUrl("jdbc:mysql://localhost:3306/mysql");
                    ds.userName("root");
                    ds.password("root");
                });
    }

}