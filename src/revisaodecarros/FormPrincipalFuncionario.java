/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import Model.Agenda;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Control.AgendaControl;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class FormPrincipalFuncionario extends javax.swing.JFrame {
    ClockTest clock;
    ArrayList<Agenda> agenda = new ArrayList<Agenda>();
    AgendaControl conexao;
    
    public FormPrincipalFuncionario() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }
    public FormPrincipalFuncionario(String login){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        txtUser.setText(login);
        clock = new ClockTest(txtDate);
        conexao = new AgendaControl();
        Date data = new Date();
        agenda = conexao.getRevisaoPorPeriodo(data, data);
        
        //Montagem da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Hora");
        model.addColumn("Mecânico");
        model.addColumn("Cliente");
        model.addColumn("Carro");
            
        Integer i=0;
        while (i < agenda.size()) {
                Agenda agendinha = new Agenda();
                
                agendinha = agenda.get(i);
                model.addRow(new Object[]{agendinha.getData().toString(),agendinha.getHora(),agendinha.getCpfMecanicos().get(0),agendinha.getCliente().getNome(),agendinha.getCarro().getModelo()});
                i++;
        }
        
        //código que completará as textboxes
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRevisao = new javax.swing.JPanel();
        scrRevisao = new javax.swing.JScrollPane();
        tableRevisao = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtInicio = new javax.swing.JTextField();
        try{  
            javax.swing.text.MaskFormatter inicio = new javax.swing.text.MaskFormatter("##/##/####");
            txtInicio = new javax.swing.JFormattedTextField(inicio);
        }  
        catch (Exception e){  
        }
        jLabel2 = new javax.swing.JLabel();
        txtFim = new javax.swing.JTextField();
        try{  
            javax.swing.text.MaskFormatter fim = new javax.swing.text.MaskFormatter("##/##/####");
            txtFim = new javax.swing.JFormattedTextField(fim);
        }  
        catch (Exception e){  
        }
        panelAcao = new javax.swing.JPanel();
        buttonSair = new javax.swing.JButton();
        buttonRevisao = new javax.swing.JButton();
        buttonControle = new javax.swing.JButton();
        buttonPesquisa = new javax.swing.JButton();
        buttonHistorico = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelRevisao.setBorder(javax.swing.BorderFactory.createTitledBorder("Revisões Agendadas"));
        panelRevisao.setName(""); // NOI18N

        tableRevisao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrRevisao.setViewportView(tableRevisao);
        tableRevisao.getAccessibleContext().setAccessibleName("tableRevisao");

        jLabel1.setText("De:");
        jLabel1.setFocusable(false);
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        txtInicio.setEditable(false);
        txtInicio.setAutoscrolls(false);
        txtInicio.setFocusable(false);
        txtInicio.setRequestFocusEnabled(false);
        txtInicio.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("Até:");
        jLabel2.setFocusable(false);
        jLabel2.setRequestFocusEnabled(false);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        txtFim.setEditable(false);
        txtFim.setAutoscrolls(false);
        txtFim.setFocusable(false);
        txtFim.setRequestFocusEnabled(false);
        txtFim.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout panelRevisaoLayout = new javax.swing.GroupLayout(panelRevisao);
        panelRevisao.setLayout(panelRevisaoLayout);
        panelRevisaoLayout.setHorizontalGroup(
            panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRevisaoLayout.createSequentialGroup()
                .addGroup(panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRevisaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRevisaoLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRevisaoLayout.setVerticalGroup(
            panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRevisaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(scrRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelAcao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        buttonSair.setText("Sair");
        buttonSair.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonRevisao.setText("Agendar Revisão");
        buttonRevisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRevisaoActionPerformed(evt);
            }
        });

        buttonControle.setText("Controle Cliente");
        buttonControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonControleActionPerformed(evt);
            }
        });

        buttonPesquisa.setText("Pesquisar");
        buttonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisaActionPerformed(evt);
            }
        });

        buttonHistorico.setText("Histórico");
        buttonHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAcaoLayout = new javax.swing.GroupLayout(panelAcao);
        panelAcao.setLayout(panelAcaoLayout);
        panelAcaoLayout.setHorizontalGroup(
            panelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonControle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelAcaoLayout.createSequentialGroup()
                        .addComponent(buttonRevisao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAcaoLayout.setVerticalGroup(
            panelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonRevisao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonControle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHistorico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSair)
                .addContainerGap())
        );

        buttonRevisao.getAccessibleContext().setAccessibleName("buttonRevisao");
        buttonHistorico.getAccessibleContext().setAccessibleName("buttonHistorico");

        panelInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblUser.setText("Usuário:");

        lblDate.setText("Hora/Data:");

        javax.swing.GroupLayout panelInfoLayout = new javax.swing.GroupLayout(panelInfo);
        panelInfo.setLayout(panelInfoLayout);
        panelInfoLayout.setHorizontalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblUser)
                .addGap(12, 12, 12)
                .addComponent(txtUser)
                .addGap(18, 18, 18)
                .addComponent(lblDate)
                .addGap(6, 6, 6)
                .addComponent(txtDate))
        );
        panelInfoLayout.setVerticalGroup(
            panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUser)
                        .addComponent(txtUser))
                    .addComponent(lblDate)
                    .addComponent(txtDate))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRevisao.getAccessibleContext().setAccessibleName("panelRevisao");
        panelAcao.getAccessibleContext().setAccessibleName("panelAcao");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        int n = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que gostaria de sair?",
            "Sair",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            new FormLogin().setVisible(true);
            clock.stop();
            this.dispose();

        }
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonRevisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRevisaoActionPerformed
        new FormAgendaRevisao(this, txtUser.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonRevisaoActionPerformed

    private void buttonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisaActionPerformed
        //Abre uma janela que recebe as duas datas
        //agenda = conexao.getRevisaoPorPeriodo(data, data);
        
        //Montagem da tabela
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Hora");
        model.addColumn("Mecânico");
        model.addColumn("Cliente");
        model.addColumn("Carro");
            
        Integer i=0;
        while (i < agenda.size()) {
                Agenda agendinha = new Agenda();
                
                agendinha = agenda.get(i);
                model.addRow(new Object[]{agendinha.getData().toString(),agendinha.getHora(),agendinha.getCpfMecanicos().get(0),agendinha.getCliente().getNome(),agendinha.getCarro().getModelo()});
                i++;
        }
        //Muda as textBoxes
    }//GEN-LAST:event_buttonPesquisaActionPerformed

    private void buttonHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHistoricoActionPerformed
        new FormHistorico(this, txtUser.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonHistoricoActionPerformed

    private void buttonControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonControleActionPerformed
        new FormControleCliente(this, txtUser.getText()).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonControleActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int n = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que gostaria de sair?",
            "Sair",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            new FormLogin().setVisible(true);
            clock.stop();
            this.dispose();

        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FormPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipalFuncionario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonControle;
    private javax.swing.JButton buttonHistorico;
    private javax.swing.JButton buttonPesquisa;
    private javax.swing.JButton buttonRevisao;
    private javax.swing.JButton buttonSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelAcao;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel panelRevisao;
    private javax.swing.JScrollPane scrRevisao;
    private javax.swing.JTable tableRevisao;
    private javax.swing.JLabel txtDate;
    private javax.swing.JTextField txtFim;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
