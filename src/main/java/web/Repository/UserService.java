package web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.model.User;

public interface UserService extends JpaRepository<User, Long> {
}
