package com.example.stubservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "stub.response") // Префикс для свойств в application.properties
public class StubProperties {
    private int delayMin = 1000; // Значение по умолчанию, если свойство не задано
    private int delayMax = 2000;

    public int getDelayMin() {
        return delayMin;
    }

    public void setDelayMin(int delayMin) {
        this.delayMin = delayMin;
    }

    public int getDelayMax() {
        return delayMax;
    }

    public void setDelayMax(int delayMax) {
        this.delayMax = delayMax;
    }
}
