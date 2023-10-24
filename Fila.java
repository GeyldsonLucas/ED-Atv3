import java.util.Scanner;

public class Fila{
    Scanner sc;

    //Fila normal
	Node inicioFila = null;
	Node fimFila = null;
    int n = 0;
    int atendimentoN = 0;

    //Fila prioridade
	Node inicioFilaP = null;
	Node fimFilaP = null;
    int p = 0;
    int atendimentoP = 0;
		
		
	public Fila(Scanner sc){
			this.sc = sc;
			
	}
	//Metodos principais	
	public Node criarNode(){
        sc.nextLine();
		System.out.println("Digite o nome: ");
		String nome = sc.nextLine();
		System.out.println("Digite a idade");
		int idade = sc.nextInt();
		Node node = new Node(nome, idade);
        return node;
	}
    public void sortPrioridades(){

    }

   
	public void inserir(){
        Node node = criarNode();
        if(node.getIdade() >= 60){
            System.out.println("Pessoa com mais de 60 anos. Sera inserida na fila de prioridades");
            inserirP(node);
            return;
        }
        if(isNormalEmpty()){
            inicioFila = node;
            fimFila = node;
        }else{

            fimFila.setProximo(node);
            fimFila = node;
        }
        n++;

	}

    //Prioridades não são necessariamente por idade
	public void inserirP(Node node) {
        if(node == null) node = criarNode();

        //Se a fila de prioridades estiver vazia ou a pessoa tiver menos de 60 anos, ela é inserida no fim da fila de prioridades
        if (isPrioridadeEmpty() || node.getIdade() < 60) {
            if (isPrioridadeEmpty()) {
                inicioFilaP = node;
                fimFilaP = node;
            } else {
                fimFilaP.setProximo(node);
                fimFilaP = node;
            }
        } else {

            //Ordenação por idade
            Node aux = inicioFilaP;
            Node prev = null;
    
            while (aux != null && node.getIdade() / 10 <= aux.getIdade() / 10) {
                prev = aux;
                aux = aux.getProximo();
            }
    
            if (prev == null) {
                node.setProximo(inicioFilaP);
                inicioFilaP = node;
            } else {
                prev.setProximo(node);
                node.setProximo(aux);
            }
        }
    
        p++;
    }
    
    public void atendimento(){
        //Se a fila de prioriadades não estiver vazia então prioriadade é atendida, se não o da fila normal é atendido
        if(!isPrioridadeEmpty()){
            System.out.println("Atendendo: " + inicioFilaP.getNome() + " Prioridade: " + inicioFilaP.getIdade() + " anos");
            inicioFilaP = inicioFilaP.getProximo();
            atendimentoP++;
            p--;

        }else if(!isNormalEmpty()){
            System.out.println("Atendendo: " + inicioFila.getNome());
            inicioFila = inicioFila.getProximo();
            atendimentoN++;
            n--;
        }

    }
    public void imprimirFilas(){
        if(isPrioridadeEmpty() && isNormalEmpty()){
            System.out.println("Filas vazias");
            return;
        }
        System.out.println("\nFila de prioridades:");
        if(isPrioridadeEmpty()) System.out.println("(Vazia)");
        Node aux = inicioFilaP;
        while(aux != null){
            System.out.println("Nome: " + aux.getNome() + " Idade: " + aux.getIdade());
            aux = aux.getProximo();
        }

        System.out.println("\nFila normal:");
        if(isNormalEmpty()) System.out.println("(Vazia)");
        aux = inicioFila;
        while(aux != null){
            System.out.println("Nome: " + aux.getNome() + " Idade: " + aux.getIdade());
            aux = aux.getProximo();
        }

    }
    public void estatisticas(){
        System.out.println("Estatistcas de atendimento");
        System.out.println("\nFila normal");
        System.out.println("Atendidas: " + atendimentoN);
        System.out.println("Tamanho da fila: " + n);
        if(atendimentoN == 0){
            System.out.println("Nenhuma pessoa atendida");
        }else{
        System.out.println((n/atendimentoN)*100 + "% das pessoas atendidas");
        }

        System.out.println("\nFila de prioridades");
        System.out.println("Atendidas: " + atendimentoP);
        System.out.println("Tamanho da fila: " + p);
        if(atendimentoP == 0){
            System.out.println("Nenhuma pessoa atendida");
        }else{
        System.out.println((p/atendimentoP)*100 + "% das pessoas atendidas");
        }
        

    }

     //Metodos acessorios
    public boolean isNormalEmpty(){
        if(inicioFila == null) return true;
        return false;
    }
    public boolean isPrioridadeEmpty(){
        if(inicioFilaP == null) return true;
        return false;
    }
    public int sizePrioridade(){
        return p;
    }
    public int sizeNormal(){
        return n;
    }



    }
		
 
