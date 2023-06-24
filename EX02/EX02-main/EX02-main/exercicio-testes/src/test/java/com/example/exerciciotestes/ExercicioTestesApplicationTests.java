package com.example.exerciciotestes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.exerciciotestes.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.exerciciotestes.model.Cliente;
import com.example.exerciciotestes.repository.ClienteRepository;

class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscaTodosClientes() {
        // Criando uma lista de clientes para simular o retorno do método findAll()
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Cliente 1", 100.0));
        clientes.add(new Cliente("Cliente 2", 200.0));

        // Configurando o mock para o método findAll() retornar a lista criada acima
        when(clienteRepository.findAll()).thenReturn(clientes);

        // Testando se o método buscaTodosClientes() está retornando a lista correta
        List<Cliente> result = clienteService.buscaTodosClientes();
        assertEquals(clientes, result);
    }

    @Test
    public void testBuscaClientePorId() {
        // Criando um cliente para simular o retorno do método findById()
        Cliente cliente = new Cliente("Cliente 1", 100.0);
        cliente.setId(1L);

        // Configurando o mock para o método findById() retornar o cliente criado acima
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        // Testando se o método buscaClientePorId() está retornando o cliente correto
        Cliente result = clienteService.buscaClientePorId(1L);
        assertNotNull(result);
        assertEquals(cliente, result);
    }
}
