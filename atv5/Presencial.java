public class Presencial extends Turma {
    //atributos
    private int diaDaSemana;
    private int turno;
    //constantes
    public static final int MIN_NOTA_APROVACAO = 60;
    public static final double MIN_FREQUENCIA_APROVACAO = 0.75;
    public static final int MINIMO = 1;
    public static final int MAX_DIA = 7;
    public static final int MAX_TURNO = 3;
    public static final int MAX_ALUNOS = 20;
    public static final int MAX_AULAS = 20;
    //construtor
    public Presencial(int nivel, int numAtividades, int diaDaSemana, int turno){
        super(nivel, numAtividades, Presencial.MAX_AULAS);
        this.setDiaDaSemana(diaDaSemana);
        this.setTurno(turno);
    }
    //setters com regras de negócio
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
    //métodos de retorno
    public double mediaNotaTurma(){
        double somaNotaTotal = 0;
        for(int i = 0;i<this.getNumAlunos();i++){
            somaNotaTotal += this.getAlunoPorNumero(i).getNotaTotal();
        }
        return somaNotaTotal/this.getNumAlunos();
    }
    public double mediaFrequenciaTurma(){
        double somaFrequenciaTotal = 0;
        for(int i = 0;i<this.getNumAlunos();i++){
            somaFrequenciaTotal += this.getAlunoPorNumero(i).getFrequenciaEmPorcentagem();
        }
        return somaFrequenciaTotal/this.getNumAlunos();
    }
    public Aluno alunoDestaque(){
        Aluno destaque = this.getAlunoPorNumero(getNumAlunos()-1);
        for(int i = 0;i<(this.getNumAlunos()-1);i++){
            if(this.getAlunoPorNumero(i).getDesempenho()>destaque.getDesempenho()){
                destaque = this.getAlunoPorNumero(i);
            }
        }
        return destaque;
    }
    //getters padrão
    public int getDiaDaSemana() {
        return diaDaSemana;
    }
    public int getTurno() {
        return turno;
    }
    //overrides
    @Override
    public void addAluno(Aluno novato) {
        if(this.getNumAlunos()<Presencial.MAX_ALUNOS){
            super.addAluno(novato);
        }
    }
    @Override
    public void gerarCodigo() {
        String codTurma = Integer.toString(getNivel())+getDiaDaSemana()+getTurno();
        this.setCodTurma(codTurma);
    }
    @Override
    public String gerarCertificado(String nome) {
        Aluno aprovado = this.getAlunoPorNome(nome);
        return "A Escola de Idiomas certifica que o aluno "+aprovado.getNome()+" foi aprovado no curso de nivel "+this.getNivel()+" com desempenho final de "+String.format("%.0f",aprovado.getDesempenho())+"%.";
    }
    @Override
    public boolean verificarAprovacao(String nome) {
        Aluno alunoVerificado = this.getAlunoPorNome(nome);
        if(Double.compare(alunoVerificado.getNotaTotal(), Presencial.MIN_NOTA_APROVACAO)>=0&&Double.compare(alunoVerificado.getFrequenciaEmPorcentagem(), Presencial.MIN_FREQUENCIA_APROVACAO)>=0){
            return true;
        }
        return false;
    }
}