package m6.spring.fullstack.EjercicioGrupalM6Spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurConfig {

    @Bean
    public InMemoryUserDetailsManager getMemoryUserDetailsManager(PasswordEncoder encoder) {
        UserDetails cliente = User.withUsername("clien")
                .password(encoder.encode("cli"))
                .roles("CLIENTE").build();

        UserDetails profesional = User.withUsername("profe")
                .password(encoder.encode("prof"))
                .roles("PROFE").build();

        UserDetails administrativo = User.withUsername("admin")
                .password(encoder.encode("adm"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(cliente, profesional, administrativo);
    }

    @Bean
    public SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers("/capacitacion/**", "/contacto").hasRole("CLIENTE")
                                .requestMatchers("/usuario/**", "/pago/**").hasRole("ADMIN")
                                .requestMatchers("/visita/**").hasRole("PROFE")
                                .requestMatchers("/", "/logout", "/css/**").permitAll())
                .httpBasic(Customizer.withDefaults())
                .formLogin(login -> login.loginPage("/login")
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")
                        .invalidateHttpSession(true).deleteCookies().permitAll());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}