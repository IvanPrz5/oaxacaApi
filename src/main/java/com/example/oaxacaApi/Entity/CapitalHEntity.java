package com.example.oaxacaApi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CapitalH")
public class CapitalHEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String concepto;
    @Column
    private String fondo;
    @Column
    private String numeroOficio;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;
    @Column
    private Date fechaPago;
    @Column
    private Double retencionIsr;
    @Column
    private Double ajusteIsr;
    @Column
    private Double subsidioAjuste;
    @Column
    private Double pagar;
    @Column 
    private Date fechaCaptura;
}
