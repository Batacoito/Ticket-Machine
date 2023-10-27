package br.calebe.ticketmachine.Tantofaz.core;

import br.calebe.ticketmachine.Tantofaz.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.Tantofaz.exception.SaldoInsuficienteException;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestTicketMachine {

    private TicketMachine ticketMachine;

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(150);
    }

    @Test
    public void testInserirValidQuantia() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(150);  
        assertEquals(150, ticketMachine.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirInvalidQuantia() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(9);  
    }

    @Test
    public void testImprimirTicketWithSufficientBalance() throws SaldoInsuficienteException,PapelMoedaInvalidaException {
        ticketMachine.inserir(150);  
        String ticket = ticketMachine.imprimir();
        String resposta = "****************\n";
        resposta += "*** R$ 150,00 ****\n";
        resposta += "*****************\n";
        assertEquals(resposta, ticket);
        assertEquals(0, ticketMachine.getSaldo());
    }
}
