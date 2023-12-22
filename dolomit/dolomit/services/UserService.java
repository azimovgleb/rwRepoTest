package rw.vtb.dolomit.dolomit.services;

import rw.vtb.dolomit.dolomit.dto.model.UserDTO;
import rw.vtb.dolomit.dolomit.models.DataDolomit;
import rw.vtb.dolomit.dolomit.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDTO> getAll();

    User getById(UUID id);
    User create(User user);

    User update(User user);

    void delete(UUID id);
}
