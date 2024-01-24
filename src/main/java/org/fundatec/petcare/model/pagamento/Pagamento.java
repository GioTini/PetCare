package org.fundatec.petcare.model.pagamento;

import jakarta.persistence.*;
import org.fundatec.petcare.model.atendimento.Atendimento;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "PAGAMENTO")
@Table(name = "PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "VALOR")
    private int valor;

    @Column(name = "DATA_PAGAMENTO")
    private LocalDateTime dataPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "FORMA_PAGAMENTO")
    private FormaPagamentoEnum formaPagamento;

    @OneToOne(mappedBy = "pagamento", orphanRemoval = true)
    private Atendimento atendimento;

    public Pagamento() {
    }

    public Pagamento(UUID id, int valor, LocalDateTime dataPagamento, FormaPagamentoEnum formaPagamento, Atendimento atendimento) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.formaPagamento = formaPagamento;
        this.atendimento = atendimento;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public FormaPagamentoEnum getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamentoEnum formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
}