package br.com.triersistemas.solar.domain;

import br.com.triersistemas.solar.enuns.EnumStatusPedido;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Pedido {

    private final UUID id;
    private Farmaceutico farmaceutico;
    private Cliente cliente;
    private List<Produto> produtos;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private final LocalDateTime dataEmissao;
    private LocalDateTime dataPagamento;
    private LocalDateTime dataCancelamento;
    private EnumStatusPedido status;

    public Pedido(final Farmaceutico farmaceutico, final Cliente cliente) {
        this.id = UUID.randomUUID();
        this.farmaceutico = farmaceutico;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.valor = BigDecimal.ZERO;
        this.valorPago = BigDecimal.ZERO;
        this.troco = BigDecimal.ZERO;
        this.dataEmissao = LocalDateTime.now();
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
