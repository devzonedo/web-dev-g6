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
public class PetDTO {
    private int id;
    private String petName;
    private int categoryId;
    private String dob;
    private String remark;
    private int ownerId;
    private int createdUser;
}
