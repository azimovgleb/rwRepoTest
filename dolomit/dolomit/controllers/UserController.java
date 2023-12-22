package rw.vtb.dolomit.dolomit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.vtb.dolomit.dolomit.dto.model.UserDTO;
import rw.vtb.dolomit.dolomit.models.User;
import rw.vtb.dolomit.dolomit.services.UserService;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dolomit/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> userList = userService.getAll();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("/create")
    //  @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<User> create(@RequestBody User user) {
        User createdUser = userService.create(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    // @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<User> update(@RequestBody User user) {
        User updatedUser = userService.update(user);

        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

//    @PutMapping("/update/password")
//    // @PreAuthorize("hasAuthority('users:write')")
//    public ResponseEntity<User> update(@RequestBody User user) {
//        User updatedUser = userService.update(user);
//
//        if (updatedUser != null) {
//            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }

    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasAuthority('users:write')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
