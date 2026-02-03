
package controladora;

import modelos.classes.TipoDeDespesa;
import persistencia.PersistenciaDespesas; 
import java.util.ArrayList;

public class ControladoraDespesa {
     // criamos uma persistência própria para a controladora, mas ela ainda está vazia, sem função
    private PersistenciaDespesas persistencia;
    
    public ControladoraDespesa(){
        this.persistencia = new PersistenciaDespesas();  // aqui, associamos essa variável a uma persistência real, ou seja, uma referência
        }
    
    // MÉTODO CADASTRAR
    public String cadastrar (int idTipoDeDespesa, String descricao){
        try{
            // VERIFICAÇÕES
            
            // o id não pode ser negativo ou zero
            if (idTipoDeDespesa<=0){
                return "Erro! O ID deve ser um número positivo.";
            }
            
            // a descrição não pode ser vazia
            if (descricao == null || descricao.trim().isEmpty()){
                return "Erro! A descrição é obrigatória.";
            }
            
            // verificamos se há duplicidade
            if (persistencia.buscar(idTipoDeDespesa) != null ){
                return "Erro! Já existe um tipo de despesa com esse ID ("+ idTipoDeDespesa + ")";
            }
            
            // Agora, se passamos por todas as verificações, criamos o objeto
            TipoDeDespesa novaDespesa = new TipoDeDespesa(idTipoDeDespesa, descricao);
            
            // Mandamos a persistência realizar a ação de salvar
            persistencia.salvar(novaDespesa);
            
            return null; // retornamos null pois o processo foi realizado com sucesso
        } catch (Exception erro) {
            return "Erro ao cadastrar: " + erro.getMessage();
        }
    }
    
    // MÉTODO ATUALIZAR
    public String atualizar (int idTipoDeDespesa, String descricao){
        try{
            
             // validamos se todos os campos estão preenchidos
            if (descricao == null || descricao.trim().isEmpty()){
                return "Erro! A descrição é obrigatória.";
            }
            
             // verificamos se o veículo realmente existe antes de tentar atualizar
            if (persistencia.buscar(idTipoDeDespesa) == null){
                return "Erro! Tipo de despesa não encontrado.";
            }
            
            // agora, se passamos por todas as verificações, atualizamos o objeto
            TipoDeDespesa despesaAtualizada = new TipoDeDespesa(idTipoDeDespesa, descricao);
            
            // mandamos a persistência realizar a ação de atualizar
            persistencia.atualizar(despesaAtualizada);
             
            return null;
        } catch (Exception erro){
            return "Erro ao atualizar: " + erro.getMessage();
        }
    }
    
    // MÉTODO REMOVER
    public String remover(int idTipoDeDespesa){
        try{
            if (persistencia.buscar(idTipoDeDespesa) == null){
                return "Erro! Tipo de despesa não encontrado para exclusão.";
            }
            
            persistencia.remover(idTipoDeDespesa);
            return null;
            
        } catch (Exception erro) {
            return "Erro ao remover: " + erro.getMessage();
        }
    }
    
    // MÉTODO LISTAR (Necessário para preencher a tabela na tela)
    public ArrayList<TipoDeDespesa> listarTodos() throws Exception {
        return persistencia.listar();
    }
    
    // MÉTODO BUSCAR
    public TipoDeDespesa buscar(int id) throws Exception {
        return persistencia.buscar(id);
    }
}