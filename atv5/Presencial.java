public class Presencial extends Turma {
    private int diaDaSemana;
    private int turno;
    private double notaAtividadeIndividual;
    public static final int MIN_NOTA_APROVACAO = 60;
    public static final double MIN_FREQUENCIA_APROVACAO = 0.75;
    public static final int MINIMO = 1;
    public static final int MAX_DIA = 7;
    public static final int MAX_TURNO = 3;
    public static final int MAX_ALUNOS = 20;
    public static final int MAX_AULAS = 20;
    public Presencial(int nivel, int numAtividades, int diaDaSemana, int turno){
        super(nivel, numAtividades);
        this.setDiaDaSemana(diaDaSemana);
        this.setTurno(turno);
        this.setCodTurma();
        this.alunos = new Aluno[MAX_ALUNOS];
    }
    public int getDiaDaSemana() {
        return diaDaSemana;
    }
    public int getTurno() {
        return turno;
    }
    public double getNotaAtividadeIndividual() {
        return notaAtividadeIndividual;
    }
    public void setDiaDaSemana(int diaDaSemana) {
        if(diaDaSemana>=MINIMO&&diaDaSemana<=MAX_DIA){
            this.diaDaSemana = diaDaSemana;
        }
    }
    public void setTurno(int turno) {
        if(turno>=MINIMO&&turno<=MAX_TURNO){
            this.turno = turno;
        }
    }
    public void setNotaAtividadeIndividual() {
        this.notaAtividadeIndividual = Presencial.MAX_NOTA/this.getNumAtividades();
    }
    public double mediaNotaTurma(){
        double somaNotaTotal = 0;
        for(int i = 0;i<this.getNumAlunos();i++){
            somaNotaTotal += this.alunos[i].notaTotal();
        }
        return somaNotaTotal/this.getNumAlunos();
    }
    public double mediaFrequenciaTurma(){
        double somaFrequenciaTotal = 0;
        for(int i = 0;i<this.getNumAlunos();i++){
            somaFrequenciaTotal += this.alunos[i].getFrequenciaEmPorcentagem();
        }
        return somaFrequenciaTotal/this.getNumAlunos();
    }
    public Aluno alunoDestaque(){
        Aluno destaque = this.alunos[getNumAlunos()-1];
        for(int i = 0;i<(this.getNumAlunos()-1);i++){
            if(this.alunos[i].getDesempenho()>destaque.getDesempenho()){
                destaque = this.alunos[i];
            }
        }
        return destaque;
    }
    @Override
    public void addAluno(Aluno novato) {
        if(this.getNumAlunos()<Presencial.MAX_ALUNOS){
            alunos[this.getNumAlunos()]=novato;
            this.addNumAlunos();
        }
    }
    @Override
    protected void setCodTurma() {
        this.codTurma = Integer.toString(getNivel())+getDiaDaSemana()+getTurno();
    }
    @Override
    public boolean verificarAprovacao(String nome) {
        Aluno alunoVerificado = this.getAlunoPorNome(nome);
        if(Double.compare(alunoVerificado.notaTotal(), Presencial.MIN_NOTA_APROVACAO)>=0&&Double.compare(alunoVerificado.getFrequenciaEmPorcentagem(), Presencial.MIN_FREQUENCIA_APROVACAO)>=0){
            return true;
        }
        return false;
    }
    @Override
    public void setNumAulas(int numAulas) {
        this.numAulas = Presencial.MAX_AULAS;
    }
}