package com.example.oaxacaApi.Entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Finalizado")
public class FinalizadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String resultado;
    @Column 
    private String exito;
    @Column
    private String fallidos;
    @Column
    private String isrTimbrado;
    @Column
    private String urlDescarga;
    @Column
    private String pdf;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Calendar fechaFinalizado;
    @Column 
    private String qr;
    @Column
    private String observaciones;
    @Column
    private String xml;
    @Column 
    private Boolean status;

    @ManyToOne
    @JoinColumn(name="idTimbrado")
    private TimbradoEntity timbradoEntity;
}
