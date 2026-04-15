package io.github.cursodsousa.arquiteturaspring.montadora.configuration;

import io.github.cursodsousa.arquiteturaspring.montadora.Engine;
import io.github.cursodsousa.arquiteturaspring.montadora.EngineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufacturerConfiguration {

    @Bean(name = "aspiratedEngine")
    public Engine aspiratedEngine(){
        var engine = new Engine();
        engine.setHorsePower(120);
        engine.setCylinders(4);
        engine.setLiters(2.0);
        engine.setModel("XPTO");
        engine.setEngineType(EngineType.ASPIRATED);
        return engine;
    }

    @Bean(name = "electricEngine")
    public Engine electricEngine(){
        var engine = new Engine();
        engine.setHorsePower(120);
        engine.setCylinders(4);
        engine.setLiters(1.4);
        engine.setModel("XPTO");
        engine.setEngineType(EngineType.ELECTRIC);
        return engine;
    }

    @Bean(name = "turboEngine")
    public Engine turboEngine(){
        var engine = new Engine();
        engine.setHorsePower(120);
        engine.setCylinders(4);
        engine.setLiters(1.4);
        engine.setModel("XPTO");
        engine.setEngineType(EngineType.TURBO);
        return engine;
    }
}
