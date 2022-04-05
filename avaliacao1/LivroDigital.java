public class LivroDigital extends Livro {
    public LivroDigital(String titulo, Autor autor, int paginas, double precoBase) {
        super(titulo, autor, paginas);
        this.setPrecoBase(precoBase);
    }
    @Override
    public double precoVenda() {
        return this.getPrecoBase()+this.direitosAutorais();
    }
    @Override
    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    } 
}