
package modelos.interfaces;
import java.util.ArrayList;
import modelos.classes.TipoDeDespesa;


public interface ITipoDeDespesasCRUD {
    void salvar(TipoDeDespesa tipoDeDespesa) throws Exception;
    ArrayList<TipoDeDespesa> listar() throws Exception;
    TipoDeDespesa buscar(int idTipoDeDespesa) throws Exception;
    void atualizar(TipoDeDespesa tipoDeDespesa) throws Exception;
    void remover(int idTipoDeDespesa) throws Exception;   
}
