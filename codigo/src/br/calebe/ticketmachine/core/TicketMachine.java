package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;

public class TicketMachine {

    protected int valor;
    protected int saldo1;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};

    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[i] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }

    public int getSaldo() {
        return this.saldo;
    }

    public Iterator<PapelMoeda> getTroco() {
        Troco troco = new Troco(this.saldo - this.valor); 
        return troco.getIterator();
    }

    public String imprimir() throws SaldoInsuficienteException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        this.saldo = this.saldo - valor;
        String result = "*****************\n";
        result += "*** R$ " + valor + ",00 ****\n";  
        result += "*****************\n";
        return result;
    }
}
