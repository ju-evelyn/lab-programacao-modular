public class codigo1{
    double bonus(){
        double vt = 0; double b;
        //foi utilizado o laço de repetição 'for' para deixar o código mais legível 
        for(int i=0; i<=11; i++){
            vt += vendas[i];
        }
        //foi invertido a ordem dos 'if's para diminuir o número de testes de condições
        if(vt>=50000)b=0.35;
        else if(vt>=36000)b=0.2;
        else if(vt>=24000)b=0.1;
        return vt*b;
    }
}