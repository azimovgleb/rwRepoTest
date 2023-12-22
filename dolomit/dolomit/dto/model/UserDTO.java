package rw.vtb.dolomit.dolomit.dto.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import rw.vtb.dolomit.dolomit.models.Role;
import rw.vtb.dolomit.dolomit.models.Status;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String email;
    private String username;
    private Role role;
    private Status status;


    public UserDTO(UUID id, String email, String username, Role role, Status status) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.role = role;
        this.status = status;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
