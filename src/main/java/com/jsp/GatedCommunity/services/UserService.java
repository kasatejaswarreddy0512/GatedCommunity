package com.jsp.GatedCommunity.services;

import com.jsp.GatedCommunity.Entity.User;
import com.jsp.GatedCommunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
   }

   public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("user Not Found...!"));
   }

   public User updateUser(User user, Long id){
        Optional<User> o=userRepository.findById(id);
        if(o.isPresent()){
            User updateUser=o.get();
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());
            updateUser.setRole(user.getRole());

        return  userRepository.save(updateUser);
        }
        else{
            throw new RuntimeException("User Not found");
        }
   }

   public  void deleteUser(Long id){
         userRepository.deleteById(id);
   }
}

