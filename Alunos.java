package SistemaDeCadastroComBusca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Alunos {//começo alunos
    ArrayList <String> nome = new ArrayList<>();
    ArrayList <Double> notas = new ArrayList<>();
    double tamanho;

    public void cadastro (Scanner leitor) {//final Cadastro
        System.out.println("");
        System.out.println("Nome do Aluno(a)");
        nome.add(leitor.nextLine().trim().toLowerCase());
        while (true) {
            try {
                System.out.println("Qual a nota Do aluno");
                notas.add(leitor.nextDouble());
                leitor.nextLine();
                System.out.println("");
                if(notas.getLast()>10 || notas.getLast()<0){
                    System.out.println("Erro, você digiu uma nota errada, tem que ser menor que 10 e maior que 0");
                }else{
                    tamanho++;
                    break;
                }


            }catch(InputMismatchException e){
                System.out.println("Erro, você digito uma letra. tem que ser um numero.");
                leitor.next();
            }
        }
    }//final Cadastro

    public  void mostraNota(){//começo mostraNota
        for(int i = 0; i<tamanho;i++){
            System.out.println("o nome do aluno é: " + nome.get(i));
            System.out.println("A nota do(a) " + nome.get(i) +  " é :" + notas.get(i));
        }
    }//final mostraNota

    public void buscaAluno(Scanner leitor){//começo busca aluno
        tamanho = notas.size();
        System.out.println("");
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
        System.out.println("");
        System.out.println("De qual aluno deseja mudar a nota?");
        String alunoAtualizado = leitor.nextLine().trim().toLowerCase();
        for (int i =0 ; i<tamanho; i++){
            if (nome.get(i).equals(alunoAtualizado)){
                System.out.println("Digite a nova nota.");
                notas.set(i , leitor.nextDouble());
                leitor.nextLine();
                break;
            }
        }
    }// fim atualizaNota
    public void removeAluno(Scanner leitor){//começo metodo remove
        tamanho = notas.size();
        System.out.println("");
        System.out.println("Deseja excluir qual aluno?");
        String alunoRemovido = leitor.nextLine().trim().toLowerCase();
            for (int i =0 ; i<tamanho; i++){
                if (nome.get(i).equals(alunoRemovido)){
                    nome.remove(i);
                    notas.remove(i);
                    System.out.println("Aluno Excluido!");
                    break;
                }
            }
    }//final meotodo remove

    public void ranking (Scanner leitor){//começo ranking
        tamanho = notas.size();//ver durante a execução, altera para -1
        double [] auxNotas = new double[(int)tamanho] ;
        String [] auxAlunos = new String[(int)tamanho];
        String nomesAux;
        double notasAux;
        boolean controle;

        //copiando array
        for (int i = 0; i<tamanho;i++){
            auxAlunos[i]=nome.get(i);
            auxNotas[i]=notas.get(i);
        }

        //bubble sort
        for (int i = 0; i<tamanho ; i++){
            controle = true;
            for (int j = 0 ; j<(tamanho-1) ; j++ ){
                if(auxNotas[j]>auxNotas[j+1]){
                    notasAux = auxNotas[j];
                    nomesAux = auxAlunos[j];

                    auxNotas[j] = auxNotas[j+1];
                    auxAlunos[j] = auxAlunos[j+1];

                    auxAlunos[j+1] = nomesAux;
                    auxNotas[j+1] = notasAux;
                    controle = false;
                }
            }
            if(controle){
                break;
            }
        }

        //mostrando o ranking

        System.out.println("qual o tamanho do ranking? ");
        int tamanhoRanking = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0 ; i<tamanhoRanking ; i++){
            System.out.println((i+1) + " do Ranking é : " + auxAlunos[i]);
            System.out.println("A nota é : " + auxNotas[i]);

        }


    }//fim ranking


}//Final alunos
