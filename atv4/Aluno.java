/**
 * Só pode estar matriculado em uma turma por semestre
 * realiza 4 atividades por semestre
 * aprovado se conseguir 60 pontos e 75% de frequência
 */
public class Aluno {
    private String nome;
    private boolean matriculado;
    private float nota[] = new float[4];
    private int numProva;
    private float frequencia;
    private double desempenho;
    private boolean aprovado;
    public static final int NOTA_MAXIMA = 100;
    public static final int MAX_AULAS = 20;
    public Aluno(String nome){
        this.setNome(nome);
    }
    public String getNome() {
        return nome;
    }
    public boolean getMatriculado() {
        return matriculado;
    }
    public float getNota(int numProva) {
        return nota[numProva];
    }
    public int getNumProva() {
        return numProva;
    }
    public float getFrequência() {
        return this.frequencia/MAX_AULAS;
    }
    public double getDesempenho() {
        return desempenho;
    }
    public boolean isAprovado() {
        return aprovado;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMatriculado(Turma codTurma) {
        
    }
    public void setNota(float nota) {
        this.nota[getNumProva()] = nota;
    }
    public void setNumProva() {
        this.numProva++;
    }
    public void setAulaAssistida() {
        if(this.frequencia<=MAX_AULAS){
            this.frequencia++;
        }
    }
    public void setDesempenho(){
        float total = getNota(1)+getNota(2)+getNota(3)+getNota(4);
        this.desempenho = ((0.8*total)+(0.2*getFrequência()))/100;
    }
    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    
}