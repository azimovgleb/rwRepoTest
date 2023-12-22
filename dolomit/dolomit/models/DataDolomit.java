package rw.vtb.dolomit.dolomit.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dolomit_data")
//@JsonIgnoreProperties({"logDolomit"})
public class DataDolomit implements Comparable<DataDolomit>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_now")
    private Date dateCreated;
    private int zayavleno;
    private int prinyato;
    private int pogruzheno;

    @Transient
    private int plusMinusPrinyato;


    @OneToMany(mappedBy = "dataDolomit", cascade = CascadeType.ALL, orphanRemoval = true)
    @Transient
    private List<LogDolomit> logDolomit = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_carriage")
    private CarriageType carriageType;

    public DataDolomit() {
        this.plusMinusPrinyato = pogruzheno - prinyato;
    }

    public DataDolomit(Date dateCreated, int zayavleno, int prinyato, int pogruzheno, CarriageType carriageType) {
        this.dateCreated = dateCreated;
        this.zayavleno = zayavleno;
        this.prinyato = prinyato;
        this.pogruzheno = pogruzheno;
        this.plusMinusPrinyato = pogruzheno - prinyato;
        this.carriageType = carriageType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getZayavleno() {
        return zayavleno;
    }

    public void setZayavleno(int zayavleno) {
        this.zayavleno = zayavleno;
    }

    public int getPrinyato() {
        return prinyato;
    }

    public void setPrinyato(int prinyato) {
        this.prinyato = prinyato;
    }

    public int getPogruzheno() {
        return pogruzheno;
    }

    public void setPogruzheno(int pogruzheno) {
        this.pogruzheno = pogruzheno;
    }

    public int getPlusMinusPrinyato() {
        return plusMinusPrinyato;
    }

    public void setPlusMinusPrinyato(int plusMinusPrinyato) {
        this.plusMinusPrinyato = plusMinusPrinyato;
    }

    public List<LogDolomit> getLogDolomit() {
        return logDolomit;
    }

    public void setLogDolomit(List<LogDolomit> logDolomit) {
        this.logDolomit = logDolomit;
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
    }

    @Override
    public int compareTo(DataDolomit other) {
        return this.dateCreated.compareTo(other.dateCreated);
    }
}