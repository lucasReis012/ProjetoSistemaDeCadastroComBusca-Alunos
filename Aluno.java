package SistemaDeCadastroComBusca;

public class Aluno {//comço aluno
    private String nome;
    private double nota;

    public Aluno(String nome, double nota){
        this.nome=nome;
        this.nota=nota;
    }
    public String getNome(){
        return nome;
    }
    public double getNota(){
        return nota;
    }
    public void setNota (double nota){
        if(nota >= 0 && nota <= 10 ){
            this.nota = nota;
        }else{
            System.out.println("Nota invalida, tem que ser maior que 0 e menor que 10");
        }
    }


}//final aluno


