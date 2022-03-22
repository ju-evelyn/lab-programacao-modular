import java.util.Scanner;
public class codigo3 {
    public static double operacao(double valor, double a){
        //foi retirado o 'while' para que o código de interface seja feito no 'main'
        valor += a;
        return valor;
    }
    public static void main(String[] args) {
        Scanner leitorScanner = new Scanner(System.in);
        int opcao = 0;
        //a pergunta inicial foi retirada do while para que houvesse a possibilidade de adicionar um número por vez na repetição
        System.out.print("Digite um número: ");
        double valor = leitorScanner.nextDouble();
        while(opcao==0){
            System.out.print("Digite outro número: ");
            //a variável 'a' foi alterada para 'double' com o intuito de evitar conflitos futuros
            double a = leitorScanner.nextDouble();
            //a variável 'b' for retirada por ser desnecessária no novo código e para que 'valor' possa armazenar o resultado final
            valor = codigo3.operacao(valor, a);
            System.out.print("0 para continuar e 1 para parar: ");
            opcao = leitorScanner.nextInt(); 
        }
        System.out.println(valor);
        leitorScanner.close();
    }  
}