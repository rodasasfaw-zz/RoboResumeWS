package com.roboresumews.project.Dataloader;

import com.roboresumews.project.Model.Role;
import com.roboresumews.project.Model.User;
import com.roboresumews.project.Repository.RoleRepository;
import com.roboresumews.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public void run(String...strings) throws Exception{
        System.out.println("Loading data ....");
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new
                User("rodas4@gmail.com","password","Rodas","Asfaw", true,"rodasa");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);



    }
}

