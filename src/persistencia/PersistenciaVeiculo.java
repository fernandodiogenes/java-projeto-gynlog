
package persistencia;

import modelos.classes.Veiculo;
import modelos.interfaces.IVeiculoCRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;


public class PersistenciaVeiculo implements IVeiculoCRUD {
    // caminho do arquivo 
    private String localDoArquivo = null;

    public PersistenciaVeiculo() {
        // define onde o arquivo será salvo
        localDoArquivo = "./src/bancodedados/Veiculos.txt";
    }

    // Método SALVAR
    @Override
    public void salvar(Veiculo veiculo) throws Exception {
        try{
        FileWriter fw = new FileWriter(localDoArquivo, true); // o "true" funciona para adicionar sem apagar o anterior!!
        BufferedWriter bw = new BufferedWriter(fw);

        // aqui montamos a linha: ID;Placa;Marca;Modelo;Ano;Ativo
        String str = veiculo.getIdVeiculo() + ";" + 
                     veiculo.getPlaca() + ";" + 
                     veiculo.getMarca() + ";" + 
                     veiculo.getModelo() + ";" + 
                     veiculo.getAnoFabricacao() + ";" + 
                     veiculo.isAtivo() + "\n";

        bw.write(str);
        bw.close(); // fecha o arquivo pra salvar
        
        } catch (Exception erro) {
            String msg = "Persistência - Método Salvar - " + erro.getMessage(); // mostra o erro técnico no console 
            throw new Exception(msg);
        }
    }

    // Método LISTAR 
    @Override
    public ArrayList<Veiculo> listar() throws Exception {
        try{
        ArrayList<Veiculo> lista = new ArrayList<>();
        File arquivo = new File(localDoArquivo);

        // se o arquivo não existe (primeira vez rodando), retorna uma lista vazia
        if (!arquivo.exists()) {
            return lista;
        }

        FileReader fr = new FileReader(localDoArquivo);
        BufferedReader br = new BufferedReader(fr);

        String linha = "";
        // lê linha por linha enquanto tiver texto. quando acabar, para a leitura
        while ((linha = br.readLine()) != null) {
            // o split serve para separar cada dado e criar um vetor para ele cada vez que tiver um ";"
            String[] vetor = linha.split(";");
            
            // agora em ordem, transformamos o texto em dados do veículo
            // fazemos uma espécie de tradução, transformando o texto em um número e vice-versa
            int id = Integer.parseInt(vetor[0]);
            String placa = vetor[1];
            String marca = vetor[2];
            String modelo = vetor[3];
            int ano = Integer.parseInt(vetor[4]);
            boolean ativo = Boolean.parseBoolean(vetor[5]); // converte o texto "true" para booleano (verdadeiro/falso)
            
            // cria o objeto veiculo com todos os dados prontinhos e põe na lista
            lista.add(new Veiculo(id, placa, marca, modelo, ano, ativo));
        }
        br.close();
        return lista;
        
        } catch (Exception erro) {
            String msg = "Erro ao ler a lista de veículos." + erro.getMessage();
            throw new Exception(msg);
        }
    }
    
    // Método BUSCAR
    @Override
    public Veiculo buscar(int id) throws Exception {
        try{
        
        ArrayList<Veiculo> lista = listar();
        for (Veiculo v : lista) {
            if (v.getIdVeiculo() == id) return v;
        }
        return null;
        } catch (Exception erro) {
            String msg = "Persistência - ID não encontrado" + erro.getMessage();
            throw new Exception(msg);
        }
    }

    // Método ATUALIZAR
    @Override
    public void atualizar(Veiculo veiculoNovo) throws Exception {
        try{
        ArrayList<Veiculo> lista = listar(); // pega todos os dados
        
        boolean achou = false;
        // troca o arquivo velho pelo arquivo novo na lista
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdVeiculo() == veiculoNovo.getIdVeiculo()) {
                lista.set(i, veiculoNovo);
                achou = true;
                break;
            }
        }
            
        if(achou){
            // o "false" serve para apagar o arquivo velho e criar um novo em branco
            FileWriter fw = new FileWriter(localDoArquivo, false); 
            BufferedWriter bw = new BufferedWriter(fw);
            
            // escreve novamente a lista inteira (já atualizada) no arquivo novo
            for (Veiculo v : lista) {
                String str = v.getIdVeiculo() + ";" + v.getPlaca() + ";" + v.getMarca() + ";" + 
                             v.getModelo() + ";" + v.getAnoFabricacao() + ";" + v.isAtivo() + "\n";
                bw.write(str);
            }
            bw.close(); // fecha e salva
        } else {
            throw new Exception("Veículo não encontrado para atualizar.");
        }
        
        } catch (Exception erro) { 
            String msg = "Persistência - Erro ao atualizar o veículo" + erro.getMessage();
            throw new Exception(msg);
        }
    }

    // Método REMOVER
    @Override
    public void remover(int id) throws Exception {
        try { 
            ArrayList<Veiculo> lista = listar();
            
            boolean achou = false;

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getIdVeiculo() == id) {
                    lista.remove(i);
                    achou = true;
                    break;
                }
            } 
            
            if(achou){
                FileWriter fw = new FileWriter(localDoArquivo, false); 
                BufferedWriter bw = new BufferedWriter(fw);
                
                for (Veiculo v : lista) {
                    String str = v.getIdVeiculo() + ";" + v.getPlaca() + ";" + v.getMarca() + ";" + 
                                 v.getModelo() + ";" + v.getAnoFabricacao() + ";" + v.isAtivo() + "\n";
                    bw.write(str);
                }
                bw.close(); 
            } else {
                throw new Exception("Veículo não encontrado para remover.");
            }

        } catch (Exception erro) {
            String msg = "Erro ao remover veículo" + erro.getMessage();
            throw new Exception(msg);
        }
    }
}