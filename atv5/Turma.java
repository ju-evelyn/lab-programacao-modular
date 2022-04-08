public abstract class Turma {
    protected Aluno[] alunos;
    private int numAlunos;
    private int numAtividades;
    protected int numAulas;
    private int nivel;
    protected String codTurma;
    public static final int MAX_NOTA = 100;
    public Aluno[] getAlunos() {
        return alunos;
    }
    public int getNumAlunos() {
        return numAlunos;
    }
    public Aluno getAlunoPorNome(String nome){
        for(int i=0;i<this.getNumAlunos();i++){
            if(nome.equalsIgnoreCase(alunos[i].getNome())){
                return alunos[i];
            }
        }
        return null;
    }
    public int getNumAtividades() {
        return numAtividades;
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
    public void addNumAlunos() {
        this.numAlunos++;
    }
    public void setNumAtividades(int numAtividades) {
        this.numAtividades = numAtividades;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String toString(){
        return "A turma "+this.getCodTurma()+"possui "+this.getNumAlunos()+" alunos e está no nível "+getNivel()+".";
    
    public abstract void addAluno(Aluno novato);
    public abstract void setNumAulas(int numAulas);
    protected abstract void setCodTurma();
    public abstract boolean verificarAprovacao(String nome);
    public String relatorio(){
        String relatorio = "Relatório geral Turma "+this.getCodTurma()+"/n";
        for(int i = 0;i<this.getNumAlunos();i++){
            relatorio += this.alunos[i].toString()+"/n";
        }
        return relatorio;
    }
    public Turma(int nivel, int numAtividades){
        this.setNivel(nivel);
        this.setNumAtividades(numAtividades);
    }
}