package com.jsp.GatedCommunity.services;

import com.jsp.GatedCommunity.Entity.Complaint;
import com.jsp.GatedCommunity.Entity.Response;
import com.jsp.GatedCommunity.Entity.User;
import com.jsp.GatedCommunity.Repository.ComplaintRepository;
import com.jsp.GatedCommunity.Repository.ResponseRepository;
import com.jsp.GatedCommunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComplaintRepository complaintRepository;


    public Response saveResponse(Long uid, Long cid, Response response){

        User user=userRepository.findById(uid)
                .orElseThrow(()-> new RuntimeException("User Id Not Found..!"));

        Complaint complaint=complaintRepository.findById(cid)
                .orElseThrow(()-> new RuntimeException("Complaint ID Not Found...!"));

        response.setUser(user);
        response.setComplaint(complaint);
        response.setLocalDateTime(LocalDateTime.now());

        complaint.setStatus("DONE");
        complaintRepository.saveAndFlush(complaint);

        return responseRepository.save(response);
    }
}
