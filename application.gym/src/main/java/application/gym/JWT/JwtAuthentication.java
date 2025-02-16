package application.gym.JWT;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthentication extends AbstractAuthenticationToken {

    private final String email;
    @Getter
    private final String role;

    public JwtAuthentication(String email, String role) {
        super(null);
        this.email = email;
        this.role = role;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return email;
    }

}
