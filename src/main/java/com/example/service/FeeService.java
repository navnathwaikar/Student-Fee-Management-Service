package com.example.service;

import com.example.dto.FeeReceiptDTO;
import com.example.entity.FeeReceiptEntity;
import com.example.exception.ReceiptNotFoundException;
import com.example.repository.FeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(FeeService.class);


    public FeeReceiptEntity collectFee(FeeReceiptEntity feeReceiptEntity) {
        FeeReceiptEntity response = feeRepository.save(feeReceiptEntity);
        logger.info("Fee Collected successfully!!");
        return response;
    }

    public List<FeeReceiptDTO> getAllReceipts(Long studentId) {
        logger.info(" Get All Receipt data for Student Id="+studentId);

        List<FeeReceiptDTO> studentList = feeRepository.findAllReceiptByStudentId(studentId);
        logger.info(studentList.toString());
        if(studentList.isEmpty()){
            throw new ReceiptNotFoundException("No Data Available for requested Receipt");
        }
        return studentList;
    }


}
