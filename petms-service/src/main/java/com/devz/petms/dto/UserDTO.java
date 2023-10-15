/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.dto;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author devzo
 */
@Data
@ToString
public class UserDTO {
    //id,first_name,last_name,role_code,tp
    private int id;
    private String firstName;
    private String lastName;
    private String roleCode;
    private String tp;
}
