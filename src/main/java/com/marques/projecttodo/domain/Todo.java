package com.marques.projecttodo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marques.projecttodo.Messages.MessageUtil;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "tb_todo")
public class Todo implements Serializable {

    private static final long serialVersionUID = 1l;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = MessageUtil.TITLE_NOT_EMPITY)
    private String titulo;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataParaFinalizar;

    private Boolean finalizado = false;
}
