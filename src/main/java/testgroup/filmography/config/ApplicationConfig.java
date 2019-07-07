package testgroup.filmography.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * ApplicationConfig say where find component for dependency
 *
 * @author s.yurchenko
 */
@Configuration
@ComponentScan(basePackages = {"testgroup.filmography.dao",
        "testgroup.filmography.service"})
@Import(DAOConfig.class)
public class ApplicationConfig {
}
