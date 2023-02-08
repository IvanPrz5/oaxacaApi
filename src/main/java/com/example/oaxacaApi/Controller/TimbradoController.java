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

import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.TimbradoRepository;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Timbrado")
public class TimbradoController {
    @Autowired
    private TimbradoRepository timbradoRepository;
    
    @GetMapping
    public List<TimbradoEntity> getData(){
        return (List<TimbradoEntity>) timbradoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<TimbradoEntity> postData(@RequestBody TimbradoEntity data){
        try{
            TimbradoEntity timbradoEntity = timbradoRepository.save(data);
            return new ResponseEntity<>(timbradoEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
