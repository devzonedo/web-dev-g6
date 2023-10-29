/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.dto;

import lombok.Data;

/**
 *
 * @author devzo
 */
@Data
public class UserPetDTO {
    //pet_name,tbl_pet.dob,tbl_pet_category.category
    private String petName;
    private String dob;
    private String category;
}
