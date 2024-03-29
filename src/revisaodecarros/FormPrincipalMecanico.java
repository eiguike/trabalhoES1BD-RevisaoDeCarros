/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import Control.ConexaoBD;
import java.sql.*;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Control.MecanicoControl;
import Model.AgendaMecanico;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aluno
 */
public class FormPrincipalMecanico extends javax.swing.JFrame {
    ClockTest clock;
    MecanicoControl mecanicoControl;
    ArrayList<AgendaMecanico> lista;
    AgendaMecanico instancia;
    AgendaMecanico instanciaAux;
  
    ActionListener actListner = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            atualizarInstancia();
        }
    };
    Timer timer = new Timer(1*1000, actListner);
    /**
     * Creates new form FormPrincipalMecanico
     */
    public FormPrincipalMecanico(String nomeUsuario) {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        jLabel3.setText(nomeUsuario);
        clock = new ClockTest(relogio); 
        
        mecanicoControl = new MecanicoControl();
        lista = atualizarTabela(new Date(), new Date());
        if(lista != null){
            jLabel6.setText(lista.get(0).getCliente().getNome());
        }else{
            jLabel6.setText("Nenhum agendamento");            
        }


        timer.start();       

    }
    public void atualizarInstancia(){
        Date data = new Date();
        Integer i;
        if(lista != null){
            if(data.getHours() >= 8 && data.getHours() < 10){
                for(i=0;i<lista.size();i++){
                    if(parseInt(lista.get(i).getHora().substring(0, 2))==8){
                        jLabel6.setText(lista.get(i).getCliente().getNome());
                        instancia = lista.get(i);
                        return;
                    }
                }
            }
            if(data.getHours() >= 10 && data.getHours() < 12){
                for(i=0;i<lista.size();i++){
                    if(parseInt(lista.get(i).getHora().substring(0, 2))==10){
                        jLabel6.setText(lista.get(i).getCliente().getNome());
                        instancia = lista.get(i);
                        return;
                    }
                }            
            }
            if(data.getHours() >= 10 && data.getHours() < 12){
                for(i=0;i<lista.size();i++){
                    if(parseInt(lista.get(i).getHora().substring(0, 2))==10){
                        jLabel6.setText(lista.get(i).getCliente().getNome());
                        instancia = lista.get(i);
                        return;
                    }
                }            
            }            
            if(data.getHours() >= 12 && data.getHours() < 14){
                for(i=0;i<lista.size();i++){
                    if(parseInt(lista.get(i).getHora().substring(0, 2))==12){
                        jLabel6.setText(lista.get(i).getCliente().getNome());
                        instancia = lista.get(i);
                        return;
                    }
                }            
            }
            if(data.getHours() >= 16 && data.getHours() < 18){
                for(i=0;i<lista.size();i++){
                    if(parseInt(lista.get(i).getHora().substring(0, 2))==16){
                        jLabel6.setText(lista.get(i).getCliente().getNome());
                        instancia = lista.get(i);
                        return;
                    }
                }            
            }
        }
        instancia = null;
        jLabel6.setText("Nenhum agendamento");
   
    }
    public ArrayList<AgendaMecanico> atualizarTabela(Date aux, Date fim){
        ArrayList<AgendaMecanico> lista = mecanicoControl.getCarrosSemana(jLabel3.getText(),aux, fim);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data Revisao");
        model.addColumn("Hora");
        model.addColumn("Nome do Cliente");
        model.addColumn("Placa do Carro");
        model.addColumn("Tipo de Revisao");
           
        if(lista != null){
            Integer i=0;
            while (i < lista.size()) {
                    model.addRow(new Object[]{lista.get(i).getData(),lista.get(i).getHora(),lista.get(i).getCliente().getNome(),lista.get(i).getCarro().getPlacaCarro(),lista.get(i).getQuilometragem()});
                    i++;
            }        
        }
        jTable2.setModel(model);
        jTable2.setEnabled(true);
        
        return lista;
        
    }
    
    public FormPrincipalMecanico() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }    
    private void fecharFormulario(){
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        relogio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        jButton1.setText("Outras Datas (F1)");
        jButton1.setToolTipText("Mostra o agendamento de outra semana");
        jButton1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Informações Carro (F2)");
        jButton2.setToolTipText("Exibe as informações do carro da revisão atual");
        jButton2.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Adicionar Peças (F3)");
        jButton3.setToolTipText("Adiciona peças no carro da revisão atual");
        jButton3.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sair");
        jButton4.setMargin(new java.awt.Insets(2, 10, 2, 10));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Ir para outra Revisão (F4)");
        jToggleButton2.setToolTipText("Realiza revisão para um outro carro");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Revisão Atual: ");

        jLabel6.setText("jLabel6");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setEnabled(false);
        jTable2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jTable2ComponentHidden(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        relogio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N

        jLabel4.setText("Data/Hora:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel2.setText("Login: ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relogio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(relogio))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        fecharFormulario();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JDateChooser inicio = new JDateChooser();
        JDateChooser fim = new JDateChooser();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
               
        //Criação da mensagem com o txtField
        Object[] mensagem = {
            "Data do Inicio do período: ", inicio,
            "Data do Fim do período: ", fim,
        };
        
        //Mostra o field
        int response = JOptionPane.showConfirmDialog(null, mensagem, "Pesquisa", JOptionPane.OK_CANCEL_OPTION);
        if(response == 0)
            atualizarTabela(inicio.getDate(),fim.getDate());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new FormProcurarCarro(jLabel3.getText(), this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fecharFormulario();
    }//GEN-LAST:event_formWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(instancia == null){
            JOptionPane.showMessageDialog(this, "Nenhuma manutenção está sendo realizado no momento!", "Erro!", JOptionPane.OK_OPTION);
        }else{
            // carro e tiposerviço
            new FormAdicionarPecas(this, instancia.getCarro(), parseInt(instancia.getQuilometragem()), jLabel3.getText()).setVisible(true);
            this.setVisible(false);
        }                
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable2ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTable2ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2ComponentHidden

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if(jToggleButton2.isSelected()){
            jToggleButton2.setText("Ir para Revisão Original (F4)");
            JComboBox quilometragem = new JComboBox();
            quilometragem.addItem("10000 km");
            quilometragem.addItem("20000 km");
            quilometragem.addItem("30000 km");
            quilometragem.addItem("40000 km");
            quilometragem.addItem("50000 km");
            quilometragem.addItem("60000 km");
            JTextField carro = new JTextField();

            //Criação da mensagem com o txtField
            Object[] mensagem = {
                "Tipo de Revisão: ", quilometragem,
                "Placa do Carro: ", carro,
            };

            int response = JOptionPane.showConfirmDialog(null, mensagem, "Pesquisa", JOptionPane.OK_CANCEL_OPTION);    
            if(response == 0){
                instanciaAux = instancia;
                instancia = mecanicoControl.getRevisao(jLabel3.getText(), carro.getText(), quilometragem.getSelectedItem().toString().substring(0, 5));
                if(instancia == null){
                    JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum carro com este tipo de revisão!", "Erro!", JOptionPane.OK_OPTION);
                    jToggleButton2.setText("Ir para outra Revisão (F4)");
                    jToggleButton2.setSelected(false);
                    instancia = instanciaAux;
                }else{
                    timer.stop();
                    jLabel6.setText(instancia.getCliente().getNome());
                }
            }else{
                timer.start();
                jToggleButton2.setText("Ir para outra Revisão (F4)");
                jToggleButton2.setSelected(false);
            }

        }else{
            timer.start();
            jToggleButton2.setText("Ir para outra Revisão (F4)");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipalMecanico().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JLabel relogio;
    // End of variables declaration//GEN-END:variables
}
