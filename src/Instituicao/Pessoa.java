package Instituicao;


public class Pessoa {

    private static int ContaCorrente = 1;

    private int numeroPessoa ;
    private String name;
    private String cpf;
   
   

    public Pessoa() { }

    public Pessoa(String name, String cpf) {
        this.numeroPessoa = Pessoa.ContaCorrente;
        this.name = name;
        this.cpf = cpf;
       
       
        Pessoa.ContaCorrente  += 1;
    }

    public int getNumeroPessoa() {
        return this.numeroPessoa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
   
   
   

    public String toString() {
        return  "\nName: " + this.getName() +
                "\nCPF: " + this.getCpf();
                
                
    }


}