package it.beije.oort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.beije.oort.db.JpaEntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(value = {"it.beije.oort.repository"})
public class ConfigurationClass {
	
    @Primary
    @Bean(name="transactionManager")
    public PlatformTransactionManager dbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(JpaEntityManagerFactory.getInstance());
        return transactionManager;
    }
	
}
