CREATE TABLE pedido(
    id UUID PRIMARY KEY,
    farmaceutico_id UUID REFERENCES farmaceutico(id),
    cliente_id UUID REFERENCES cliente(id),
    valor NUMERIC(10,2) NOT NULL,
    valor_pago NUMERIC(10,2),
    troco NUMERIC(10,2),
    data_emissao TIMESTAMP NOT NULL DEFAULT NOW(),
    data_pagamento TIMESTAMP,
    data_cancelamento TIMESTAMP,
    status VARCHAR NOT NULL
);

CREATE TABLE pedido_produto(
    pedido_id UUID REFERENCES pedido(id),
    produto_id UUID REFERENCES produto(id),
    PRIMARY KEY (pedido_id, produto_id)
);
