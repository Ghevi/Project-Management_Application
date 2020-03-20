package com.ghevi.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

// BEWARE: COMMENTS HELL è.é

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource; // Automatically wires h2 database as data source // Now it is associated with the postgreSQL

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    // Authentication (the who)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        auth.inMemoryAuthentication() // Use in memory authentication based on the code below
        auth.jdbcAuthentication().dataSource(dataSource) // Use h2 database as a data source for authentication
            .withDefaultSchema() // Create a user table and authorities tables in the database for the authentication using the code below
            .withUser("myuser")
                .password("pass")
                .roles("USER")
            .and()
            .withUser("ghevi")
                .password("pass2")
                .roles("USER")
            .and()
            .withUser("managerUser")
                .password("pass3")
                .roles("ADMIN");
         */

        // Dont use a default schema from the in memory database h2 but use the one we will create in PostgreSql
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username, password, enabled " +  // Authentication
                        "from user_accounts where username = ?")
                .authoritiesByUsernameQuery("select username, role " +  // Authorization
                        "from user_accounts where username = ?")
                .dataSource(dataSource)
                // .passwordEncoder(getPasswordEncoder());
                .passwordEncoder(bCryptPasswordEncoder); // Proper encoder for passwords

    }

    // When we put bCryptPasswordEncoder this became uselee cuz it's bad to not have the password crypted.
    // @Bean
    // public PasswordEncoder getPasswordEncoder(){return NoOpPasswordEncoder.getInstance(); // Momentarily}

    // Authorization (what he can do)
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                    // This order is important we cant say permitAll() first because otherwise everyone have access to all
                    .antMatchers("/projects/new").hasRole("ADMIN") // Only ADMINs can create a new project
                    .antMatchers("/projects/save").hasRole("ADMIN")
                    .antMatchers("/employees/new").hasRole("ADMIN")
                    .antMatchers("/employees/save").hasRole("ADMIN")
                    // .antMatchers("/h2_console./**").permitAll()
                    // .antMatchers("/").authenticated().and().formLogin(); // everyone can go to the homepage endpoint
                    .antMatchers("/", "/**").permitAll()
                .and()
                    // .formLogin().loginPage("/login-page" or we could write another line with "/logout-page"); Customize the login/logout if we had a controller with them
                    .formLogin();

        // Just for having the h2 console working before
        // httpSecurity.csrf().disable();
        // httpSecurity.headers().frameOptions().disable();
    }
}
