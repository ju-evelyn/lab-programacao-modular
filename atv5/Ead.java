public class Ead extends Turma {
    public static final int MIN_NOTA_APROVACAO = 60;
    public Ead(int nivel, int numAtividades) {
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
        this.codTurma = Integer.toString(getNivel())+"E";       
    }
    @Override
    public boolean verificarAprovacao(String nome) {
        Aluno alunoVerificado = this.getAlunoPorNome(nome);
        if(Double.compare(alunoVerificado.notaTotal(), Ead.MIN_NOTA_APROVACAO)>=0){
            return true;
        }
        return false;
    }
    @Override
    public String relatorio(){
        String relatorio = "Relatório geral Turma "+this.getCodTurma()+"/n";
        for(int i = 0;i<this.getNumAlunos();i++){
            relatorio += this.alunos[i].toString()+"/n";
        }
        return relatorio;
    }
    @Override
    public void setNumAulas(int numAulas) {
        this.numAulas = this.getNumAtividades();
    }
}
