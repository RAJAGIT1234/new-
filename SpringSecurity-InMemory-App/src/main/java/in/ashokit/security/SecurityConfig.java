package in.ashokit.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	/**
	 * in this method we will configure Authentication credential
	 */
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//{noop}no encoded password for encoder
	auth.inMemoryAuthentication().withUser("Raja").password("{noop}Raja").authorities("ADMIN");
	auth.inMemoryAuthentication().withUser("em").password("{noop}Raja").authorities("EMPLOYEE");
	auth.inMemoryAuthentication().withUser("mg").password("{noop}Raja").authorities("MANAGER");
}

@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * in this method we will configure Authorized credential
		 */
		http.authorizeRequests()
		.antMatchers("/home").permitAll()
		.antMatchers("/welcome").authenticated()
		.antMatchers("/admin").hasAuthority("ADMIN")
		.antMatchers("/emp").hasAuthority("EMPLOYEE")
		.antMatchers("/mgr").hasAuthority("MANAGER")
		.antMatchers("/common").hasAnyAuthority("EMPLOYEE","MANAGER")
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.defaultSuccessUrl("/welcome",true)
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/accessDenied");
	}
}
