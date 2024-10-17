package Instituicao;

	import Instituicao.Adicional;
	
	public class Conta {

	    private static int agencia = 1;

	    private int numeroConta;
	    private Pessoa pessoa;
	    private Double saldo = 0.0;


	    public Conta(Pessoa pessoa) {
	        this.numeroConta = Conta.agencia;
	        this.pessoa = pessoa;
	        this.saldoAtual();
	        Conta.agencia += 1;
	    }


	    public int getNumeroConta() {
	        return numeroConta;
	    }
	    public Pessoa getClient() {
	        return pessoa;
	    }
	    public void setClient(Pessoa pessoa) {
	        this.pessoa = pessoa;
	    }
	    public Double getSaldo() {
	        return saldo;
	    }
	    public void setSaldo(Double saldo) {
	        this.saldo = saldo;
	    }

	    private void saldoAtual() {
	        this.saldo = this.getSaldo();
	    }

	    public String toString() {

	        return "\nBank account: " + this.getNumeroConta() +
	                "\nCliente: " + this.pessoa.getName() +
	                "\nCPF: " + this.pessoa.getCpf() +
	                "\nSaldo: " + Adicional.doubleToString(this.getSaldo()) +
	                "\n" ;
	    }

	    public void depositar(Double valor) {
	        if(valor > 0) {
	            setSaldo(getSaldo() + valor);
	            //this.saldo = this.getSaldo() + valor;
	            System.out.println("Seu depósito foi realizado com sucesso!");
	        }else {
	            System.out.println("Não foi possível realizar o depósito!");
	        }
	    }

	    public void sacar(Double valor) {
	        if(valor > 0 && this.getSaldo() >= valor) {
	            setSaldo(getSaldo() - valor);
	            System.out.println("Saque realizado com sucesso!");
	        }else {
	            System.out.println("Não foi possível realizar o saque!");
	        }
	    }

	    public void transferencia(Conta contaParaDeposito, Double valor) {
	        if(valor > 0 && this.getSaldo() >= valor) {
	            setSaldo(getSaldo() - valor);
	            //this.saldo = this.getSaldo() - valor;
	            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
	            System.out.println("Transferência realizada com sucesso!");
	        }else {
	            System.out.println("Não foi possível realizar a tranferência");
	        }

	    }

	}