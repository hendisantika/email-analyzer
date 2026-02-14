package id.my.hendisantika.emailanalyzer.repository;

import id.my.hendisantika.emailanalyzer.entity.EmailAnalysisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.38
 * To change this template use File | Settings | File Templates.
 */
public interface EmailAnalysisRepository extends JpaRepository<EmailAnalysisEntity, Long> {
    List<EmailAnalysisEntity> findByUsernameOrderByAnalyzedAtDesc(String username);
}
