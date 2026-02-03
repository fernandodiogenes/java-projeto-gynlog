/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos.interfaces;
import modelos.classes.Veiculo;
import java.util.ArrayList;
/**
 *
 * @author aluno
 */
public interface IVeiculoCRUD {
    
    void salvar(Veiculo veiculo) throws Exception;
    ArrayList<Veiculo> listar() throws Exception;
    Veiculo buscar(int id) throws Exception;
    void atualizar(Veiculo veiculo) throws Exception;
    void remover(int id) throws Exception;
    
}
