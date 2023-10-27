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
        ticketMachine = new TicketMachine(100);
    }

    @Test
    //teste para verificar a insercao se um valor valido
    public void testInserirValidQuantia() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(100);  
        assertEquals(100, ticketMachine.getSaldo());
    }

    @Test
    public void testGetTroco() throws PapelMoedaInvalidaException {
        assertEquals(-100, ticketMachine.getTroco());
    }
 
    @Test
    //teste para verificar a impressao com saldo suficiente
    public void testImprimirTicketWithSufficientBalance() throws SaldoInsuficienteException,PapelMoedaInvalidaException {
        ticketMachine.inserir(100);  
        String ticket = ticketMachine.imprimir();
        String resposta = "*****************\n";
        resposta += "*** R$ 100,00 ****\n";
        resposta += "*****************\n";
        assertEquals(resposta, ticket);
        assertEquals(0, ticketMachine.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    //teste para verificar a insercao de valores invalidos na maquina
    public void testInserirInvalidQuantia() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(17);  
    }

}
