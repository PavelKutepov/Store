package pkutepov.com.security;

import org.springframework.stereotype.Service;

public interface SecurityService {

    String findLoggedLogin();

    void autoLogin(String login, String password);
}
