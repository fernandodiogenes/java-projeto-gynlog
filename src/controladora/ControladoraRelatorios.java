
package controladora;

import modelos.classes.Veiculo;
import java.util.ArrayList;

public class ControladoraRelatorios {
    // criamos uma persistência própria para a controladora, mas ela ainda está vazia, sem função
    private ControladoraVeiculo ctrlVeiculo;
    // depois do dre fazer a movimentação, adicionaremos mais uma linha aqui
    
    public ControladoraRelatorios(){
        // aqui, associamos essa variável a uma persistência real, ou seja, uma referência
        this.ctrlVeiculo = new ControladoraVeiculo(); 
        
    }
    
    // RELATÓRIO 5 - VEÍCULOS INATIVOS (enquanto a movimentação ainda está sendo feita)
    // aqui percorremos toda a lista de veículos e retornamos todos que estão com ativo = false
    public ArrayList<Veiculo> gerarRelatorioVeiculosInativos() throws Exception {
        // primeiro pegamos todos os veículos do arquivo
        ArrayList<Veiculo> todos = ctrlVeiculo.listarTodos();
        
        // depois criamos uma nova lista apenas para os que estão inativos
        ArrayList<Veiculo> inativos = new ArrayList<>();
        
        // agora filtramos e separamos os veículos ativos dos inativos
        for (Veiculo v : todos){
            // verificamos se está marcado como ativo ou não
            if (v.isAtivo() == false){
                inativos.add(v);
            }
        }
        return inativos;
    }  
}
