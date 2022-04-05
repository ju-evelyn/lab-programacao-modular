public class Livro {
    private static final double PCT_DIREITOS = 0.08;
    protected String titulo;
    protected Autor autor;
    protected int paginas;
    protected double precoBase;
    protected int[] avaliacoes;
    private int numAvaliacoes;
    public String getTitulo(){
        return this.titulo;
    }
    public Autor getAutor(){
        return this.autor;
    }
    public int getPaginas(){
        return this.paginas;
    }
    public double getPrecoBase(){
        return this.precoBase;
    }
    public int[] getAvaliacoes(){
        return this.avaliacoes;
    }
    public int getNumAvaliacoes(){
        return this.numAvaliacoes;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(Autor autor){
        this.autor = autor;
    }
    public void setPaginas(int paginas){
        this.paginas = paginas;
    }
    public void setPrecoBase(double precoBase){
        this.precoBase = precoBase;
    }
    private void setAvaliacoes(){
        this.avaliacoes = new int[100];
    }
    public double precoVenda(){
        return this.getPrecoBase()+this.direitosAutorais();
    }
    public double direitosAutorais(){
        return this.getPrecoBase()*Livro.PCT_DIREITOS;
    }
    public double avaliacaoMedia(){
        int somaDasNotas = 0;
        for(int i=0;i<this.getNumAvaliacoes();i++){
            somaDasNotas+=this.avaliacoes[i];
        }
        return somaDasNotas/this.getNumAvaliacoes();
    }
    protected double precoBase(){
        return this.getPrecoBase();
    }
    public void novaAvaliacao(int nota){
        if(nota>=1&&nota<=5){
            this.avaliacoes[this.getNumAvaliacoes()] = nota;
            this.aumentarNumAvaliacoes();
        }
    }
    private void aumentarNumAvaliacoes(){
        this.numAvaliacoes++;
    }
    public Livro(String titulo, Autor autor, int paginas, double precoBase){
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setPaginas(paginas);
        this.setPrecoBase(precoBase);
        this.setAvaliacoes();
    }
}
