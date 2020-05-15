package pl.fox.allezon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.fox.allezon.model.User;
import pl.fox.allezon.repository.UserRepository;
import pl.fox.allezon.utils.ConsoleColors;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    private static Logger LOG = LoggerFactory.getLogger(UserService.class);
    private static final String LOG_COLOR = ConsoleColors.PURPLE_BOLD;

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public void saveUser(User u){
        var bcrypt = new BCryptPasswordEncoder();
        u.setPassword(bcrypt.encode(u.getPassword()));
        repository.save(u);
        LOG.info(LOG_COLOR + "Saved {}" + ConsoleColors.RESET, u.toString());
    }

    public void deleteUser(Integer id) {
       repository.deleteById(id);
       LOG.info(LOG_COLOR + "Deleted User with id {}" + ConsoleColors.RESET, id);
    }

    public User getById(Integer id){
        return repository.getOne(id);
    }

    @PostConstruct
    public void countUsers(){
        LOG.info(LOG_COLOR + "There are {} users in database" + ConsoleColors.RESET, repository.count());
    }

}
