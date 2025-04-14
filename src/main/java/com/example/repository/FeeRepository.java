package com.example.repository;

import com.example.dto.FeeReceiptDTO;
import com.example.entity.FeeReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<FeeReceiptEntity, Long> {
    @Query(value = "select r.reference_Id,r.card_Number,r.card_Type,r.date, r.tuition_Fee from RECEIPT r where r.student_Id =:studentId", nativeQuery = true)
    List<FeeReceiptDTO> findAllReceiptByStudentId(Long studentId);

}
