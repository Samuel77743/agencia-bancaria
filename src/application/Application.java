package application;

import java.util.ArrayList;
import java.util.Scanner;



public class Application {

    static Scanner input = new Scanner(System.in);
    public static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
                      
        contasBancarias = new ArrayList<Conta>();
        init();
    }
        public static void init() {

            System.out.print("\n--------------------------------\n");
            System.out.print("---Bem-vindos a nossa Agencia---\n");
            System.out.print("--------------------------------\n");
            System.out.print("-----SELICIONE UMA OPERAÇÃO-----\n");
            System.out.print("--------------------------------\n");

            System.out.println("[1] Realizar Saque");
            System.out.println("[2] Realizar Depósito");
            System.out.println("[3] Fazer transferência");
            System.out.println("[4] Listar contas");
            System.out.println("[5] Criar conta");
            System.out.println("\n[0] Sair");

            System.out.print("\nSUA RESPOSTA --> ");
            int resp = input.nextInt();

            switch (resp) {
                case 0:
                    System.out.print("\n-----Operação Cancelada-----\n");
                    System.exit(0);
                    break;
            
                case 1:
                    sacar();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    transferir();
                    break;
                case 4:
                    listarContas();
                        break;
                case 5:
                    criarConta();
                    break;
                

                default:
                System.out.print("\n--------Opção Inválida--------\n\n\n");
                init(); //Reinício
            }

        }

        //CASE 6
        public static void criarConta() { 
            System.out.print("\nNOME........... ");
            String nome = input.next();
            System.out.print("CPF............ ");
            String cpf = input.next();

            System.out.print("E-mail......... ");
            String email = input.next();
        //////////////////////////////////////////////
            Cliente cliente = new Cliente(nome, cpf, email);
            Conta conta = new Conta(cliente);

            contasBancarias.add(conta);

            System.out.print("\n------CONTA CRIADA COM SUCESSO------\n");
            init();
        }

        public static Conta encontrarConta(int numConta) {
            
            Conta conta = null;

            if(contasBancarias.size() > 0) {
                for(Conta c : contasBancarias) {
                    if(c.getNumConta() == numConta){
                        conta = c;
                        break;
                    }
                }
            }
            return conta;
        }

        public static void depositar() {
            System.out.println("\n===== DEPÓSITO =====");
            System.out.print("Digite o número da conta: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if(conta != null) {
                System.out.print("Digite o valor que deseja depositar: ");
                double valorDeposito = input.nextDouble();
                conta.depositar(valorDeposito);

            }
            else{
                System.out.println("\n=====Conta não encontrada!=====");
            }
            init();
        }

        public static void sacar() {
            System.out.println("\n========= SAQUE =========");
            System.out.print("Digite o número da conta: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if(conta != null) {
                System.out.print("Digite o valor que deseja sacar: ");
                double valorSaque = input.nextDouble();
                conta.sacar(valorSaque);
            }
            else {
                System.out.println("\n=====Conta não encontrada!=====");               
            }
            init();
        }

        public static void transferir() {
            System.out.println("\n========= TRANSFERÊNCIA =========");
            System.out.print("Digite o número da SUA conta: ");
            int ncontaRem = input.nextInt();
            System.out.print("\nDigite o número da conta do destinatário: ");
            int ncontaDest = input.nextInt();
            
            Conta contaRem = encontrarConta(ncontaRem);
            Conta contaDest = encontrarConta(ncontaDest); 

            if(contaRem != null || contaDest != null){
                System.out.print("Digite o valor que deseja transferir: ");
                double valor = input.nextDouble();
                contaRem.transferir(contaDest, valor);
            }
            else {
                System.out.println("\n=====Conta(s) não encontrada(s)!=====");        
            }
            init();
        }
        public static int ordinal;

        public static void listarContas() {
            if(contasBancarias.size() > 0) {
                
                for(Conta conta : contasBancarias) {
                    System.out.println( conta.getNumConta() + "º CONTA: " + conta);
                }
            }
            else{
                System.out.println("\nNão há contas cadastradas");
            }
            init();
        }





    
    
}
