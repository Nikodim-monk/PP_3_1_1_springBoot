package web.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private UserService userService;

    public List<User> getAllUsers() {
        return userService.findAll();
    }


    public User getUserById(int id) {
        return userService.findById((long) id).orElse(null);
    }

    public void addNewUser(User user) {
        userService.save(user);
    }
//
//    public void updateUser(User user, int id) {
//       userDao.
//    }
//
    public void UserDelete(int id) {
       userService.deleteById((long) id);
    }
}
