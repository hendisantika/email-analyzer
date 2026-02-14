package id.my.hendisantika.emailanalyzer.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : email-analyzer
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/02/26
 * Time: 06.36
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class EmailAnalysisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // utilisateur qui a analysé
    @Column(length = 5000)
    private String content;
    private boolean suspicious;
    private int score;

    @ElementCollection
    private List<String> reasons;

    private LocalDateTime analyzedAt = LocalDateTime.now();

    // getters / setters

    public LocalDateTime getDate(){
        return analyzedAt;
    }

    public String getUser(){
        return username;
    }

    public String getContent(){
        return content;
    }

    public int getScore(){
        return score;
    }

    public boolean isSuspicious() { return suspicious; }
    public List<String> getReasons() { return reasons; }

    public void setUsername(String username){
        this.username = username;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setSuspicious(boolean suspicious){
        this.suspicious = suspicious;
    }

    public void setReasons(List<String> reasons){
        this.reasons = reasons;
    }

    public void setDate(LocalDateTime date){
        this.analyzedAt = date;
    }
}
