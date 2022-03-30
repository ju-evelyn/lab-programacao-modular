public abstract class Turma{
    private Aluno[] alunos;
    private int numAlunos;
    private int nivel;
    private int numAtividades;
    private double valorAtividade;
    public static final int MAX_PONTOS = 100;
    public Aluno[] getAlunos() {
        return alunos;
    }
    public Aluno getAlunoPorNome(String nome) {
        for(int i=0;i<this.getNumAlunos();i++){
            if(nome.equalsIgnoreCase(this.alunos[i].getNome())){
                return alunos[i];
            }
        }
        return null;
    }
    public Aluno getAlunoPorId(int id){
        for(int i=0;i<this.getNumAlunos();i++){
            if(id==i){
                return alunos[i];
            }
        }
        return null;
    }
    public int getNumAlunos() {
        return numAlunos;
    }
    public int getNivel() {
        return nivel;
    }
    public int getNumAtividades() {
        return numAtividades;
    }
    public double getValorAtividade() {
        return valorAtividade;
    }
    public void setNumAlunos() {
        this.numAlunos++;
    }
    private void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setNumAtividades(int numAtividades) {
        this.numAtividades = numAtividades;
    }
    public void setValorAtividade() {
        this.valorAtividade=Turma.MAX_PONTOS/this.getNumAtividades();
    }
    public abstract String relatorioTurma();
    public abstract String emitirCertificado(String nome, double desempenho);
    public Turma(int nivel, int numAtividades){
        this.setNivel(nivel);
        this.setNumAtividades(numAtividades);
        this.setValorAtividade();
    }
}