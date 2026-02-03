/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.classes;

/**
 *
 * @author aluno
 */
public class TipoDeDespesa {
    // Atributos
    private int idTipoDeDespesa; // Os atributos são definidos como privados para garantir maior segurança dos dados!!!
    private String descricao;
    
    // Métodos
    public TipoDeDespesa(){ // Construtor default, pois inicia com os dados em 0 ou null
        
    }
    
    public TipoDeDespesa(int idTipoDeDespesa, String descricao){ // Agora o construtor com parâmetros, para pegar os dados
        // digitados pelo usuário para outras classes usarem
       
        this.idTipoDeDespesa = idTipoDeDespesa;
        this.descricao = descricao;
    }
    
    // Por fim, os getters e setters
    public int getidTipoDeDespesa() {
        return idTipoDeDespesa;
    }

    public void idTipoDeDespesa(int idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
    return this.descricao; 
    }
}
