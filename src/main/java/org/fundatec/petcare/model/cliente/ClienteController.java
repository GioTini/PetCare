package org.fundatec.petcare.model.cliente;

import io.swagger.v3.oas.annotations.Operation;
import org.fundatec.petcare.model.cliente.contract.AdicionarClienteRequest;
import org.fundatec.petcare.model.cliente.domain.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(final ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @Operation(summary = "Adicionar um novo cliente ao sistema.")
    public ResponseEntity<Cliente> adicionarCliente(final @RequestBody AdicionarClienteRequest novoCliente) {
        final Cliente clienteAdicionado = clienteService.adicionarCliente(novoCliente);
        return ResponseEntity.ok(clienteAdicionado);
    }
}