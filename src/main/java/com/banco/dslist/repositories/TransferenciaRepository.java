package com.banco.dslist.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.dslist.entities.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
	
}
