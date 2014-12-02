/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Control.CarroControl;
import Control.PecasControl;
import Model.Pecas;
import Model.Carro;
import java.awt.Color;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class FormAdicionarPecas extends javax.swing.JFrame {
    ClockTest clock;
    
    DefaultTableModel model;
    ArrayList<Pecas> pecas;
    PecasControl pecaControl;
    
    Integer km;
    Integer num_pecas;
    
    public FormPrincipalMecanico formPrincipal;
    /**
     * Creates new form FormAdicionarPecas
     */
    public FormAdicionarPecas() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }
    public FormAdicionarPecas(FormPrincipalMecanico form, Carro carro, Integer quilometragem, String nomeUsuario) {
        Integer i;
        formPrincipal = form;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        clock = new ClockTest(lbdataHora);  
        pecaControl = new PecasControl();
        nomeLogin.setText(nomeUsuario);
        
        // trata a tabela
        model = new DefaultTableModel();
        model.addColumn("Peça");
        model.addColumn("Garantia");

        tblPecas.setModel(model);
        tblPecas.setEnabled(true);
        
        i = 0;
        pecas = pecaControl.getPecasRevisao(quilometragem);
        while (i < pecas.size()) {
            Pecas aux = new Pecas();
            aux = pecas.get(i);
            model.addRow(new Object[]{aux.getDescricao(), aux.getGarantia()});
            i++;
        }
        num_pecas = i;
        km = quilometragem;
    }
    
    private void fecharFormulario(){
        int n = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que gostaria de sair sem salvar?",
            "Sair",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            formPrincipal.setVisible(true);
            clock.stop();
            this.dispose();
        }         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbAdicionar = new javax.swing.JButton();
        jbRemover = new javax.swing.JButton();
        jbSairSemSalvar = new javax.swing.JButton();
        jbSalvarSair = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        nomeLogin = new javax.swing.JLabel();
        dataHora = new javax.swing.JLabel();
        lbdataHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jbAdicionar.setText("Adicionar");
        jbAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdicionarActionPerformed(evt);
            }
        });

        jbRemover.setText("Remover");
        jbRemover.setEnabled(false);
        jbRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRemoverActionPerformed(evt);
            }
        });

        jbSairSemSalvar.setText("Sair sem salvar");
        jbSairSemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairSemSalvarActionPerformed(evt);
            }
        });

        jbSalvarSair.setText("Salvar e Sair");
        jbSalvarSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbRemover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jbSairSemSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
            .addComponent(jbSalvarSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(jbSairSemSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSalvarSair, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tabela Peças", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPecasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPecas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Login.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login.setText("Login:");

        nomeLogin.setText("jLabel2");

        dataHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dataHora.setText("Data/Hora:");

        lbdataHora.setText("jLabel4");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeLogin)
                .addGap(18, 18, 18)
                .addComponent(dataHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbdataHora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Login)
                    .addComponent(nomeLogin)
                    .addComponent(dataHora)
                    .addComponent(lbdataHora))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarSairActionPerformed
        int n = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que gostaria de salvar?",
            "Salvar e Sair",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            //add mais coisas aqui antes de sair
            // para retornar as pecas adicionadas
            ArrayList<Pecas> listapecas = new ArrayList<Pecas>();
            Pecas auxPeca = null;
            
            Integer i= num_pecas;
            Integer j =0;
            while(i<tblPecas.getRowCount()){
                auxPeca = new Pecas();
                j=0;
                while(j<1){
                    switch(j){
                        case 0:
                            auxPeca.setDescricao(tblPecas.getValueAt(i, j).toString());
                            break;
                        case 1:
                            auxPeca.setGarantia(parseInt(tblPecas.getValueAt(i, j).toString()));
                            break;
                        default:
                            break;
                    }
                    j++;
                }
                listapecas.add(auxPeca);                
                i++;
            }
            formPrincipal.setVisible(true);
            clock.stop();
            this.dispose();
        } 
    }//GEN-LAST:event_jbSalvarSairActionPerformed

    private void jbSairSemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSairSemSalvarActionPerformed
        fecharFormulario();
    }//GEN-LAST:event_jbSairSemSalvarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fecharFormulario();
    }//GEN-LAST:event_formWindowClosing

    private void jbAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdicionarActionPerformed
        ArrayList<Pecas> pecas = new ArrayList<Pecas>();
        Pecas peca = new Pecas();
        
        pecas = pecaControl.getPecasDemais(km);
        
        if(pecas != null){
            ArrayList<String> lista = new ArrayList<String>();
            Integer j = 0;
            while(j < pecas.size()){
                lista.add(pecas.get(j).getDescricao());
                j++;
            }
            Object [] choices = lista.toArray();

            //Input dialog with a combo box 
            String picked = (String)JOptionPane.showInputDialog(this, "Escolha a peça:"
                            , "Peças encontrados", JOptionPane.QUESTION_MESSAGE
                            , null, choices, choices[0]);
            j=0;
            while(j < pecas.size()){
                if(picked.compareTo(pecas.get(j).getDescricao()) == 0)
                    break;
                else
                    j++;
            }
            peca = pecas.get(j);
            
            model.addRow(new Object[]{peca.getDescricao(), peca.getGarantia()});
        }
        else
        {
            JOptionPane.showMessageDialog(this, "O sistema não retornou nenhuma peça", "Erro!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_jbAdicionarActionPerformed

    private void jbRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRemoverActionPerformed
        Integer i;

        int n = JOptionPane.showConfirmDialog(
                this,
                "Você tem certeza que deseja excluir a peça selecionada?",
                "Sair",
                JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            if(tblPecas.getSelectedRow() != -1)
            {
                if(tblPecas.getSelectedRow() > num_pecas-1)
                {
                    ((DefaultTableModel)tblPecas.getModel()).removeRow(tblPecas.getSelectedRow());
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Você não pode remover uma peça que faz parte da revisão que será feita!", "Erro!", JOptionPane.OK_OPTION);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Você precisa escolher uma peça para ser excluída", "Erro!", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_jbRemoverActionPerformed

    private void tblPecasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPecasMousePressed
        if(tblPecas.getSelectedRow() != -1)
        {
            jbRemover.enable(true);
        }
        else
        {
            jbRemover.enable(true);
        }
    }//GEN-LAST:event_tblPecasMousePressed

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
            java.util.logging.Logger.getLogger(FormAdicionarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdicionarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdicionarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdicionarPecas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdicionarPecas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JLabel dataHora;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdicionar;
    private javax.swing.JButton jbRemover;
    private javax.swing.JButton jbSairSemSalvar;
    private javax.swing.JButton jbSalvarSair;
    private javax.swing.JLabel lbdataHora;
    private javax.swing.JLabel nomeLogin;
    private javax.swing.JTable tblPecas;
    // End of variables declaration//GEN-END:variables
}
