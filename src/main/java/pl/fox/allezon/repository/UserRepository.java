package pl.fox.allezon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.fox.allezon.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select t from User t where t.email=?1")
    User getByMail(String email);

}
