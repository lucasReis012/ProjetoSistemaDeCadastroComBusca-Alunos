package SistemaDeCadastroComBusca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Alunos {//começo alunos
    ArrayList <String> nome = new ArrayList<>();
    ArrayList <Double> notas = new ArrayList<>();
    double tamanho;

    public void cadastro (Scanner leitor) {//final Cadastro
        System.out.println("Nome do Aluno(a)");
        nome.add(leitor.nextLine().trim().toLowerCase());
        while (true) {
            try {
                System.out.println("Qual a nota Do aluno");
                notas.add(leitor.nextDouble());
                leitor.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Erro, você digito uma letra. tem que ser um numero.");
                leitor.next();
            }
        }
    }//final Cadastro

    public  void mostraNota(int i){//começo mostraNota
        System.out.println("o nome do aluno é: " + nome.get(i));
        System.out.println("A nota do(a) " + nome.get(i) +  " é :" + notas.get(i));
    }//final mostraNota
    public void buscaAluno(Scanner leitor){//começo busca aluno
        tamanho = notas.size();
        System.out.println("Nome do Aluno(a) que deseja buscar?");
        String busca=leitor.nextLine().trim().toLowerCase();
        for(int i =0 ; i<tamanho ; i++){
            if (nome.get(i).equalsIgnoreCase(busca)){
                System.out.println("Nota do(a) " + nome.get(i) + " é " + notas.get(i));
                break;
            }
        }
    }//final busca alunos
    public void atualizaNota(Scanner leitor){//começo atualizaNota
        tamanho = notas.size();
        System.out.println("De qual aluno deseja mudar a nota?");
        String alunoAtualizado = leitor.nextLine().trim().toLowerCase();
        for (int i =0 ; i<tamanho; i++){
            if (nome.get(i).equals(alunoAtualizado)){
                System.out.println("Digite o valor.");
                notas.set(i , leitor.nextDouble());
                break;
            }
        }
    }// fim atualizaNota


}//Final alunos
