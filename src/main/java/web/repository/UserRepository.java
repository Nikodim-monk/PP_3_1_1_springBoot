package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Repository
public class UserRepository implements UserService {
    @Autowired
    private JpaRepo jpaRepo;

    public List<User> getAllUsers() {
        return jpaRepo.findAll();
    }

    public void addNewUser(User user) {
        jpaRepo.save(user);
    }

    public User getUserById(long id) {
        return jpaRepo.findById(id).orElse(null);
    }

    public void updateUser(User user) {
        jpaRepo.saveAndFlush(user);
    }

    public void UserDelete(long id) {
        jpaRepo.deleteById(id);
    }
}
