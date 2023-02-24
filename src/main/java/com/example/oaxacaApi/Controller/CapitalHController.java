package com.example.oaxacaApi.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.oaxacaApi.Entity.CapitalHEntity;
import com.example.oaxacaApi.Repository.CapitalHRepository;
import com.example.oaxacaApi.Service.CapitalHService;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/CapitalHumano")
public class CapitalHController {
    @Autowired
    private CapitalHRepository capitalHRepository;
    @Autowired
    private CapitalHService capitalHService;

    @GetMapping
    public List <CapitalHEntity> getData(){
        return (List<CapitalHEntity>) capitalHRepository.findAll();
    }
    
    @GetMapping("/{idCapitalH}")
    public Optional<CapitalHEntity> getDataById(@PathVariable("idCapitalH") Integer idCapitalH){
        return capitalHRepository.findById(idCapitalH);
    }

    @GetMapping("/dataCapital/{statusCapitalH}")
    public List <CapitalHEntity> getDataByStatus(@PathVariable("statusCapitalH") Boolean status){
        return (List<CapitalHEntity>) capitalHService.getDataByStatus(status); 
    }

    //Consutal Fecha
    /* @GetMapping("/fechaCapital/{fechaInicio}")
    public List <CapitalHEntity> getDataByFechaInicio(@PathVariable("fechaInicio") String fechaInicio) throws ParseException{
        return (List<CapitalHEntity>) capitalHService.getDataByFechaPago(fechaInicio);
    }
 */


    // Consulta Fecha Pago
    @GetMapping("/fechasCapital/{fechaPago}")
    public List <CapitalHEntity> getDataByFechaPago(@PathVariable("fechaPago") String fechaPago) throws ParseException{
        return (List<CapitalHEntity>) capitalHService.getDataByFechaPago(fechaPago);
    }


    /* Fecha Inicio - Fecha Fin */
    /* @GetMapping("/fechasCapital/{fechaInicio}/{fechaFin}")
    public List <CapitalHEntity> getDataByFechaInicioAndFechaFin(@PathVariable("fechaInicio") String fechaInicio, @PathVariable("fechaFin") String fechaFin) throws ParseException {
        return (List<CapitalHEntity>) capitalHService.getDataByFechaInicioAndFechaFin(fechaInicio, fechaFin);
    } */

    /* */
    @PostMapping
    public ResponseEntity<CapitalHEntity> postData(@RequestBody CapitalHEntity data){
        try{
            CapitalHEntity capitalHEntity = capitalHRepository.save(data);
            return new ResponseEntity<>(capitalHEntity, HttpStatus.CREATED);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }     
    }

    @PutMapping("/{idCapitalH}")
    public ResponseEntity <CapitalHEntity> updatingRegistro(@PathVariable("idCapitalH") Integer idCapitalH, @RequestBody CapitalHEntity capitalHEntity){
        Optional<CapitalHEntity> capitalHData = capitalHRepository.findById(idCapitalH);

        if(capitalHData.isPresent()){
            CapitalHEntity capitalH = capitalHData.get();
            capitalH.setConcepto(capitalHEntity.getConcepto());
            capitalH.setFondo(capitalHEntity.getFondo());
            capitalH.setNumeroOficio(capitalHEntity.getNumeroOficio());
            capitalH.setFechaInicio(capitalHEntity.getFechaInicio());
            capitalH.setFechaFin(capitalHEntity.getFechaFin());
            capitalH.setFechaPago(capitalHEntity.getFechaPago());
            capitalH.setRetencionIsr(capitalHEntity.getRetencionIsr());
            capitalH.setAjusteIsr(capitalHEntity.getAjusteIsr());
            capitalH.setSubsidioAjuste(capitalHEntity.getSubsidioAjuste());
            capitalH.setPagar(capitalHEntity.getPagar());
            capitalH.setStatus(capitalHEntity.getStatus());
            return new ResponseEntity<>(capitalHRepository.save((capitalH)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/statusCapital/{idCapitalH}")
    public ResponseEntity <CapitalHEntity> updatingStatus(@PathVariable("idCapitalH") Integer idCapitalH, @RequestBody CapitalHEntity capitalHEntity){
        Optional<CapitalHEntity> capitalHData = capitalHRepository.findById(idCapitalH);

        if(capitalHData.isPresent()){
            CapitalHEntity capitalH = capitalHData.get();
            capitalH.setStatus(capitalHEntity.getStatus());
            return new ResponseEntity<>(capitalHRepository.save((capitalH)), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /* @DeleteMapping("/{idCapitalH}")
    public ResponseEntity<HttpStatus> deleteRegistro(@PathVariable("idCapitalH") Integer idCapitalH){
        try{
            capitalHRepository.deleteById(idCapitalH);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    } */
}

