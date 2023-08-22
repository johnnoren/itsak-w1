package com.example.sql_injection.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class InsecureAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	DataSource dataSource;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		var username = authentication.getName();
		var password = authentication.getCredentials().toString();
		var authorities = authentication.getAuthorities();
		if (passwordIsCorrect(username, password)) {
			return new UsernamePasswordAuthenticationToken(username, password, authorities);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	private boolean passwordIsCorrect(String username, String password) {
		try (Connection conn = dataSource.getConnection()) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'");
			return rs.next();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
