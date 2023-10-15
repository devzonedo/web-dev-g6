/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.repository;

import com.devz.petms.dto.UserDTO;
import com.devz.petms.model.UserRegisterReqModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public List<UserDTO> getLogin(String username, String pword) {
        StringBuilder query = new StringBuilder();
        try {
            query.append("SELECT id,first_name,last_name,role_code,tp FROM tbl_user WHERE username =  ? AND pword = ? ");
            Object[] params = {username, pword};

            List<UserDTO> userList = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<UserDTO> getUserList() {
        StringBuilder query = new StringBuilder();
        try {
            query.append("SELECT id,first_name,last_name,role_code,tp FROM tbl_user");

            List<UserDTO> userList = jdbcTemplate.query(query.toString(), new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
