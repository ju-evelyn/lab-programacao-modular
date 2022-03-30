public class Ead extends Turma {
    private static final int MIN_NOTA_APROVACAO = 60;
    private static final int MAX_ALUNOS = 100;
    private String codTurma;
    private Aluno[] alunos;
    private int numAlunos;
    public String getCodTurma() {
        return codTurma;
    }
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
    public int getNumAlunos() {
        return numAlunos;
    }
    public void setCodTurma() {
        this.codTurma = Integer.toString(this.getNivel())+"L";
    }
    public Ead(int nivel, int numAtividades) {
        super(nivel, numAtividades);
        this.setCodTurma();
    }
    public boolean verificarAprovacao(double nota) {
        if(nota>=MIN_NOTA_APROVACAO){
            return true;
        } else return false;
    }
    @Override
    public String emitirCertificado(String nome, double desempenho) {
        return "O aluno "+nome+"finalizou o curso à distância de nível "+getNivel()+". Seu desempenho final foi "+String.format("%.0f", (desempenho*100))+"%.";
    }
    @Override
    public String toString(){
        return "A turma "+this.getCodTurma()+"possui "+this.getNumAlunos()+" alunos e está no nível "+getNivel()+".";
    }
}
