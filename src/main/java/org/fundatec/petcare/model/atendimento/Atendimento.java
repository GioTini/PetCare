package org.fundatec.petcare.model.atendimento;

import jakarta.persistence.*;
import org.fundatec.petcare.model.cliente.domain.Cliente;
import org.fundatec.petcare.model.pagamento.Pagamento;
import org.fundatec.petcare.model.produto.Produto;
import org.fundatec.petcare.model.unidade.Unidade;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ATENDIMENTO")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_ATENDIMENTO", nullable = false)
    private UUID id;

    @Column(name = "DATA_ATENDIMENTO")
    private LocalDateTime dataAtendimento;

    @Column(name = "NOME_ATENDENTE")
    private String nomeAtendente;

    @Column(name = "PAGAMENTO_EFETUADO")
    private Boolean pagamentoEfetuado;

    @Column(name = "VALOR_CONSULTA")
    private Integer valorConsulta;

    @Column(name = "ESTADO", length = 10)
    private String estado;

    @Column(name = "NOME_VETERINARIO")
    private String nomeVeterinario;

    @ManyToOne
    @JoinColumn(name = "CLIENTE")
    private Cliente cliente;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "PRODUTO")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "UNIDADE")
    private Unidade unidade;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "PAGAMENTO_ID")
    private Pagamento pagamento;

    public Atendimento() {
    }

    public Atendimento(UUID id, LocalDateTime dataAtendimento, String nomeAtendente, Boolean pagamentoEfetuado, Integer valorConsulta, String estado, String nomeVeterinario, Cliente cliente, Produto produto, Unidade unidade, Pagamento pagamento) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.nomeAtendente = nomeAtendente;
        this.pagamentoEfetuado = pagamentoEfetuado;
        this.valorConsulta = valorConsulta;
        this.estado = estado;
        this.nomeVeterinario = nomeVeterinario;
        this.cliente = cliente;
        this.produto = produto;
        this.unidade = unidade;
        this.pagamento = pagamento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public Boolean getPagamentoEfetuado() {
        return pagamentoEfetuado;
    }

    public void setPagamentoEfetuado(Boolean pagamentoEfetuado) {
        this.pagamentoEfetuado = pagamentoEfetuado;
    }

    public Integer getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Integer valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
