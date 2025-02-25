package com.banco.dslist.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.dslist.entities.Transferencia;
import com.banco.dslist.repositories.TransferenciaRepository;
import com.banco.dslist.services.TransferenciaService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
public class TranferenciaController {

	    @Autowired
	    private TransferenciaRepository transferenciaRepository;

	    @Autowired
	    private TransferenciaService transferenciaService;

	    @PostMapping
	    public ResponseEntity<Transferencia> agendarTransferencia(@RequestBody Transferencia transferencia) {
	        try {
	            BigDecimal taxa = transferenciaService.calcularTaxa(transferencia.getDataTransferencia(),
	                    transferencia.getDataAgendamento(), transferencia.getValor());
	            transferencia.setTaxa(taxa);
	            transferencia.setDataAgendamento(LocalDate.now());
	            transferenciaRepository.save(transferencia);
	            return ResponseEntity.ok(transferencia);
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(null);
	        }
	    }

	    @GetMapping
	    public List<Transferencia> listarTransferencias() {
	        return transferenciaRepository.findAll();
	    }
}

