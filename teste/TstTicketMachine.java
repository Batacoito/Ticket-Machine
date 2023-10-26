package br.calebe.ticketmachine.core;
import SourceCodeInspection.src.br.calebe.ticketmachine.core
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TstTicketMachine {

    private TicketMachine ticketMachine;

    public String resposta = "*****************\n";

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(75);  
    }

    @Test
    // teste para verificar saldo
    public void testVerificaSaldo() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(150);  
        assertEquals(150, ticketMachine.getSaldo());
    }

    @Test
    // teste de impressão com dinheiro insuficiente
    public void testImprimirTicketWithInsufficientBalance() {
        TicketMachine ticketMachine = new TicketMachine(50); 
        assertThrows(SaldoInsuficienteException.class, () -> {ticketMachine.imprimir();});
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
