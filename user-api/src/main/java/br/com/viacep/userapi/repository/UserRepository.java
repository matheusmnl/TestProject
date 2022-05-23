package br.com.viacep.userapi.repository;

import br.com.viacep.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCep(String cep);

    List<User> queryByNomeLike(String name);

}
