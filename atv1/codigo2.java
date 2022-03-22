/*Neste código, com o teste do mês e do dia não negativo sendo feito inicialmente, o switch só será executado na excessão
da data ser um dia maior que 28 e com o mês já validado. E, mesmo na excessão, em dias críticos como dia 30 de novembro ou
29 de fevereiro serão feitos no total menos testes para comprovar a validade da data, comparando com o exercício.*/
public class codigo2 {
    boolean metodo(int d, int m, int a){
        if(m<13 && m>0 && d>0){
            if(d<29){
                //caso o dia esteja entre 1 e 28, não é necessário seguir adiante, já finalizando o código
                return true;
            } else {
                switch (m) {
                    case 2:
                        /*no caso do mês 2, basta testar se o ano é bissexto e é dia 29, já que anos bissextos
                        também possuem dia 28 e o código teria terminado antes de entrar no switch/case*/
                        if(a%4==0 && (a%100!=0 || a%400==0)){
                            if(d==29) return true;
                        } else return false;
                        break;
                    case 4: case 6: case 9: case 11:
                        //há um menor número de meses com 30 dias então esses serão testados no 'case'
                        if(d<=30) return true;
                        else return false;
                        break; 
                    default:
                        //no caso de ser um mês com 31 dias, ele será direcionado para default e testado apenas mais uma vez
                        if(d<=31) return true;
                        else return false;
                        break;
                }
            }
        }
        else return false;
    } 
}