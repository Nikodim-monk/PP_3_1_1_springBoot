package web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends JpaRepository<User, Long> {
}
