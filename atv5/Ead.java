public class Ead extends Turma {
    public Ead(int nivel, int numAtividades) {
        super(nivel, numAtividades);
        //TODO Auto-generated constructor stub
    }
    private int numMateriais;
    private static final int MIN_NOTA_APROVACAO = 60;
    @Override
    public void setCodTurma() {
        Ead.codTurma = Integer.toString(getNivel())+"E";
        
    }
    @Override
    public boolean verificarAprovacao(double nota, double frequencia) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public String emitirCertificado(String nome, double desempenho) {
        // TODO Auto-generated method stub
        return null;
    }
}
