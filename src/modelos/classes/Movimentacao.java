package modelos.classes;

public class Movimentacao {
    //Atributos
    private int idMovimentacao;
    private int idVeiculo; //armazena o id do veiculo escolhido
    private int idTipoDeDespesa; //armazena o id do tipo de despesa
    private String descricao;
    private String data; //vai ser utilizado String para deixar mais facil de se armzanar, por exemplo "02/12/2025"
    private double valor;
    
    //Métodos
    public Movimentacao(){}
    public Movimentacao(int idMovimentacao, int idVeiculo, int idTipoDeDespesa, String descricao, String data, double valor){
        this.idMovimentacao = idMovimentacao;
        this.idVeiculo = idVeiculo;
        this.idTipoDeDespesa = idTipoDeDespesa;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
    }

    public int getIdMovimentacao() {
        return idMovimentacao;
    }
    public void setIdMovimentacao(int idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }
    public int getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public int getIdTipoDeDespesa() {
        return idTipoDeDespesa;
    }
    public void setIdTipoDeDespesa(int idTipoDeDespesa) {
        this.idTipoDeDespesa = idTipoDeDespesa;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    //só pra testar se ta funcionando
    
    @Override
    public String toString(){
        return data + " - R$" + valor;
    }
    
}

