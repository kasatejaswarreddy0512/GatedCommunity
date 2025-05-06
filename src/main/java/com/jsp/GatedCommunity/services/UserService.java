package com.jsp.GatedCommunity.services;

import com.jsp.GatedCommunity.Entity.User;
import com.jsp.GatedCommunity.Repository.UserRepository;
import com.jsp.GatedCommunity.helper.ResponseStructure;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public ResponseStructure<User> saveUser(User user){
//        userRepository.save(user);
//        ResponseStructure<User> rs=new ResponseStructure<>();
//        rs.setStatusCode(HttpStatus.CREATED.value());
//        rs.setData(user);
//        rs.setMessage("User Data Successfully....!");
//        return rs;
//    }

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

