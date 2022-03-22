public class Data{
    /*
    * Constantes para garantir que:
    * os dias estejam entre 1 e 31
    * os meses estejam entre 1 e 12
    * o ano tenha 4 dígitos: AAAA
    */
    private static final int MIN_DIA = 1;
    private static final int MIN_MES = 1;
    private static final int MIN_ANO = 1000;
    private static final int MAX_DIA = 31;
    private static final int MAX_MES = 12;
    private static final int MAX_ANO = 9999;
    /*
    * Atributos necessários para formar a data DD/MM/AAAA
    * e garantir que fevereiro tenha os dias corretos
    */
    private int dia;
    private int mes;
    private int ano;
    private boolean anoBissexto;
    public Data(){
        this.dia = MIN_DIA;
        this.mes = MIN_MES;
        this.ano = MIN_ANO;
        this.anoBissexto = true;
    }
    public Data(int dia, int mes, int ano){
        this.validarAno(ano);
        this.validarMes(mes);
        this.validarDia(dia, mes, anoBissexto);
    }
    /**Getters */
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAno(){
        return this.ano;
    }
    /**Métodos para conferir se o dia/mes/ano estão corretos */
    private void validarAno(int ano){
        if(ano>=MIN_ANO && ano<=MAX_ANO){
            this.ano = ano;
            if(ano%4==0 && (ano%100!=0 || ano%400==0)){
                this.anoBissexto = true;
            } else this.anoBissexto = false;
        } else {
            this.ano = MIN_ANO;
            this.anoBissexto = true;
        }
    }
    private void validarMes(int mes){
        if(mes>0 && mes<=MAX_MES){
            this.mes = mes;
        } else this.mes = MIN_MES;
    }
    private void validarDia(int dia, int mes, boolean anoBissexto){
        if (dia>=MIN_DIA && dia<=MAX_DIA) {
            switch (mes) {
                case 2:
                     if(anoBissexto && dia<=(MAX_DIA-2)){
                        this.dia = dia;
                     } else if(dia<=(MAX_DIA-3)){
                        this.dia = dia;
                     } else this.dia = MIN_DIA;
                    break;
                case 4: case 6: case 9: case 11:
                    if (dia<=(MAX_DIA-1)) {
                        this.dia = dia; 
                    } else {
                        this.dia = MIN_DIA;
                    }
                    break;
                default:
                    this.dia = dia;                        
                    break;
            }
        } else this.dia = MIN_DIA;
    }
    public Data criarNovaData(int diasAdicionados){
        /**
         * Atributos para a nova data
         */
        int novoAno = this.ano;
        int novoMes = this.mes;
        int novoDia = this.dia + diasAdicionados;
        /**
         * Métodos que ajustarão o dia e o mês para a nova data
         */
        switch (novoMes) {
            case 2:
                 if(this.anoBissexto && novoDia>(MAX_DIA-2)){
                    novoDia -= 29 ;
                    novoMes++;
                 } else if(novoDia>(MAX_DIA-3)){
                    novoDia -= 28;
                    novoMes++;
                 }
                break;
            case 4: case 6: case 9: case 11:
                if (novoDia>(MAX_DIA-1)) {
                    novoDia -= 30;
                    novoMes++; 
                }
                break;
            default:
                if (novoDia>(MAX_DIA)) {
                    novoDia -= 31;
                    novoMes++; 
                }                       
                break;
        }
        if (novoMes>MAX_MES) {
            novoMes = 1;
            novoAno++;
        }
        Data novaData = new Data(novoDia, novoMes, novoAno);
        return novaData;
    }
    /**
     * Método que irá comparar a data atual com a data inserida
     * e verificar qual é a mais futura iniciando pela comparação dos anos,
     *  depois comparando os meses e por fim comparando os dias, caso necessário.
     */
    public String dataMaisFutura(Data data2){
        if(this.ano>data2.getAno()){
            return "A maior data é "+imprimirData();
        } else if(data2.getAno()>this.ano){
            return "A data mais futura é "+data2.imprimirData();
        } else if(this.mes>data2.getMes()){
            return "A data mais futura é "+imprimirData();
        } else if(data2.getMes()>this.mes){
            return "A data mais futura é "+data2.imprimirData();
        } else if(this.dia>data2.getDia()){
            return "A data mais futura é "+imprimirData();
        } else if(data2.getDia()>this.dia){
            return "A data mais futura é "+data2.getDia();
        } else return "As datas são iguais";
    }
    /**
     * Método que irá imprimir a data no formato DD/MM/AAAA
     */
    public String imprimirData(){
        return this.dia+"/"+this.mes+"/"+this.ano;
    }
}