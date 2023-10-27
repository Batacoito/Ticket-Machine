package br.calebe.ticketmachine.Tantofaz.teste;
//import Source Code Inspection.src.br.calebe.ticketmachine.core;
import br.calebe.ticketmachine.Tantofaz.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.Tantofaz.exception.PapelMoedaInvalidaException;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThrows;

public class TicketMachine {

    private TstTicketMachine ticketMachine;

    public String resposta = "****************\n";

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(75);  
    }

    @Test
    public void testVerificaSaldo() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(150);  
        assertEquals(150, ticketMachine.getSaldo());
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
