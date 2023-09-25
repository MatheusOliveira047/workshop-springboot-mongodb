package com.mattcode.workshop.service;

import com.mattcode.workshop.domain.Post;
import com.mattcode.workshop.domain.User;
import com.mattcode.workshop.dto.UserDTO;
import com.mattcode.workshop.repository.PostRepository;
import com.mattcode.workshop.repository.UserRepository;
import com.mattcode.workshop.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
