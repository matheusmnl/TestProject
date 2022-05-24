package br.com.viacep.serverapi.repository;

import br.com.viacep.serverapi.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ServerRepository extends JpaRepository<Server, Long> {

    public List<Server> findAllByUserIdentifier(String userIdentifier);

    public List<Server> findAllByDaeGreaterThanEquals(Date date);
}
