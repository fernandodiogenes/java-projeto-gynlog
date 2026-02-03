package persistencia;

import modelos.classes.Movimentacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import modelos.interfaces.IMovimentacaoCRUD;

public class PersistenciaMovimentacao implements IMovimentacaoCRUD{
    //define o caminho de onde vai ser salvo as despesas
    private String localDoArquivo = null; 
    
    public PersistenciaMovimentacao(){
        localDoArquivo =  "./src/bancodedados/Movimentacao.txt";
       
    }
    
    @Override
    public void salvar(Movimentacao movimentacao) throws Exception {
        try{
            //colocamos true para adicionar no final sem apagar o anterior
            FileWriter fw = new FileWriter(localDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            //agora, montamos a linha da movimentação separado por ponto e vírgula
            String str = movimentacao.getIdMovimentacao() + ";" +
                           movimentacao.getIdVeiculo() + ";" +
                           movimentacao.getIdTipoDeDespesa() + ";" +
                           movimentacao.getDescricao() + ";" + 
                           movimentacao.getData() + ";" + 
                           movimentacao.getValor() + "\n";
            bw.write(str);
            bw.close();
            
        }catch(Exception erro){
            String msg = "Persistência - Método Salvar - " + erro.getMessage();
            throw new Exception(msg);
        }
    }

    @Override
    public ArrayList<Movimentacao> listar() throws Exception {
        try{
            ArrayList<Movimentacao> lista = new ArrayList<>();
            File arquivo = new File(localDoArquivo);
            
            //se o arquivo não existir, ele retorna uma lista vazia
            if(!arquivo.exists()){
                return lista;
            }
            
            FileReader fr = new FileReader(localDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            
            String str = "";
            while((str = br.readLine()) != null){ // enquanto conseguir ler uma linha e ela não for nula, continue
                //convertemos os dados do texto para o objeto
                String[] vetor = str.split(";");
                int idMovimentação = Integer.parseInt(vetor[0]);
                int idVeiculo = Integer.parseInt(vetor[1]);
                int idTipoDeDespesa = Integer.parseInt(vetor[2]);
                String descricao = vetor[3];
                String data = vetor[4];
                double valor = Double.parseDouble(vetor[5]);
                //aqui criamos o objeto e adicionamos na lista
                Movimentacao m = new Movimentacao(idMovimentação, idVeiculo, idTipoDeDespesa, descricao, data, valor);
                lista.add(m);
            }
            br.close();
            return lista;
            
        }catch(Exception erro){
            String msg = "Persistência - Método Listar - " + erro.getMessage();
            throw new Exception(msg);
        }
        
    }

    @Override
    public Movimentacao buscar(int id) throws Exception {
        try{
            ArrayList<Movimentacao> lista = listar();
            for(Movimentacao m : lista){
                if(m.getIdMovimentacao() == id){
                    return m;
                }
            }
            return null;    
        }catch(Exception erro){
            String msg = "Persistência - Método Buscar - " + erro.getMessage();
            throw new Exception(msg);
        }
    }

    @Override
    public void atualizar(Movimentacao movimentacaoEditada) throws Exception {
        try{
            ArrayList<Movimentacao> lista = listar();
            boolean achou = false;
            
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i).getIdMovimentacao() == movimentacaoEditada.getIdMovimentacao()){   
                lista.set(i, movimentacaoEditada);
                achou = true;
                break;
                }
            }
            if(achou){
                reescreverArquivo(lista);
            }else{
                throw new Exception("Movimentação não foi encontrada para ser atualizada!");
            }
        }catch(Exception erro){
        String msg = "Persistência - Método Atualizar - " + erro.getMessage();
        throw new Exception(msg);
    }
    }

    @Override
    public void remover(int id) throws Exception {
        try{
            ArrayList<Movimentacao> lista = listar();
            boolean achou = false;
            
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i).getIdMovimentacao() == id){   
                lista.remove(i);
                achou = true;
                break;
                }
            }
            if(achou){
                reescreverArquivo(lista);
            }else{
                throw new Exception("Movimentação não foi encontrada para ser removida");
            }
            
        }catch(Exception erro){
            String msg = "Persistência - Método Remover - " + erro.getMessage();
            throw new Exception(msg);
        }
    }
    
    private void reescreverArquivo(java.util.ArrayList<modelos.classes.Movimentacao> lista) throws Exception {
        try {
            // 'false' apaga o arquivo velho e cria um novo
            java.io.FileWriter fw = new java.io.FileWriter(localDoArquivo, false);
            java.io.BufferedWriter bw = new java.io.BufferedWriter(fw);

            for (modelos.classes.Movimentacao m : lista) {
                // Monta a linha novamente para salvar
                // Nota: Verifique se os seus métodos são getId() ou getIdMovimentacao()
                String linha = m.getIdMovimentacao() + ";" +  
                               m.getIdVeiculo() + ";" +
                               m.getIdTipoDeDespesa() + ";" +
                               m.getDescricao() + ";" +
                               m.getData() + ";" +
                               m.getValor() + "\n";
                bw.write(linha);
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Erro crítico ao reescrever o arquivo de movimentações.");
        }
    }
}
