public class Ead extends Turma {
    public static final int MIN_NOTA_APROVACAO = 60;
    //construtor
    public Ead(int nivel, int numAtividades) {
        super(nivel, numAtividades);
        this.setNumAulas(numAtividades);
        this.gerarCodigo();
    }
    //metodo de retorno para relatorio sobre a turma
    public double mediaNotaTurma(){
        double somaNotaTotal = 0;
        for(int i = 0;i<this.getNumAlunos();i++){
            somaNotaTotal += this.getAlunoPorNumero(i).getNotaTotal();
        }
        return somaNotaTotal/this.getNumAlunos();
    }
    //overrides
    @Override
    public void gerarCodigo() {
        String codTurma = Integer.toString(getNivel())+"E";
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
        if(Double.compare(alunoVerificado.getNotaTotal(), Ead.MIN_NOTA_APROVACAO)>=0){
            return true;
        }
        return false;
    }
}
