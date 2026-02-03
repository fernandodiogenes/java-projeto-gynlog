package modelos.interfaces;
import modelos.classes.Movimentacao;
import java.util.ArrayList;

public interface IMovimentacaoCRUD {
    
    void salvar(Movimentacao movimentacao) throws Exception;
    ArrayList<Movimentacao> listar() throws Exception;
    Movimentacao buscar(int id) throws Exception;
    void atualizar(Movimentacao movimentacao) throws Exception;
    void remover(int id) throws Exception;
}
