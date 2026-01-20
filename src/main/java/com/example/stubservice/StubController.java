package com.example.stubservice;

import com.example.stubservice.dto.GetUserDto;
import com.example.stubservice.dto.PostUserDto;
import com.example.stubservice.dto.UserRequest;
import com.example.stubservice.util.DelayUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class StubController {
    private final DelayUtil delayUtil;

    @Autowired
    public StubController(DelayUtil delayUtil) {
        this.delayUtil = delayUtil;
    }

    @GetMapping("/user")
    public ResponseEntity<GetUserDto> getUser() throws InterruptedException {
        delayUtil.addRandomDelay(); // Добавляем случайную задержку

        GetUserDto userDto = new GetUserDto("Login1", "ok");

        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/user")
    public ResponseEntity<PostUserDto> createUser(@RequestBody @Valid PostUserDto userDto)  throws InterruptedException {
        delayUtil.addRandomDelay(); // Добавляем случайную задержку

        // Форматируем текущую дату и время
        String currentDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        userDto.setDate(currentDate);

        // Формируем ответ вручную (можно использовать библиотеку Jackson, но так проще)
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
}