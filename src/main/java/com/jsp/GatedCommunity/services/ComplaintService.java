package com.jsp.GatedCommunity.services;


import com.jsp.GatedCommunity.Entity.Complaint;
import com.jsp.GatedCommunity.Entity.User;
import com.jsp.GatedCommunity.Repository.ComplaintRepository;
import com.jsp.GatedCommunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    public Complaint writeComplaint(Long id, Complaint complaint){
        Optional<User> o= userRepository.findById(id);
        if(o.isPresent()){
            User user=o.get();

            complaint.setUser(user);

            return complaintRepository.save(complaint);
        }
        else{
            throw  new RuntimeException("User Id Not Found");
        }
    }

    public List<Complaint> getAllComplaints(){
        return complaintRepository.findAll();
    }

    public Complaint getComplaintById(Long id){
        return complaintRepository.findById(id)
                .orElseThrow(()->new  RuntimeException("Complaint Not Found..!"));
    }

    public Complaint updateComplaint(Complaint complaint ,Long id, Long userId){

        Complaint updateComplaint=complaintRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Complaint Id not Found"));

        User existingUser=userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User Id not found"));

        updateComplaint.setTitle(complaint.getTitle());
        updateComplaint.setDescription(complaint.getDescription());
        updateComplaint.setStatus(complaint.getStatus());
        updateComplaint.setUser(existingUser);

        return complaintRepository.save(updateComplaint);
    }

    public String deleteComplaint(Long id) {
        if (complaintRepository.existsById(id)) {
            complaintRepository.deleteById(id);
            return "Complaint deleted successfully.";
        } else {
            throw new RuntimeException("Complaint ID not found!");
        }
    }

}
