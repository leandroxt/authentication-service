package br.com.soig.service;

import br.com.soig.dto.Credentials;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthenticationService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // Find user in mongo's collection hgere.

        final String password = "123456";
        final Credentials credentials = new Credentials(s, password);

        return credentials;
    }


}
