public abstract class Turma{
    public static String codTurma;
    private int nivel;
    private int numAtividades;
    private double valorAtividade;
    public static final int MAX_PONTOS = 100;
    public int getNivel() {
        return nivel;
    }
    public int getNumAtividades() {
        return numAtividades;
    }
    public double getValorAtividade() {
        return valorAtividade;
    }
    private void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public abstract void setCodTurma();
    public void setNumAtividades(int numAtividades) {
        this.numAtividades = numAtividades;
    }
    public void setValorAtividade() {
        this.valorAtividade=Turma.MAX_PONTOS/this.getNumAtividades();
    }
    public abstract boolean verificarAprovacao(double nota, double frequencia);
    public abstract String emitirCertificado(String nome, double desempenho);
    public Turma(int nivel, int numAtividades){
        this.setNivel(nivel);
        this.setCodTurma();
        this.setNumAtividades(numAtividades);
        this.setValorAtividade();
    }
    public int getMaxFrequencia() {
        return 0;
    }
}