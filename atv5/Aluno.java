public class Aluno {
    //Atributos
    private String nome;
    private Turma turma;
    private double[] nota;
    private int numProva;
    private int frequencia;
    private double desempenho;
    private boolean aprovado;
    private String certificado;
    //construtor
    public Aluno(String nome, Turma turma){
        this.setNome(nome);
        this.setTurma(turma);
        this.nota = new double[turma.getNumAtividades()];
    }
    //getters e setters com regras de negócio e/ou lógica específica
    public double getNotaPorNumero(int numProva){
        return nota[numProva];
    }
    public double getFrequenciaEmPorcentagem(){
        return this.getFrequência()/turma.getNumAulas();
    }
    public double getDesempenhoEmPorcentagem(){
        return this.getDesempenho()*100;
    }
    public void addNota(double nota) {
        if(getNumProva()<turma.getNumAtividades() && nota<turma.getNotaAtividadeIndividual()){
            this.nota[getNumProva()] = nota;
            this.addNumProva();
        }
    }
    private void addNumProva() {
        this.numProva++;
    }
    public double getNotaTotal(){
        double total = 0;
        for(int i = 0;i<this.getNumProva();i++){
            total += getNotaPorNumero(i);
        }
        return total;
    }
    //métodos de alteração de atributo
    public void marcarPresencaEmAula() {
        this.frequencia++;
    }
    public void atualizarDesempenho(){
        this.desempenho = ((80*this.getNotaTotal())+(20*this.getFrequenciaEmPorcentagem()))/100;
    }
    public void atualizarAprovacao(){
        this.aprovado = turma.verificarAprovacao(this.getNome());
        if(aprovado){
            this.setCertificado(turma.gerarCertificado(this.getNome()));
        }
    }
    //getters e setters padrão
    public String getNome() {
        return nome;
    }
    public Turma getTurma() {
        return turma;
    }
    public double[] getNota() {
        return nota;
    }
    public int getNumProva() {
        return numProva;
    }
    public int getFrequência() {
        return this.frequencia;
    }
    public double getDesempenho() {
        return desempenho;
    }
    public boolean isAprovado() {
        this.atualizarAprovacao();
        return aprovado;
    }
    public String getCertificado() {
        return certificado;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
    public void setTurma(Turma turma) {
            this.turma = turma;
    }
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }
    public String toString(){
        if(this.isAprovado()){
            return this.nome+" foi aprovado e sua nota final foi "+String.format("%.2d",this.getNotaTotal())+".";
        } else {
            return this.nome+" foi reprovado e sua nota final foi "+String.format("%.2d",this.getNotaTotal())+".";
        }
    }
}