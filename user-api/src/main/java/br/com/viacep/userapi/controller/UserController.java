package br.com.viacep.userapi.controller;

import br.com.viacep.userapi.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }
    @GetMapping("/users/{cep}")
    public UserDTO getUsersFiltro(@PathVariable String cep) {
        for (UserDTO userFilter:usuarios) {
            if (userFilter.getCep().equals((cep))){
                return userFilter;
            }
        }
        return null;
    }
    @PostMapping("/newUser")
    UserDTO inserir(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(new Date());
        usuarios.add(userDTO);
        return userDTO;
    }
    @DeleteMapping("/user/{cep}")
    public boolean remover(@PathVariable String cep){
        for (UserDTO userFilter:usuarios) {
            if (userFilter.getCep().equals(cep)) {
                usuarios.remove(userFilter);
                return true;
            }
        }
        return false;
    }
    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();
        @PostConstruct
        public void initiateList() {

            UserDTO userDTO = new UserDTO();
            userDTO.setNome("Matheus Ricardo");
            userDTO.setCep("59104140");
            userDTO.setEmail("matheus@email.com");
            userDTO.setCpf("098.098.098-55");
            userDTO.setEndereco("Avenida tupi");
            userDTO.setTelefone("842563146");
            userDTO.setDataCadastro(new Date());

            UserDTO userDTO2 = new UserDTO();
            userDTO2.setNome("Alan Ricardo");
            userDTO2.setCep("59104-150");
            userDTO2.setEmail("alan@email.com");
            userDTO2.setCpf("098.098.098-55");
            userDTO2.setEndereco("Avenida tupi");
            userDTO2.setTelefone("842563146");
            userDTO2.setDataCadastro(new Date());

            UserDTO userDTO3 = new UserDTO();
            userDTO3.setNome("Liz Ricardo");
            userDTO3.setCep("59104-150");
            userDTO3.setEmail("Liz@email.com");
            userDTO3.setCpf("098.098.098-55");
            userDTO3.setEndereco("Avenida tupi");
            userDTO3.setTelefone("842563146");
            userDTO3.setDataCadastro(new Date());

            usuarios.add(userDTO);
            usuarios.add(userDTO2);
            usuarios.add(userDTO3);

        }

}
