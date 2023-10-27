package br.calebe.ticketmachine.Tantofaz.core;
//import Source Code Inspection.src.br.calebe.ticketmachine.core;
import br.calebe.ticketmachine.Tantofaz.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.Tantofaz.exception.SaldoInsuficienteException;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;

public class TestTicketMachine {

    private TicketMachine ticketMachine;

    public String resposta = "****************\n";

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(75);  
    }

    @Test
    public void testVerificaSaldo() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(150);  
        assertEquals(151, ticketMachine.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirInvalidQuantia() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(7);  
    }

    

    @Test
    // teste de impressão com dinheiro suficiente
    public void testImprimirTicketDinheiroSuficiente() throws SaldoInsuficienteException,PapelMoedaInvalidaException {
        
        ticketMachine.inserir(20);  
        String ticket = ticketMachine.imprimir();
        
        resposta += "*** R$ 20,00 ****\n";
        resposta += "*****************\n";
        
        assertEquals(resposta, ticket);
        assertEquals(0, ticketMachine.getSaldo());
    }
}