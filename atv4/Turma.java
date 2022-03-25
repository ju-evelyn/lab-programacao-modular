/**
 * pode conter até 20 alunos
 * atividades avaliativas tem o mesmo valor e somam 100 pontos
 * dividida por nível de ensino
 * código de turma com nível, dia da semana e turno da turma
 * uma aula por semana
 * semeste tem 20 semanas
 * ordem alfabética dos alunos com nome, nota e estado de aprovação
 * aluno destaque: nota(80%) e frequência (20%)
 */

public class Turma {
    private Aluno alunos[] = new Aluno[20];
    private int numAlunos = 1;
    private int nivel;
    private int diaDaSemana;
    private int turno;
    private String codTurma;
    public static final int MINIMO = 1;
    public static final int DIA_MAXIMO = 7;
    public static final int TURNO_MAXIMO = 3;

    public Turma(){
        this.setNivel(MINIMO);
        this.setDiaDaSemana(MINIMO);
        this.setTurno(MINIMO);
        this.setCodTurma();
    }
    public Turma(int nivel, int diaDaSemana, int turno){
        this.setNivel(nivel);
        this.setDiaDaSemana(diaDaSemana);
        this.setTurno(turno);
        this.setCodTurma();
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
    public void setAlunos(Aluno aluno) {
        if(getNumAlunos()<=20){
            this.alunos[getNumAlunos()] = aluno;
            setNumAluno();
        }
    }
    public void setNumAluno() {
        this.numAlunos ++;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setDiaDaSemana(int diaDaSemana) {
        if(diaDaSemana>=MINIMO&&diaDaSemana<=DIA_MAXIMO){
            this.diaDaSemana = diaDaSemana;
        }
    }
    public void setTurno(int turno) {
        if(turno>=MINIMO&&turno<=TURNO_MAXIMO){
            this.turno = turno;
        }
    }
    public void setCodTurma() {
        this.codTurma = Integer.toString(getNivel())+getDiaDaSemana()+getTurno();
    }

    
}
