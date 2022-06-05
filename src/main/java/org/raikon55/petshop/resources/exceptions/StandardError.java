package org.raikon55.petshop.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private static final long serialVersionUID = -3606299852653404781L;


    private Integer status;
    private String msg;

    public StandardError() {
    }

    public StandardError(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    
}
