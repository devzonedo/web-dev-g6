/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.model;

/**
 *
 * @author devzo
 */
public class LoginReqModel {
    private String username;
    private String pword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    @Override
    public String toString() {
        return "LoginReqModel{" + "username=" + username + ", pword=" + pword + '}';
    }
    
    
}
