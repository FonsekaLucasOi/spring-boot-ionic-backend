package com.cursomc.domain;

import com.cursomc.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {

    private static final long serialVersionUID = 1L;

    private Date dataVencimento;
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
