public class Microondas {
    private boolean aberto;
    private boolean ligado;

    Temporizador tempo = new Temporizador();

    public Microondas(){
        this.aberto = false;
        this.ligado = false;
    }
    public boolean isAberto(){
        return aberto;
    }
    public boolean isLigado(){
        return ligado;
    }
    public void programarTempo(int minutos, int segundos){
        tempo.inicioContagem(minutos, segundos);
    }
    public String verTempo(){
        return tempo.verContagem();
    }
    public void abrirMicroondas(){
        if(!this.ligado){
            this.aberto = true;
        }
    }
    public void fecharMicroondas(){
        this.aberto = false;
    }
    public void ligarMicroondas(){
        if(!this.aberto&&tempo.getTempo()>0){
            this.ligado = true;
            tempo.passarTempo();
        }
        if(tempo.getTempo()==0)this.desligarMicroondas();
    }
    public void desligarMicroondas(){
        tempo.zerarContagem();
        this.ligado = false;
    }
    public void pausarMicroondas(){
        tempo.pararContagem();
        this.ligado = false;
    }
    public void reiniciarTempo(){
        tempo.reiniciarContagem();
    }
}