/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.model;

import com.devz.petms.dto.UserDTO;
import lombok.Data;

/**
 *
 * @author devzo
 */
@Data
public class LoginResModel {

    private UserDTO userDTO;
    
    private String resCode;
    private String resMsg;
}
