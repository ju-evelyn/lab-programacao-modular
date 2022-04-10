public abstract class Turma {
    //Atributos
    private Aluno[] alunos;
    private int numAlunos;
    private int numAtividades;
    private double notaAtividadeIndividual;
    private int numAulas;
    private int nivel;
    private String codTurma;
    public static final int MAX_NOTA = 100;
    //Construtores
    public Turma(int nivel, int numAtividades){
        this.setNivel(nivel);
        this.setNumAtividades(numAtividades);
        this.alunos = new Aluno[100];
    }
    public Turma(int nivel, int numAtividades, int maxAlunos){
        this.setNivel(nivel);
        this.setNumAtividades(numAtividades);
        this.alunos = new Aluno[maxAlunos];
    }
    //Getters e Setters com regras de negócio
    public Aluno getAlunoPorNome(String nome){
        for(int i=0;i<this.getNumAlunos();i++){
            if(nome.equalsIgnoreCase(alunos[i].getNome())){
                return alunos[i];
            }
        }
        return null;
    }
    public Aluno getAlunoPorNumero(int numAluno){
        return this.alunos[numAluno];
    }
    private void addNumAlunos() {
        this.numAlunos++;
    }
    public void addAluno(Aluno novato) {
        alunos[this.getNumAlunos()]=novato;
        this.addNumAlunos();
    }
    public void setNotaAtividadeIndividual() {
        this.notaAtividadeIndividual = Presencial.MAX_NOTA/this.getNumAtividades();
    }
    //métodos abstratos e/ou com retorno
    public abstract void gerarCodigo();
    public abstract String gerarCertificado(String nome);
    public abstract boolean verificarAprovacao(String nome);
    public String relatorio(){
        String relatorio = "Relatório geral Turma "+this.getCodTurma()+"/n";
        for(int i = 0;i<this.getNumAlunos();i++){
            relatorio += this.getAlunoPorNumero(i).toString()+"/n";
        }
        return relatorio;
    }
    //getters e setters padrão
    public int getNumAlunos() {
        return numAlunos;
    }
    public int getNumAtividades() {
        return numAtividades;
    }
    public double getNotaAtividadeIndividual() {
        return notaAtividadeIndividual;
    }
    public int getNumAulas() {
        return numAulas;
    }
    public int getNivel() {
        return nivel;
    }
    public String getCodTurma() {
        return codTurma;
    }
    public void setNumAtividades(int numAtividades) {
        this.numAtividades = numAtividades;
    }
    public void setNumAulas(int numAulas) {
        this.numAulas = numAulas;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }
    public String toString(){
        return "A turma "+this.getCodTurma()+"possui "+this.getNumAlunos()+" alunos e está no nível "+getNivel()+".";
    } 
}