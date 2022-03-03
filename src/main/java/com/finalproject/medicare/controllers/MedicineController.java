package com.finalproject.medicare.controllers;

import com.finalproject.medicare.entity.Medicine;
import com.finalproject.medicare.entity.Users;
import com.finalproject.medicare.service.LoginService;
import com.finalproject.medicare.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicare")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    // API : localhost:8080/medicare/createMedicine/
    @PostMapping(value = "/createMedicine",consumes = {"application/json"},produces = {"application/json"})
    public Medicine createMedicine(@RequestBody Medicine medicine){

        Medicine med = medicineService.saveMedicine(medicine);
        return med;
    }

    // API : localhost:8080/medicare/createMedicine/
    @PostMapping(value = "/updateMedicine",consumes = {"application/json"},produces = {"application/json"})
    public Medicine updateMedicine(@RequestBody Medicine medicine){

        Medicine med = medicineService.updateMedicine(medicine);
        return med;
    }

    // API : localhost:8080/medicare/getAllMedicine/
    @GetMapping(value = "/getAllMedicine",consumes = {"application/json"},produces = {"application/json"})
    public List<Medicine> getAllMedicine(){

        List<Medicine> med = medicineService.getAllMedicine();
        return med;
    }

    // API : localhost:8080/medicare/searchMedicine?searchText=200
    @GetMapping(value = "/searchMedicine",consumes = {"application/json"},produces = {"application/json"})
    public List<Medicine> searchMedicine(@RequestParam("searchText") String searchText){

        List<Medicine> med = medicineService.searchAllMedicine(searchText);
        return med;
    }





}
