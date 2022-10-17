package ru.test.generator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.test.generator.service.dao.service.LoadGenService;
import ru.test.generator.service.dao.service.LoadGenServiceImpl;

@Configuration
@EnableJpaRepositories( basePackages = {"ru.test.generator.service.dao.repository"},
        entityManagerFactoryRef = "apossEntityManager",
        transactionManagerRef = "apossTransactionManager")
public class JpaConfig {

    @Bean("LoadGenService")
    public LoadGenService loadGenService() {
        return new LoadGenServiceImpl();
    }

}
