package rw.vtb.dolomit.dolomit.models;

import java.util.Set;
import java.util.stream.Collectors;
public enum Role {
    USER(Set.of(Permission.DEVELOPERS_READ)),
    OPERATOR(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),

    ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

//    public Set<SimpleGrantedAuthority> getAuthorities() {
//        return getPermissions().stream()
//                .map(permission -> new SimpleGrantedAuthority((permission.getPermission())))
//                .collect(Collectors.toSet());
//    }
}