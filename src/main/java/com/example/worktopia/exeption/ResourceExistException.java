package com.example.worktopia.exeption;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message) {
        super(message);
    }
}