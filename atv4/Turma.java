public class Turma {
    private Aluno[] alunos;
    private int numAlunos;
    private int nivel;
    private int diaDaSemana;
    private int turno;
    private String codTurma;
    public static final int MINIMO = 1;
    public static final int MAX_DIA = 7;
    public static final int MAX_TURNO = 3;
    public static final int MAX_ALUNOS = 20;
    public Turma(){
        this.setNivel(MINIMO);
        this.setDiaDaSemana(MINIMO);
        this.setTurno(MINIMO);
        this.definirCodTurma();
        this.alunos = new Aluno[MAX_ALUNOS];
    }
    public Turma(int nivel, int diaDaSemana, int turno){
        this.setNivel(nivel);
        this.setDiaDaSemana(diaDaSemana);
        this.setTurno(turno);
        this.definirCodTurma();
        this.alunos = new Aluno[MAX_ALUNOS];
    }
    public Aluno getAlunos(int numAluno) {
        return alunos[numAluno];
    }
    public int getNumAlunos() {
        return numAlunos;
    }
    public int getNivel() {
        return nivel;
    }
    public int getDiaDaSemana() {
        return diaDaSemana;
    }
    public int getTurno() {
        return turno;
    }
    public String getCodTurma() {
        return codTurma;
    }
    private void setNumAluno() {
        this.numAlunos ++;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
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
    private void definirCodTurma() {
        this.codTurma = Integer.toString(getNivel())+getDiaDaSemana()+getTurno();
    }
    public void matricularAluno(String nomeDoAluno){
        if(getNumAlunos()<MAX_ALUNOS){
            this.alunos[getNumAlunos()] = new Aluno(nomeDoAluno, getCodTurma());
            setNumAluno();
        }
        this.ordenarChamada();
    }
    private void ordenarChamada() {
        for(int i = 0; i<this.getNumAlunos()-1; i++){
            boolean isOrdenado = true;
            for(int j = 0; j<(this.getNumAlunos()-1-i); j++){
                if(this.getAlunos(j).getNome().compareToIgnoreCase(this.getAlunos(j+1).getNome())>0){
                    Aluno aux = this.getAlunos(j);
                    this.alunos[j] = this.alunos[j+1];
                    this.alunos[j+1] = aux;
                    isOrdenado = false;
                }
            }
            if(isOrdenado)break;
        }
    }
    public String relatorioTurma(){
        String relatorio = "Relatório geral Turma "+this.getCodTurma()+"/n";
        for(int i = 0;i<this.getNumAlunos();i++){
            relatorio += this.alunos[i].toString()+"/n";
        }
        return relatorio;
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
    public String toString(){
        return "A turma "+this.getCodTurma()+"possui "+this.getNumAlunos()+" alunos e está no nível "+getNivel()+".";
    }
}