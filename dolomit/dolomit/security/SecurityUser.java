package rw.vtb.dolomit.dolomit.security;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import rw.vtb.dolomit.dolomit.models.User;
//import rw.vtb.dolomit.dolomit.models.Status;
//
//
//import java.util.Collection;
//import java.util.List;
//
//public class SecurityUser
//        implements UserDetails {
//
//    private final String userName;
//    private final String password;
//    private final List<SimpleGrantedAuthority> authorities;
//    private final boolean isActive;
//
//    public SecurityUser(String userName, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
//        this.userName = userName;
//        this.password = password;
//        this.authorities = authorities;
//        this.isActive = isActive;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return isActive;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return isActive;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return isActive;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return isActive;
//    }
//
//    public static UserDetails fromUser(User user) {
//        if (user.getStatus().equals(Status.NOPASSWORD)) {
//            return new org.springframework.security.core.userdetails.User(
//                    user.getEmail(), user.getPassword(),
//                    user.getStatus().equals(Status.NOPASSWORD),
//                    user.getStatus().equals(Status.NOPASSWORD),
//                    user.getStatus().equals(Status.NOPASSWORD),
//                    user.getStatus().equals(Status.NOPASSWORD),
//                    user.getRole().getAuthorities()
//            );
//        }
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(), user.getPassword(),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getStatus().equals(Status.ACTIVE),
//                user.getRole().getAuthorities()
//        );
//
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public boolean isActive() {
//        return isActive;
//    }
//}