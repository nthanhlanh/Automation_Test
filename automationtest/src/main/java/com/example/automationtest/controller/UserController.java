package com.example.automationtest.controller;

import com.example.automationtest.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // GET /api/users → trả về danh sách user mẫu
    @GetMapping
    public List<UserDto> getAllUsers() {
        return Arrays.asList(
                new UserDto(1L, "Alice", "alice@example.com"),
                new UserDto(2L, "Bob", "bob@example.com"),
                new UserDto(3L, "Charlie", "charlie@example.com")
        );
    }

    // GET /api/users/{id} → trả về user cụ thể
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return new UserDto(id, "User " + id, "user" + id + "@example.com");
    }

    // POST /api/users → tạo user (giả lập)
    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        user.setId(99L); // giả lập ID tự sinh
        return user;
    }
}
