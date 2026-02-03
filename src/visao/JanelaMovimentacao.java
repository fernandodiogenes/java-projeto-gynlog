package visao;
import controladora.ControladoraDespesa;
import modelos.classes.Veiculo;
import modelos.classes.TipoDeDespesa; 
import controladora.ControladoraMovimentacao;
import controladora.ControladoraVeiculo;
import javax.swing.JOptionPane;

public class JanelaMovimentacao extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JanelaMovimentacao.class.getName());

    public JanelaMovimentacao() {
        initComponents();
        setLocationRelativeTo(null); // centralizamos a janela na tela
        this.setResizable(false);
        
        tblMovimentacao.getTableHeader().setReorderingAllowed(false);
        tblMovimentacao.setDefaultEditor(Object.class, null);
        
        carregarCombos();   
        
        atualizarTabela(); 
        
        // Bloqueia botões de edição inicialmente
        btnAtualizar.setEnabled(false);
        btnRemover.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbVeiculo = new javax.swing.JComboBox<>();
        cmbDespesa = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        btnLancar1 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimentacao = new javax.swing.JTable();
        btnAtualizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 100, 148));

        jPanel2.setBackground(new java.awt.Color(19, 41, 61));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VEÍCULO:");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIPO DE DESPESA:");

        cmbVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVeiculo.addActionListener(this::cmbVeiculoActionPerformed);

        cmbDespesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DESCRIÇÃO:");

        txtDescricao.addActionListener(this::txtDescricaoActionPerformed);

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DATA:");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("VALOR(R$):");

        btnVoltar.setBackground(new java.awt.Color(153, 0, 0));
        btnVoltar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        btnLancar1.setBackground(new java.awt.Color(27, 152, 224));
        btnLancar1.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnLancar1.setText("LANÇAR DESPESA");
        btnLancar1.addActionListener(this::btnLancar1ActionPerformed);

        txtId.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        txtId.setText("ID");
        txtId.setEnabled(false);
        txtId.addActionListener(this::txtIdActionPerformed);

        tblMovimentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Veículo", "Tipo", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMovimentacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMovimentacao);

        btnAtualizar.setBackground(new java.awt.Color(27, 152, 224));
        btnAtualizar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        btnRemover.setBackground(new java.awt.Color(27, 152, 224));
        btnRemover.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnRemover.setText("REMOVER");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(this::btnRemoverActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21)
                        .addComponent(cmbDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19)
                                .addComponent(cmbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 46, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(20, 20, 20)
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(22, 22, 22)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(17, 17, 17)
                                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(btnLancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(cmbDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(btnLancar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MOVIMENTAÇÃO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(278, 278, 278))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
      this.dispose();
      
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnLancar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancar1ActionPerformed
      try{
          
      //aqui pegamos os dados que são String   
      String descricao = txtDescricao.getText();
      String data = txtData.getText();
      String valorTxt = txtValor.getText();
      
      //agora, verificamos se todos os campos estão preenchidos
      if(descricao.isEmpty() || data.isEmpty() || valorTxt.isEmpty()){
          JOptionPane.showMessageDialog(this, "É necessário preencher todos os campos!");
          return;
      }
      //aqui, nós fazemos a conversão do valor de texto para double
      double valor = Double.parseDouble(valorTxt.replace(",", "."));
      
      Veiculo veiculoSelecionado = (Veiculo) cmbVeiculo.getSelectedItem();
      TipoDeDespesa tipoSelecionado = (TipoDeDespesa) cmbDespesa.getSelectedItem();
      
      
      //aqui recebemos as escolhas de veículo e de tipo de despesa
      if (veiculoSelecionado == null || tipoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "É necessário escolher um veículo e um tipo de despesa!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
      
      
      
      //aqui vamos chamar a controladora de movimentação
      ControladoraMovimentacao control = new ControladoraMovimentacao();
      String erro = control.cadastrar(
                    veiculoSelecionado.getIdVeiculo(), 
                    tipoSelecionado.getidTipoDeDespesa(),                     descricao, 
                    data, 
                    valor
            );
      if (erro == null) {
                JOptionPane.showMessageDialog(this, "Despesa lançada com sucesso!");
                limparTela();
                
                atualizarTabela();
                
            } else {
                JOptionPane.showMessageDialog(this, erro, "Erro ao Salvar", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException erro) {
            JOptionPane.showMessageDialog(this, "O valor deve ser numérico!", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro técnico: " + erro.getMessage());
        }
    }
     

        private void limparTela(){
            txtDescricao.setText("");
            txtData.setText("");
            txtValor.setText("");
            
            if(cmbVeiculo.getItemCount() > 0) cmbVeiculo.setSelectedItem(0);
            if(cmbDespesa.getItemCount() > 0) cmbDespesa.setSelectedItem(0);
            txtDescricao.requestFocus();
         
    }//GEN-LAST:event_btnLancar1ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void tblMovimentacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMovimentacaoMouseClicked
        int linha = tblMovimentacao.getSelectedRow();
        if (linha >= 0) {
            try {
                // 1. Pega o ID da linha clicada
                int idMov = Integer.parseInt(tblMovimentacao.getValueAt(linha, 0).toString());
                txtId.setText(idMov + ""); // Joga no campo escondido

                // 2. Busca o objeto completo no banco para pegar os detalhes
                ControladoraMovimentacao ctrl = new ControladoraMovimentacao();
                modelos.classes.Movimentacao m = ctrl.buscar(idMov);

                if (m != null) {
                    // 3. Preenche os textos
                    txtDescricao.setText(m.getDescricao());
                    txtData.setText(m.getData());
                    txtValor.setText(m.getValor() + "");

                    // 4. Seleciona os Combos usando aquele método auxiliar mágico
                    selecionarItemPeloId(cmbVeiculo, m.getIdVeiculo());
                    selecionarItemPeloId(cmbDespesa, m.getIdTipoDeDespesa());

                    // 5. Ajusta botões
                    btnLancar1.setEnabled(false); // Bloqueia criar novo
                    btnAtualizar.setEnabled(true);
                    btnRemover.setEnabled(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao selecionar: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_tblMovimentacaoMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText()); // Pega o ID do campo cinza
            
            // Pega dados da tela
            modelos.classes.Veiculo v = (modelos.classes.Veiculo) cmbVeiculo.getSelectedItem();
            modelos.classes.TipoDeDespesa t = (modelos.classes.TipoDeDespesa) cmbDespesa.getSelectedItem();
            String desc = txtDescricao.getText();
            String data = txtData.getText();
            double valor = Double.parseDouble(txtValor.getText().replace(",", "."));

            ControladoraMovimentacao ctrl = new ControladoraMovimentacao();
            // Chama o atualizar passando todos os IDs
            String erro = ctrl.atualizar(id, v.getIdVeiculo(), t.getidTipoDeDespesa(), desc, data, valor);

            if (erro == null) {
                JOptionPane.showMessageDialog(this, "Atualizado com sucesso!");
                atualizarTabela(); // Atualiza a lista
                limparTela();      // Limpa os campos
                
                // Reseta botões
                btnLancar1.setEnabled(true);
                btnAtualizar.setEnabled(false);
                btnRemover.setEnabled(false);
                txtId.setText("");
            } else {
                JOptionPane.showMessageDialog(this, erro);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText());
            
            int confirma = JOptionPane.showConfirmDialog(this, "Tem certeza?", "Remover", JOptionPane.YES_NO_OPTION);
            
            if (confirma == JOptionPane.YES_OPTION) {
                ControladoraMovimentacao ctrl = new ControladoraMovimentacao();
                String erro = ctrl.remover(id);

                if (erro == null) {
                    JOptionPane.showMessageDialog(this, "Removido com sucesso!");
                    atualizarTabela();
                    limparTela();
                    
                    btnLancar1.setEnabled(true);
                    btnAtualizar.setEnabled(false);
                    btnRemover.setEnabled(false);
                    txtId.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, erro);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cmbVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVeiculoActionPerformed
 
        private void carregarCombos() {
        try {
            // 1. Instancia a controladora que tem acesso às listas
            controladora.ControladoraMovimentacao ctrl = new controladora.ControladoraMovimentacao();
            
            // 2. Preenchendo o Combo de VEÍCULOS
            java.util.ArrayList<modelos.classes.Veiculo> listaVeiculos = ctrl.listarVeiculosParaCombo();
            
            cmbVeiculo.removeAllItems(); // Limpa antes de encher
            for (modelos.classes.Veiculo v : listaVeiculos) {
                // Adiciona o OBJETO inteiro. O Java vai usar o toString() dele para mostrar o nome.
                cmbVeiculo.addItem(v);
            }
            
            // 3. Preenchendo o Combo de TIPOS DE DESPESA
          
            java.util.ArrayList<modelos.classes.TipoDeDespesa> listaTipos = ctrl.listarTiposParaCombo();
            cmbDespesa.removeAllItems();
            for (modelos.classes.TipoDeDespesa t : listaTipos) {
                cmbDespesa.addItem(t);
            }
            
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar listas: " + e.getMessage());
        }
        }
    
        // 1. Método para preencher a tabela lá embaixo
    private void atualizarTabela() {
        try {
            // Instancia as controladoras necessárias
            ControladoraMovimentacao ctrlMov = new ControladoraMovimentacao();
            ControladoraVeiculo ctrlVeic = new ControladoraVeiculo();
            ControladoraDespesa ctrlDesp = new ControladoraDespesa();

            // Pega a lista de movimentações
            java.util.ArrayList<modelos.classes.Movimentacao> lista = ctrlMov.listar();

            // Configura a tabela
            javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tblMovimentacao.getModel();
            modelo.setRowCount(0); // Limpa tabela
            
         

            for (modelos.classes.Movimentacao m : lista) {
                // Buscamos os nomes para ficar bonito na tabela
                modelos.classes.Veiculo v = ctrlVeic.buscar(m.getIdVeiculo());
                modelos.classes.TipoDeDespesa t = ctrlDesp.buscar(m.getIdTipoDeDespesa());

                String nomeVeiculo = (v != null) ? v.getPlaca() : "Excluído";
                String nomeTipo = (t != null) ? t.getDescricao() : "Excluído";

                modelo.addRow(new Object[]{
                    m.getIdMovimentacao(),
                    nomeVeiculo,
                    nomeTipo,
                    m.getValor()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar tabela: " + e.getMessage());
        }
    }


    // 2. Método auxiliar para selecionar o item certo na ComboBox pelo ID
    // Esse método "varre" a caixinha até achar o veículo/tipo com o ID certo
    private void selecionarItemPeloId(javax.swing.JComboBox combo, int idBusca) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            Object item = combo.getItemAt(i);
            
            // Verifica se é Veículo
            if (item instanceof modelos.classes.Veiculo) {
                if (((modelos.classes.Veiculo) item).getIdVeiculo() == idBusca) {
                    combo.setSelectedIndex(i);
                    return;
                }
            }
            // Verifica se é Tipo de Despesa
            else if (item instanceof modelos.classes.TipoDeDespesa) {
                if (((modelos.classes.TipoDeDespesa) item).getidTipoDeDespesa() == idBusca) {
                    combo.setSelectedIndex(i);
                    return;
                }
            }
        }
    
        }   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new JanelaMovimentacao().setVisible(true));
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLancar1;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Object> cmbDespesa;
    private javax.swing.JComboBox<Object> cmbVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMovimentacao;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables

}
