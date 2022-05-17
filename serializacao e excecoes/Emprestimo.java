import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Cliente cliente;
    private ArrayList<Livro> livros;
    private ArrayList<LocalDate> prazos;
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Emprestimo(Cliente cliente, Livro livro) {
        this.cliente = cliente;
        this.livros.add(livro);
        this.prazos.add(LocalDate.now());
    }
    public void renovarEmprestimo(){

    }
}
