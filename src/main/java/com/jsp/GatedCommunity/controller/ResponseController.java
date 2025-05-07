package com.jsp.GatedCommunity.controller;

import com.jsp.GatedCommunity.Entity.Response;
import com.jsp.GatedCommunity.services.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/response")
public class ResponseController {

    @Autowired
    private ResponseService responseService;


    @PostMapping("/saveResponse/{uid}/{cid}")
    public ResponseEntity<Response> saveResponseService(@RequestBody Response response, @PathVariable Long uid, @PathVariable Long cid){
        return new ResponseEntity<>(responseService.saveResponse(uid,cid,response), HttpStatus.CREATED);
    }
}
