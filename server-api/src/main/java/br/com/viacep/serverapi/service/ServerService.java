package br.com.viacep.serverapi.service;

import br.com.viacep.serverapi.dto.ServerDTO;
import br.com.viacep.serverapi.model.Server;
import br.com.viacep.serverapi.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    public List<ServerDTO> getAll() {
        List<Server> servers = serverRepository.findAll();
        return servers
                .stream()
                .map(ServerDTO::convert)
                .collect(Collectors.toList());
    }
    public List<ServerDTO> getByUser(String userIdentifier) {
        List<Server> servers = serverRepository
                .findAllByUserIdentifier(userIdentifier);
        return servers
                .stream()
                .map(ServerDTO::convert)
                .collect(Collectors.toList());
    }
    public List<ServerDTO> getByDate(ServerDTO serverDTO) {
        List<Server> servers = serverRepository
                .findAllByDaeGreaterThanEquals(serverDTO.getDate());
        return servers
                .stream()
                .map(ServerDTO::convert)
                .collect(Collectors.toList());
    }
    public ServerDTO findById(long ProductId) {
        Optional<Server> server =
                serverRepository.findById(ProductId);
        if (server.isPresent()) {
            return ServerDTO.convert(server.get());
        }
        return null;
    }

    public ServerDTO save(ServerDTO serverDTO) {

        serverDTO.setTotal(serverDTO.getRegions()
                .stream()
                .map(x -> x.getTaxPercentage())
                .reduce((float) 0, Float::sum)
        );

        Server server = Server.convert(serverDTO);
        server.setDate(new Date());

        server = serverRepository.save(server);
        return ServerDTO.convert(server);
    }

}
