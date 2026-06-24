package com.hexaware.cricketteam.exception;

public class PlayerNotFoundException
       extends RuntimeException {

    public PlayerNotFoundException(String msg) {
        super(msg);
    }
}