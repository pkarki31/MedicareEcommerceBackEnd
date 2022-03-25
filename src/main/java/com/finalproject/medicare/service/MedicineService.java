package com.finalproject.medicare.service;

import com.finalproject.medicare.entity.Medicine;
import com.finalproject.medicare.entity.Users;

import java.util.List;

public interface MedicineService {

  //  String login(String username, String password);

    Medicine saveMedicine(Medicine med);

    Medicine updateMedicine(Medicine medicine);

    List<Medicine> getAllMedicine();

    List<Medicine> getAllActiveMedicine();

    List<Medicine> searchAllMedicine(String searchText);

    Medicine searchMedicineById(int m_id);

    int deleteMedicineById(int m_id);
}
