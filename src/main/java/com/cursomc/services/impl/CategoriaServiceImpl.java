package com.cursomc.services.impl;

import com.cursomc.domain.Categoria;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria buscar(Integer id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.orElse(null);
    }

}
