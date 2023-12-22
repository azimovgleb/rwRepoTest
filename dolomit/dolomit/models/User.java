package rw.vtb.dolomit.dolomit.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;
    private String email;
    private String username;
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LogDolomit> logDolomit = new ArrayList<>();

    public User(UUID id, String email, String username, String password, Role role, Status status) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<LogDolomit> getLogs() {
        return logDolomit;
    }

    public void setLogs(List<LogDolomit> logDolomit) {
        this.logDolomit = logDolomit;
    }
}
