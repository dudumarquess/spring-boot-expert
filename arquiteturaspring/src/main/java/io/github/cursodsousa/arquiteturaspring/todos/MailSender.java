package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void sendEmail(String s) {
        System.out.println("Email sent: " + s);
    }
}
