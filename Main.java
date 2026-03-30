package SistemaDeCadastroComBusca;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main (String[] args){//metodo main começo
        Scanner leitor = new Scanner(System.in);
        Alunos alunos = new Alunos();

//        //cadastro
//        alunos.cadastro(leitor);
//        //mostra
////        alunos.mostraNota(i);

        for(int i = 0 ; i<3 ; i++){
            alunos.cadastro(leitor);

        }

        alunos.buscaAluno(leitor);

        for(int i = 0 ; i<3 ; i++){
            alunos.mostraNota(i);
        }

    }//metodo main final
}
