/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodecarros;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Control.ClienteControl;
import Control.CarroControl;
import Model.Cliente;
import Model.Carro;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charizard
 */
public class FormControleCliente extends javax.swing.JFrame {
    ClockTest clock;
    private Cliente cliente;
    private ClienteControl conexao;
    private CarroControl carroControl;
    public Integer salvar;
    
    private ArrayList<Carro> listaCarros;
    
    public FormPrincipalFuncionario formPrincipal;
    
    public FormControleCliente() {
        initComponents();
    }
    
    public FormControleCliente(FormPrincipalFuncionario formFunc, String login)
    {
        formPrincipal = formFunc;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        txtUser.setText(login);
        Table tabela = new Table();
        tblCarro.setModel(tabela);
        clock = new ClockTest(txtDate);
        conexao = new ClienteControl();
        
        carroControl = new CarroControl();
        salvar = 0;

    }
    
    class Table extends AbstractTableModel {
        private String[] NomeColuna = { "Placa", "Chassi", "Modelo", "Cor", "Ano" };
        private Object[][] Info = {};
        
        public int getColumnCount() {
            return NomeColuna.length;
        }

        public int getRowCount() {
            return Info.length;
        }

        public String getColumnName(int col) {
            return NomeColuna[col];
        }

        public Object getValueAt(int linha, int coluna) {
            return Info[linha][coluna];
        }
        
        public void setValueAt(String valor, int linha, int coluna) {
            Info[linha][coluna] = valor;
            fireTableCellUpdated(linha, coluna);
        }
        
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAcao = new javax.swing.JPanel();
        buttonSair = new javax.swing.JButton();
        buttonAdicionar = new javax.swing.JButton();
        buttonProcura = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        panelInfo = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEmp = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblCidade = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblChassi = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox();
        txtPlaca = new javax.swing.JTextField();
        txtChassi = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        sprCli = new javax.swing.JSeparator();
        txtCelular = new javax.swing.JTextField();
        sprTel = new javax.swing.JSeparator();
        sprEnd = new javax.swing.JSeparator();
        txtEmp = new javax.swing.JTextField();
        lblRua = new javax.swing.JLabel();
        lblBairro = new javax.swing.JLabel();
        lblComp = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        pnlCarro = new javax.swing.JPanel();
        sclCarro = new javax.swing.JScrollPane();
        tblCarro = new javax.swing.JTable();
        buttonADD = new javax.swing.JButton();
        buttonEDIT = new javax.swing.JButton();
        buttonDEL = new javax.swing.JButton();
        lblExemploNome = new javax.swing.JLabel();
        lblExemploCPF = new javax.swing.JLabel();
        lblExemploTelefone = new javax.swing.JLabel();
        lblExemploPlaca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelAcao.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        buttonSair.setText("Sair");
        buttonSair.setMargin(new java.awt.Insets(2, 10, 2, 10));
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonAdicionar.setText("Cadastrar Cliente");
        buttonAdicionar.setActionCommand("");
        buttonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarActionPerformed(evt);
            }
        });

        buttonProcura.setText("Procurar Cliente");
        buttonProcura.setActionCommand("");
        buttonProcura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProcuraActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar Cliente");
        buttonEditar.setActionCommand("");
        buttonEditar.setEnabled(false);
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonLimpar.setText("Limpar Tudo");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAcaoLayout = new javax.swing.GroupLayout(panelAcao);
        panelAcao.setLayout(panelAcaoLayout);
        panelAcaoLayout.setHorizontalGroup(
            panelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProcura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelAcaoLayout.setVerticalGroup(
            panelAcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProcura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(buttonSair)
                .addContainerGap())
        );

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
                .addComponent(txtDate)
                .addContainerGap(669, Short.MAX_VALUE))
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

        lblNome.setText("Nome");

        lblCPF.setText("CPF");

        lblTel.setText("Telefone");

        lblCelular.setText("Celular");

        lblEmp.setText("Empresarial");

        lblEstado.setText("Estado");

        lblCidade.setText("Cidade");

        lblNumero.setText("Número");

        lblPlaca.setText("Placa");

        lblChassi.setText("Chassi");

        lblModelo.setText("Modelo");

        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });

        try{  
            javax.swing.text.MaskFormatter tel = new javax.swing.text.MaskFormatter("(##)####-####");  
            txtTelefone = new javax.swing.JFormattedTextField(tel);  
        }  
        catch (Exception e){  
        }
        txtTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        try{  
            javax.swing.text.MaskFormatter placa = new javax.swing.text.MaskFormatter("???-####");  
            txtPlaca = new javax.swing.JFormattedTextField(placa);  
        }  
        catch (Exception e){  
        }
        txtPlaca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPlacaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPlacaFocusLost(evt);
            }
        });

        try{  
            javax.swing.text.MaskFormatter ano = new javax.swing.text.MaskFormatter("####");  
            txtAno = new javax.swing.JFormattedTextField(ano);  
        }  
        catch (Exception e){  
        }

        try{  
            javax.swing.text.MaskFormatter cel = new javax.swing.text.MaskFormatter("(##)#####-####");  
            txtCelular = new javax.swing.JFormattedTextField(cel);  
        }  
        catch (Exception e){  
        }
        txtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        try{  
            javax.swing.text.MaskFormatter emp = new javax.swing.text.MaskFormatter("(##)#####-####");  
            txtEmp = new javax.swing.JFormattedTextField(emp);  
        }  
        catch (Exception e){  
        }
        txtEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        lblRua.setText("Rua");

        lblBairro.setText("Bairro");

        lblComp.setText("Compl.");

        lblAno.setText("Ano");

        lblCor.setText("Cor");

        tblCarro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCarro.setEditingColumn(0);
        tblCarro.setEditingRow(0);
        tblCarro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarroMouseClicked(evt);
            }
        });
        sclCarro.setViewportView(tblCarro);

        javax.swing.GroupLayout pnlCarroLayout = new javax.swing.GroupLayout(pnlCarro);
        pnlCarro.setLayout(pnlCarroLayout);
        pnlCarroLayout.setHorizontalGroup(
            pnlCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(pnlCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sclCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
        );
        pnlCarroLayout.setVerticalGroup(
            pnlCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
            .addGroup(pnlCarroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sclCarro, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );

        buttonADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ADD.png"))); // NOI18N
        buttonADD.setEnabled(false);
        buttonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonADDActionPerformed(evt);
            }
        });

        buttonEDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/EDIT.png"))); // NOI18N
        buttonEDIT.setEnabled(false);
        buttonEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEDITActionPerformed(evt);
            }
        });

        buttonDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DEL.png"))); // NOI18N
        buttonDEL.setEnabled(false);
        buttonDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDELActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sprCli)
                            .addComponent(sprEnd)
                            .addComponent(sprTel)
                            .addComponent(pnlCarro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNome)
                                            .addComponent(lblCPF))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblExemploCPF))
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblExemploNome))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCelular)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblTel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblExemploTelefone)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEmp)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblRua)
                                            .addComponent(lblBairro)
                                            .addComponent(lblComp))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblEstado, javax.swing.GroupLayout.Alignment.LEADING))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtNumero, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 71, Short.MAX_VALUE)))))
                                .addGap(0, 188, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPlaca)
                                    .addComponent(lblChassi)
                                    .addComponent(lblModelo))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblExemploPlaca))
                                    .addComponent(txtChassi, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(txtModel))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(buttonADD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonDEL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAno)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExemploNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPF)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExemploCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sprCli, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTel)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblExemploTelefone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCelular)
                            .addComponent(txtEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sprTel, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNumero)
                                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblEstado)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCidade)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRua))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblComp))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sprEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPlaca)
                                            .addComponent(lblExemploPlaca))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblAno))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtChassi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblChassi)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCor))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblModelo))))
                                    .addComponent(buttonADD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buttonEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buttonDEL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        int n = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que gostaria de sair?",
            "Sair",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            formPrincipal.setVisible(true);
            clock.stop();
            this.dispose();
        }
    }//GEN-LAST:event_buttonSairActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int n = JOptionPane.showConfirmDialog(
            this,
            "Você tem certeza que gostaria de sair?",
            "Sair",
            JOptionPane.YES_NO_OPTION);
        if(n==0){
            formPrincipal.setVisible(true);
            clock.stop();
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcuraActionPerformed
        Object[] possibilities = {"","CPF", "Nome"};
        String opcao;
        Integer i = 0;
        do{
        opcao = (String)JOptionPane.showInputDialog(
                            this,
                            "Procurar por:",
                            "Pesquisar",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            possibilities,
                            "");        
        }while(opcao.compareTo("") == 0);
        
        if(opcao.compareTo("CPF") == 0){
            String s = (String)JOptionPane.showInputDialog(
                               this,
                               "Entre com o CPF do Cliente:\n",
                               "Pesquisa: CPF",
                               JOptionPane.PLAIN_MESSAGE,
                               null,
                               null,
                               "");
            
            cliente = conexao.getCliente(s, null);
        }
        if(opcao.compareTo("Nome") == 0){
            String s = (String)JOptionPane.showInputDialog(
                               this,
                               "Entre com o nome do Cliente:",
                               "Pesquisa: Nome",
                               JOptionPane.PLAIN_MESSAGE,
                               null,
                               null,
                               "");    
            cliente = conexao.getCliente(null, s);
        }
        
        if(cliente != null){
            txtNome.setText(cliente.getNome());
            txtNome.setEditable(false);
            txtCPF.setText(cliente.getCPF());
            txtCPF.setEditable(false);
            txtTelefone.setText(cliente.getTelefone());
            txtTelefone.setEditable(false);
            txtCelular.setText(cliente.getCelular());
            txtCelular.setEditable(false);
            txtEmp.setText(cliente.getEmpresarial());
            txtEmp.setEditable(false);
            txtRua.setText(cliente.getRua());
            txtRua.setEditable(false);
            txtNumero.setText(cliente.getNumero().toString());
            txtNumero.setEditable(false);
            txtBairro.setText(cliente.getBairro());
            txtBairro.setEditable(false);
            txtComplemento.setText(cliente.getComplemento());
            txtComplemento.setEditable(false);
            txtCidade.setText(cliente.getCidade());
            txtCidade.setEditable(false);
//            Código caso a linha acima não selecione o estado correto            
            while(cliente.getEstado().compareTo(cmbEstado.getItemAt(i).toString())== 0);
            {
                i++;
            }
            cmbEstado.setSelectedIndex(i);
            cmbEstado.setEditable(false);
            
            //Editar a tabela com os valores atuais do carro
            
            txtPlaca.setEditable(false);
            txtChassi.setEditable(false);
            txtModel.setEditable(false);
            txtCor.setEditable(false);
            txtAno.setEditable(false);
            buttonADD.enable(false);
            buttonEDIT.enable(false);
            buttonDEL.enable(false);
            buttonAdicionar.enable(false);
            buttonEditar.enable(true);
            
            // trata a tabela
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Placa de Carro");
            model.addColumn("Chassi");
            model.addColumn("Modelo");
            model.addColumn("Cor");
            model.addColumn("Ano");
            
            i=0;
            
            listaCarros = carroControl.getCarros(cliente.getCPF());
            while(i < listaCarros.size()){
                Carro aux = new Carro(); 
                if(aux.isRemovido() != true){
                    aux = listaCarros.get(i);
                    model.addRow(new Object[]{aux.getPlacaCarro(), aux.getChassi(), aux.getModelo(), aux.getCor(), aux.getAno().toString()});
                    
                }
                i++;
            }
            
            tblCarro.setModel(model);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_buttonProcuraActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        String nome = buttonEditar.getName();
        boolean verificacao;
        Cliente cliente = new Cliente();
        ClienteControl conexao_cliente = new ClienteControl();
        
        if(nome.compareTo("Editar") == 0)
        {
            txtNome.setEditable(true);
            txtTelefone.setEditable(true);
            txtCelular.setEditable(true);
            txtEmp.setEditable(true);
            txtRua.setEditable(true);
            txtNumero.setEditable(true);
            txtBairro.setEditable(true);
            txtComplemento.setEditable(true);
            txtCidade.setEditable(true);
            cmbEstado.setEditable(true);
            txtPlaca.setEditable(true);
            txtChassi.setEditable(true);
            txtModel.setEditable(true);
            txtCor.setEditable(true);
            txtAno.setEditable(true);
            buttonADD.enable(true);
            buttonEDIT.enable(true);
            buttonDEL.enable(true);
        }
        else
        {
            cliente.setNome(txtNome.getText());
            cliente.setCPF(txtCPF.getText());
            cliente.setTelefone(txtTelefone.getText());
            cliente.setCelular(txtCelular.getText());
            cliente.setEmpresarial(txtEmp.getText());
            cliente.setRua(txtRua.getText());
            cliente.setBairro(txtBairro.getText());
            cliente.setNumero(Integer.parseInt(txtNumero.getText()));
            cliente.setEstado(cmbEstado.getSelectedItem().toString());
            cliente.setCidade(txtCidade.getText());
            cliente.setComplemento(txtComplemento.getText());
            
            verificacao = conexao_cliente.setCliente(cliente);
            
            if(verificacao)
            {
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Não foi possível a edição do cliente.", "Erro!", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        txtNome.setText("");
        txtCPF.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtEmp.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtCidade.setText("");
        cmbEstado.setSelectedIndex(0);
        txtPlaca.setText("");
        txtChassi.setText("");
        txtModel.setText("");
        txtCor.setText("");
        txtAno.setText("");
        lblExemploNome.setText("");
        lblExemploCPF.setText("");
        lblExemploTelefone.setText("");
        lblExemploPlaca.setText("");
        txtNome.setEditable(true);
        txtCPF.setEditable(true);
        txtTelefone.setEditable(true);
        txtCelular.setEditable(true);
        txtEmp.setEditable(true);
        txtRua.setEditable(true);
        txtNumero.setEditable(true);
        txtBairro.setEditable(true);
        txtComplemento.setEditable(true);
        txtCidade.setEditable(true);
        cmbEstado.setEditable(true);
        txtPlaca.setEditable(true);
        txtChassi.setEditable(true);
        txtModel.setEditable(true);
        txtCor.setEditable(true);
        txtAno.setEditable(true);
        buttonADD.setEnabled(false);
        buttonDEL.setEnabled(false);
        buttonEDIT.setEnabled(false);
        
        Table resetada = new Table();
        
        tblCarro.setModel(resetada);
        
        if(buttonEditar.isEnabled() == true)
        {
            buttonEditar.enable(false);
        }
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void tblCarroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarroMouseClicked
        Integer i;
        Carro carro = listaCarros.get(tblCarro.getSelectedRow());
        
        txtPlaca.setText(carro.getPlacaCarro());
        txtChassi.setText(carro.getChassi());
        txtModel.setText(carro.getModelo());
        txtCor.setText(carro.getCor());
        txtAno.setText(carro.getAno().toString());
        
        buttonEDIT.setEnabled(true);
    }//GEN-LAST:event_tblCarroMouseClicked

    private void buttonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonADDActionPerformed
        Integer x = tblCarro.getRowCount();

        if (txtPlaca.getText().trim().length() != 0
                && txtChassi.getText().trim().length() != 0
                && txtModel.getText().trim().length() != 0
                && txtCor.getText().trim().length() != 0
                && txtAno.getText().trim().length() != 0) {
            tblCarro.addRowSelectionInterval(tblCarro.getRowCount(), tblCarro.getRowCount());
            tblCarro.setValueAt(txtPlaca.getText(), x, 0);
            tblCarro.setValueAt(txtChassi.getText(), x, 1);
            tblCarro.setValueAt(txtModel.getText(), x, 2);
            tblCarro.setValueAt(txtCor.getText(), x, 3);
            tblCarro.setValueAt(txtAno.getText(), x, 4);
        } else {
            JOptionPane.showMessageDialog(this, "Não pode existir campos em branco!", "Erro!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_buttonADDActionPerformed

    private void buttonEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEDITActionPerformed
        Integer i = 0;
        
        while(txtPlaca.getText().compareTo(tblCarro.getValueAt(i, 0).toString()) != 0)
        {
            i++;
        }
        
        if (txtPlaca.getText().trim().length() != 0
                && txtChassi.getText().trim().length() != 0
                && txtModel.getText().trim().length() != 0
                && txtCor.getText().trim().length() != 0
                && txtAno.getText().trim().length() != 0) {
            tblCarro.setValueAt(txtPlaca.getText(), i, 0);
            tblCarro.setValueAt(txtChassi.getText(), i, 1);
            tblCarro.setValueAt(txtModel.getText(), i, 2);
            tblCarro.setValueAt(txtCor.getText(), i, 3);
            tblCarro.setValueAt(txtAno.getText(), i, 4);
        } else {
            JOptionPane.showMessageDialog(this, "Não pode existir campos em branco!", "Erro!", JOptionPane.OK_OPTION);
        }
        
        buttonEDIT.setEnabled(false);
    }//GEN-LAST:event_buttonEDITActionPerformed

    private void buttonDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDELActionPerformed
        
    }//GEN-LAST:event_buttonDELActionPerformed

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        lblExemploNome.setText("Ex.: Alberto Souza");
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusGained
        lblExemploCPF.setText("Ex.: 421.110.688-02");
    }//GEN-LAST:event_txtCPFFocusGained

    private void txtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusGained
        lblExemploTelefone.setText("Ex.: (15)3224-6474");
    }//GEN-LAST:event_txtTelefoneFocusGained

    private void txtCelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusGained
        lblExemploTelefone.setText("Ex.: (15)99651-7922");
    }//GEN-LAST:event_txtCelularFocusGained

    private void txtEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmpFocusGained
        lblExemploTelefone.setText("Ex.: (15)99651-7922");
    }//GEN-LAST:event_txtEmpFocusGained

    private void txtPlacaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlacaFocusGained
        lblExemploPlaca.setText("Ex.: AAA-0000");
    }//GEN-LAST:event_txtPlacaFocusGained

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        lblExemploNome.setText("");
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusLost
        lblExemploCPF.setText("");
    }//GEN-LAST:event_txtCPFFocusLost

    private void txtTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusLost
        lblExemploTelefone.setText("");
    }//GEN-LAST:event_txtTelefoneFocusLost

    private void txtPlacaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlacaFocusLost
        lblExemploPlaca.setText("");
    }//GEN-LAST:event_txtPlacaFocusLost

    private void buttonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarActionPerformed
        if (salvar == 0) {
            buttonAdicionar.setText("Salvar");
            buttonProcura.enable(false);
            buttonEDIT.enable(false);

            txtNome.setText("");
            txtCPF.setText("");
            txtTelefone.setText("");
            txtCelular.setText("");
            txtEmp.setText("");
            txtRua.setText("");
            txtNumero.setText("");
            txtBairro.setText("");
            txtComplemento.setText("");
            txtCidade.setText("");
            cmbEstado.setSelectedIndex(0);

            txtPlaca.setText("");
            txtChassi.setText("");
            txtModel.setText("");
            txtCor.setText("");
            txtAno.setText("");

            tblCarro.enable(false);
            
            salvar = 1;

        } else {
            if (salvar != 0) {
                if (((txtNome.getText().compareTo("") == 0) || (txtCPF.getText().compareTo("") == 0) || (txtTelefone.getText().compareTo("") == 0) || (txtCelular.getText().compareTo("") == 0) || (txtEmp.getText().compareTo("") == 0) || (txtRua.getText().compareTo("") == 0) || (txtNumero.getText().compareTo("") == 0) || (txtBairro.getText().compareTo("") == 0) || (txtCidade.getText().compareTo("") == 0))) {
                    JOptionPane.showMessageDialog(this, "Você precisa preencher todos os campos!", "Erro!", JOptionPane.OK_OPTION);
                } else {
                    Cliente aux = new Cliente();
                    aux.setNome(txtNome.getText());
                    aux.setCPF(txtCPF.getText());
                    aux.setTelefone(txtTelefone.getText());
                    aux.setCelular(txtCelular.getText());
                    aux.setEmpresarial(txtEmp.getText());
                    aux.setRua(txtRua.getText());
                    aux.setNumero(parseInt(txtNumero.getText()));
                    aux.setBairro(txtBairro.getText());
                    aux.setComplemento(txtComplemento.getText());
                    aux.setCidade(txtCidade.getText());
                    aux.setEstado(cmbEstado.getSelectedItem().toString());

                    ClienteControl cadastro = new ClienteControl();
                    if (cadastro.setCliente(aux)) {
                        JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso! ");
                        buttonAdicionar.setText("Cadastrar Cliente");
                        buttonProcura.enable(true);
                        buttonEDIT.enable(true);
                        salvar = 0;
                    } else {
                        JOptionPane.showMessageDialog(this, "ERRO!", "", JOptionPane.OK_OPTION);
                        salvar = 0;
                    }
                    txtNome.setText("");
                    txtCPF.setText("");
                    txtTelefone.setText("");
                    txtCelular.setText("");
                    txtEmp.setText("");
                    txtRua.setText("");
                    txtNumero.setText("");
                    txtBairro.setText("");
                    txtComplemento.setText("");
                    txtCidade.setText("");
                    cmbEstado.setSelectedIndex(0);                    
                }
            }
        }
            
 

    }//GEN-LAST:event_buttonAdicionarActionPerformed

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
            java.util.logging.Logger.getLogger(FormControleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormControleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormControleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormControleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormControleCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonADD;
    private javax.swing.JButton buttonAdicionar;
    private javax.swing.JButton buttonDEL;
    private javax.swing.JButton buttonEDIT;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonProcura;
    private javax.swing.JButton buttonSair;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblChassi;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblComp;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblExemploCPF;
    private javax.swing.JLabel lblExemploNome;
    private javax.swing.JLabel lblExemploPlaca;
    private javax.swing.JLabel lblExemploTelefone;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblRua;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelAcao;
    private javax.swing.JPanel panelInfo;
    private javax.swing.JPanel pnlCarro;
    private javax.swing.JScrollPane sclCarro;
    private javax.swing.JSeparator sprCli;
    private javax.swing.JSeparator sprEnd;
    private javax.swing.JSeparator sprTel;
    private javax.swing.JTable tblCarro;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtChassi;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCor;
    private javax.swing.JLabel txtDate;
    private javax.swing.JTextField txtEmp;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
