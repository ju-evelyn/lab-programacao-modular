public class Temporizador{
    private int tempo;
    private int tempoInicial;
    private boolean contando;
    private static final int tempoFinal = 0;
    //tempo padrão é o parâmetro dos cálculos de conversão de minutos para segundos e vice-versa
    private static final int tempoPadrao = 60;
    public Temporizador(){
        this.tempo = tempoFinal;
        this.contando = false;
    }
    public int getTempo(){
        return this.tempo;
    }
    public int getTempoInicial(){
        return this.tempoInicial;
    }
    public boolean isContando(){
        return this.contando;
    }
    public void inicioContagem(int minutos, int segundos) {
        this.tempo = (minutos*tempoPadrao)+segundos;
        this.tempoInicial = this.tempo;
        this.contando = true;
    }
    public String verContagem() {
        int minutos = this.tempo/tempoPadrao;
        int segundos = this.tempo%tempoPadrao;
        return minutos+":"+segundos;
    }
    public void pararContagem() {
        this.contando = false;
    }
    public void reiniciarContagem() {
        this.tempo = tempoInicial;
        this.contando = true;
    }
    public void zerarContagem(){
        this.contando = false;
        this.tempo = tempoFinal; 
    }
    public void passarTempo() {
        if(this.contando){
            this.tempo--;
        }
    }
      
}