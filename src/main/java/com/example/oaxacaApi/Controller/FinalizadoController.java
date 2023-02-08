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

import com.example.oaxacaApi.Entity.FinalizadoEntity;
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.FinalizadoRepository;
import com.example.oaxacaApi.Repository.TimbradoRepository;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Finalizado")
public class FinalizadoController {
    @Autowired
    private FinalizadoRepository finalizadoRepository;

    @GetMapping
    public List <FinalizadoEntity> getData(){
        return (List<FinalizadoEntity>) finalizadoRepository.findAll();
    }    

    @PostMapping
    public ResponseEntity<FinalizadoEntity> postData(@RequestBody FinalizadoEntity data){
        try{
            FinalizadoEntity finalizadoEntity = finalizadoRepository.save(data);
            return new ResponseEntity<>(finalizadoEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
