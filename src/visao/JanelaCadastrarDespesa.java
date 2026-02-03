package visao;
import controladora.ControladoraDespesa;
import controladora.ControladoraMovimentacao;
import modelos.classes.TipoDeDespesa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.PersistenciaMovimentacao;

public class JanelaCadastrarDespesa extends javax.swing.JFrame {
ControladoraDespesa Controladora = new ControladoraDespesa(); 


    public JanelaCadastrarDespesa() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        btnAtualizar.setEnabled(false);
        btnRemover.setEnabled(false);
        
        tableMostrar.getTableHeader().setReorderingAllowed(false);
        tableMostrar.setDefaultEditor(Object.class, null);
        
        mostrarDados();
        atualizarTabela();
    }

    public void mostrarDados(){
        try{
            // Busca a lista na controladora
            ArrayList<TipoDeDespesa> listagem = Controladora.listarTodos();
            DefaultTableModel model = (DefaultTableModel) tableMostrar.getModel();
            model.setNumRows(0); // Limpa a tabela

            if (listagem.isEmpty()) return;

            // Loop para adicionar cada item na tabela
            for (TipoDeDespesa objeto : listagem) {
                // Criamos um vetor com o tamanho de colunas da tabela (Geralmente 2: ID e Descrição)
                String[] linha = new String[2]; 
                
                linha[0] = objeto.getidTipoDeDespesa() + "";        // Coluna 0: ID
                linha[1] = objeto.getDescricao();      // Coluna 1: Descrição
                        
                model.addRow(linha);
            }
            } catch (Exception erro){
                
        }
    }
    private void limparTela(){
        txtId.setText("");
        txtDescricao.setText("");
        txtId.requestFocus();
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMostrar = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(19, 41, 61));
        setForeground(new java.awt.Color(19, 41, 61));

        jPanel1.setBackground(new java.awt.Color(0, 100, 148));

        jPanel2.setBackground(new java.awt.Color(19, 41, 61));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID da Despesa:");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descrição:");

        tableMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Descrição"
            }
        ));
        tableMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMostrarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMostrar);

        btnAtualizar.setBackground(new java.awt.Color(27, 152, 224));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(153, 0, 0));
        btnVoltar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSalvar.setBackground(new java.awt.Color(27, 152, 224));
        btnSalvar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(27, 152, 224));
        btnRemover.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnRemover.setText("REMOVER");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTO DE NOVA DESPESA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel1)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
       try {
            int id = Integer.parseInt(txtId.getText());
            String descricao = txtDescricao.getText();
            
            Controladora.atualizar(id, descricao);
            
            JOptionPane.showMessageDialog(this, "Atualizado com sucesso!");
            mostrarDados(); // Atualiza a tabela
            
            // Opcional: Limpar campos e resetar botões após atualizar
            txtId.setText("");
            txtDescricao.setText("");
            btnSalvar.setEnabled(true);
            btnAtualizar.setEnabled(false);
            btnRemover.setEnabled(false);
            txtId.setEnabled(true);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try{
            
            // 1. Pegar dados da tela
            int id = Integer.parseInt(txtId.getText());
            String descricao = txtDescricao.getText();

            // 2. Enviar para a controladora
            // (Verifique se seu método cadastrar aceita esses parametros)
            String erro = Controladora.cadastrar(id, descricao);

            // 3. Verificar resultado
            if (erro == null) {
                JOptionPane.showMessageDialog(this, "Sucesso! Tipo de despesa salvo!");
                
                // Limpar campos
                txtId.setText("");
                txtDescricao.setText("");
                txtId.requestFocus(); // Foco volta pro ID
                
                // Atualizar tabela
                mostrarDados();
                
            } else {
                JOptionPane.showMessageDialog(this, erro, "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID deve ser um número!", "Erro", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
}
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText());
            
            // --- BLINDAGEM DE INTEGRIDADE ---
            // Verifica se o tipo está em uso antes de apagar
            ControladoraMovimentacao ctrlMov = new ControladoraMovimentacao();
            ArrayList<modelos.classes.Movimentacao> movimentacoes = ctrlMov.listar(); // Importante importar Movimentacao
            
            for(modelos.classes.Movimentacao m : movimentacoes){
                if(m.getIdTipoDeDespesa() == id){
                    JOptionPane.showMessageDialog(this, "Não é possível excluir! Este tipo está sendo usado em movimentações.");
                    return;
                }
            }
            // -------------------------------

            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza?", "Confirmar", JOptionPane.YES_NO_OPTION);
            
            if (confirmacao == JOptionPane.YES_OPTION) {
                String erro = Controladora.remover(id);
                
                if (erro == null) {
                    JOptionPane.showMessageDialog(this, "Removido com sucesso!");
                    mostrarDados(); // ATUALIZA A TABELA
                    limparTela();
                    
                    btnSalvar.setEnabled(true);
                    btnAtualizar.setEnabled(false);
                    btnRemover.setEnabled(false);
                    txtId.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, erro);
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao remover: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tableMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMostrarMouseClicked
        int linha = tableMostrar.getSelectedRow(); // pega a linha selecionada

        if(linha >= 0){
            // Pega os valores das colunas (0 = ID, 1 = Descrição) e joga nos textos
            txtId.setText(tableMostrar.getValueAt(linha, 0).toString());
            txtDescricao.setText(tableMostrar.getValueAt(linha, 1).toString());
            
            // Lógica dos botões
            btnAtualizar.setEnabled(true);
            btnRemover.setEnabled(true);
            btnSalvar.setEnabled(false); // Não pode salvar novo enquanto edita
            txtId.setEnabled(false);     // Não pode mudar o ID de algo que já existe
        
    }
    }//GEN-LAST:event_tableMostrarMouseClicked

 
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastrarDespesa().setVisible(true);
            }
        });
    }

    private void atualizarTabela(){
        try{
            java.util.ArrayList<modelos.classes.TipoDeDespesa> lista = Controladora.listarTodos();
            
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tableMostrar.getModel();
            
            modelo.setRowCount(0);
            
            for(modelos.classes.TipoDeDespesa t : lista){
                modelo.addRow(new Object[]{
                   t.getidTipoDeDespesa(),
                    t.getDescricao()
                });
            }   
        }catch(Exception erro){
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + erro.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMostrar;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
