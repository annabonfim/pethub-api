package br.com.fiap.pethub.service;

import br.com.fiap.pethub.entity.Role;
import br.com.fiap.pethub.entity.User;
import br.com.fiap.pethub.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User cadastrar(User user) {
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

    public User atualizar(Long id, User userAtualizado) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        user.setNome(userAtualizado.getNome());
        user.setEmail(userAtualizado.getEmail());
        if (userAtualizado.getSenha() != null) {
            user.setSenha(passwordEncoder.encode(userAtualizado.getSenha()));
        }
        return userRepository.save(user);
    }
}