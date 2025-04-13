package com.example.controller;


import com.example.dto.FeeReceiptDTO;
import com.example.entity.FeeReceiptEntity;
import com.example.service.FeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fee-collect")
public class StudentFeeController {


    @Autowired
    FeeService feeService;

    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(StudentFeeController.class);


    @PostMapping
    public ResponseEntity<FeeReceiptEntity> collectFee(@RequestBody FeeReceiptEntity feeReceiptEntity){
        logger.info("Save Receipt Data started!!");
        return ResponseEntity.status(HttpStatus.CREATED).body(feeService.collectFee(feeReceiptEntity));

    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<FeeReceiptDTO>> getAllReceipts(@PathVariable Long studentId){
        logger.info("Retrieving All Student Data!!");
        return ResponseEntity.status(HttpStatus.OK).body(feeService.getAllReceipts(studentId));
    }

}
