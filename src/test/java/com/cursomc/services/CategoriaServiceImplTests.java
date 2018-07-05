package com.cursomc.services;

import com.cursomc.domain.Categoria;
import com.cursomc.repositories.CategoriaRepository;
import com.cursomc.services.impl.CategoriaServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceImplTests {

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    private static final Integer ID = 1;

    @Before
    public void init() {
        categoriaRepository = Mockito.mock(CategoriaRepository.class);
    }

    @Test
    public void shouldReturnCategoriaWhenBuscarIsCalled() {
        Categoria categoria = new Categoria(1, "Informática");
        when(categoriaRepository.findById(ID)).thenReturn(Optional.of(categoria));
        Assert.assertEquals(Optional.of(categoria), categoriaService.find(ID));
    }

}