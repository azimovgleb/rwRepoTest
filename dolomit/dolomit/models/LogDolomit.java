package rw.vtb.dolomit.dolomit.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "logs")
@JsonIgnoreProperties({"dataDolomit"})
public class LogDolomit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date_now")
    private Date dateCreated;


    @Column(name = "log_action")
    @Enumerated(EnumType.STRING)
    private LogAction logActions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_log_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_log_data")
    @Transient
    private DataDolomit dataDolomit;

    @Column(name = "id_log_data")
    private UUID logDataId;

    public LogDolomit() {
        this.id = UUID.randomUUID();
        this.dateCreated = new Date();
    }

    public LogDolomit(LogAction logActions, User user, UUID logDataId) {
        this.id = UUID.randomUUID();
        this.dateCreated = new Date();
        this.logActions = logActions;
        this.user = user;
        this.logDataId = logDataId;
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

    public LogAction getLogActions() {
        return logActions;
    }

    public void setLogActions(LogAction logActions) {
        this.logActions = logActions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DataDolomit getDataDolomit() {
        return dataDolomit;
    }

    public void setDataDolomit(DataDolomit dataDolomit) {
        this.dataDolomit = dataDolomit;
    }

    public UUID getLogDataId() {
        return logDataId;
    }

    public void setLogDataId(UUID logDataId) {
        this.logDataId = logDataId;
    }
}
