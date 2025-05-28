package com.example.worktopia.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class ErrorMessage {
    private int status;
    private String msg;
    private String error;
    private Date timestamp;

    public ErrorMessage() {
    }

    public ErrorMessage(int status, String msg, String error, Date timestamp) {
        this.status = status;
        this.msg = msg;
        this.error = error;
        this.timestamp = timestamp;
    }

}