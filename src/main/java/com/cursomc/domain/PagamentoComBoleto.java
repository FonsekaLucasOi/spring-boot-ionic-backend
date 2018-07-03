package com.cursomc.domain;

import com.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataṔagamento;

    public PagamentoComBoleto() {

    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Date dataVencimento, Date dataṔagamento) {
        super(id, estadoPagamento, pedido);
        this.dataVencimento = dataVencimento;
        this.dataṔagamento = dataṔagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataṔagamento() {
        return dataṔagamento;
    }

    public void setDataṔagamento(Date dataṔagamento) {
        this.dataṔagamento = dataṔagamento;
    }
}
