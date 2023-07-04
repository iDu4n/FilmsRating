package com.itdep.portalbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;
import java.util.logging.Logger;

@SpringBootApplication
@EnableJpaRepositories("com.itdep.portalbackend.*")
@ComponentScan(basePackages = { "com.itdep.portalbackend.*" })
@EntityScan("com.itdep.portalbackend.*")
public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(Application.class, args);

/*        Tables.start();

        logger.log(Level.INFO, () -> "\nКонец");*/

    }

}