package SistemaDeCadastroComBusca;
import java.awt.desktop.SystemEventListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class Main {//começo programa

    public  static  int menuInicial(Scanner leitor){//final metodo menuInicial
        while(true){
            try{
                System.out.println("O que deseja fazer?");
                System.out.println("");
                System.out.println("[1] - Cadastro aluno.");
                System.out.println("[2] - Mostrar todos ");
                System.out.println("[3] - Busca pelo nome ");
                System.out.println("[4] - Atualizar nota de aluno");
                System.out.println("[5] - Remover Aluno");
                System.out.println("[6] - Ranking de alunos.");
                System.out.println("[7] - Sair.");
                int escolha = leitor.nextInt();
                leitor.nextLine();
                if(escolha <0 || escolha>7){
                    System.out.println("Erro, Você digitou um numero diferente das opções");
                }else {
                    return  escolha;
                }


            } catch (InputMismatchException e) {
                System.out.println("Erro, incorreto tente novamente!");
                leitor.nextLine();
            }
        }



    }//final metodo menuInicial

    public static  String controle(Scanner leitor){//começo controle
        while (true){
            System.out.println("");
            System.out.println("Gostaria de continuar? (sim/nao)");
            String controle = leitor.nextLine().trim().toLowerCase();;;
            System.out.println("");
            if(controle.trim().equalsIgnoreCase("sim") || controle.trim().equalsIgnoreCase("nao")){
                return controle;
            }else {
                System.out.println("Erro, você digitou algo diferente, tente novamente");
                leitor.nextLine();
            }
        }
    }//final metodo controle
    public static void main (String[] args){//metodo main começo
        //inicialização do Scanner
        Scanner leitor = new Scanner(System.in);
        //inicialização do objeto alunos.
        Alunos alunos = new Alunos();
        //menu - inicialização
        int escolhaUsuario;
        //controle do laço
        String controle;
        //trava
        boolean trava = false;

        do {//começo do-while
            escolhaUsuario= menuInicial(leitor);
            if(escolhaUsuario ==7){
                System.out.println("Finalizando Sistema... Até logo!");
                break;
            }
            switch (escolhaUsuario){//inicio switch
                case 1:
                    System.out.println("Quantos alunos gostaria de cadastrar");
                    int quantidade = leitor.nextInt();
                    leitor.nextLine();
                     for(int i = 0; i< quantidade;i++){
                         alunos.cadastro(leitor);

                     }

                        trava = true;
                        break;

                case 2:
                        if(trava){
                            alunos.mostraNota();
                            break;
                        }else{
                            System.out.println("Realize o cadastro antes.");
                            break;
                        }

                case 3 :
                        if(trava){
                            alunos.buscaAluno(leitor);
                            break;
                        }else{
                            System.out.println("Realize o cadastro antes.");
                            break;
                        }
                case 4 :
                    if(trava){
                        alunos.atualizaNota(leitor);
                        break;
                    }else{
                        System.out.println("Realize o cadastro antes.");
                        break;
                    }

                case 5  :
                    if(trava){
                        alunos.removeAluno(leitor);
                        break;
                    }else{
                        System.out.println("Realize o cadastro antes.");
                        break;
                    }
                case 6  :
                    if(trava){
                        alunos.ranking(leitor);
                        break;
                    }else{
                        System.out.println("Realize o cadastro antes.");
                        break;
                    }
                default:
                    System.out.println("Finalizando Sistema... Até logo!");
                    break;
            }//Final switch

            controle=controle(leitor);

        }while(controle.equals("sim")); //final do-while


    }//metodo main final
}//fim programa
