public class LivroFisico extends Livro {
    private static final double ADIC_PAGINA = 0.07;
    private double valorEncadernacao;
    public double getValorEncadernacao() {
        return this.valorEncadernacao;
    }
    public void setValorEncadernacao(double valorEncadernacao) {
        this.valorEncadernacao = valorEncadernacao;
    }
    public LivroFisico(String titulo, Autor autor, int paginas, double precoBase, double valorEncadernacao) {
        super(titulo, autor, paginas);
        this.setValorEncadernacao(valorEncadernacao);
        this.setPrecoBase(precoBase);
    }
    @Override
    public double precoVenda() {
        return this.getPrecoBase()+this.direitosAutorais();
    }
    @Override
    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase+this.precoImpressao()+this.getValorEncadernacao();
    }
    private double precoImpressao(){
        return (this.getPaginas()*LivroFisico.ADIC_PAGINA);
    }
}