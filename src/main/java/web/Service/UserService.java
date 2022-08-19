package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Repositiry.UserRepository;
import web.model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }


    public User getUserById(int id) {
        return userDao.findById((long) id).orElse(null);
    }

    public void addNewUser(User user) {
        userDao.save(user);
    }
//
//    public void updateUser(User user, int id) {
//       userDao.
//    }
//
    public void UserDelete(int id) {
       userDao.deleteById((long) id);
    }
}
