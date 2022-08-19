package web.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Component
public class UserDao {
    @Autowired
    private UserService userService;

    public List<User> getAllUsers() {
        return userService.findAll();
    }

    public void addNewUser(User user) {
        userService.save(user);
    }

    public User getUserById(long id) {
        return userService.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        long aa=user.getId();
       User userNotUpdate=getUserById(aa);
        userNotUpdate.setName(user.getName());
        userNotUpdate.setAge(user.getAge());
    }

    public void UserDelete(long id) {
       userService.deleteById(id);
    }
}
