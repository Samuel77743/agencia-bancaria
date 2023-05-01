package application;

public class Cliente {

    private static int qntClientes = 1;

    private int numPessoa;
    private String nome;
    private String cpf;
    private String email;
    

    public Cliente(){
            
    }

    public Cliente(String nome, String cpf, String email) {
        this.numPessoa = qntClientes;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;

        qntClientes++;
    }

    public int getNumPessoa() {
        return this.numPessoa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    } 

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return
         "\nNOME........... " + nome +
         "\nCPF............ " + cpf + 
         "\nE-mail......... " + email +
         "\n\n";
    }
    
}
