import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        Fila a = new Fila(sc);

        int opt = 0;
        while(opt != -1){
        System.out.println("\n\033[1;34m=== Menu ===\033[0m");
        System.out.println("1 - Chegada normal");
        System.out.println("2 - Chegada prioritario");
        System.out.println("3 - Atendimento");
        System.out.println("4 - Listar filas");
        System.out.println("5 - Exibir estatisticas parciais");
        System.out.println("6 - Sair");
        opt = sc.nextInt();
        switch(opt){
            case 1: 
            a.inserir();
            break;

            case 2:
            a.inserirP(null);
            break;

            case 3:
            a.atendimento();
            break;

            case 4:
            a.imprimirFilas();
            break;

            case 5:
            a.estatisticas();
            break;

            case 6:
            if(a.isPrioridadeEmpty() && a.isNormalEmpty()){
                a.estatisticas();
                System.out.println("Saindo...");
                opt = -1;
            }else{
                System.out.println("Ainda há pessoas na fila");
            }
            break;

            default: System.out.println("Opção inválida");

        }
    }
    sc.close();
}
}


