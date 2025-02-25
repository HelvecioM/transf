package com.banco.dslist.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TransferenciaService {
	
	BigDecimal taxa;

	public BigDecimal calcularTaxa(LocalDate dataTransferencia, LocalDate dataAgendamento, BigDecimal valor) {
	        long diasDeDiferenca = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);
	        
	        if (diasDeDiferenca <= 0) {
	            return BigDecimal.valueOf(2.5).multiply(valor).divide(BigDecimal.valueOf(100)).add(taxa);
	            
	        } else if (diasDeDiferenca <= 10) {
	            //return BigDecimal.valueOf(12.00).multiply(valor).divide(BigDecimal.valueOf(100)); // 0%
	            return BigDecimal.valueOf(12.00); // 0%
	        } else if (diasDeDiferenca <= 20) {
	            return BigDecimal.valueOf(8.2).multiply(valor).divide(BigDecimal.valueOf(100)); // 8.2%
	        } else if (diasDeDiferenca <= 30) {
	            return BigDecimal.valueOf(6.9).multiply(valor).divide(BigDecimal.valueOf(100)); // 6.9%
	        } else if (diasDeDiferenca <= 40) {
	            return BigDecimal.valueOf(4.7).multiply(valor).divide(BigDecimal.valueOf(100)); // 4.7%
	        } else if (diasDeDiferenca <= 50) {
	            return BigDecimal.valueOf(1.7).multiply(valor).divide(BigDecimal.valueOf(100)); // 1.7%
	        } else {
	        	System.out.println("Data de transferência inválida: taxa não aplicável.");
	            throw new IllegalArgumentException("Data de transferência inválida: taxa não aplicável.");
	        }
	    }
	}



