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
 * @author Charizard
 */
public class FormControleCliente extends javax.swing.JFrame {

    ClockTest clock;
    protected Cliente cliente;

    private ClienteControl conexao;
    private CarroControl carroControl;
    public Integer salvar;
    public Integer edicao;

    private boolean verificacao;
    ArrayList<Carro> listaCarros;
    ArrayList<Cliente> arrayCliente;

    public FormPrincipalFuncionario formPrincipal;

    public FormControleCliente() {
        initComponents();
    }

    public FormControleCliente(FormPrincipalFuncionario formFunc, String login) {
        formPrincipal = formFunc;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        txtUser.setText(login);
        Table tabela = new Table();
        tblCarro.setModel(tabela);
        clock = new ClockTest(txtDate);
        conexao = new ClienteControl();
        
        buttonADD.setVisible(false);

        carroControl = new CarroControl();
        salvar = 0;
        edicao = 0;

        buttonLimpar.setEnabled(false);
        txtPlaca.setEnabled(false);
        txtChassi.setEnabled(false);
        txtModel.setEnabled(false);
        txtCor.setEnabled(false);
        txtAno.setEnabled(false);
    }

    class Table extends AbstractTableModel {

        private String[] NomeColuna = {"Placa", "Chassi", "Modelo", "Cor", "Ano"};
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

        public boolean isCellEditable(int row, int column) {
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
        try{  
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");  
            txtCPF = new javax.swing.JFormattedTextField(cpf);  
        }  
        catch (Exception e){  
        }
        txtTelefone = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtComplemento = new javax.swing.JTextField();
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
        buttonADD1 = new javax.swing.JButton();
        txtNumero = new javax.swing.JFormattedTextField();

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
        buttonLimpar.setEnabled(false);
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

        lblNome.setText("Nome*");

        lblCPF.setText("CPF*");

        lblTel.setText("Telefone*");
        lblTel.setToolTipText("");

        lblCelular.setText("Celular");

        lblEmp.setText("Empresarial");

        lblEstado.setText("Estado*");

        lblCidade.setText("Cidade*");

        lblNumero.setText("Número*");

        lblPlaca.setText("Placa*");

        lblChassi.setText("Chassi*");

        lblModelo.setText("Modelo*");

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
        cmbEstado.setFocusable(false);

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
            javax.swing.text.MaskFormatter chassi = new javax.swing.text.MaskFormatter("AAAAAAAAAAAAAAAAA");  
            txtChassi = new javax.swing.JFormattedTextField(chassi);                    
        }  
        catch (Exception e){  
        }

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
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });
        txtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCelularFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefoneFocusLost(evt);
            }
        });

        try{  
            javax.swing.text.MaskFormatter emp = new javax.swing.text.MaskFormatter("(##)####-####");
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

        lblRua.setText("Rua*");

        lblBairro.setText("Bairro*");

        lblComp.setText("Compl.");

        lblAno.setText("Ano*");

        lblCor.setText("Cor*");

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
        tblCarro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tblCarroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblCarroFocusLost(evt);
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

        buttonADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1416530062_Check.png"))); // NOI18N
        buttonADD.setEnabled(false);
        buttonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonADDActionPerformed(evt);
            }
        });

        buttonEDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1416530124_pencil_32.png"))); // NOI18N
        buttonEDIT.setEnabled(false);
        buttonEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEDITActionPerformed(evt);
            }
        });

        buttonDEL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1416530067_Delete.png"))); // NOI18N
        buttonDEL.setEnabled(false);
        buttonDEL.setFocusPainted(false);
        buttonDEL.setFocusable(false);
        buttonDEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDELActionPerformed(evt);
            }
        });

        buttonADD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1416530056_Add.png"))); // NOI18N
        buttonADD1.setEnabled(false);
        buttonADD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonADD1ActionPerformed(evt);
            }
        });

        txtNumero.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

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
                                .addGap(0, 196, Short.MAX_VALUE))
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
                                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAno)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonADD, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonADD1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDEL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sprEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(buttonADD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                    .addComponent(lblModelo)))))
                                    .addComponent(buttonEDIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonADD1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonDEL, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Você tem certeza que gostaria de sair?",
                "Sair",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
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
        if (n == 0) {
            formPrincipal.setVisible(true);
            clock.stop();
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void buttonProcuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProcuraActionPerformed
        Object[] possibilities = {"", "CPF", "Nome"};
        String opcao;
        Integer i = 0;
        do {
            opcao = (String) JOptionPane.showInputDialog(
                    this,
                    "Procurar por:",
                    "Pesquisar",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "");
        } while (opcao.compareTo("") == 0);

        if (opcao.compareTo("CPF") == 0) {
            String s = (String) JOptionPane.showInputDialog(
                    this,
                    "Entre com o CPF do Cliente:\n",
                    "Pesquisa: CPF",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");

            cliente = conexao.getCliente(s);
        }
        if (opcao.compareTo("Nome") == 0) {
            String s = (String) JOptionPane.showInputDialog(
                    this,
                    "Entre com o nome do Cliente:",
                    "Pesquisa: Nome",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    "");
            arrayCliente = conexao.getClientes(s);
            cliente = new Cliente();
            if(arrayCliente != null){
                ArrayList<String> lista = new ArrayList<String>();
                Integer j = 0;
                while(j < arrayCliente.size()){
                    lista.add(arrayCliente.get(j).getNome());
                    j++;
                }
                Object [] choices = lista.toArray();

                //Input dialog with a combo box 
                String picked = (String)JOptionPane.showInputDialog(this, "Escolha um nome:"
                                , "Nomes encontrados", JOptionPane.QUESTION_MESSAGE
                                , null, choices, choices[0]);
                j=0;
                while(j < arrayCliente.size()){
                    if(picked.compareTo(arrayCliente.get(j).getNome()) == 0)
                        break;
                    else
                        j++;
                }
                cliente = arrayCliente.get(j);
            }else{
                cliente = null;
            }
        }

        if (cliente != null) {
            buttonEditar.setEnabled(true);

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
            while (cliente.getEstado().compareTo(cmbEstado.getItemAt(i).toString().trim()) != 0) {
                System.out.println(cmbEstado.getItemAt(i).toString().trim());
                System.out.println(cliente.getEstado());
                i++;
            }
            cmbEstado.setSelectedIndex(i);
            cmbEstado.setEnabled(false);

            //Editar a tabela com os valores atuais do carro
            txtPlaca.setEnabled(true);
            txtChassi.setEnabled(true);
            txtModel.setEnabled(true);
            txtCor.setEnabled(true);
            txtAno.setEnabled(true);                
            txtPlaca.setEditable(false);
            txtChassi.setEditable(false);
            txtModel.setEditable(false);
            txtCor.setEditable(false);
            txtAno.setEditable(false);
            buttonADD1.setEnabled(true);
            buttonEDIT.setEnabled(false);
            buttonDEL.setEnabled(false);
            buttonAdicionar.setEnabled(false);
            buttonEditar.setEnabled(true);
            buttonLimpar.setEnabled(true);

            // trata a tabela
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Placa de Carro");
            model.addColumn("Chassi");
            model.addColumn("Modelo");
            model.addColumn("Cor");
            model.addColumn("Ano");

            i = 0;

            listaCarros = carroControl.getCarros(cliente.getCPF());
            while (i < listaCarros.size()) {
                Carro aux = new Carro();
                if (aux.isRemovido() != true) {
                    aux = listaCarros.get(i);
                    model.addRow(new Object[]{aux.getPlacaCarro(), aux.getChassi(), aux.getModelo(), aux.getCor(), aux.getAno().toString()});

                }
                i++;
            }

            tblCarro.setModel(model);
            tblCarro.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro: Procura do Cliente", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_buttonProcuraActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed

        if (edicao == 0) {
            buttonEditar.setText("Salvar edição");

            txtNome.setEditable(false);
            txtTelefone.setEditable(true);
            txtCelular.setEditable(true);
            txtEmp.setEditable(true);
            txtRua.setEditable(true);
            txtNumero.setEditable(true);
            txtBairro.setEditable(true);
            txtComplemento.setEditable(true);
            txtCidade.setEditable(true);
            cmbEstado.setEditable(true);
            txtPlaca.setEditable(false);
            txtChassi.setEditable(false);
            txtModel.setEditable(false);
            txtCor.setEditable(true);
            txtAno.setEditable(false);

            buttonAdicionar.setEnabled(false);
            buttonProcura.setEnabled(false);

            buttonLimpar.setEnabled(false);

            //buttonADD.enable(true);
            //buttonEDIT.enable(false);
            //buttonDEL.enable(true);
            edicao = 1;
        } else {
            Cliente cliente = new Cliente();
            ClienteControl conexao_cliente = new ClienteControl();
            String mensagem = checkCliente();

            if(mensagem.compareTo("") == 0)
            {
                cliente.setNome(txtNome.getText());
                cliente.setCPF(txtCPF.getText().replaceAll("[(-.]",""));
                cliente.setTelefone(txtTelefone.getText().replaceAll("[(-.]",""));
                cliente.setCelular(txtCelular.getText().replaceAll("[(-.]",""));
                cliente.setEmpresarial(txtEmp.getText().replaceAll("[(-.]",""));
                cliente.setRua(txtRua.getText());
                cliente.setBairro(txtBairro.getText());
                cliente.setNumero(Integer.parseInt(txtNumero.getText()));
                cliente.setEstado(cmbEstado.getSelectedItem().toString());
                cliente.setCidade(txtCidade.getText());
                cliente.setComplemento(txtComplemento.getText());

                if (conexao_cliente.updateCliente(cliente)) {
                    JOptionPane.showMessageDialog(this, "Edição feita com êxito!","Sucesso: Edição de Cliente", JOptionPane.OK_OPTION);
                    buttonEditar.setText("Editar Cliente");
                    buttonAdicionar.setEnabled(true);
                    buttonProcura.setEnabled(true);
                    buttonLimpar.setEnabled(true);

                    txtNome.setEditable(false);
                    txtTelefone.setEditable(false);
                    txtCelular.setEditable(false);
                    txtEmp.setEditable(false);
                    txtRua.setEditable(false);
                    txtNumero.setEditable(false);
                    txtBairro.setEditable(false);
                    txtComplemento.setEditable(false);
                    txtCidade.setEditable(false);
                    cmbEstado.setEditable(false);
                    txtPlaca.setEditable(false);
                    txtChassi.setEditable(false);
                    txtModel.setEditable(false);
                    txtCor.setEditable(false);
                    txtAno.setEditable(false);
                    buttonAdicionar.setEnabled(true);
                    edicao = 0;
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível a edição do cliente. Tente novamente.", "Erro: Edição de Cliente", JOptionPane.OK_OPTION);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Você precisa completar o(s) seguinte(s) campo(s):\n\n" + mensagem, "Erro: Campos Incompletos", JOptionPane.OK_OPTION);
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
        buttonADD1.setEnabled(false);
        buttonADD.setVisible(false);
        buttonADD1.setVisible(true);

        Table resetada = new Table();

        tblCarro.setModel(resetada);

        if (buttonEditar.isEnabled() == true) {
            buttonEditar.enable(false);
        }
        buttonLimpar.setEnabled(false);
        buttonAdicionar.setEnabled(true);
        buttonAdicionar.setText("Cadastrar Cliente");
        buttonProcura.setEnabled(true);
        limparBorders();
        salvar = 0;
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
        txtCor.setEnabled(true);
        txtCor.setEditable(true);
    }//GEN-LAST:event_tblCarroMouseClicked

    private void buttonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonADDActionPerformed
        Carro aux = new Carro();
        String mensagem = checkCarro();
        if(mensagem.compareTo("") == 0)
        {
            aux.setCPF(cliente.getCPF().replaceAll("[(-.]",""));
            aux.setAno(parseInt(txtAno.getText()));
            aux.setChassi(txtChassi.getText());
            aux.setCor(txtCor.getText());
            aux.setModelo(txtModel.getText());
            aux.setPlacaCarro(txtPlaca.getText());

            buttonEditar.setEnabled(false);

            // trata a tabela
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Placa de Carro");
            model.addColumn("Chassi");
            model.addColumn("Modelo");
            model.addColumn("Cor");
            model.addColumn("Ano");
            if(carroControl.setCarro(aux)){
                JOptionPane.showMessageDialog(this, "Cadastro de Carro feito com sucesso!", "Sucesso: Cadastro de Carro", JOptionPane.OK_OPTION);
                txtPlaca.setEnabled(false);
                txtChassi.setEnabled(false);
                txtAno.setEnabled(false);
                txtModel.setEnabled(false);
                txtCor.setEnabled(false);
                txtPlaca.setText("");
                txtChassi.setText("");
                txtAno.setText("");
                txtModel.setText("");
                txtCor.setText("");
                buttonADD.setVisible(false);
                buttonADD1.setVisible(true);
                Integer i = 0;



                listaCarros = carroControl.getCarros(cliente.getCPF());
                while (i < listaCarros.size()) {
                    aux = new Carro();
                    if (aux.isRemovido() != true) {
                        aux = listaCarros.get(i);
                        model.addRow(new Object[]{aux.getPlacaCarro(), aux.getChassi(), aux.getModelo(), aux.getCor(), aux.getAno().toString()});

                    }
                    i++;
                }

                tblCarro.setModel(model);            
            }else{
                JOptionPane.showMessageDialog(this, "Não foi possível cadastar o carro! Tente novamente.", "Erro: Cadastro de Carro", JOptionPane.OK_OPTION);

            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Você precisa completar o(s) seguinte(s) campo(s):\n\n" + mensagem, "Erro: Campos Incompletos", JOptionPane.OK_OPTION);    
        }
    }//GEN-LAST:event_buttonADDActionPerformed

    private void buttonEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEDITActionPerformed
        Carro aux = new Carro();
        Integer i = 0;

        while (txtPlaca.getText().compareTo(tblCarro.getValueAt(i, 0).toString()) != 0) {
            i++;
        }

        String mensagem = checkCarro();
        if (mensagem.compareTo("") == 0) {
            aux.setPlacaCarro(txtPlaca.getText().replaceAll("[(-.]",""));
            aux.setCor(txtCor.getText());
            if (carroControl.updateCarro(aux)) {
                tblCarro.setValueAt(txtPlaca.getText(), i, 0);
                tblCarro.setValueAt(txtChassi.getText(), i, 1);
                tblCarro.setValueAt(txtModel.getText(), i, 2);
                tblCarro.setValueAt(txtCor.getText(), i, 3);
                tblCarro.setValueAt(txtAno.getText(), i, 4);
                JOptionPane.showMessageDialog(this, "Edição feito com sucesso!", "Sucesso: Edição do Carro", JOptionPane.OK_OPTION);
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível editar! Tente novamente.", "Erro: Edição do Carro", JOptionPane.OK_OPTION);
            }
            buttonLimpar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Você precisa completar o(s) seguinte(s) campo(s):\n\n" + mensagem, "Erro: Campos Incompletos", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_buttonEDITActionPerformed

    private void buttonDELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDELActionPerformed
        Integer i;

        int n = JOptionPane.showConfirmDialog(
                this,
                "Você tem certeza que deseja excluir o carro selecionado?",
                "Sair",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            Carro carro = listaCarros.get(tblCarro.getSelectedRow());
            if (carroControl.deleteCarro(carro)) {
                JOptionPane.showMessageDialog(this, "Carro excluido com sucesso!", "Sucesso: Exclusão de Carro", JOptionPane.OK_OPTION);
                i = 0;
                
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Placa de Carro");
                model.addColumn("Chassi");
                model.addColumn("Modelo");
                model.addColumn("Cor");
                model.addColumn("Ano");
                listaCarros = carroControl.getCarros(cliente.getCPF());
                Carro aux;
                while (i < listaCarros.size()) {
                    aux = new Carro();
                    if (aux.isRemovido() != true) {
                        aux = listaCarros.get(i);
                        model.addRow(new Object[]{aux.getPlacaCarro(), aux.getChassi(), aux.getModelo(), aux.getCor(), aux.getAno().toString()});

                    }
                    i++;
                }
                tblCarro.setModel(model);

            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível excluir o carro! Tente novamente.", "Erro: Exclusão", JOptionPane.OK_OPTION);
            }
        }        
    }//GEN-LAST:event_buttonDELActionPerformed

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        if(txtNome.isEditable())
        {
            lblExemploNome.setText("Ex.: Alberto Souza");
        }
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusGained
        if(txtCPF.isEditable())
        {
            lblExemploCPF.setText("Ex.: 421.110.688-02 - Utilize apenas números");
        }
    }//GEN-LAST:event_txtCPFFocusGained

    private void txtTelefoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefoneFocusGained
        if(txtTelefone.isEditable())
        {
            lblExemploTelefone.setText("Ex.: (15)3224-6474");
        }
    }//GEN-LAST:event_txtTelefoneFocusGained

    private void txtCelularFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusGained
        if(txtCelular.isEditable())
        {
            lblExemploTelefone.setText("Ex.: (15)99651-7922");
        }
    }//GEN-LAST:event_txtCelularFocusGained

    private void txtEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmpFocusGained
        if(txtEmp.isEditable())
        {
            lblExemploTelefone.setText("Ex.: (15)99651-7922");
        }
    }//GEN-LAST:event_txtEmpFocusGained

    private void txtPlacaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPlacaFocusGained
        if(txtPlaca.isEditable())
        {
            lblExemploPlaca.setText("Ex.: AAA-0000");
        }
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
            buttonProcura.setEnabled(false);
            buttonEDIT.setEnabled(false);
            buttonEditar.setEnabled(false);

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

            // Limpa tabela...
            Table resetada = new Table();
            tblCarro.setModel(resetada);

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

            tblCarro.enable(false);
            buttonLimpar.setEnabled(true);

            salvar = 1;
            txtNome.requestFocus();

        } else {
            if (salvar != 0) {
                String mensagem = checkCliente();
                if (!(mensagem.compareTo("") == 0)) {
                    JOptionPane.showMessageDialog(this, "Você precisa completar o(s) seguinte(s) campo(s):\n\n" + mensagem, "Erro: Campos Incompletos", JOptionPane.OK_OPTION);
                } else {
                    Cliente aux = new Cliente();
                    aux.setNome(txtNome.getText());
                    aux.setCPF(txtCPF.getText().replaceAll("[(-.]",""));
                    aux.setTelefone(txtTelefone.getText().replaceAll("[(-.]",""));
                    aux.setCelular(txtCelular.getText().replaceAll("[(-.]",""));
                    aux.setEmpresarial(txtEmp.getText().replaceAll("[(-.]",""));
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
                        buttonProcura.setEnabled(true);
                        buttonEDIT.setEnabled(false);
                        buttonLimpar.setEnabled(false);
                        //buttonEditar.setEnabled(true);

                        // travando os campos
                        txtNome.setEditable(false);
                        txtCPF.setEditable(false);
                        txtTelefone.setEditable(false);
                        txtCelular.setEditable(false);
                        txtEmp.setEditable(false);
                        txtRua.setEditable(false);
                        txtNumero.setEditable(false);
                        txtBairro.setEditable(false);
                        txtComplemento.setEditable(false);
                        txtCidade.setEditable(false);

                        // limpeza dos campos
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
                        salvar = 0;
                    } else {
                        JOptionPane.showMessageDialog(this, "Não foi possível cadastrar o cliente! Tente novamente.", "Erro: Cadastro de Cliente", JOptionPane.OK_OPTION);
                    }
                }
            }
        }


    }//GEN-LAST:event_buttonAdicionarActionPerformed

    private void buttonADD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonADD1ActionPerformed
        buttonADD1.setVisible(false);
        buttonADD.setEnabled(true);
        buttonADD.setVisible(true);
        Integer i;

        txtPlaca.setEnabled(true);
        txtChassi.setEnabled(true);
        txtModel.setEnabled(true);
        txtCor.setEnabled(true);
        txtAno.setEnabled(true);
        txtPlaca.setEditable(true);
        txtChassi.setEditable(true);
        txtModel.setEditable(true);
        txtCor.setEditable(true);
        txtAno.setEditable(true);
        txtPlaca.setText("");
        txtChassi.setText("");
        txtModel.setText("");
        txtCor.setText("");
        txtAno.setText("");
        txtPlaca.requestFocus();
    }//GEN-LAST:event_buttonADD1ActionPerformed

    private void tblCarroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblCarroFocusGained
        buttonDEL.setEnabled(true);
    }//GEN-LAST:event_tblCarroFocusGained

    private void tblCarroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblCarroFocusLost

    }//GEN-LAST:event_tblCarroFocusLost

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed
    
    private String checkCliente()
    {
        String mensagem = "";
        Border aviso = BorderFactory.createLineBorder(Color.red);
        Border original = txtEmp.getBorder();
        Border cmbOriginal = new javax.swing.JComboBox().getBorder();
        Border cmbAviso = BorderFactory.createLineBorder(Color.red);
        
        if(txtNome.getText().trim().length() == 0)
        {
            txtNome.setBorder(aviso);
            lblNome.setText("Nome *");
            mensagem += "Nome\n";
        }
        else
        {
            txtNome.setBorder(original);
        }
        
        if(txtCPF.getText().replaceAll("[(-.]","").trim().length() == 0)
        {
            txtNome.setBorder(aviso);
            mensagem += "CPF\n";
        }
        else
        {
            txtNome.setBorder(original);
        }
        
        if(txtTelefone.getText().replaceAll("[(-.]","").trim().length() == 0)
        {
            txtTelefone.setBorder(aviso);
            mensagem += "Telefone\n";
        }
        else
        {
            txtTelefone.setBorder(original);
        }
        
        if(txtRua.getText().trim().length() == 0)
        {
            txtRua.setBorder(aviso);
            mensagem += "Rua\n";
        }
        else
        {
            txtRua.setBorder(original);
        }
        
        if(txtBairro.getText().trim().length() == 0)
        {
            txtBairro.setBorder(aviso);
            mensagem += "Bairro\n";
        }
        else
        {
            txtBairro.setBorder(original);
        }
        
        if(txtNumero.getText().trim().length() == 0)
        {
            txtNumero.setBorder(aviso);
            mensagem += "Número\n";
        }
        else
        {
            txtNumero.setBorder(original);
        }
        
        if(cmbEstado.getSelectedItem().toString().compareTo(" ") == 0)
        {
            cmbEstado.setBorder(cmbAviso);
            mensagem += "Estado\n";
        }
        else
        {
            cmbEstado.setBorder(cmbOriginal);
        }
        
        if(txtCidade.getText().trim().length() == 0)
        {
            txtCidade.setBorder(aviso);
            mensagem += "Cidade";
        }
        else
        {
            txtCidade.setBorder(original);
        }
        
        return mensagem;
    }
    
    private String checkCarro()
    {
        String mensagem = "";
        Border aviso = BorderFactory.createLineBorder(Color.red);
        Border original = txtEmp.getBorder();
        
        if(txtPlaca.getText().replaceAll("[(-.]","").trim().length() == 0)
        {
            txtPlaca.setBorder(aviso);
            mensagem = "Placa\n";
        }
        else
        {
            txtPlaca.setBorder(original);
        }
        
        if(txtChassi.getText().trim().length() == 0)
        {
            txtChassi.setBorder(aviso);
            mensagem += "Chassi \n";
        }
        else
        {
            txtChassi.setBorder(original);
        }
        
        if(txtAno.getText().trim().length() == 0)
        {
            txtAno.setBorder(aviso);
            mensagem += "Ano\n";
        }
        else
        {
            txtAno.setBorder(original);
        }
        
        if(txtModel.getText().trim().length() == 0)
        {
            txtModel.setBorder(aviso);
            mensagem += "Modelo\n";
        }
        else
        {
            txtModel.setBorder(original);
        }
        
        if(txtCor.getText().trim().length() == 0)
        {
            txtCor.setBorder(aviso);
            mensagem += "Cor\n";
        }
        else
        {
            txtCor.setBorder(original);
        }
        
        return mensagem;
    }
    
    private void limparBorders()
    {
        Border original = txtEmp.getBorder();
        
        txtNome.setBorder(original);
        txtCPF.setBorder(original);
        txtTelefone.setBorder(original);
        txtRua.setBorder(original);
        txtBairro.setBorder(original);
        txtNumero.setBorder(original);
        cmbEstado.setBorder(original);
        txtCidade.setBorder(original);
        txtPlaca.setBorder(original);
        txtChassi.setBorder(original);
        txtModel.setBorder(original);
        txtCor.setBorder(original);
        txtAno.setBorder(original);
    }
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
    private javax.swing.JButton buttonADD1;
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
    private javax.swing.JFormattedTextField txtNumero;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JLabel txtUser;
    // End of variables declaration//GEN-END:variables
}
