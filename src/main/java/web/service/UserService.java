package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addNewUser(User user);

    User getUser(long id);

    void updateUser(User user);

    void userDelete(long id);
}
