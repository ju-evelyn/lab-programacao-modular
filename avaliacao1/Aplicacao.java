public class Aplicacao {
    Autor moderno = new Autor("Paulo Jose");
    Livro romance = new Livro("Primeiro Amor", moderno, 250, 100.0);
    Livro terror = new Livro("Dormindo Sozinho", moderno, 430, 100.0);
    moderno.incluirLivro(romance);
    moderno.incluirLivro(terror);
    public double totalDeDireitos(Autor autor){
        double somaDeDireitos = 0;
        for(int i = 0;i<autor.getNumLivros();i++){
            Livro livro = autor.getLivro(i);
            somaDeDireitos+=autor.direitoAutoral(livro);
        }
        return somaDeDireitos;
    }
    public static void main(String[] args){
        System.out.println(totalDeDireitos(moderno));
    }
}