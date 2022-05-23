package br.com.viacep.userapi.service;

import br.com.viacep.userapi.dto.UserDTO;
import br.com.viacep.userapi.model.User;
import br.com.viacep.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public UserDTO findById(long userId) {
        Optional<User> usuarios = userRepository.findById(userId);
        if(usuarios.isPresent()) {
            return UserDTO.convert(usuarios.get());
        }
        return null;
    }
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }
    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCep(String cep) {
        User user = userRepository.findByCep(cep);
        if(user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String Name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
}
