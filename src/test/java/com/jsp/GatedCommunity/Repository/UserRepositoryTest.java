package com.jsp.GatedCommunity.Repository;


import com.jsp.GatedCommunity.Entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest  {

    @Autowired
    private UserRepository userRepository;
    User user;

    @BeforeEach
    void setUp() {
//        Optional<User> optionalUser = userRepository.findById(2l);
//        if (optionalUser.isPresent()) {
//            user = optionalUser.get();
//        } else {
//            throw new RuntimeException("Required test user not found in DB");
//        }
        user=new User(1l,"Tejaswar Reddy","tejagmail.com","12345","ADMIN");
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        user=null;
        userRepository.deleteAll();
    }

    //Test case SUCCESS

    @Test
    void testFindById_Found(){
        Optional<User> user1=userRepository.findById(1l);
        assertThat(user1).isPresent();
        assertThat(user1.get().getName()).isEqualTo(user.getName());
        assertThat(user1.get().getEmail()).isEqualTo(user.getEmail());
        assertThat(user1.get().getRole()).isEqualTo(user.getRole());
        System.out.println(user.getId()+" "+user.getName());
    }

    //Test Case FAILURE
    @Test
    void testFindById_NotFound(){

    }



}
