package persistencia;

import java.util.ArrayList;
import modelos.classes.TipoDeDespesa;
import modelos.interfaces.ITipoDeDespesasCRUD;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PersistenciaDespesas implements ITipoDeDespesasCRUD {
    private String localDoArquivo = null;

    public PersistenciaDespesas() {
        // Garante que o caminho esteja correto
        localDoArquivo = "./src/bancodedados/TipoDeDespesas.txt";
    }

    @Override
    public void salvar(TipoDeDespesa tipoDeDespesa) throws Exception {
        try {
            FileWriter fw = new FileWriter(localDoArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            String str = tipoDeDespesa.getidTipoDeDespesa() + ";";
            str += tipoDeDespesa.getDescricao();
            
            bw.write(str);
            bw.newLine(); // Ordem correta: Escreve -> Enter
            
            bw.close();
        } catch (Exception erro) {
            throw new Exception("Erro ao salvar: " + erro.getMessage());
        }
    }

    @Override
    public ArrayList<TipoDeDespesa> listar() throws Exception {
        try {
            ArrayList<TipoDeDespesa> listagem = new ArrayList<>();
            File arquivo = new File(localDoArquivo);

            if (!arquivo.exists()) return listagem;

            FileReader fr = new FileReader(localDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";

            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue; // Ignora linhas vazias

                String[] vetor = linha.split(";");
                if (vetor.length < 2) continue; // Proteção contra linhas quebradas

                int IdTipoDeDespesa = Integer.parseInt(vetor[0]);
                String descricao = vetor[1];

                listagem.add(new TipoDeDespesa(IdTipoDeDespesa, descricao));
            }
            br.close();
            return listagem;
        } catch (Exception erro) {
            throw new Exception("Erro ao listar: " + erro.getMessage());
        }
    }

    @Override
    public TipoDeDespesa buscar(int idTipoDeDespesa) throws Exception {
        try {
            ArrayList<TipoDeDespesa> lista = listar();
            for (TipoDeDespesa obj : lista) {
                if (obj.getidTipoDeDespesa() == idTipoDeDespesa) return obj;
            }
            return null;
        } catch (Exception erro) {
            throw new Exception("Erro ao buscar: " + erro.getMessage());
        }
    }

    @Override
    public void atualizar(TipoDeDespesa novoTipoDeDespesa) throws Exception {
        try {
            ArrayList<TipoDeDespesa> lista = listar();
            boolean achou = false;

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getidTipoDeDespesa() == novoTipoDeDespesa.getidTipoDeDespesa()) {
                    lista.set(i, novoTipoDeDespesa);
                    achou = true;
                    break;
                }
            }

            if (achou) {
                reescreverArquivo(lista);
            } else {
                throw new Exception("Tipo de despesa não encontrado para atualizar");
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao atualizar: " + erro.getMessage());
        }
    }

    @Override
    public void remover(int idTipoDeDespesa) throws Exception {
        try {
            // CORREÇÃO CRÍTICA: Carregamos a lista antes de usar
            ArrayList<TipoDeDespesa> lista = listar(); 
            boolean achou = false;

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getidTipoDeDespesa() == idTipoDeDespesa) {
                    lista.remove(i);
                    achou = true;
                    break;
                }
            }

            if (achou) {
                reescreverArquivo(lista);
            } else {
                throw new Exception("ID não encontrado para exclusão.");
            }
        } catch (Exception erro) {
            throw new Exception("Erro ao remover: " + erro.getMessage());
        }
    }

    // Método auxiliar para evitar repetição de código no atualizar e remover
    private void reescreverArquivo(ArrayList<TipoDeDespesa> lista) throws Exception {
        FileWriter fw = new FileWriter(localDoArquivo, false); // false = Sobrescrever
        BufferedWriter bw = new BufferedWriter(fw);

        for (TipoDeDespesa obj : lista) {
            String str = obj.getidTipoDeDespesa() + ";" + obj.getDescricao();
            bw.write(str);
            bw.newLine();
        }
        bw.close();
    }
}