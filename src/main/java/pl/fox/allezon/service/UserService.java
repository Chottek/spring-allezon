package pl.fox.allezon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public boolean loginUser(Object o){
        String data = o.toString();
        String[] user = data.split(",");
        String mail = user[0].replace("{user=", "");
        String p = user[1].replace(" password=", "");
        String password = p.replace("}", "");

        LOG.info("{ " + mail + ", " + password + " }");
        if(repository.getByMail(mail) != null){
            var bcrypt = new BCryptPasswordEncoder();
            User u = repository.getByMail(mail);
            if(bcrypt.matches(password, u.getPassword())){
                LOG.info("User {} logged in!", u.getUsername());
                return true;
            }else{
                LOG.info("Invalid user or password!");
                return false;
            }
        }
        else{
            LOG.info("Invalid user or password!");
            return false;
        }

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
