import java.util.ArrayList;

public class Biblioteca {
    public static final int DURACAO_EMPRESTIMO = 7;
    private ArrayList<Livro> livros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Emprestimo> emprestimos;

    public void cadastrarLivro(Livro livro){
        this.livros.add(livro);
    }
    public void cadastrarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
    public void cadastrarEmprestimo(){

    }
}
