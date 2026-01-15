package com.example.stubservice;

import com.example.stubservice.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class StubController {

    // GET метод - возвращает статичный JSON
    @GetMapping("/user")
    public String getUser() {
        try {
            TimeUnit.SECONDS.sleep(2); // Задержка 2 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "{\"login\":\"Login1\",\"status\":\"ok\"}";
    }

    // POST метод - принимает JSON, возвращает JSON с датой
    @PostMapping("/user")
    public String createUser(@RequestBody UserRequest userRequest) {
        // Форматируем текущую дату и время
        String currentDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        try {
            TimeUnit.SECONDS.sleep(2); // Задержка 2 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Формируем ответ вручную (можно использовать библиотеку Jackson, но так проще)
        return String.format(
                "{\"login\":\"%s\",\"password\":\"%s\",\"date\":\"%s\"}",
                userRequest.getLogin(),
                userRequest.getPassword(),
                currentDate
        );
    }
}

