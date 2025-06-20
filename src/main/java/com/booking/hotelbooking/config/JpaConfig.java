/**
 * 
 */
package com.booking.hotelbooking.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

/**
 * 
 */
@Configuration
//@EnableJpaRepositories(basePackages = "com.booking.hotelbooking.repository")
//@EntityScan("com.booking.hotelbooking.model")
public class JpaConfig {
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
        vendor.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(vendor);
        emf.setPackagesToScan("com.booking.hotelbooking.entity");
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
    
    @Bean
    public DataSource dataSource() {
	    return DataSourceBuilder.create()
	      .url("jdbc:mysql://localhost:3306/wekare")
	      .username("root")
	      .password("root")
	      .driverClassName("com.mysql.cj.jdbc.Driver")
	      .build();
	  }

}
