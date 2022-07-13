package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.enuns.EnumStatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
@Getter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", insertable = false, updatable = false, unique = true, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "farmaceutico_id", referencedColumnName = "id")
    private Farmaceutico farmaceutico;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id")
    )
    private List<Produto> produtos;

    private BigDecimal valor;

    @Column(name = "valor_pago")
    private BigDecimal valorPago;

    private BigDecimal troco;

    @Column(name = "data_emissao", insertable = false)
    private LocalDateTime dataEmissao;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Column(name = "data_cancelamento")
    private LocalDateTime dataCancelamento;

    @Enumerated(EnumType.STRING)
    private EnumStatusPedido status;

    public Pedido(final Farmaceutico farmaceutico, final Cliente cliente) {
        this.farmaceutico = farmaceutico;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.valor = BigDecimal.ZERO;
        this.valorPago = BigDecimal.ZERO;
        this.troco = BigDecimal.ZERO;
        this.status = EnumStatusPedido.PENDENTE;
    }

    public Pedido adicionarProdutos(final List<Produto> produtos) {
        if (EnumStatusPedido.PENDENTE.equals(this.status)) {
            this.produtos.addAll(produtos);
            this.valor = this.produtos.stream()
                    .map(Produto::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return this;
    }

    public Pedido pagar(final BigDecimal valor) {
        if (EnumStatusPedido.PENDENTE.equals(this.status) && valor.compareTo(this.valor) > 0) {
            this.valorPago = valor;
            this.troco = this.valorPago.subtract(this.valor);
            this.status = EnumStatusPedido.PAGO;
            this.dataPagamento = LocalDateTime.now();
        }
        return this;
    }
}
