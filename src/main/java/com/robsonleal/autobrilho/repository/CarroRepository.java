package com.robsonleal.autobrilho.repository;

import com.robsonleal.autobrilho.model.Carro;
import com.robsonleal.autobrilho.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	Optional<Carro> findByPlaca(String placa);
	List<Carro> findByStatus(Status status);
}
