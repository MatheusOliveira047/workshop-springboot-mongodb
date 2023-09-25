package com.mattcode.workshop.service;

import com.mattcode.workshop.domain.User;
import com.mattcode.workshop.dto.UserDTO;
import com.mattcode.workshop.repository.UserRepository;
import com.mattcode.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User update(User obj){
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);

    }

    private void updateData(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }




}
