public class Presencial extends Turma {
    private int diaDaSemana;
    private int turno;
    private String codTurma;
    private static final int MINIMO = 1;
    private static final int MAX_DIA = 7;
    private static final int MAX_TURNO = 3;
    private static final int MAX_ALUNOS = 20;
    private static final int MAX_FREQUENCIA = 20;
    private static final double MIN_FREQUENCIA_APROVACAO = 0.75;
    private static final double MIN_NOTA_APROVACAO = 60;
    public int getDiaDaSemana() {
        return diaDaSemana;
    }
    public int getTurno() {
        return turno;
    }
    public String getCodTurma() {
        return codTurma;
    }
    public static int getMaxFrequencia() {
        return MAX_FREQUENCIA;
    }
    public void matricularAluno(String nomeDoAluno, Turma turma){
        if(this.getNumAlunos()<Presencial.MAX_ALUNOS){
            this.alunos = new Aluno(nomeDoAluno, turma);
            this.setNumAlunos();
        }
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
    public void setCodTurma() {
        this.codTurma = Integer.toString(getNivel())+getDiaDaSemana()+getTurno();
    }
    public void marcarPresenca(String nome) {
        Aluno presente = this.getAlunoPorNome(nome);
        if(presente.getFrequência()<Presencial.MAX_FREQUENCIA){
            presente.setFrequencia();
        }
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
            somaFrequenciaTotal += this.alunos[i].frequenciaEmPorcentagem();
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
    public boolean verificarAprovacao(double nota, double frequencia) {
        if(nota>=Presencial.MIN_NOTA_APROVACAO&&frequencia>=Presencial.MIN_FREQUENCIA_APROVACAO){
            return true;
        } else {
            return false;
        }   
    }
    public Presencial(int nivel, int numAtividades, int diaDaSemana, int turno) {
        super(nivel, numAtividades);
        this.setDiaDaSemana(diaDaSemana);
        this.setTurno(turno);
        this.alunos = new Aluno[MAX_ALUNOS];
    }
    @Override
    public String relatorioTurma(){
        String relatorio = "Relatório geral Turma "+this.getCodTurma()+"/n";
        for(int i = 0;i<this.getNumAlunos();i++){
            relatorio += this.alunos[i].toString()+"/n";
        }
        return relatorio;
    }
    @Override
    public String emitirCertificado(String nome, double desempenho) {
        return "O aluno "+nome+"finalizou o curso presencial de nível "+getNivel()+", com duração de "+MAX_FREQUENCIA+" dias. Seu desempenho final foi "+String.format("%.0f", (desempenho*100))+"%.";
    }
    @Override
    public String toString(){
        return "A turma "+this.getCodTurma()+"possui "+this.getNumAlunos()+" alunos e está no nível "+getNivel()+".";
    }
}