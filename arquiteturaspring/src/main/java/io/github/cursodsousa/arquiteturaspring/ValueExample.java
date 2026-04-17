package io.github.cursodsousa.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueExample {

    @Value("${app.config.variable}")
    private String variable;

    public void printValue() {
        System.out.println("Variable value: " + variable);
    }
}
