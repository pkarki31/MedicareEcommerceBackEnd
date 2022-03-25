package com.finalproject.medicare.repository;

import com.finalproject.medicare.entity.Medicine;
import com.finalproject.medicare.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface medicinerepository extends JpaRepository<Medicine, Integer> {

   //@Query("select l.isadmin from users l where l.email_id =?1 and l.password=?2")
   // Users findByUsernameAndPassword(String username, String password);

    @Override
    Medicine save(Medicine meds);

    @Modifying
    @Transactional
    @Query("update Medicine m set m.medicine_name=:medicine_name,m.medicine_company=:medicine_company,m.description=:description,m.quantity=:quantity,m.price=:price,m.active=:active,m.image=:image where m.m_id=:m_id")
    int updateMed(@Param(value = "m_id") int m_id,@Param(value = "medicine_name") String medicine_name,@Param(value = "medicine_company") String medicine_company,
                    @Param(value = "description") String description,@Param(value = "quantity") int quantity,@Param(value = "price") int price,
                    @Param(value = "active") boolean active,@Param(value = "image") String image);

    @Override
    List<Medicine> findAll();

    @Transactional
    @Query("select m from Medicine m where ( m.active = ?1)")
    List<Medicine> findAllActive(boolean text);

    @Modifying
    @Transactional
    @Query("select m from Medicine m where ( m.medicine_name like %?1% or m.medicine_company like %?1% or m.description like %?1% or " +
            "m.quantity like %?1% or m.price like %?1% )")
    List<Medicine> searchMedicine(String text);


    @Transactional
    @Query("select m from Medicine m where ( m.m_id = :m_id)")
    Medicine searchMedicineById(int m_id);

    @Modifying
    @Transactional
    @Query("delete from Medicine b where b.m_id=:m_id")
    int deleteMedicineById(int m_id);


//    @Modifying
//    @Transactional
//    @Query("update Medicine c set c.medicine_name=:medicine_name where c.m_id=:m_id")
//    void updateMed(@Param(value = "m_id") int m_id,@Param(value = "medicine_name") String medicine_name);



//    @Modifying
//    @Transactional
//    @Query("update LoginUser log set log.password=:password where log.id=:id")
//    void changePassword(@Param(value = "password") String password, @Param(value = "id") Long id);
}
