/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.model;

import com.devz.petms.dto.UserDTO;
import java.util.List;
import lombok.Data;

/**
 *
 * @author devzo
 */
@Data
public class UsersResModel {

    List<UserDTO> userList;
    private String resCode;
    private String resMsg;
}
