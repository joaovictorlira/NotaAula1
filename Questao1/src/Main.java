import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Digite o nome do aluno ");
        String alunoNome = sc.nextLine();
        System.out.println(alunoNome);

        System.out.println("Digite a primeira nota");
        double nota1 = sc.nextInt();

        System.out.println("Digite a segunda nota");
        double nota2 =  sc.nextInt();

        System.out.println("Digite a terceira nota");
        double nota3 = sc.nextInt();


        double media = (nota1 + nota2 + nota3) / 3;
        System.out.println("A sua média foi "+ media);

        if (media >= 7) {
            System.out.println("Aprovado");
        } else if (media < 4) {
            System.out.println("Reprovado");
        } else {
            System.out.println("Está na final");
        }
    }

}