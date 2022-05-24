package br.com.viacep.serverapi.controller;

import br.com.viacep.serverapi.dto.ServerDTO;
import br.com.viacep.serverapi.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/servers")
    public List<ServerDTO> getServerss() {
        List<ServerDTO> produtos = serverService.getAll();
        return produtos;
    }

    @GetMapping("/servers/serverByUser/{userIdentifier}")
    public List<ServerDTO> getServerss(
            @PathVariable String userIdentifier) {
                List<ServerDTO> produtos =
                        serverService.getByUser(userIdentifier);
                return produtos;
    }

    @GetMapping("/server/serverByDate")
    public List<ServerDTO> getServerss(@RequestBody ServerDTO serverDTO) {
        List<ServerDTO> produtos = serverService.getByDate(serverDTO);
        return produtos;
    }

    @GetMapping("server/{id}")
    public ServerDTO findById(@PathVariable Long id) {
        return serverService.findById(id);
    }

    @GetMapping("/server/{id}")
    public ServerDTO findById(@PathVariable Long id) {
        return serverService.findById(id);
    }

    @PostMapping("/server")
    public ServerDTO newServer(@Valid @RequestBody ServerDTO serverDTO) {
        return serverService.save(serverDTO);
    }
}
