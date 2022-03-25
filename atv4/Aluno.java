/**
 * Só pode estar matriculado em uma turma por semestre
 * realiza 4 atividades por semestre
 * aprovado se conseguir 60 pontos e 75% de frequência
 */
public class Aluno {
    private String nome;
    private String codTurma;
    private float[] nota;
    private int numProva;
    private float frequencia;
    private double desempenho;
    private boolean aprovado;
    public static final int MIN_NOTA_APROVACAO = 60;
    public static final float MIN_FREQUENCIA_APROVACAO = (float) 0.75;
    public static final int MAX_AULAS = 20;
    public static final int MAX_ATIVIDADES = 4;
    public static final int MAX_NOTA_SEMESTRE = 100;
    public static final int MAX_NOTA_PROVA = MAX_NOTA_SEMESTRE/MAX_ATIVIDADES;
    public Aluno(String nome, String codTurma){
        this.setNome(nome);
        this.setCodTurma(codTurma);
        this.nota = new float[MAX_ATIVIDADES];
    }
    public String getNome() {
        return nome;
    }
    public String getCodTurma() {
        return codTurma;
    }
    public float getNota(int numProva) {
        return nota[numProva];
    }
    public int getNumProva() {
        return numProva;
    }
    public float getFrequência() {
        return this.frequencia;
    }
    public float getFrequenciaEmPorcentagem(){
        return this.frequencia/MAX_AULAS;
    }
    public double getDesempenho() {
        return desempenho;
    }
    public boolean isAprovado() {
        this.atualizarAprovacao();
        return aprovado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private void setCodTurma(String codTurma) {
            this.codTurma = codTurma;
    }
    public void setNota(float nota) {
        if(getNumProva()<MAX_ATIVIDADES && nota<MAX_NOTA_PROVA){
            this.nota[getNumProva()] = nota;
            this.setNumProva();
        }
    }
    private void setNumProva() {
        this.numProva++;
    }
    public float notaTotal(){
        float total = 0;
        for(int i = 0;i<MAX_ATIVIDADES;i++){
            total += getNota(i);
        }
        return total;
    }
    public void marcarPresencaEmAula() {
        if(this.frequencia<=MAX_AULAS){
            this.frequencia++;
        }
    }
    public void atualizarDesempenho(){
        this.desempenho = ((80*notaTotal())+(20*getFrequenciaEmPorcentagem()))/100;
    }
    public void atualizarAprovacao(){
        if(this.notaTotal()>Aluno.MIN_NOTA_APROVACAO&&this.getFrequenciaEmPorcentagem()>Aluno.MIN_FREQUENCIA_APROVACAO){
            this.aprovado = true;
        } else {
            this.aprovado = false;
        }
    }
    public String toString(){
        if(this.isAprovado()){
            return this.nome+" foi aprovado e sua nota final foi "+this.notaTotal()+".";
        } else {
            return this.nome+" foi reprovado e sua nota final foi "+this.notaTotal()+".";
        }
    }
}