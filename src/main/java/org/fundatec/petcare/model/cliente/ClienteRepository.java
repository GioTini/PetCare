package org.fundatec.petcare.model.cliente;

import org.fundatec.petcare.model.cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    @Query("select (count(c) > 0) from CLIENTE c where upper(c.nome) = upper(?1) or c.cpf = ?2")
    boolean existeClienteComCPFOuNomeCadastrado(@NonNull String nome, @NonNull long cpf);
}