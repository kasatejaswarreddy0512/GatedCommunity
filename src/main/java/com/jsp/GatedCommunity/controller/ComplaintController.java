package com.jsp.GatedCommunity.controller;

import com.jsp.GatedCommunity.Entity.Complaint;
import com.jsp.GatedCommunity.services.ComplaintService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaint")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/complaint/{id}")
    public ResponseEntity<Complaint> writeComplaint(@RequestBody Complaint complaint, @PathVariable Long id){
        return new ResponseEntity<>(complaintService.writeComplaint(id, complaint),HttpStatus.CREATED);
    }

    @GetMapping("/getAllComplaints")
    public ResponseEntity<List<Complaint>> getAllComplaints(){
        return new ResponseEntity<>(complaintService.getAllComplaints(),HttpStatus.FOUND) ;
    }

    @GetMapping("/getComplaintById/{id}")
    public ResponseEntity<Complaint> getComaComplaintById(@PathVariable Long id){
        return new ResponseEntity<>(complaintService.getComplaintById(id), HttpStatus.FOUND);
    }

    @PutMapping("/updateComplaint/{id}/{userId}")
    public ResponseEntity<Complaint> udpateComplaint(@RequestBody Complaint complaint, @PathVariable Long id, @PathVariable("userId") Long userId){
        return new ResponseEntity<>(complaintService.updateComplaint(complaint,id,userId),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteComplaint/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable Long id) {
        String result = complaintService.deleteComplaint(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
