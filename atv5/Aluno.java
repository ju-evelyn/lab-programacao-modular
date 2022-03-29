public class Aluno {
    private String nome;
    private Turma turma;
    private double[] atvAvaliativa;
    private int atvEntregue;
    private int frequencia;
    private double desempenho;
    private boolean aprovado;
    private String certificado;
    public String getNome() {
        return nome;
    }
    public Turma getTurma() {
        return turma;
    }
    public double[] getAtvAvaliativa() {
        return atvAvaliativa;
    }
    public double getAtvAvaliativa(int numAtividade) {
        return atvAvaliativa[numAtividade];
    }
    public int getAtvEntregue() {
        return atvEntregue;
    }
    public float getFrequência() {
        return frequencia;
    }
    public double getDesempenho() {
        this.atualizarDesempenho();
        return desempenho;
    }
    public boolean isAprovado() {
        this.atualizarAprovacao();
        return this.aprovado;
    }
    public String getCertificado() {
        if(!certificado.equalsIgnoreCase(null)){
            return certificado;
        } else {
            return "O aluno"+this.getNome()+" ainda não possui certificado.";
        }
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
    private void setTurma(Turma turma) {
        this.turma = turma;
    }
    public void adicionarNota(double nota) {
        if(this.getAtvEntregue()<turma.getNumAtividades() && nota<=turma.getValorAtividade()){
            this.atvAvaliativa[getAtvEntregue()] = nota;
            this.setAtvEntregue();
        }
    }
    private void setAtvEntregue() {
        this.atvEntregue++;
    }
    public void marcarPresenca() {
        if(this.getFrequência()<this.getTurma().getMaxFrequencia()){
            this.frequencia++;
        }
    }
    private void atualizarDesempenho() {
        this.desempenho = ((80*notaTotal())+(20*frequenciaEmPorcentagem()))/100;
    }
    private void atualizarAprovacao() {
        this.aprovado = turma.verificarAprovacao(this.notaTotal(),this.frequenciaEmPorcentagem());
        if(this.aprovado)this.setCertificado();
    }
    private void setCertificado() {
        this.certificado = turma.emitirCertificado(this.getNome(), this.getDesempenho());
    }
    public double notaTotal(){
        double total = 0;
        for(int i = 0;i<this.getAtvEntregue();i++){
            total += this.getAtvAvaliativa(i);
        }
        return total;
    }
    public double frequenciaEmPorcentagem(){
        return this.getFrequência()/this.getTurma().getMaxFrequencia();
    }
    public Aluno(String nome, Turma turma){
        this.setNome(nome);
        this.setTurma(turma);
    }
    public String toString(){
        if(this.isAprovado()){
            return this.nome+" foi aprovado e sua nota final foi "+this.notaTotal()+".";
        } else {
            return this.nome+" foi reprovado e sua nota final foi "+this.notaTotal()+".";
        }
    }
}