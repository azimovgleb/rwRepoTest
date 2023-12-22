package rw.vtb.dolomit.dolomit.models;

public enum Permission {
    DEVELOPERS_READ("users:read"),
    DEVELOPERS_WRITE("users:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
