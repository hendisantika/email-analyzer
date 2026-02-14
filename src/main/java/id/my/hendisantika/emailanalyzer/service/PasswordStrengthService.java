package id.my.hendisantika.emailanalyzer.service;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.43
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PasswordStrengthService {

    public boolean isStrong(String password) {
        if (password == null) return false;

        return password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*[a-z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }
}
