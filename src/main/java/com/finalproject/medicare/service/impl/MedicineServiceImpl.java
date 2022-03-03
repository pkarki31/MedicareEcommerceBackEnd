package com.finalproject.medicare.service.impl;

import com.finalproject.medicare.entity.Medicine;
import com.finalproject.medicare.entity.Users;
import com.finalproject.medicare.repository.loginrepository;
import com.finalproject.medicare.repository.medicinerepository;
import com.finalproject.medicare.service.LoginService;
import com.finalproject.medicare.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private medicinerepository medicinerepository;


    @Override
    public Medicine saveMedicine(Medicine med) {

        Medicine medicine = medicinerepository.save(med);
        return medicine;
    }

    @Override
    public Medicine updateMedicine(Medicine medicine) {

        int m_id = medicine.getM_id();
        String medicine_name = medicine.getMedicine_name();
        String medCompany = medicine.getMedicine_company();
        String medDesc = medicine.getDescription();
        int medQty = medicine.getQuantity();
        int medPrice = medicine.getPrice();
        boolean medActive = medicine.isActive();

        int med1 = medicinerepository.updateMed(m_id,medicine_name,medCompany,medDesc,medQty,medPrice,medActive);
        if(med1>0){

            return medicine;
        }
        return null;
    }

    @Override
    public List<Medicine> getAllMedicine() {

        List<Medicine> allMedList = medicinerepository.findAll();
        return allMedList;
    }

    @Override
    public List<Medicine> searchAllMedicine(String searchText) {
        List<Medicine> allSearchedMedList = medicinerepository.searchMedicine(searchText);
        return allSearchedMedList;
    }
}
