package Instituicao;

import java.util.ArrayList;
import java.util.Scanner;

		public class Banco {

	
	 	static  Scanner digitar = new Scanner(System.in);
	    static ArrayList<Conta> contasBancarias;

	    public static void main(String[] args) {
	        contasBancarias = new ArrayList<Conta>();
	        transacoes();
	    }

	    public static void transacoes() {

	        System.out.println("------------------------------------------------------");
	        System.out.println("***** Selecione uma operação que deseja realizar *****");
	        System.out.println("------------------------------------------------------");
	        System.out.println("|   Opção 1 - Criar conta   |");
	        System.out.println("|   Opção 2 - Depositar     |");
	        System.out.println("|   Opção 3 - Sacar         |");
	        System.out.println("|   Opção 4 - Transferir    |");
	        System.out.println("|   Opção 5 - Listar        |");
	        System.out.println("|   Opção 6 - Sair          |");

	        int operacao = digitar.nextInt();;

	        switch (operacao) {
	            case 1:
	                criarConta();
	                break;

	            case 2:
	                depositar();
	                break;

	            case 3:
	                sacar();
	                break;

	            case 4:
	                transferir();
	                break;

	            case 5:
	                listarContas();
	                break;

	            case 6:
	                System.out.println("Obrigado e volte sempre!!!");
	                System.exit(0); 

	            default:
	                System.out.println("Opção inválida!");
	                transacoes();
	                break;
	        }
	    }


	

	    public static void criarConta() {
	       

	        System.out.println("\nNome: ");
	        String nome = digitar.next();

	        System.out.println("\nCPF: ");
	        String cpf = digitar.next();

	      

	        Pessoa cliente = new Pessoa(nome, cpf);

	        Conta conta = new Conta(cliente);

	        contasBancarias.add(conta);
	        System.out.println("--- Sua conta foi criada com sucesso! ---");

	        transacoes();

	    }

	    private static Conta encontrarConta(int numeroConta) {
	        Conta conta = null;
	        if(contasBancarias.size() > 0) {
	            for(Conta cc : contasBancarias) {
	                if(cc.getNumeroConta() == numeroConta) {
	                    conta = cc;
	                }
	            }
	        }
	        return conta;
	    }

	    public static void depositar() {
	        System.out.println("Número da conta: ");
	        int numeroConta = digitar.nextInt();
	        Conta conta = encontrarConta(numeroConta);

	        if(conta != null) {
	            System.out.println("Qual valor deseja depositar? ");
	            Double valorDeposito = digitar.nextDouble();

	            conta.depositar(valorDeposito);
	        }else {
	            System.out.println("--- Conta não encontrada ---");
	        }

	        transacoes();

	    }

	    public static void sacar() {
	        System.out.println("Número da conta: ");
	        int numeroConta = digitar.nextInt();

	        Conta conta = encontrarConta(numeroConta);

	        if(conta != null) {
	            System.out.println("Qual valor deseja sacar? ");
	            Double valorSaque = digitar.nextDouble();

	            conta.sacar(valorSaque);
	            System.out.println("--- Saque realizado com sucesso! ---");
	        }else {
	            System.out.println("--- Conta não encontrada ---");
	        }

	        transacoes();

	    }

	    public static void transferir() {
	        System.out.println("Número da conta que vai enviar a transferência: ");
	        int numeroContaRemetente = digitar.nextInt();

	        Conta contaRemetente = encontrarConta(numeroContaRemetente);

	        if(contaRemetente != null) {
	            System.out.println("Número da conta do destinatário: ");
	            int numeroContaDestinatario = digitar.nextInt();

	            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

	            if(contaDestinatario != null) {
	                System.out.println("Valor da transferência: ");
	                Double valor = digitar.nextDouble();

	                contaRemetente.transferencia(contaDestinatario, valor);

	            }else {
	                System.out.println("-A conta para depósito não foi encontrada-");
	            }

	        }else {
	            System.out.println("-Conta para transferência não encontrada-");
	        }
	        transacoes();
	    }

	    public static void listarContas() {
	        if(contasBancarias.size() > 0) {
	            for(Conta conta: contasBancarias) {
	                System.out.println(conta);
	            }
	        }else {
	            System.out.println("-Não há contas cadastradas -");
	        }

	        transacoes();
	    }
	}
