/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.controller;

import com.devz.petms.dto.UserDTO;
import com.devz.petms.model.LoginReqModel;
import com.devz.petms.model.LoginResModel;
import com.devz.petms.model.UserRegisterReqModel;
import com.devz.petms.model.UserRegistrerResModel;
import com.devz.petms.model.UsersResModel;
import com.devz.petms.repository.UserDataHandler;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public ResponseEntity<UserRegistrerResModel> register(@RequestBody UserRegisterReqModel userRegisterReqModel) {
        System.out.println("users>>register");
        System.out.println("values:" + userRegisterReqModel.toString());

        boolean addUser = userDataHandler.addUser(userRegisterReqModel);

        UserRegistrerResModel resValue = new UserRegistrerResModel();

        if (addUser) {
            resValue.setResCode("000");
            resValue.setResMsg("SUCCESS");
            return new ResponseEntity<UserRegistrerResModel>(resValue, HttpStatus.OK);
        } else {
            resValue.setResCode("999");
            resValue.setResMsg("ERROR");
            return new ResponseEntity<UserRegistrerResModel>(resValue, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping("/login")
    public LoginResModel getLogin(@RequestBody LoginReqModel loginReqModel,HttpServletResponse response) {
        System.out.println("users>>login");
        System.out.println(loginReqModel.toString());

        LoginResModel res = new LoginResModel();

        List<UserDTO> login = userDataHandler.getLogin(loginReqModel.getUsername(), loginReqModel.getPword());
        if (!login.isEmpty()) {
            // user found
            UserDTO get = login.get(0);
            res.setUserDTO(get);
            res.setResCode("000");
            res.setResMsg("SUCCESS");
            
            // generate Token 
            response.addHeader("token", "this is generated token form backend"); // JWT
        } else {
            res.setResCode("999");
            res.setResMsg("ERROR");
        }  
        return res;
    }

    @PostMapping
    public UsersResModel listUsers(@RequestHeader("token")String token){
     System.out.println("users>>");
     System.out.println("token:"+token);
     
     //validate the token 
     
     
     UsersResModel res = new UsersResModel();
        List<UserDTO> userList = userDataHandler.getUserList();
        res.setUserList(userList);
        res.setResCode("000");
        res.setResMsg("SUCCESS");
        return res;
    }
}
