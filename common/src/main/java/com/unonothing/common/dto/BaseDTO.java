package com.unonothing.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(notes = "id, system generated")
    private Integer id;

    // for exceptions
    @ApiModelProperty(notes = "error, system generated")
    private Boolean error;
    @ApiModelProperty(notes = "error message, system generated")
    private String message;

    @ApiModelProperty(notes = "true if object is deleted or to be deleted")
    private Boolean deleted;

    public BaseDTO(Integer id, Boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }

}
