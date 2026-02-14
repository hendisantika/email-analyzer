package id.my.hendisantika.emailanalyzer.service;

import id.my.hendisantika.emailanalyzer.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PasswordStrengthService passwordStrengthService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, PasswordStrengthService passwordStrengthService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.passwordStrengthService = passwordStrengthService;
    }
}
