/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import Model.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Charizard
 */
public class FormEscolhaCliente extends javax.swing.JFrame {
    ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    Cliente cliente;
    
    public FormEscolhaCliente() {
        initComponents();
    }
    
    public FormEscolhaCliente(FormControleCliente form, ArrayList<Cliente> aux, Cliente aux2)
    {
        cliente = aux2;
        initComponents();
        FormControleCliente formulario = form;
        Clientes = aux;
        Integer i = 0;
        while (i < Clientes.size()) {
            cmbNomes.addItem(Clientes.get(i).getNome());
            i++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbNomes = new javax.swing.JComboBox();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        try{  
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");  
            txtCPF = new javax.swing.JFormattedTextField(cpf);  
        }  
        catch (Exception e){  
        }
        buttonOK = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome");

        lblCPF.setText("CPF");

        txtNome.setEditable(false);
        txtNome.setFocusable(false);

        txtCPF.setEditable(false);
        txtCPF.setFocusable(false);

        buttonOK.setText("Selecionar");
        buttonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOKActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(buttonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(buttonCancelar)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCPF)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPF)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbNomes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbNomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(buttonCancelar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblNome.getAccessibleContext().setAccessibleName("lblNome");
        lblCPF.getAccessibleContext().setAccessibleName("lblCPF");
        buttonOK.getAccessibleContext().setAccessibleName("buttonOk");
        buttonCancelar.getAccessibleContext().setAccessibleName("buttonCancel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        //Aqui a gente utiliza o this.aux pra acessar e completar os campos do outro form
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getBairro());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getCPF());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getCelular());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getCidade());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getComplemento());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getEmpresarial());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getEstado());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getNome());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getNumero());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getRua());
System.out.println(Clientes.get(cmbNomes.getSelectedIndex()).getTelefone());

        cliente.setBairro(Clientes.get(cmbNomes.getSelectedIndex()).getBairro());
        cliente.setCPF(Clientes.get(cmbNomes.getSelectedIndex()).getCPF());
        cliente.setCelular(Clientes.get(cmbNomes.getSelectedIndex()).getCelular());
        cliente.setCidade(Clientes.get(cmbNomes.getSelectedIndex()).getCidade());
        cliente.setComplemento(Clientes.get(cmbNomes.getSelectedIndex()).getComplemento());
        cliente.setEmpresarial(Clientes.get(cmbNomes.getSelectedIndex()).getEmpresarial());
        cliente.setEstado(Clientes.get(cmbNomes.getSelectedIndex()).getEstado());
        cliente.setNome(Clientes.get(cmbNomes.getSelectedIndex()).getNome());
        cliente.setNumero(Clientes.get(cmbNomes.getSelectedIndex()).getNumero());
        cliente.setRua(Clientes.get(cmbNomes.getSelectedIndex()).getRua());
        cliente.setTelefone(Clientes.get(cmbNomes.getSelectedIndex()).getTelefone());


    }//GEN-LAST:event_buttonOKActionPerformed

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
            java.util.logging.Logger.getLogger(FormEscolhaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEscolhaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEscolhaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEscolhaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormEscolhaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOK;
    private javax.swing.JComboBox cmbNomes;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
