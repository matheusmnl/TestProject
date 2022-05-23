package br.com.viacep.userapi.service;

import br.com.viacep.userapi.dto.UserDTO;
import br.com.viacep.userapi.model.User;
import br.com.viacep.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {

        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(User::convert)
                .collect(Collectors.toList());
    }
}
