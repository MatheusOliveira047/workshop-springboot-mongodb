package com.mattcode.workshop.config;

import com.mattcode.workshop.domain.Post;
import com.mattcode.workshop.domain.User;
import com.mattcode.workshop.dto.AuthorDTO;
import com.mattcode.workshop.repository.PostRepository;
import com.mattcode.workshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,sdf.parse("12/03/2018"),"Partiu viagem","Vou viajar para são paulo",new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/01/2018"),"Partiu praia","Vou viajar jeri",new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1,post2));

    }
}
