package br.com.viacep.serverapi.dto;

import br.com.viacep.serverapi.model.Server;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ServerDTO {

    @NotBlank
    private String userIdentifier;
    @NotNull
    private Float total;
    @NotNull
    private Date date;
    @NotNull
    private List<ServerDTO> servers;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ServerDTO> getServers() {
        return servers;
    }

    public void setServers(List<ServerDTO> servers) {
        this.servers = servers;
    }

    public static ServerDTO convert(Server server) {
        ServerDTO serverDTO = new ServerDTO();

        serverDTO.setTotal(server.getTotal());
        return serverDTO;
    }
}
