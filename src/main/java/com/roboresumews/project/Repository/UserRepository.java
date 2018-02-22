package com.roboresumews.project.Repository;
import com.roboresumews.project.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String username);
    User findByEmail(String email);
    Long countByEmail(String email);
    Long countByUserName(String username);


}