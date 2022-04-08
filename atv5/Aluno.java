public class Aluno {
    private String nome;
    private Turma turma;
    private double[] nota;
    private int numProva;
    private int frequencia;
    private double desempenho;
    private boolean aprovado;
    public Aluno(String nome, Turma turma){
        this.setNome(nome);
        this.setTurma(turma);
        this.nota = new double[turma.getNumAtividades()];
    }
    public String getNome() {
        return nome;
    }
    public Turma getTurma() {
        return turma;
    }
    public double[] getNota() {
        return nota;
    }
    public double getNotaEspecifica(int numProva){
        return nota[numProva];
    }
    public int getNumProva() {
        return numProva;
    }
    public int getFrequência() {
        return this.frequencia;
    }
    public double getFrequenciaEmPorcentagem(){
        return this.getFrequência()/turma.getNumAulas();
    }
    public double getDesempenho() {
        return desempenho;
    }
    public boolean isAprovado() {
        this.atualizarAprovacao();
        return aprovado;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
    public void setTurma(Turma turma) {
            this.turma = turma;
    }
    public void addNota(float nota) {
        if(getNumProva()<turma.getNumAtividades() && nota<Turma.MAX_NOTA){
            this.nota[getNumProva()] = nota;
            this.addNumProva();
        }
    }
    private void addNumProva() {
        this.numProva++;
    }
    public float notaTotal(){
        float total = 0;
        for(int i = 0;i<this.getNumProva();i++){
            total += getNotaEspecifica(i);
        }
        return total;
    }
    public void marcarPresencaEmAula() {
        this.frequencia++;
    }
    public void atualizarDesempenho(){
        this.desempenho = ((80*this.notaTotal())+(20*this.getFrequenciaEmPorcentagem()))/100;
    }
    public void atualizarAprovacao(){
        this.aprovado = turma.verificarAprovacao(this.getNome());
    }
    public String toString(){
        if(this.isAprovado()){
            return this.nome+" foi aprovado e sua nota final foi "+this.notaTotal()+".";
        } else {
            return this.nome+" foi reprovado e sua nota final foi "+this.notaTotal()+".";
        }
    }
}