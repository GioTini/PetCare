package org.fundatec.petcare.model.cliente.contract;

import org.fundatec.petcare.model.cliente.domain.Cliente;
import org.fundatec.petcare.model.endereco.Endereco;

public record AdicionarClienteRequest(
        String nome,
        long cpf,
        EnderecoRequest endereco
) {

    public Cliente converterParaEntidade() {
        final Cliente novoCliente = new Cliente();
        novoCliente.setNome(this.nome);
        novoCliente.setCpf(this.cpf);

        final Endereco endereco = new Endereco();
        endereco.setCidade(this.endereco().cidade);
        endereco.setLogradouro(this.endereco().logradouro);
        endereco.setBairro(this.endereco().bairro);
        endereco.setEstado(this.endereco().estado);
        endereco.setNumero(this.endereco().numero);

        novoCliente.setEndereco(endereco);
        return novoCliente;
    }

    public record EnderecoRequest(
            String logradouro,
            int numero,
            String bairro,
            String cidade,
            String estado
    ) { }
}