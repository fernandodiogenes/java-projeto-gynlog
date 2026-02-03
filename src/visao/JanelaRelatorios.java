
package visao;

import controladora.ControladoraDespesa;
import controladora.ControladoraMovimentacao;
import controladora.ControladoraVeiculo;
import controladora.ControladoraRelatorios;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import modelos.classes.Movimentacao;
import modelos.classes.TipoDeDespesa;
import modelos.classes.Veiculo;

public class JanelaRelatorios extends javax.swing.JFrame {


    public JanelaRelatorios() {
        initComponents();
    // centraliza na tela
    this.setLocationRelativeTo(null);
    
    // trava a janela para o usuário não esticar e estragar o layout
    this.setResizable(false);
    
    // carregamos (chamamos o método) a lista para que assim que o usuario abrir a janela ela esteja pronta pra ser usada
    carregarComboBoxVeiculos();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        cbTipoDeRelatorio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbVeiculo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jButtonGerarRelatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRelatorio = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        btnPdf = new javax.swing.JButton();

        jLabel3.setBackground(new java.awt.Color(255, 56, 119));
        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 56, 119));
        jLabel3.setText("PLACA");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(19, 41, 61));

        jLabel1.setBackground(new java.awt.Color(255, 56, 119));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(232, 241, 242));
        jLabel1.setText("Ano:");

        jPanel2.setBackground(new java.awt.Color(0, 100, 148));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel7.setText("RELATÓRIOS GERENCIAIS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(228, 228, 228))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(28, 28, 28))
        );

        btnVoltar.setBackground(new java.awt.Color(153, 0, 0));
        btnVoltar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        cbTipoDeRelatorio.setBackground(new java.awt.Color(27, 152, 224));
        cbTipoDeRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Despesas por Veículo", "Total de Despesas no Mês", "Gasto com Combustível no Mês", "Total IPVA no Ano", "Veículos Inativos", "Multas no Ano" }));
        cbTipoDeRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDeRelatorioActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 56, 119));
        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(232, 241, 242));
        jLabel2.setText("Tipo de Relatório:");

        cbVeiculo.setBackground(new java.awt.Color(27, 152, 224));
        cbVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Despesas por Veículo", "Total de Despesas no Mês", "Gasto com Combustível no Mês", "Total IPVA no Ano", "Veículos Inativos", "Multas no Ano" }));
        cbVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVeiculoActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 56, 119));
        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(232, 241, 242));
        jLabel4.setText("Veículo:");

        txtMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMesActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 56, 119));
        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(232, 241, 242));
        jLabel5.setText("Mês:");

        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });

        jButtonGerarRelatorio.setBackground(new java.awt.Color(27, 152, 224));
        jButtonGerarRelatorio.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButtonGerarRelatorio.setText("GERAR RELATÓRIO");
        jButtonGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarRelatorioActionPerformed(evt);
            }
        });

        tblRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Placa", "Modelo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRelatorio);

        lblTotal.setBackground(new java.awt.Color(255, 56, 119));
        lblTotal.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(232, 241, 242));
        lblTotal.setText("TOTAL: R$0,00");

        btnPdf.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnPdf.setText("GERAR PDF");
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVoltar)
                            .addComponent(jLabel2)
                            .addComponent(cbTipoDeRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnPdf)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(4, 4, 4)
                        .addComponent(cbTipoDeRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(cbVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaPrincipal menu = new TelaPrincipal();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    
    private void carregarComboBoxVeiculos(){
        try{
            // chamamos a controladora de veículos para pedir a lista dos veículos cadastrados 
            ControladoraVeiculo ctrl = new ControladoraVeiculo();
                ArrayList<Veiculo> lista = ctrl.listarTodos();
                
                // limpamos a combobox pra não duplicar itens se chamarmos novamente
                cbVeiculo.removeAllItems();
                
                // aqui adicionamos item por item 
                for (Veiculo v : lista){
                cbVeiculo.addItem(v.toString());
            }
            } catch (Exception erro){
                    System.out.println ("Erro ao carregar a lista de veículos: " + erro.getMessage());
                    }
        }
    
    private void jButtonGerarRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioActionPerformed
        try {
            // 1. Configuração Inicial e Instanciação das Controladoras
            int tipoSelecionado = cbTipoDeRelatorio.getSelectedIndex();
            
            ControladoraMovimentacao ctrlMov = new ControladoraMovimentacao();
            ControladoraVeiculo ctrlVeic = new ControladoraVeiculo();
            ControladoraDespesa ctrlDesp = new ControladoraDespesa();
            
            // Limpamos a tabela para receber os novos dados
            DefaultTableModel modelo = (DefaultTableModel) tblRelatorio.getModel();
            modelo.setRowCount(0); 
            
            double totalValor = 0.0;
            ArrayList<Movimentacao> listaResultado = new ArrayList<>();

            // 2. Verificamos qual o tipo de relatório selecionado
            switch (tipoSelecionado) {

                // CASE 0: DESPESAS POR VEÍCULO
                case 0:
                    modelo.setColumnIdentifiers(new String[] {"Data", "Tipo", "Descrição", "Valor (R$)"});
                    
                    ArrayList<Veiculo> todosVeiculos = ctrlVeic.listarTodos();
                    // Verifica se tem algum veículo selecionado no combo
                    if(cbVeiculo.getSelectedIndex() >= 0 && cbVeiculo.getSelectedIndex() < todosVeiculos.size()){
                        Veiculo veiculoSelecionado = todosVeiculos.get(cbVeiculo.getSelectedIndex());
                        listaResultado = ctrlMov.filtrarPorVeiculo(veiculoSelecionado.getIdVeiculo());
                    }
                    break;
                    
                // CASE 1: TOTAL DE DESPESAS NO MÊS
                case 1:
                    modelo.setColumnIdentifiers(new String[] {"Veículo", "Data", "Tipo", "Valor (R$)"});
                    
                    if(txtMes.getText().isEmpty() || txtAno.getText().isEmpty()) throw new Exception("Preencha Mês e Ano!");
                    
                    listaResultado = ctrlMov.filtrarPorMesAno(
                            Integer.parseInt(txtMes.getText()), 
                            Integer.parseInt(txtAno.getText())
                    );
                    break;
                    
                // CASE 2: GASTO COM COMBUSTÍVEL NO MÊS
                case 2:
                    modelo.setColumnIdentifiers(new String[] {"Veículo", "Data", "Descrição", "Valor (R$)"});
                    
                    if(txtMes.getText().isEmpty() || txtAno.getText().isEmpty()) throw new Exception("Preencha Mês e Ano!");

                    // Filtra buscando "Combustível". Certifique-se que cadastrou tipos com esse nome.
                    listaResultado = ctrlMov.filtrarPorTipoTermo("Combustível", 
                            Integer.parseInt(txtMes.getText()), 
                            Integer.parseInt(txtAno.getText()));
                    break;
                    
                // CASE 3: TOTAL IPVA NO ANO
                case 3:
                    modelo.setColumnIdentifiers(new String[] {"Veículo", "Data", "Descrição", "Valor (R$)"});
                    if(txtAno.getText().isEmpty()) throw new Exception("Preencha o Ano!");

                    listaResultado = ctrlMov.filtrarPorTipoTermo("IPVA", 0, Integer.parseInt(txtAno.getText()));
                    break;
                
                // CASE 4: VEÍCULOS INATIVOS (Caso Especial - Não usa Movimentação)
                case 4:
                    modelo.setColumnIdentifiers(new String[] {"ID", "Placa", "Modelo", "Status"});
                    ControladoraRelatorios ctrlRel = new ControladoraRelatorios(); 
                    ArrayList<Veiculo> listaInativos = ctrlRel.gerarRelatorioVeiculosInativos(); 
                    
                    if(listaInativos.isEmpty()){
                         JOptionPane.showMessageDialog(this, "Nenhum veículo inativo encontrado.");
                    } else {
                        for (Veiculo v : listaInativos) {
                            modelo.addRow(new Object[]{ v.getIdVeiculo(), v.getPlaca(), v.getModelo(), "Inativo" });
                        }
                    }
                    lblTotal.setText("Total: -");
                    return; // Encerra aqui pois este relatório é diferente dos outros
                    
                // CASE 5: MULTAS NO ANO
                case 5:
                    modelo.setColumnIdentifiers(new String[] {"Veículo", "Data", "Descrição", "Valor (R$)"});
                    if(txtAno.getText().isEmpty()) throw new Exception("Preencha o Ano!");

                    listaResultado = ctrlMov.filtrarPorTipoTermo("Multa", 0, Integer.parseInt(txtAno.getText()));
                    break;
            }

            // 3. Preenchimento da Tabela (Comum para os casos 0, 1, 2, 3, 5)
            
            if (listaResultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum registro encontrado para este filtro.");
            }

            for (Movimentacao m : listaResultado) {
                // Buscamos os nomes (Objetos) usando os IDs salvos na movimentação
                Veiculo v = ctrlVeic.buscar(m.getIdVeiculo());
                TipoDeDespesa t = ctrlDesp.buscar(m.getIdTipoDeDespesa());
                
                String nomeVeiculo = (v != null) ? v.getModelo() + " ("+v.getPlaca()+")" : "Excluído";
                String nomeTipo = (t != null) ? t.toString() : "Tipo Excluído";

                // Adiciona na tabela conforme a estrutura definida no switch
                if (tipoSelecionado == 0) { 
                     // Relatório por veículo não precisa repetir o nome do carro na linha
                     modelo.addRow(new Object[]{ m.getData(), nomeTipo, m.getDescricao(), m.getValor() });
                } else { 
                     // Os outros mostram qual é o veículo
                     modelo.addRow(new Object[]{ nomeVeiculo, m.getData(), nomeTipo, m.getValor() });
                }
                
                totalValor += m.getValor();
            }

            // Atualiza o Label de Total
            lblTotal.setText(String.format("TOTAL: R$ %.2f", totalValor));

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + erro.getMessage());
            // Opcional: imprimir erro no console para debug
            // erro.printStackTrace(); 
        }
    }//GEN-LAST:event_jButtonGerarRelatorioActionPerformed

    private void cbVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVeiculoActionPerformed
    }//GEN-LAST:event_cbVeiculoActionPerformed

    private void cbTipoDeRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDeRelatorioActionPerformed
        // descobrimos qual opção está marcada
        int tipo = cbTipoDeRelatorio.getSelectedIndex();
        
        // bloqueamos todas as opções e ativaremos apenas quando necessário
        cbVeiculo.setEnabled(false);
        txtMes.setEnabled(false);
        txtAno.setEnabled(false);
        
        switch (tipo){
            
            // DESPESAS POR VEÍCULO - é necessário informar o veículo
            case 0:
                cbVeiculo.setEnabled(true);
                break;
                
            // TOTAL MÊS e COMBUSTÍVEL MÊS - é necessário informar mês e ano
            case 1: 
            case 2:
                txtMes.setEnabled(true);
                txtAno.setEnabled(true);
                break;
                
            // IPVA ANO e MULTAS ANO - é necessário informar o ano
            case 3:
            case 5:
                txtAno.setEnabled(true);
                
            // VEÍCULOS INATIVOS - não é necessário informar nada
            case 4:
                break;
        }
    }//GEN-LAST:event_cbTipoDeRelatorioActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        // Verifica se a tabela tem dados antes de tentar imprimir
        if (tblRelatorio.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Gere um relatório antes de imprimir!");
            return;
        }

        try {
            // Título que vai aparecer no topo da folha
            java.text.MessageFormat header = new java.text.MessageFormat("Relatório GynLog");
            // Rodapé com número da página
            java.text.MessageFormat footer = new java.text.MessageFormat("Página {0,number,integer}");
            
            // O comando print abre a caixa de diálogo do Windows
            boolean completo = tblRelatorio.print(javax.swing.JTable.PrintMode.FIT_WIDTH, header, footer); 
            
            if (completo) {
                JOptionPane.showMessageDialog(this, "Exportação concluída!");
            } else {
                JOptionPane.showMessageDialog(this, "Exportação cancelada.");
            }
            
        } catch (java.awt.print.PrinterException pe) {
            JOptionPane.showMessageDialog(this, "Erro ao exportar: " + pe.getMessage());
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaRelatorios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPdf;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbTipoDeRelatorio;
    private javax.swing.JComboBox<String> cbVeiculo;
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblRelatorio;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtMes;
    // End of variables declaration//GEN-END:variables
}
