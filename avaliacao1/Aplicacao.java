public class Aplicacao {
    public static double totalDeDireitos(Autor autor){
        double somaDeDireitos = 0;
        for(int i = 0;i<autor.getNumLivros();i++){
            Livro livro = autor.getLivro(i);
            somaDeDireitos+=autor.direitoAutoral(livro);
        }
        return somaDeDireitos;
    }
    public static void main(String[] args){
        Autor moderno = new Autor("Paulo Jose");
        Livro romance = new LivroDigital("Primeiro Amor", moderno, 250, 100.0);
        Livro terror = new LivroDigital("Dormindo Sozinho", moderno, 430, 100.0);
        moderno.incluirLivro(romance);
        moderno.incluirLivro(terror);
        double total = totalDeDireitos(moderno);
        System.out.println(total);
    }
}