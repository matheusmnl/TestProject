package br.com.viacep.serverapi.model;

import javax.persistence.*;
import javax.swing.plaf.synth.Region;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="server")
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userIdentifier;
    private float total;
    private Date date;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "region",
    joinColumns = @JoinColumn(name = "server_id"))
    private List<Region> regions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public static Server convert(ServerDTO serverDTO) {
        Server server = new Server();

        server.setUserIdentifier(serverDTO.getUserIdentifier());
        server.setTotal(serverDTO.getTotal());
        server.setDate(serverDTO.getDate());
        server.setRegions(serverDTO
                .getRegions()
                .stream
                .map(Region::convert)
                .collect(Collectors.toList()));

    }

}
