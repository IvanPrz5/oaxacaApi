package com.example.oaxacaApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/CapitalHumano")
public class CapitalHController {
    @Autowired
    private CapitalHRepository capitalHRepository;

    @GetMapping
    public List <CapitalHEntity> getData(){
        return (List<CapitalHEntity>) capitalHRepository.findAll();
    }
    
    @PostMapping
    public ResponseEntity<CapitalHEntity> postData(@RequestBody CapitalHEntity data){
        try{
            CapitalHEntity capitalHEntity = capitalHRepository.save(data);
            return new ResponseEntity<>(capitalHEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }     
    }
}

