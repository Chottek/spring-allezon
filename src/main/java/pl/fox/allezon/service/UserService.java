package pl.fox.allezon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fox.allezon.model.User;
import pl.fox.allezon.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public void saveUser(User u){
        repository.save(u);
    }

    public void deleteUser(Integer id) {
       repository.deleteById(id);
    }

}
