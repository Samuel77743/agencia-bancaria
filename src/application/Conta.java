package application;

import application.utils.Utilidades;

public class Conta {

    private static int qntConta = 1;

    private int numConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta(Cliente cliente) {
        
        this.numConta = qntConta;
        this.cliente = cliente;
        
        qntConta++;

    }

    public int getNumConta() {
        return this.numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    ///////////////////////////////////////
    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    ///////////////////////////////////////
    public double getSaldo() {
        return this.saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    ///////////////////////////////////////
    public String toString() {
        return
        "\nCONTA...... " + this.numConta +
        "\nNOME....... " + cliente.getNome() +
        "\nCPF........ " + cliente.getCpf() + 
        "\nE-mail..... " + cliente.getEmail() +
        "\nSaldo...... " + Utilidades.doubleToString(getSaldo()) +

        "\n\n";
    }

    /////////////////////////////////////////////////////////////////////////////////////

    public void depositar(double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.printf("\n\nDEPÓSITO REALIZADO COM SUCESSO\n");
            System.out.printf("SALDO ATUAL: R$ %.2f\n", getSaldo());
        }
        else {
            System.out.print("\n\n-------VALOR NÃO PERMITIDO-------\n\n");
        }
    }
    ////////////////////////////////////
    public void sacar(double valor) {
        if(valor > getSaldo()) {
            System.out.printf("\n\nVOCÊ NÃO TEM SALDO SUFICIENTE PARA SACAR R$ %.2f", valor);
            System.out.printf("\nSALDO ATUAL: R$ %.2f\n", this.getSaldo());
        }
        else if(valor <= 0) {
            System.out.print("\n\nNÃO É POSSÍVEL SACAR ESTES VALORES\n");
        }

        else{
            setSaldo(getSaldo() - valor);
            System.out.printf("\n\n------SAQUE DE R$%.2f REALIZADO COM SUCESSO ------", valor);
        }
    }

    public void transferir(Conta contaDest, double valor) {
        if(this.getSaldo() >= valor && valor > 0) {

            this.setSaldo(getSaldo() - valor);
            contaDest.setSaldo(contaDest.getSaldo() + valor);

            System.out.print("\n\n---TRANSFERÊNCIA REALIZADA COM SUCESSO---");
        }
        else {
            System.out.print("\n\n---OPERAÇÃO INVÁLIDA---\n");
        }
    }
    
}
