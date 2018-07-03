package com.cursomc.services.impl;

import com.cursomc.domain.Pedido;
import com.cursomc.repositories.PedidoRepository;
import com.cursomc.services.PedidoService;
import com.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public Pedido buscar(Integer id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.orElseThrow(
                () -> new ObjectNotFoundException("Objeto não foi encontrado! Id: " + id + " Tipo: " + Pedido.class.getName()));
    }

}
