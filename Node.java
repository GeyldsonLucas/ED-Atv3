public class Node {
    private int idade;
    private String nome;
    Node prox = null;

    public Node(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
   
    public void setProximo(Node prox){
        this.prox = prox;
    }
    //Getters
    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public Node getProximo(){
        return prox;
    }
}
