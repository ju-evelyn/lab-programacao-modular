public class Autor{
    public String nome;
    private Livro[] livros;
    private int numLivros;

    public String getNome(){
        return this.nome;
    }
    public Livro[] getLivros(){
        return this.livros;
    }
    public Livro getLivro(int numLivro){
        return this.livros[numLivro];
    }
    public int getNumLivros(){
        return this.numLivros;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setLivros() {
        this.livros = new Livro[100];
    }
    private void aumentarNumLivros(){
        this.numLivros++;
    }
    public double direitoAutoral(Livro livro){
        return livro.direitosAutorais();
    }
    public void incluirLivro(Livro novo){
        this.livros[this.getNumLivros()] = novo;
        this.aumentarNumLivros();
    }
    public Autor(String nome){
        this.setNome(nome);
    }
}