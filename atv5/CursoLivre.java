public class CursoLivre extends Turma {
    //construtor
    public CursoLivre(int nivel, int numAtividades) {
        super(nivel, numAtividades);
        this.setNumAulas(numAtividades);
    }
    //overrides
    @Override
    public void gerarCodigo() {
        String codTurma = Integer.toString(getNivel())+"L";
        this.setCodTurma(codTurma);     
    }
    @Override
    public String gerarCertificado(String nome) {
        return "A modalidade de curso 'Livre' não gera certificado";
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
    public String relatorio(){
        String relatorio = "Relatório geral Turma "+this.getCodTurma()+"/n";
        for(int i=0;i<this.getNumAlunos();i++){
            if(this.getAlunoPorNumero(i).isAprovado()){
                return this.getAlunoPorNumero(i).getNome()+" foi aprovado./n";
            } else {
                return this.getAlunoPorNumero(i).getNome()+" foi reprovado./n";
            }
        }
        return relatorio;
    }
}