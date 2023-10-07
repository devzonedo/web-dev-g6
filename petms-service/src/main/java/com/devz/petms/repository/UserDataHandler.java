/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.repository;

import com.devz.petms.model.UserRegisterReqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author devzo
 */
@Repository
public class UserDataHandler {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addUser(UserRegisterReqModel values) {
        StringBuilder query = new StringBuilder();
        boolean flag = false;
        try {
            query.append("INSERT INTO tbl_user (first_name,last_name,role_code,username,pword,tp) "
                    + " VALUES (?,?,?,?,?,?) ");
            Object[] params = {values.getFirstName(),
                values.getLastName(),
                values.getRoleCode(),
                values.getUsername(),
                values.getPword(),
                values.getTp()};
            
            jdbcTemplate.update(query.toString(), params);
            System.out.println("record inserted success");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
