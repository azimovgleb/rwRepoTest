package rw.vtb.dolomit.dolomit.security;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import rw.vtb.dolomit.dolomit.models.Status;
//import rw.vtb.dolomit.dolomit.models.User;
//import rw.vtb.dolomit.dolomit.repositories.UserRepository;
//
//@Service("userDetailsServiceImpl")
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public UserDetailsServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email).orElseThrow(() ->
//                new UsernameNotFoundException("User doesn't exists"));
//        if (user.getStatus().equals(Status.NOPASSWORD)) {
//            user.setPassword("$2a$12$RkEhgDn7Offx8oUt.PYkjuLW8UPqYqH2mfEWYGaY8OdSEMM7xAPci".intern());
//        }
//        return SecurityUser.fromUser(user);
//    }
//}