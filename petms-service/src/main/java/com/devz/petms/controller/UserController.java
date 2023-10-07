/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.controller;

import com.devz.petms.model.UserRegisterReqModel;
import com.devz.petms.model.UserRegistrerResModel;
import com.devz.petms.repository.UserDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author devzo
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserDataHandler userDataHandler;
    
    @PostMapping("/register")
    public ResponseEntity<UserRegistrerResModel>  register(@RequestBody UserRegisterReqModel userRegisterReqModel){
        System.out.println("users>>register");
        System.out.println("values:"+userRegisterReqModel.toString());
        
        boolean addUser = userDataHandler.addUser(userRegisterReqModel);
        
        UserRegistrerResModel resValue =new UserRegistrerResModel();
        
        if(addUser){
            resValue.setResCode("000");
            resValue.setResMsg("SUCCESS");
             return new ResponseEntity<UserRegistrerResModel>(resValue,HttpStatus.OK);
        }else{
          resValue.setResCode("999");
          resValue.setResMsg("ERROR");
           return new ResponseEntity<UserRegistrerResModel>(resValue,HttpStatus.EXPECTATION_FAILED);
        }
        
       
    }
    
    
}
