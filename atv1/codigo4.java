public class codigo4 {
    boolean condicao(int n){
        //a variável resposta foi retirada por não ser necessária
        //os 'if's aninhados foram reduzidos a uma linha, deixando o código mais legível
        if(n%4==0 && (n%100!=0 || n%400==0)) return true;
        else return false;
    }
}
