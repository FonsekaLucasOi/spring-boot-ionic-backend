package com.cursomc.services;

import com.cursomc.domain.Categoria;

public interface CategoriaService {

    public Categoria buscar(Integer id);

    public Categoria insert(Categoria categoria);
}
