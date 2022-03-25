package com.finalproject.medicare.controllers;

import com.finalproject.medicare.entity.Medicine;
import com.finalproject.medicare.entity.Users;
import com.finalproject.medicare.service.LoginService;
import com.finalproject.medicare.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/updateMedicine",consumes = {"application/json"},produces = {"application/json"})
    public Medicine updateMedicine(@RequestBody Medicine medicine){

        Medicine med = medicineService.updateMedicine(medicine);
        return med;
    }

    // API : localhost:8080/medicare/getAllMedicine/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getAllMedicine",consumes = {"application/json"},produces = {"application/json"})
    public List<Medicine> getAllMedicine(){

        List<Medicine> med = medicineService.getAllMedicine();
        System.out.println("final "+med.size());
        return med;
    }

    // API : localhost:8080/medicare/getAllActiveMedicine/
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getAllActiveMedicine",consumes = {"application/json"},produces = {"application/json"})
    public List<Medicine> getAllActiveMedicine(){

        List<Medicine> med = medicineService.getAllActiveMedicine();
        System.out.println("final "+med.size());
        return med;
    }

    // API : localhost:8080/medicare/searchMedicine?searchText=200
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/searchMedicine",consumes = {"application/json"},produces = {"application/json"})
    public List<Medicine> searchMedicine(@RequestParam("searchText") String searchText){

        List<Medicine> med = medicineService.searchAllMedicine(searchText);
        return med;
    }

    // API : localhost:8080/medicare/searchMedicineById?searchText=1
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/searchMedicineById",consumes = {"application/json"},produces = {"application/json"})
    public Medicine searchMedicineById(@RequestBody Medicine medicine){

        Medicine med = medicineService.searchMedicineById(medicine.getM_id());
        return med;
    }

    // API : localhost:8080/medicare/deleteMedicineById
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/deleteMedicineById",consumes = {"application/json"},produces = {"application/json"})
    public Medicine deleteMedicineById(@RequestBody Medicine medicine){

        int med = medicineService.deleteMedicineById(medicine.getM_id());

        if (med>0){

            return medicine;

        }

        return null;
    }





}
