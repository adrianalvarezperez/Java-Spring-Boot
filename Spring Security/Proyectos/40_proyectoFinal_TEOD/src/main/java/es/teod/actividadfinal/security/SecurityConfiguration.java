package es.teod.actividadfinal.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth
			.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email, contraseña, enabled from Usuarios where email=?")
			.authoritiesByUsernameQuery("select u.email, r.nombre from Usuarios u " +   " inner join Roles r on r.id_rol = u.id_rol " +  "where u.email = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
			// Los directorios estáticos no requieren autenticacion
			.antMatchers("/bootstrap/**",  "/images/**", "/css/**", "js/**").permitAll()
			.antMatchers("/rest/demo-bcrypt/**").permitAll()
		//	.antMatchers("/**").permitAll()
			/*
			// Las vistas públicas no requieren autenticación
			.antMatchers("/", "/login", "/logout", "/registro","/search", "/app/producto/verUno/**").permitAll()
			// Las autorizaciones sobre urls para ROLES
			.antMatchers("/app/producto/**").hasAnyAuthority("ROLE_GESTOR","ROLE_ADMINISTRADOR")
			.antMatchers("/app/usuarios/**").hasAnyAuthority("ROLE_GESTOR","ROLE_ADMINISTRADOR")
			.antMatchers("/app/perfiles/**").hasAnyAuthority("ROLE_ADMINISTRADOR")
			.antMatchers("/app/tipos/**").hasAnyAuthority("ROLE_GESTOR")
			
			// Todas las demás URLs de la Aplicación requieren autenticación
			.anyRequest().authenticated()
			*/
			// El formulario de Login no requiere autenticacion
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
			// El formulario de logout no requiere autenticacion
	//		.and().logout().permitAll()
			;
			 
	}
	/*
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
*/
}
