package br.com.fiap.pethub.controller;

import br.com.fiap.pethub.entity.User;
import br.com.fiap.pethub.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> cadastrar(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.cadastrar(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.atualizar(id, user));
    }

}