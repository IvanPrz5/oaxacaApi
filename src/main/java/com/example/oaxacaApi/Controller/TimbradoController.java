package com.example.oaxacaApi.Controller;

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
import com.example.oaxacaApi.Entity.TimbradoEntity;
import com.example.oaxacaApi.Repository.TimbradoRepository;
import com.example.oaxacaApi.Service.TimbradoServicio;

@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/Timbrado")
public class TimbradoController {
    @Autowired
    private TimbradoRepository timbradoRepository;
    @Autowired
    private TimbradoServicio timbradoServicio;
    
    @GetMapping
    public List<TimbradoEntity> getData(){
        return (List<TimbradoEntity>) timbradoRepository.findAll();
    }

    @GetMapping("/{id}")
    public TimbradoEntity getDataById(@PathVariable("id") Integer id){
        return timbradoServicio.getId(id).orElseThrow();
    }

    @GetMapping("/dataCapital/{idCapitalHumano}")
    public TimbradoEntity getDataCapital(@PathVariable("idCapitalHumano") Integer capitalHEntity){
        return timbradoServicio.getIdCapitalHumano(capitalHEntity).orElseThrow();
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

    @PutMapping("/{idTimbrado}")
    public ResponseEntity <TimbradoEntity> updateRegistro(@PathVariable("idTimbrado") Integer idTimbrado, @RequestBody TimbradoEntity timbradoEntity){
        Optional <TimbradoEntity> timbradoData = timbradoRepository.findById(idTimbrado);
        
        if(timbradoData.isPresent()){
            TimbradoEntity tEntity = timbradoData.get();
            tEntity.setNomina(timbradoEntity.getNomina());
            tEntity.setArchivo(timbradoEntity.getArchivo());
            tEntity.setArchivoTimbrar(timbradoEntity.getArchivoTimbrar());
            tEntity.setTotalEmpleados(timbradoEntity.getTotalEmpleados());
            tEntity.setFechaInicio(timbradoEntity.getFechaInicio());
            tEntity.setFechaFin(timbradoEntity.getFechaFin());
            tEntity.setFechaPago(timbradoEntity.getFechaPago());
            tEntity.setImporteIsr(timbradoEntity.getImporteIsr());
            tEntity.setFechaSubida(timbradoEntity.getFechaSubida());
            tEntity.setNeto(timbradoEntity.getNeto());
            tEntity.setNumEjecuciones(timbradoEntity.getNumEjecuciones());
            tEntity.setObservaciones(timbradoEntity.getObservaciones());
            tEntity.setDocumentoContable(timbradoEntity.getDocumentoContable());
            tEntity.setNumero(timbradoEntity.getNumero());
            
            return new ResponseEntity<>(timbradoRepository.save(tEntity), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
