/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.petms.controller;

import com.devz.petms.dto.PetDTO;
import com.devz.petms.dto.UserPetDTO;
import com.devz.petms.model.PetAddReqModel;
import com.devz.petms.model.PetAddResModel;
import com.devz.petms.model.PetUpdateResModel;
import com.devz.petms.repository.PetDataHandler;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author devzo
 */
@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetDataHandler PetDataHandler;

    @PostMapping
    public PetAddResModel addPet(@RequestBody PetAddReqModel petAddReqModel) {
        System.out.println("pets>>addPet");

        PetAddResModel res = new PetAddResModel();
        boolean addNewPet = PetDataHandler.addNewPet(petAddReqModel);
        if (addNewPet) {
            res.setResCode("000");
            res.setResMsg("SUCCESS");
        } else {
            res.setResCode("999");
            res.setResMsg("ERROR");
        }
        return res;
    }

    @GetMapping("/{id}")
    public PetDTO getPetById(@PathVariable int id) {
        System.out.println("pet>>getPetById:" + id);
        // get pet details
        PetDTO petDetails = PetDataHandler.getPetDetails(id);
        return petDetails;
    }

    @PutMapping("/{id}")
    public PetUpdateResModel updatePet(@PathVariable int id, @RequestBody PetAddReqModel petAddReqModel) {
        System.out.println("updatePet:" + id);
        System.out.println(petAddReqModel.toString());

        PetUpdateResModel resObj = new PetUpdateResModel();

        boolean updatePetDetails = PetDataHandler.updatePetDetails(id, petAddReqModel);
        if (updatePetDetails) {
            resObj.setResCode("000");
            resObj.setResMsg("SUCCESS");
            // select and get the pet details from the DB
            resObj.setPetDetail(petAddReqModel);
        } else {
            resObj.setResCode("999");
            resObj.setResMsg("ERROR");
        }

        return resObj;
    }
    
    
    // get users pet list 
    @GetMapping("/userpetlist/{userid}")
    public List<UserPetDTO> getUsersPetList(@PathVariable int userid){
        System.out.println("getUsersPetList>>:"+userid);
        List<UserPetDTO> usersPetList = PetDataHandler.getUsersPetList(userid);
        return usersPetList;
    }
    
    
    

}
