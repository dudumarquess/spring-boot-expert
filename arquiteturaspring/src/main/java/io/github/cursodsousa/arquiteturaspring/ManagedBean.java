package io.github.cursodsousa.arquiteturaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagedBean {

    public ManagedBean() {
        System.out.println("ManagedBean created");
    }
}
