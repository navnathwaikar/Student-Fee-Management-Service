package com.example;

import com.example.entity.FeeReceiptEntity;
import com.example.repository.FeeRepository;
import com.example.service.FeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class FeeServiceTest {

    @Mock
    private FeeRepository feeRepository;

    @InjectMocks
    private FeeService feeService;

    @Test
    void testCollectFee_Success() {

        FeeReceiptEntity input = new FeeReceiptEntity(null, "1234-1234-1234-1234","Master Card", new Date(), 10.10,1L);
        FeeReceiptEntity saved = new FeeReceiptEntity(1L, "1234-1234-1234-1234","Master Card", new Date(), 10.10,1L);

        Mockito.when(feeRepository.save(input)).thenReturn(saved);

        FeeReceiptEntity result = feeService.collectFee(input);

        assertNotNull(result);
        assertEquals(1L, result.getReferenceId());

    }

}
