/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class FormPrincipalFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipalFuncionario
     */
    public FormPrincipalFuncionario() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRevisao = new javax.swing.JPanel();
        panelAtual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRevisao = new javax.swing.JTable();
        labelAtual = new javax.swing.JLabel();
        panelAcao = new javax.swing.JPanel();
        buttonSair = new javax.swing.JButton();
        buttonRevisao = new javax.swing.JButton();
        buttonControle = new javax.swing.JButton();
        buttonPesquisa = new javax.swing.JButton();
        buttonHistorico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelRevisao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        panelRevisao.setName(""); // NOI18N

        panelAtual.setText("Revisão Atual: ");

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
        jScrollPane1.setViewportView(tableRevisao);
        tableRevisao.getAccessibleContext().setAccessibleName("tableRevisao");

        labelAtual.setText("hue");

        javax.swing.GroupLayout panelRevisaoLayout = new javax.swing.GroupLayout(panelRevisao);
        panelRevisao.setLayout(panelRevisaoLayout);
        panelRevisaoLayout.setHorizontalGroup(
            panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRevisaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRevisaoLayout.createSequentialGroup()
                        .addComponent(panelAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAtual))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRevisaoLayout.setVerticalGroup(
            panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRevisaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRevisaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panelAtual)
                    .addComponent(labelAtual))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelAtual.getAccessibleContext().setAccessibleName("jPanelAtual");
        labelAtual.getAccessibleContext().setAccessibleName("labelAtual");

        panelAcao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        buttonSair.setText("Sair");
        buttonSair.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonRevisao.setText("Agendar Revisão");

        buttonControle.setText("Controle Cliente");
        buttonControle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonControleActionPerformed(evt);
            }
        });

        buttonPesquisa.setText("Pesquisar");

        buttonHistorico.setText("Histórico");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(buttonSair)
                .addContainerGap())
        );

        buttonRevisao.getAccessibleContext().setAccessibleName("buttonRevisao");
        buttonHistorico.getAccessibleContext().setAccessibleName("buttonHistorico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRevisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            this.dispose();

        }
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonControleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonControleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonControleActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAtual;
    private javax.swing.JPanel panelAcao;
    private javax.swing.JLabel panelAtual;
    private javax.swing.JPanel panelRevisao;
    private javax.swing.JTable tableRevisao;
    // End of variables declaration//GEN-END:variables
}
