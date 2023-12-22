package rw.vtb.dolomit.dolomit.dto.model;

import rw.vtb.dolomit.dolomit.models.LogAction;

import java.util.Date;
import java.util.UUID;

public class LogDolomitDTO {
    private UUID id;
    private Date dateCreated;
    private LogAction logActions;
    private String email;
    private UUID logDataId;

    public LogDolomitDTO(UUID id, Date dateCreated, LogAction logActions, String email, UUID logDataId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.logActions = logActions;
        this.email = email;
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

    public String getUserEmail() {
        return email;
    }

    public void setUserId(String email) {
        this.email = email;
    }

    public UUID getLogDataId() {
        return logDataId;
    }

    public void setLogDataId(UUID logDataId) {
        this.logDataId = logDataId;
    }
}
