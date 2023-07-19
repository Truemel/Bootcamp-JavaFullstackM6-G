package m6.spring.fullstack.EjercicioGrupalM6Spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("m6.spring.fullstack.EjercicioGrupalM6Spring")
@PropertySource("classpath:database.properties")
public class Config {

    Environment environment;

    public Config(Environment environment){
        this.environment = environment;
    }

    @Bean
    public DataSource dataSo(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(environment.getProperty("driver"));
        driverManagerDataSource.setUrl(environment.getProperty("url"));
        driverManagerDataSource.setUsername(environment.getProperty("db_user"));
        driverManagerDataSource.setPassword(environment.getProperty("db_password"));
        /*System.out.println(environment.getProperty("driver").toString());
        System.out.println(environment.getProperty("url").toString());
        System.out.println(environment.getProperty("db_user").toString());
        System.out.println(environment.getProperty("db_password").toString());*/
        return driverManagerDataSource;
    }
}