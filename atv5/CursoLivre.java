public class CursoLivre extends Turma {

    public CursoLivre(int nivel, int numAtividades) {
        super(nivel, numAtividades);
        this.setCodTurma();
        this.alunos = new Aluno[100];
    }
    @Override
    public void addAluno(Aluno novato) {
        alunos[this.getNumAlunos()]=novato;
        this.addNumAlunos();
    }
    @Override
    protected void setCodTurma() {
        this.codTurma = Integer.toString(getNivel())+"L";       
    }
    @Override
    public boolean verificarAprovacao(String nome) {
        Aluno alunoVerificado = this.getAlunoPorNome(nome);
        if(alunoVerificado.getFrequenciaEmPorcentagem()==1){
            return true;
        }
        return false;
    }
    @Override
    public String relatorio() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void setNumAulas(int numAulas) {
        this.numAulas = this.getNumAtividades();
    }
}
