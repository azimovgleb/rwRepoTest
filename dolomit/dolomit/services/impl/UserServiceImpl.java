package rw.vtb.dolomit.dolomit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.vtb.dolomit.dolomit.dto.model.LogDolomitDTO;
import rw.vtb.dolomit.dolomit.dto.model.UserDTO;
import rw.vtb.dolomit.dolomit.models.*;
import rw.vtb.dolomit.dolomit.repositories.UserRepository;
import rw.vtb.dolomit.dolomit.services.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : users) {
            UserDTO userDTO = new UserDTO(
                    user.getId(),
                    user.getEmail(),
                    user.getUsername(),
                    user.getRole(),
                    user.getStatus()
            );
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

    @Override
    public User getById(UUID id) {
        return userRepository.getById(id);
    }

    @Override
    public User create(User user) {
        User createdUser = new User(
                UUID.randomUUID(),
                user.getEmail(),
                user.getUsername(),
                //      passwordEncoder.encode(
                user.getPassword()
                //        )
                ,
                Role.OPERATOR,
                Status.NOPASSWORD
        );

        return userRepository.save(createdUser);
    }

    @Override
    public User update(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public void delete(UUID id) {
        User deletingUser = userRepository.findById(id).orElse(null);
        if (deletingUser != null) {
            userRepository.delete(deletingUser);
        }
    }
}
