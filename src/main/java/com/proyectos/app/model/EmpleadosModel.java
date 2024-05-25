package com.proyectos.app.model;

import java.util.Date;

import lombok.Data;

@Data
public class EmpleadosModel {
    private Integer id;
    private String name1;
    private String name2;
    private String apP;
    private String apM;
    private int edad;
    private int sexo;
    private Date fechaNac;
    private int puesto;
}
