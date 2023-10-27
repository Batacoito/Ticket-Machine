package br.calebe.ticketmachine.Tantofaz.core;
//import Source Code Inspection.src.br.calebe.ticketmachine.core;
import br.calebe.ticketmachine.Tantofaz.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.Tantofaz.exception.SaldoInsuficienteException;
import org.junit.Test;
import org.junit.Before;

//import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestTicketMachine {

    private TicketMachine ticketMachine;

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(50);
    }

    @Test
    public void testImprimirTicketWithSufficientBalance() throws SaldoInsuficienteException,PapelMoedaInvalidaException {
        
        ticketMachine.inserir(50);  
        String ticket = ticketMachine.imprimir();
        String resposta = "****************\n";
        resposta += "*** R$ 50,00 ****\n";
        resposta += "*****************\n";
        
        assertEquals(resposta, ticket);
        assertEquals(0, ticketMachine.getSaldo());
    }
}
