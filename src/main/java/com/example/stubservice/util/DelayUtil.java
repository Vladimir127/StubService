package com.example.stubservice.util;

import com.example.stubservice.config.StubProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class DelayUtil {

    private final StubProperties stubProperties;
    private final Random random = new Random();

    @Autowired
    public DelayUtil(StubProperties stubProperties) {
        this.stubProperties = stubProperties;
    }

    /**
     * Создаёт случайную задержку в пределах, заданных в application.properties
     */
    public void addRandomDelay() throws InterruptedException {
        int minDelay = stubProperties.getDelayMin();
        int maxDelay = stubProperties.getDelayMax();

        // Генерируем случайное значение в диапазоне [minDelay, maxDelay]
        int delay = random.nextInt(maxDelay - minDelay + 1) + minDelay;

        TimeUnit.MILLISECONDS.sleep(delay); // Задержка в миллисекундах
    }
}
