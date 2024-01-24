package org.fundatec.petcare.model.cliente;

import org.fundatec.petcare.model.cliente.contract.AdicionarClienteRequest;
import org.fundatec.petcare.model.cliente.domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(final ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente adicionarCliente(final AdicionarClienteRequest novoCliente) {
        if (possuiNomeOuCPFCadastrados(novoCliente.nome(), novoCliente.cpf())) {
            throw new IllegalArgumentException("Nome/CPF já estão cadastrados no sistema.");
        }

        final Cliente novoClienteConvertidoParaEntidade = novoCliente.converterParaEntidade();
        return clienteRepository.save(novoClienteConvertidoParaEntidade);
    }

    public boolean possuiNomeOuCPFCadastrados(final String nome, final long cpf) {
        return clienteRepository.existeClienteComCPFOuNomeCadastrado(nome, cpf);
    }
}