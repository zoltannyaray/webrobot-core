package com.dayswideawake.webrobot.core.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:/config/datasource.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.dayswideawake.webrobot.core.repository")
public class DbConfig {
    
    @Value("${datasource.url}")
    private String dataSourceUrl;
    @Value("${datasource.username}")
    private String dataSourceUsername;
    @Value("${datasource.password}")
    private String dataSourcePassword;
    
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUsername);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("com.dayswideawake.webrobot.core.entity");
        entityManagerFactoryBean.setJpaProperties(getJpaProperties());
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }

    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.id.new_generator_mappings", "false");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
