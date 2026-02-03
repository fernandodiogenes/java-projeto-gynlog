
package controladora;

import modelos.classes.Veiculo;
import persistencia.PersistenciaVeiculo;
import java.util.ArrayList;

public class ControladoraVeiculo {
    // criamos uma persistência própria para a controladora, mas ela ainda está vazia, sem função
    private PersistenciaVeiculo persistencia;
    
    public ControladoraVeiculo(){
        this.persistencia = new PersistenciaVeiculo(); // aqui, associamos essa variável a uma persistência real, ou seja, uma referência
    }
    // MÉTODO CADASTRAR
    public String cadastrar (int id, String placa, String marca, String modelo, int ano, boolean ativo){
        try{
            // VERIFICAÇÕES
            
            // o id não pode ser negativo ou zero
            if (id<=0){
                return "Erro! O ID deve ser um número positivo.";
            }
            
            // a placa não pode ser vazia
            if (placa == null || placa.trim().isEmpty()){
                return "Erro! A placa é obrigatória.";
            }
            
            
            // a marca e modelo não podem ser vazios 
            if (marca.trim().isEmpty() || modelo.trim().isEmpty()){
                return "Erro! Marca e modelo são obrigatórios.";
            }
            
            if (!marca.matches("[a-zA-ZÀ-ÿ\\s]+") || !modelo.matches("[a-zA-Z0-9À-ÿ\\s]+")){
                return "Erro! Marca e Modelo devem conter apenas letras, sem números ou caractéres especiais.";
            }
            
            // o ano do carro tem que ser realista
            if (ano < 1950 || ano > 2026){
                return "Erro! O ano informado (" + ano + ") é inválido";
            }
            
            // verificação de id duplicado 
            if (persistencia.buscar(id) != null){
                return "Erro! Já existe um veículo com esse ID (" + id + ")";
            }
            
            // Agora, se passamos por todas as verificações, criamos o objeto
            Veiculo novoVeiculo = new Veiculo(id, placa, marca, modelo, ano, ativo);
            
            // Mandamos a persistência realizar a ação de salvar
            persistencia.salvar(novoVeiculo);
            
            return null; // retornamos null pois o processo foi realizado com sucesso
            
        } catch (Exception erro){
            return "Erro técnico: " + erro.getMessage();
        }
    }
    
    // MÉTODO ATUALIZAR 
    
    public String atualizar(int id, String placa, String marca, String modelo, int ano, boolean ativo){
        try{
            // validamos se todos os campos estão preenchidos
            if (placa.isEmpty() || marca.isEmpty()){
                return "Preencha todos os campos!";
            }
            
            // verificamos se o veículo realmente existe antes de tentar atualizar
            if (persistencia.buscar(id) == null){
                return "Erro! Veículo não encontrado.";
            }
            
            // criamos o objeto pro veículo editado
            Veiculo veiculoEditado = new Veiculo(id, placa, marca, modelo, ano, ativo);
            
            // mandamos a persistência realizar a ação de atualizar
            persistencia.atualizar(veiculoEditado);
            return null;
        } catch (Exception erro){
            return "Erro ao atualizar: " + erro.getMessage();
        }
    }
    
    // MÉTODO REMOVER
    public String remover(int idVeiculo) {
        try {
            // 1. Primeiro verificamos se o veículo existe no banco/arquivo
            // Se o buscar retornar null, significa que não existe, então não dá pra remover.
            if (persistencia.buscar(idVeiculo) == null) {
                return "Erro! Veículo não encontrado para exclusão.";
            }

            // 2. Se chegou aqui, o veículo existe. Mandamos a persistência remover.
            persistencia.remover(idVeiculo);
            
            // 3. Retornamos null para avisar a tela que deu tudo certo (sem erros)
            return null;

        } catch (Exception erro) {
            // Caso ocorra algum erro técnico (ex: erro de arquivo), retornamos a mensagem
            return "Erro ao remover: " + erro.getMessage();
        }
    }
    
    // MÉTODO LISTAR 
    public ArrayList<Veiculo> listarTodos() throws Exception {
        return persistencia.listar();
    }
    
    // MÉTODO BUSCAR
    public Veiculo buscar(int id) throws Exception {
        return persistencia.buscar(id);
    }
}
