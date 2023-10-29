/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.repository;

import com.devz.petms.dto.PetDTO;
import com.devz.petms.dto.UserPetDTO;
import com.devz.petms.model.PetAddReqModel;
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
public class PetDataHandler {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean addNewPet(PetAddReqModel values) {
        StringBuilder query = new StringBuilder();
        boolean flag = false;
        try {
            query.append("INSERT INTO tbl_pet (pet_name,category_id,dob,remark,owner_id,created_user) "
                    + " VALUES (?,?,?,?,?,?) ");
            Object[] params = {values.getPetName(),
                values.getCategoryId(),
                values.getDob(),
                values.getRemark(),
                values.getOwnerId(),
                values.getCreatedUser()};

            jdbcTemplate.update(query.toString(), params);
            System.out.println("pet record inserted success");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public PetDTO getPetDetails(int petid) {
        StringBuilder query = new StringBuilder();
        try {
            query.append("SELECT id,pet_name,category_id,dob,remark,owner_id,created_user FROM tbl_pet  WHERE id =  ? ");
            Object[] params = {petid};

            List<PetDTO> petList = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<PetDTO>(PetDTO.class));
            return petList.get(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updatePetDetails(int petId, PetAddReqModel data) {

        StringBuilder query = new StringBuilder();
        try {
            query.append("UPDATE tbl_pet SET pet_name=?,category_id=?,dob=?,remark=? WHERE id=?");
            Object[] params = {data.getPetName(), data.getCategoryId(), data.getDob(), data.getRemark(), petId};

            int update = jdbcTemplate.update(query.toString(), params);
            System.out.println("update success");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<UserPetDTO> getUsersPetList(int userid) {
        StringBuilder query = new StringBuilder();
        try {
            query.append("SELECT tbl_pet.pet_name,tbl_pet.dob,tbl_pet_category.category FROM tbl_pet \n"
                    + "INNER JOIN tbl_pet_category\n"
                    + "ON tbl_pet_category.id = tbl_pet.category_id\n"
                    + "WHERE tbl_pet.owner_id = ? ");
            Object[] params = {userid};

            List<UserPetDTO> petList = jdbcTemplate.query(query.toString(), params, new BeanPropertyRowMapper<UserPetDTO>(UserPetDTO.class));
            return petList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
