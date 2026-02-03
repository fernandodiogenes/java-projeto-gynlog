package controladora;
import java.util.ArrayList;
import persistencia.PersistenciaMovimentacao;
import modelos.classes.Movimentacao;
import modelos.classes.Veiculo;
import modelos.classes.TipoDeDespesa;
import controladora.ControladoraVeiculo;
import controladora.ControladoraDespesa;

public class ControladoraMovimentacao {
    // conversamos com a controladora de veiculo e despesa para ver se os dados realmente existem
    private PersistenciaMovimentacao persistencia;
    private ControladoraVeiculo controlVeiculo;
    private ControladoraDespesa controlDespesa;
    
    public ControladoraMovimentacao(){
        // aqui criamos a instância de cada objeto, ou seja, o que antes era uma variável vazia agora existe de verdade e pode ser usada
        this.persistencia = new PersistenciaMovimentacao();
        this.controlVeiculo = new ControladoraVeiculo();
        this.controlDespesa = new ControladoraDespesa();
    }
    
    // MÉTODO CADASTRAR
    public String cadastrar(int idVeiculo, int idTipoDeDespesa, String descricao, String data, double valor){
        try{
            //primeiro, começaremos com as validações
            if(valor <= 0) return "Erro! É necessário que o valor seja maior que 0";
            if(descricao == null || descricao.trim().isEmpty()) return "Erro! É necessário que a descrição seja preenchida";
            if(data == null || data.trim().isEmpty()) return "Erro! É necessário colocar uma data";
            
            //depois, fazemos a validação que relacionam os modelos
            if(controlVeiculo.buscar(idVeiculo) == null) return "Erro! Não foi possível encontrar este veículo";
            if(controlDespesa.buscar(idTipoDeDespesa) == null) return "Erro! Não possível encontrar esse tipo de despesa";
            
            //agora vamos gerar o id
            // essa linha serve para ir no arquivo e trazer tudo que já tem salvo para a memória
            ArrayList<Movimentacao> listaAtual = persistencia.listar();
            int idNovo = 0; // cria uma variável temporária para guardar o ID que vamos criar
            if(listaAtual.isEmpty()){ // se a lista estiver vaiza, esse ID será o primeiro, ou seja, 1
                idNovo = 1;
            }else{
                idNovo = listaAtual.get(listaAtual.size() -1).getIdMovimentacao() + 1; // se não, pegamos o índice do último item da lista e soma 1
            }
            //depois criamos o objeto Movimentacao e mandamos salvar com todos os dados validados e o novo id
            Movimentacao novaMovimentacao = new Movimentacao(idNovo, idVeiculo, idTipoDeDespesa, descricao, data, valor);
            persistencia.salvar(novaMovimentacao);
            
            return null; 
            
        }catch(Exception erro){
            return "Erro no salvamento de despesa: " + erro.getMessage();
        }
    }
    
    // MÉTODO ATUALIZAR
    public String atualizar(int idMovimentacao, int idVeiculo, int idTipoDeDespesa, String descricao, String data, double valor){
    try{
        if(valor <= 0) return "Valor inválido";
        if(descricao.isEmpty()) return "É necessário colocar uma descrição";
        
        // aqui verifica se a movimentação que queremos editar existe mesmo
        if(persistencia.buscar(idMovimentacao) == null) return "Erro! Não foi possível encontrar a movimentação";
        /// verifica de novo se Veículo e Despesa existem (vai que o usuário excluiu o veículo enquanto editava a despesa)
        if(controlVeiculo.buscar(idVeiculo) == null) return "Erro! Não foi possível encontrar o veículo";
        if(controlDespesa.buscar(idTipoDeDespesa) == null) return "Erro! Não foi possível encontrar o tipo de despesa";
        
        // criamos um novo objeto com os dados alterados, mas mantendo o mesmo ID antigo
        Movimentacao movimentacaoEditada = new Movimentacao(idMovimentacao, idVeiculo, idTipoDeDespesa, descricao, data, valor);
        // manda a persistência substituir o velho pelo novo
        persistencia.atualizar(movimentacaoEditada);
        
        return null;
        
    }catch(Exception erro){
     return "Erro ao atualizar" + erro.getMessage();   
        
    }
    }
    
    // MÉTODO REMOVER
    public String remover(int id){
        try{
          if(persistencia.buscar(id) == null) return "Erro! Não foi possível encontrar a movimentação";
          persistencia.remover(id);
          return null;
        }catch(Exception erro){
            return "Erro! Não foi possível remover" + erro.getMessage();
        }
    }
    
    //método listar
    public ArrayList<Movimentacao> listar() throws Exception{
        return persistencia.listar();
    }
    
    //método buscar
    public Movimentacao buscar(int id)throws Exception{
        return persistencia.buscar(id);
    }
    
    //esses são métodos para ajudar a tela na seleção das combobox
    public ArrayList<Veiculo> listarVeiculosParaCombo() throws Exception {
        return controlVeiculo.listarTodos();
    }
    
    public ArrayList<TipoDeDespesa> listarTiposParaCombo() throws Exception {
        return controlDespesa.listarTodos();
    }

    // filtra apenas as despesas de um veículo específico
    public ArrayList<Movimentacao> filtrarPorVeiculo(int idVeiculo) throws Exception {
        ArrayList<Movimentacao> todas = persistencia.listar(); // busca tudo que tem no banco de dados
        ArrayList<Movimentacao> filtradas = new ArrayList<>(); // cria uma lista nova, só para os veículos selecionados
        
        for (Movimentacao m : todas) { // para cada movimentação m que estiver dentro da lista todas
            if (m.getIdVeiculo() == idVeiculo) { // se o id do veículo dessa movimentação for igual ao id que eu estou buscando, adicionamos na lista filtradas
                filtradas.add(m);
            }
        }
        return filtradas;
    }

    // filtramos por Mês e Ano (Ex: Todas as despesas de 12/2025)
    public ArrayList<Movimentacao> filtrarPorMesAno(int mes, int ano) throws Exception {
        ArrayList<Movimentacao> todas = persistencia.listar();
        ArrayList<Movimentacao> filtradas = new ArrayList<>();
        
        for (Movimentacao m : todas) {
            // a data vem como String "dd/mm/aaaa". Vamos quebrar ela nas barras "/"
            String[] partesData = m.getData().split("/"); // corta o texto onde tiver a barra / e cria um vetor (vetor para dia, mês e ano)
            
            if (partesData.length == 3) { // a data só entra de realmente tiver 3 pares (dia, mês e ano)
                
                //convertemos o texto (string) para número (int)
                int mesDespesa = Integer.parseInt(partesData[1]); 
                int anoDespesa = Integer.parseInt(partesData[2]);
                
                // comparamos com o mês e ano que o usuário pediu. se bater, adicionamos na lista final
                if (mesDespesa == mes && anoDespesa == ano) {
                    filtradas.add(m);
                }
            }
        }
        return filtradas;
    }

    // Filtra por Ano e por um termo no Nome do Tipo (ex: "IPVA", "Multa", "Combustível")
    // Se passar mes = 0, ele ignora o mês (usado para relatórios anuais)
    public ArrayList<Movimentacao> filtrarPorTipoTermo(String termo, int mes, int ano) throws Exception {
        
        ArrayList<Movimentacao> todas = persistencia.listar();
        ArrayList<Movimentacao> filtradas = new ArrayList<>();
        
        String termoLimpo = normalizarTexto(termo); // chamamos ma função para deixar minúsculo e tirar o acento do que o usuário digitou
        
        // para cada movimentação, ele vai no banco de despesas buscar qual é o Nome desse tipo (ex: ele pega o ID 5 e descobre que é Gasolina)
        for (Movimentacao m : todas) { 
            TipoDeDespesa tipo = controlDespesa.buscar(m.getIdTipoDeDespesa());
            
            if (tipo != null) {
                // limpa o nome que vem do banco
                String nomeTipoLimpo = normalizarTexto(tipo.getDescricao());
                
                if (nomeTipoLimpo.contains(termoLimpo)) {
                    String[] partesData = m.getData().split("/");
                    int mesDespesa = Integer.parseInt(partesData[1]);
                    int anoDespesa = Integer.parseInt(partesData[2]);

                    // criamos um booleano para checar se o ano é igual (true ou false)
                    boolean dataBate = (anoDespesa == ano);
                    if (mes > 0) { 
                        dataBate = dataBate && (mesDespesa == mes);
                    }

                    if (dataBate) {
                        filtradas.add(m);
                    }
                }
            }
        }
        return filtradas;
    }
    
    // Remove acentos e deixa minúsculo
    private String normalizarTexto(String str) {
        if (str == null) return "";
        String nfdNormalizedString = java.text.Normalizer.normalize(str, java.text.Normalizer.Form.NFD); 
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("").toLowerCase();
    }
}
