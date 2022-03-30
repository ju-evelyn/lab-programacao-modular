public class CursoLivre extends Turma {
    private String codTurma;
    public String getCodTurma() {
        return codTurma;
    }
    public void setCodTurma() {
        this.codTurma = Integer.toString(this.getNivel())+"L";
    }
    public CursoLivre(int nivel, int numAtividades) {
        super(nivel, numAtividades);
        this.setCodTurma();
    }
    public void visualizarMaterial(){
        
    }
    public boolean verificarAprovacao(double nota, double frequencia) {
        if(this.getNumAtividadesFeitas()==this.getNumAtividades()){
            return true;
        } else return false;
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
        return "A modalidade livre não emite certificado";
    }
    @Override
    public String toString(){
        return "A turma "+this.getCodTurma()+" está no nível "+getNivel()+".";
    }
}
