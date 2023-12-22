package rw.vtb.dolomit.dolomit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_of_carriage")
public class CarriageType {
    @Id
    private Integer id;

    @Column(name = "carriage")
    private String type;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "carriageType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DataDolomit> dataDolomit = new ArrayList<>();

    public CarriageType() {
    }

    public CarriageType(Integer id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DataDolomit> getDataDolomit() {
        return dataDolomit;
    }

    public void setDataDolomit(List<DataDolomit> dataDolomit) {
        this.dataDolomit = dataDolomit;
    }
}

