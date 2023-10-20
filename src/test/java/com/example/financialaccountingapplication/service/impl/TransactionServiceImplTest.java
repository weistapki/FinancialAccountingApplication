package com.example.financialaccountingapplication.service.impl;

import com.example.financialaccountingapplication.model.entity.Transaction;
import com.example.financialaccountingapplication.model.entity.dto.TransactionDTO;
import com.example.financialaccountingapplication.model.mapper.TransactionMapper;
import com.example.financialaccountingapplication.model.enums.TransactionType;
import com.example.financialaccountingapplication.repository.TransactionRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private TransactionMapper transactionMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllTransactions() {
        // Подготовка заглушек
        when(transactionRepository.findAll()).thenReturn(Arrays.asList(new Transaction(), new Transaction()));
        TransactionDTO transactionDTO = new TransactionDTO(1L,
                "Sample Transaction",
                new BigDecimal("100.00"),
                new java.sql.Date(new Date().getTime()),
                TransactionType.INCOME);
        when(transactionMapper.toTransactionDTO(new Transaction())).thenReturn(transactionDTO);

        // Вызов метода
        List<TransactionDTO> transactionDTOs = transactionService.getAllTransactions();

        // Проверки
        assertEquals(2, transactionDTOs.size());
        for (TransactionDTO dto : transactionDTOs) {
            assertNotNull(dto);
            assertEquals(TransactionType.INCOME, dto.getType());
        }
    }

    @Test
    public void testGetTransactionById() {
        // Подготовка заглушек
        Long transactionId = 1L;
        Transaction transaction = new Transaction();
        TransactionDTO transactionDTO = new TransactionDTO(1L, "Sample Transaction", new BigDecimal("100.00"), new java.sql.Date(new Date().getTime()), TransactionType.INCOME);
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(transaction));
        when(transactionMapper.toTransactionDTO(transaction)).thenReturn(transactionDTO);

        // Вызов метода
        TransactionDTO result = transactionService.getTransactionById(transactionId);

        // Проверки
        assertNotNull(result);
        assertEquals(TransactionType.INCOME, result.getType());
    }

    @Test
    public void testSaveTransaction() {
        // Подготовка заглушек
        TransactionDTO transactionDTO = new TransactionDTO(1L, "Sample Transaction", new BigDecimal("100.00"),new java.sql.Date(new Date().getTime()), TransactionType.INCOME);
        Transaction transaction = new Transaction();
        when(transactionMapper.toTransaction(transactionDTO)).thenReturn(transaction);
        when(transactionRepository.save(transaction)).thenReturn(transaction);
        when(transactionMapper.toTransactionDTO(transaction)).thenReturn(transactionDTO);

        // Вызов метода
        TransactionDTO result = transactionService.saveTransaction(transactionDTO);

        // Проверки
        assertNotNull(result);
        assertEquals(TransactionType.INCOME, result.getType());
    }

    @Test
    public void testDeleteTransaction() {
        // Вызов метода
        transactionService.deleteTransaction(1L);

        // Проверки
        verify(transactionRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateTransaction() {
        // Подготовка заглушек
        Long transactionId = 1L;
        TransactionDTO transactionDTO = new TransactionDTO(1L, "Sample Transaction", new BigDecimal("100.00"), new java.sql.Date(new Date().getTime()), TransactionType.INCOME);
        Transaction existingTransaction = new Transaction();
        Transaction updatedTransaction = new Transaction();
        when(transactionRepository.findById(transactionId)).thenReturn(Optional.of(existingTransaction));
        when(transactionMapper.toTransaction(transactionDTO)).thenReturn(updatedTransaction);
        when(transactionRepository.save(updatedTransaction)).thenReturn(updatedTransaction);
        when(transactionMapper.toTransactionDTO(updatedTransaction)).thenReturn(transactionDTO);

        // Вызов метода
        TransactionDTO result = transactionService.updateTransaction(transactionId, transactionDTO);

        // Проверки
        assertNotNull(result);
        assertEquals(TransactionType.INCOME, result.getType());
    }
}

