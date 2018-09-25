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
public class BaseEntityDTO implements Serializable {

    @ApiModelProperty(notes = "id, system generated")
    private Integer id;

    // for exceptions
    @ApiModelProperty(notes = "error, system generated")
    private Boolean error = false;
    @ApiModelProperty(notes = "error message, system generated")
    private String message = "No error";

    @ApiModelProperty(notes = "true if object is deleted or to be deleted")
    private Boolean deleted;

    public BaseEntityDTO(Integer id, Boolean deleted) {
        this.id = id;
        this.deleted = deleted;
    }

}
