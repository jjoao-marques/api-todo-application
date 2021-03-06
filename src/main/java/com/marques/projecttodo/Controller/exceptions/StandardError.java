package com.marques.projecttodo.Controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class StandardError implements  Serializable{

    private static final long serialVersionUID = 1l;


    private Long timestamp;
    private Integer status;
    private String message;

}
