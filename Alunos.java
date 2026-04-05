package SistemaDeCadastroComBusca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Alunos {//começo alunos
    ArrayList <Aluno> listaAlunos = new ArrayList<>();

    public void cadastro (Scanner leitor) {//final Cadastro
        System.out.println("");
        System.out.println("Nome do Aluno(a)");
        String nomeAlunos = leitor.nextLine().trim().toLowerCase();
        double notaAlunos = 0;
        while (true) {
            try {
                System.out.println("Qual a nota Do aluno");
                notaAlunos= leitor.nextDouble();
                leitor.nextLine();
                System.out.println("");
                if(notaAlunos >=0 && notaAlunos<=10){
                    break;
                }

            }catch(InputMismatchException e){
                System.out.println("Erro, você digito uma letra. tem que ser um numero.");
                leitor.next();
            }
        }
        Aluno novoAluno = new Aluno(nomeAlunos, notaAlunos);
        listaAlunos.add(novoAluno);

    }//final Cadastro

    public  void mostraNota(){//começo mostraNota
        for(int i = 0; i< listaAlunos.size();i++){
            Aluno aluno = listaAlunos.get(i);
            System.out.println("o nome do aluno é: " + aluno.getNome());
            System.out.println("A nota do(a) " + aluno.getNome() +  " é :" + aluno.getNota());
        }
    }//final mostraNota

    public void buscaAluno(Scanner leitor){//começo busca aluno
        boolean trava = false;
        System.out.println("");
        System.out.println("Nome do Aluno(a) que deseja buscar?");
        String busca=leitor.nextLine().trim().toLowerCase();
        for(int i =0 ; i< listaAlunos.size() ; i++){
            if (listaAlunos.get(i).getNome().equalsIgnoreCase(busca)){
                System.out.println("Nota do(a) " + listaAlunos.get(i).getNome() + " é " + listaAlunos.get(i).getNota());
                trava = true;
                break;
            }
        }
        if (!trava){
            System.out.println("Aluno não encontrado.");
        }



    }//final busca alunos

    public void atualizaNota(Scanner leitor){//começo atualizaNota
        System.out.println("");
        boolean trava = false;
        System.out.println("De qual aluno deseja mudar a nota?");
        String alunoAtualizado = leitor.nextLine().trim().toLowerCase();
        double novaNota;
        while(!trava){
            try {
                for (int i =0 ; i< listaAlunos.size(); i++){
                    if (listaAlunos.get(i).getNome().equals(alunoAtualizado)){
                        System.out.println("Digite a nova nota.");
                        novaNota = leitor.nextDouble();
                        if (novaNota > 10 || novaNota < 0 ){
                            System.out.println("Erro, você não pode digitar uma nota maoir que 10 e menor que 0");
                        }else{
                            listaAlunos.get(i).setNota(novaNota);
                            leitor.nextLine();
                            trava = true;
                            break;
                        }

                    }
                }

                if(!trava){
                    System.out.println("Aluno não encontrado...");
                    System.out.println("...");
                    trava = true;
                }

            }catch (InputMismatchException e){
                System.out.println("Erro, você digito uma letra. tem que ser um numero.");
                leitor.next();
            }
        }


    }// fim atualizaNota

    public void removeAluno(Scanner leitor){//começo metodo remove
        System.out.println("");
        System.out.println("Deseja excluir qual aluno?");
        String alunoRemovido = leitor.nextLine().trim().toLowerCase();
        boolean trava = false;
        while(!trava){
            for (int i =0 ; i< listaAlunos.size(); i++){
                if (listaAlunos.get(i).getNome().equals(alunoRemovido)){
                    listaAlunos.remove(i);
                    System.out.println("Aluno Excluido!");
                    trava = true;
                    break;
                }
            }

            if(!trava){
                System.out.println("Aluno não encontrado...");

                System.out.println("tente denovo, mais tarde...");
                trava = true;
            }
        }


    }//final meotodo remove


    public void ranking (Scanner leitor){//começo ranking
        boolean controle;
        ArrayList<Aluno> auxLista = new ArrayList<>(listaAlunos);
        //bubble sort
        for (int i = 0; i< listaAlunos.size() ; i++){
            controle = true;
            for (int j = 0 ; j<(listaAlunos.size()-1) ; j++ ){
                if(auxLista.get(j).getNota() < auxLista.get(j+1).getNota()){
                    Aluno aux = auxLista.get(j);
                    auxLista.set(j, auxLista.get(j+1));
                    auxLista.set(j+1, aux);
                    controle = false;
                }
            }
            if(controle){
                break;
            }
        }

        //mostrando o ranking
        int tamanhoRanking =0 ;
        //validação de tamanho.
        while (true){
            System.out.println("qual o tamanho do ranking? ");
            tamanhoRanking = leitor.nextInt();
            leitor.nextLine();
            if(tamanhoRanking > listaAlunos.size()){
                System.out.println("Erro, tente novamente, você digitou um numero maior que a quantidade de alunos");
            }else {
                break;
            }
        }

        //imprimindo o ranking
        for (int i = 0 ; i<tamanhoRanking ; i++){
            System.out.println(" ");
            System.out.println((i+1) + " do Ranking é : " + auxLista.get(i).getNome());
            System.out.println("A nota é : " + auxLista.get(i).getNota());

        }


    }//fim ranking
    public boolean temAlunos(){
        return listaAlunos.size() > 0;
    }

}//Final alunos
