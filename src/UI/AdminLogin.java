/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JOptionPane;
import Control.*;
import Entity.*;
import Exception.*;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Smith
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    AdminControl AC = new AdminControl();
    KameraControl KC = new KameraControl();
    LensaControl LC = new LensaControl();
    PesananControl PC = new PesananControl();
    Admin admin = null;
    DefaultTableModel tabelKameraModel, tabelLensaModel;
    DefaultTableModel tabelPBerlangsungModel, tabelPSelesaiModel;
    
    public AdminLogin() {
        initComponents();
        
        tabelKameraModel = (DefaultTableModel) tableKameraTampil.getModel();
        tabelLensaModel = (DefaultTableModel) tableLensaTampil.getModel();
        tabelPBerlangsungModel = (DefaultTableModel) tablePesananBerlangsung.getModel();
        tabelPSelesaiModel = (DefaultTableModel) tablePesananSelesai.getModel();
        
    }
    
    //All might Exception
    public void ExceptionLoginSalah(Admin ad) throws ExceptionLoginSalah
    {
        if(ad==null){
            throw new ExceptionLoginSalah();
        }else if(txtUsername.getText().equalsIgnoreCase(ad.getUsername())==false || 
                txtPassword.getText().equals(ad.getPassword())==false){
            throw new ExceptionLoginSalah();
        }
    }
    
    public void cekNamaKamera(String nama) throws ExceptionNamaKamera{
        if(nama.length()<3 || 15<nama.length())
            throw new ExceptionNamaKamera();
    }
    
    public void cekNamaLensa(String nama) throws ExceptionNamaLensa{
        if(nama.length()<3 || 15<nama.length())
            throw new ExceptionNamaLensa();
    }
    
    public void cekKameraAda(String nama) throws ExceptionKameraAda{
        if(KC.searchKamera(nama)!=null)
            throw new ExceptionKameraAda();
    }
    
    public void cekLensaAda(String nama) throws ExceptionLensaAda{
        if(LC.searchLensa(nama)!=null)
            throw new ExceptionLensaAda();
    }
    
    
    private void addTableKameraRow(String nama, int jumlah, int harga)
    {
        
        Vector data = new Vector();
        data.add(nama);
        data.add(jumlah);
        data.add(harga);
        tabelKameraModel.addRow(data);
    }
    
    private void deleteTableKamera(){
        while(tabelKameraModel.getRowCount()!=0)
        {    
            tabelKameraModel.removeRow(tabelKameraModel.getRowCount()-1);
        }
    }
    
    private void addTableLensaRow(String nama, int jumlah, int harga)
    {
        
        Vector data = new Vector();
        data.add(nama);
        data.add(jumlah);
        data.add(harga);
        tabelLensaModel.addRow(data);
    }
    
    private void deleteTableLensa(){
        while(tabelLensaModel.getRowCount()!=0)
        {    
            tabelLensaModel.removeRow(tabelLensaModel.getRowCount()-1);
        }
    }
    
    public void adminLogin(){
        try{   
            admin = AC.cekLogin(txtUsername.getText(), txtPassword.getText());
            ExceptionLoginSalah(admin);
            if(admin!=null)
            {
                JOptionPane.showMessageDialog(this, "Login Sukses!");
                MainPanel.removeAll();
                MainPanel.repaint();
                MainPanel.revalidate();

                MainPanel.add(AdminMenu);
                MainPanel.repaint();
                MainPanel.revalidate();
                
                PanelTengah.removeAll();
                PanelTengah.repaint();
                PanelTengah.revalidate();
                
                PanelTengah.add(PanelTambahUtama);
                PanelTengah.repaint();
                PanelTengah.revalidate();
                
                ButtonTambah.setBackground(new Color(51,51,51));
                ButtonHapus.setBackground(Color.black);
                ButtonTampil.setBackground(Color.black);
                ButtonTransaksi.setBackground(Color.black);
                ButtonAkun.setBackground(Color.black);
                
                txtKameraAdd.setText("");
                txtLensaAdd.setText("");
                txtAddHargaKamera.setText("");
                txtAddHargaLensa.setText("");
                txtUbahHargaKamera.setText("");
                txtUbahHargaLensa.setText("");
                
                KameraBoxUbah.removeAllItems();
                LensaBoxUbah.removeAllItems();
                
                KameraBoxUbah.addItem("- Pilih Kamera -");
                List<Kamera> userDataKamera = KC.showDataKamera();
                for(int i=0;i<userDataKamera.size();i++){
                    KameraBoxUbah.addItem(userDataKamera.get(i).getNama());
                }
                
                LensaBoxUbah.addItem("- Pilih Lensa -");
                List<Lensa> userDataLensa = LC.showDataLensa();
                for(int i=0;i<userDataLensa.size();i++){
                    LensaBoxUbah.addItem(userDataLensa.get(i).getNama());
                }
            }
            
        }catch(NullPointerException e){
            e.getMessage();
            JOptionPane.showMessageDialog(this, e);
        }catch(ExceptionLoginSalah e){
            JOptionPane.showMessageDialog(this, e.showMessageSalah());
        }catch(Exception e){
            e.getMessage();
            JOptionPane.showMessageDialog(this, e);
        }
    }
    private void addTablePBerlangsungRow(int id, String username, String namaKamera, 
                    int jumlahKamera, String namaLensa, int jumlahLensa, int lamaSewa, float totalHarga)
    {
        
        Vector data = new Vector();
        data.add(id);
        data.add(username);
        data.add(namaKamera);
        data.add(jumlahLensa);
        data.add(namaLensa);
        data.add(jumlahLensa);
        data.add(lamaSewa);
        data.add(totalHarga);
        tabelPBerlangsungModel.addRow(data);
    }
    
    private void addTablePSelesaiRow(int id, String username, String namaKamera, 
                    int jumlahKamera, String namaLensa, int jumlahLensa, int lamaSewa, float totalHarga)
    {
        
        Vector data = new Vector();
        data.add(id);
        data.add(username);
        data.add(namaKamera);
        data.add(jumlahLensa);
        data.add(namaLensa);
        data.add(jumlahLensa);
        data.add(lamaSewa);
        data.add(totalHarga);
        tabelPSelesaiModel.addRow(data);
    }
    
    private void deleteTablePBerlangsung(){
        while(tabelPBerlangsungModel.getRowCount()!=0)
        {    
            tabelPBerlangsungModel.removeRow(tabelPBerlangsungModel.getRowCount()-1);
        }
    }
    private void deleteTablePSelesai(){
        while(tabelPSelesaiModel.getRowCount()!=0)
        {    
            tabelPSelesaiModel.removeRow(tabelPSelesaiModel.getRowCount()-1);
        }
    }
    
    /*public void showPanel(String Identifier){
        CardLayout cl = (CardLayout)MainPanel.getLayout();
        cl.show(MainPanel, Identifier);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jTextField1 = new javax.swing.JTextField();
        MainPanel = new javax.swing.JPanel();
        PanelMasuk = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JLabel();
        txtUsername = new Placeholder.username();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        MasukButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPassword = new Placeholder.password();
        AdminMenu = new javax.swing.JPanel();
        MenuAdminLeftPanel = new javax.swing.JPanel();
        ButtonTambah = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ButtonHapus = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ButtonTampil = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        ButtonTransaksi = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ButtonAkun = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        PanelTengah = new javax.swing.JPanel();
        PanelTambahUtama = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtKameraAdd = new Placeholder.namakamera();
        txtLensaAdd = new Placeholder.namalensa();
        spinAddKamera = new javax.swing.JSpinner();
        spinAddLensa = new javax.swing.JSpinner();
        txtAddHargaKamera = new Placeholder.hargakamera();
        txtAddHargaLensa = new Placeholder.hargalensa();
        btnAddItem = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        KameraBoxUbah = new javax.swing.JComboBox<>();
        LensaBoxUbah = new javax.swing.JComboBox<>();
        spinKameraUbah = new javax.swing.JSpinner();
        spinLensaUbah = new javax.swing.JSpinner();
        txtUbahHargaKamera = new Placeholder.hargakamera();
        txtUbahHargaLensa = new Placeholder.hargalensa();
        btnUbahItem = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel31 = new javax.swing.JLabel();
        PanelHapusUtama = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        LensaBoxHapus = new javax.swing.JComboBox<>();
        KameraBoxHapus = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnDeleteItem = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        PanelTampilUtama = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKameraTampil = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLensaTampil = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        PanelTransaksiUtama = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePesananBerlangsung = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePesananSelesai = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        btnSelesaiTransaksi = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        PanelAkunUtama = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txtNamaAdmin = new javax.swing.JTextField();
        txtUsernameAdmin = new javax.swing.JTextField();
        btnKeluarAdmin = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        jScrollPane5.setViewportView(jEditorPane1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        MainPanel.setLayout(new java.awt.CardLayout());

        PanelMasuk.setBackground(new java.awt.Color(51, 51, 51));
        PanelMasuk.setPreferredSize(new java.awt.Dimension(700, 500));

        LeftPanel.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/administrator logo.png"))); // NOI18N

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        txtTitle.setForeground(new java.awt.Color(255, 255, 255));
        txtTitle.setText("Laman Masuk Admin");

        txtUsername.setBackground(new java.awt.Color(51, 51, 51));
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setToolTipText("Username");
        txtUsername.setBorder(null);

        MasukButton.setBackground(new java.awt.Color(102, 102, 102));
        MasukButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MasukButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasukButtonMouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MASUK");

        javax.swing.GroupLayout MasukButtonLayout = new javax.swing.GroupLayout(MasukButton);
        MasukButton.setLayout(MasukButtonLayout);
        MasukButtonLayout.setHorizontalGroup(
            MasukButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasukButtonLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MasukButtonLayout.setVerticalGroup(
            MasukButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasukButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPassword.setBackground(new java.awt.Color(51, 51, 51));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setToolTipText("Password");
        txtPassword.setBorder(null);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout PanelMasukLayout = new javax.swing.GroupLayout(PanelMasuk);
        PanelMasuk.setLayout(PanelMasukLayout);
        PanelMasukLayout.setHorizontalGroup(
            PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMasukLayout.createSequentialGroup()
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(MasukButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );
        PanelMasukLayout.setVerticalGroup(
            PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMasukLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(txtTitle)
                .addGap(86, 86, 86)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MasukButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        MainPanel.add(PanelMasuk, "card2");

        AdminMenu.setBackground(new java.awt.Color(51, 51, 51));
        AdminMenu.setPreferredSize(new java.awt.Dimension(700, 500));

        MenuAdminLeftPanel.setBackground(new java.awt.Color(0, 153, 255));

        ButtonTambah.setBackground(new java.awt.Color(51, 51, 51));
        ButtonTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonTambahMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setLabelFor(ButtonTambah);
        jLabel3.setText("Tambah Kamera");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ButtonTambahLayout = new javax.swing.GroupLayout(ButtonTambah);
        ButtonTambah.setLayout(ButtonTambahLayout);
        ButtonTambahLayout.setHorizontalGroup(
            ButtonTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTambahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonTambahLayout.setVerticalGroup(
            ButtonTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTambahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        ButtonHapus.setBackground(new java.awt.Color(25, 25, 25));
        ButtonHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonHapusMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setLabelFor(ButtonTambah);
        jLabel4.setText("Hapus Kamera");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ButtonHapusLayout = new javax.swing.GroupLayout(ButtonHapus);
        ButtonHapus.setLayout(ButtonHapusLayout);
        ButtonHapusLayout.setHorizontalGroup(
            ButtonHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonHapusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonHapusLayout.setVerticalGroup(
            ButtonHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonHapusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        ButtonTampil.setBackground(new java.awt.Color(25, 25, 25));
        ButtonTampil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonTampilMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setLabelFor(ButtonTambah);
        jLabel5.setText("Tampil Kamera");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ButtonTampilLayout = new javax.swing.GroupLayout(ButtonTampil);
        ButtonTampil.setLayout(ButtonTampilLayout);
        ButtonTampilLayout.setHorizontalGroup(
            ButtonTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTampilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonTampilLayout.setVerticalGroup(
            ButtonTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTampilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        ButtonTransaksi.setBackground(new java.awt.Color(25, 25, 25));
        ButtonTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonTransaksiMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setLabelFor(ButtonTambah);
        jLabel6.setText("Konfirmasi");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setLabelFor(ButtonTambah);
        jLabel7.setText("Transaksi");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ButtonTransaksiLayout = new javax.swing.GroupLayout(ButtonTransaksi);
        ButtonTransaksi.setLayout(ButtonTransaksiLayout);
        ButtonTransaksiLayout.setHorizontalGroup(
            ButtonTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTransaksiLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(ButtonTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonTransaksiLayout.setVerticalGroup(
            ButtonTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTransaksiLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        ButtonAkun.setBackground(new java.awt.Color(25, 25, 25));
        ButtonAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAkunMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setLabelFor(ButtonTambah);
        jLabel8.setText("Kelola Akun");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ButtonAkunLayout = new javax.swing.GroupLayout(ButtonAkun);
        ButtonAkun.setLayout(ButtonAkunLayout);
        ButtonAkunLayout.setHorizontalGroup(
            ButtonAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonAkunLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ButtonAkunLayout.setVerticalGroup(
            ButtonAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonAkunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuAdminLeftPanelLayout = new javax.swing.GroupLayout(MenuAdminLeftPanel);
        MenuAdminLeftPanel.setLayout(MenuAdminLeftPanelLayout);
        MenuAdminLeftPanelLayout.setHorizontalGroup(
            MenuAdminLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonTampil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonAkun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuAdminLeftPanelLayout.setVerticalGroup(
            MenuAdminLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAdminLeftPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(ButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTengah.setLayout(new java.awt.CardLayout());

        PanelTambahUtama.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tambah Kamera dan Lensa jika tersedia jenis baru. ");

        txtKameraAdd.setBackground(new java.awt.Color(51, 51, 51));
        txtKameraAdd.setForeground(new java.awt.Color(255, 255, 255));
        txtKameraAdd.setBorder(null);
        txtKameraAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKameraAddActionPerformed(evt);
            }
        });

        txtLensaAdd.setBackground(new java.awt.Color(51, 51, 51));
        txtLensaAdd.setForeground(new java.awt.Color(255, 255, 255));
        txtLensaAdd.setBorder(null);
        txtLensaAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLensaAddActionPerformed(evt);
            }
        });

        spinAddKamera.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinAddLensa.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        txtAddHargaKamera.setBackground(new java.awt.Color(51, 51, 51));
        txtAddHargaKamera.setForeground(new java.awt.Color(255, 255, 255));
        txtAddHargaKamera.setBorder(null);

        txtAddHargaLensa.setBackground(new java.awt.Color(51, 51, 51));
        txtAddHargaLensa.setForeground(new java.awt.Color(255, 255, 255));
        txtAddHargaLensa.setBorder(null);

        btnAddItem.setBackground(new java.awt.Color(102, 102, 102));
        btnAddItem.setForeground(new java.awt.Color(255, 255, 255));
        btnAddItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddItemMouseClicked(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setLabelFor(btnAddItem);
        jLabel10.setText("TAMBAH");

        javax.swing.GroupLayout btnAddItemLayout = new javax.swing.GroupLayout(btnAddItem);
        btnAddItem.setLayout(btnAddItemLayout);
        btnAddItemLayout.setHorizontalGroup(
            btnAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAddItemLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(85, 85, 85))
        );
        btnAddItemLayout.setVerticalGroup(
            btnAddItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Ubah Kamera dan lensa jika ingin mengubah ");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah atau harga dari kamera atau lensa yang sudah ada.");

        KameraBoxUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KameraBoxUbahActionPerformed(evt);
            }
        });

        spinKameraUbah.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spinLensaUbah.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        txtUbahHargaKamera.setBackground(new java.awt.Color(51, 51, 51));
        txtUbahHargaKamera.setForeground(new java.awt.Color(255, 255, 255));
        txtUbahHargaKamera.setBorder(null);

        txtUbahHargaLensa.setBackground(new java.awt.Color(51, 51, 51));
        txtUbahHargaLensa.setForeground(new java.awt.Color(255, 255, 255));
        txtUbahHargaLensa.setBorder(null);

        btnUbahItem.setBackground(new java.awt.Color(102, 102, 102));
        btnUbahItem.setForeground(new java.awt.Color(255, 255, 255));
        btnUbahItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUbahItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahItemMouseClicked(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setLabelFor(btnUbahItem);
        jLabel13.setText("UBAH");

        javax.swing.GroupLayout btnUbahItemLayout = new javax.swing.GroupLayout(btnUbahItem);
        btnUbahItem.setLayout(btnUbahItemLayout);
        btnUbahItemLayout.setHorizontalGroup(
            btnUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUbahItemLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(95, 95, 95))
        );
        btnUbahItemLayout.setVerticalGroup(
            btnUbahItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnUbahItemLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Kamera");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Lensa");

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Jumlah");

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Jumlah");

        javax.swing.GroupLayout PanelTambahUtamaLayout = new javax.swing.GroupLayout(PanelTambahUtama);
        PanelTambahUtama.setLayout(PanelTambahUtamaLayout);
        PanelTambahUtamaLayout.setHorizontalGroup(
            PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTambahUtamaLayout.createSequentialGroup()
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTambahUtamaLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(KameraBoxUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LensaBoxUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinKameraUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinLensaUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(76, 76, 76)
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUbahHargaLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUbahHargaKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7)
                            .addComponent(jSeparator8)))
                    .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUbahItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelTambahUtamaLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel9)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelTambahUtamaLayout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator3)
                                            .addComponent(txtKameraAdd)
                                            .addComponent(txtLensaAdd)
                                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(68, 68, 68)
                                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spinAddKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spinAddLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30))))
                                .addGap(76, 76, 76)
                                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAddHargaLensa, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(txtAddHargaKamera, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(jSeparator5)
                                    .addComponent(jSeparator6))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(946, Short.MAX_VALUE))
        );
        PanelTambahUtamaLayout.setVerticalGroup(
            PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKameraAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddHargaKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinAddKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(spinAddLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddHargaLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLensaAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(16, 16, 16)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinLensaUbah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTambahUtamaLayout.createSequentialGroup()
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KameraBoxUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinKameraUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUbahHargaKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTambahUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LensaBoxUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addComponent(txtUbahHargaLensa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btnUbahItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        PanelTengah.add(PanelTambahUtama, "card6");

        PanelHapusUtama.setBackground(new java.awt.Color(51, 51, 51));

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Hapus Kamera atau Lensa");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Melakukan penghapusan akan menghapus");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("semua stok dari kamera atau lensa yang dipilih");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Kamera");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Lensa");

        btnDeleteItem.setBackground(new java.awt.Color(102, 102, 102));
        btnDeleteItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteItemMouseClicked(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setLabelFor(btnDeleteItem);
        jLabel21.setText("HAPUS");

        javax.swing.GroupLayout btnDeleteItemLayout = new javax.swing.GroupLayout(btnDeleteItem);
        btnDeleteItem.setLayout(btnDeleteItemLayout);
        btnDeleteItemLayout.setHorizontalGroup(
            btnDeleteItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnDeleteItemLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(82, 82, 82))
        );
        btnDeleteItemLayout.setVerticalGroup(
            btnDeleteItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDeleteItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelHapusUtamaLayout = new javax.swing.GroupLayout(PanelHapusUtama);
        PanelHapusUtama.setLayout(PanelHapusUtamaLayout);
        PanelHapusUtamaLayout.setHorizontalGroup(
            PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHapusUtamaLayout.createSequentialGroup()
                .addGroup(PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelHapusUtamaLayout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addGroup(PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel17)
                                .addComponent(jLabel16)))
                        .addGroup(PanelHapusUtamaLayout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(jLabel20)
                            .addGap(18, 18, 18)
                            .addComponent(LensaBoxHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelHapusUtamaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelHapusUtamaLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(KameraBoxHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(1074, Short.MAX_VALUE))
        );
        PanelHapusUtamaLayout.setVerticalGroup(
            PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelHapusUtamaLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(57, 57, 57)
                .addGroup(PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KameraBoxHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(PanelHapusUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LensaBoxHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(49, 49, 49)
                .addComponent(btnDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(226, Short.MAX_VALUE))
        );

        PanelTengah.add(PanelHapusUtama, "card5");

        PanelTampilUtama.setBackground(new java.awt.Color(51, 51, 51));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Menampilkan semua kamera dan lensa yang tersedia");

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Kamera");

        tableKameraTampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Kamera", "Jumlah", "Harga/hari"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableKameraTampil);

        tableLensaTampil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Lensa", " Jumlah", "Harga/hari"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableLensaTampil);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Lensa");

        javax.swing.GroupLayout PanelTampilUtamaLayout = new javax.swing.GroupLayout(PanelTampilUtama);
        PanelTampilUtama.setLayout(PanelTampilUtamaLayout);
        PanelTampilUtamaLayout.setHorizontalGroup(
            PanelTampilUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTampilUtamaLayout.createSequentialGroup()
                .addGroup(PanelTampilUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTampilUtamaLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel22))
                    .addGroup(PanelTampilUtamaLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel24))
                    .addGroup(PanelTampilUtamaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(PanelTampilUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelTampilUtamaLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel23))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(926, Short.MAX_VALUE))
        );
        PanelTampilUtamaLayout.setVerticalGroup(
            PanelTampilUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTampilUtamaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );

        PanelTengah.add(PanelTampilUtama, "card4");

        PanelTransaksiUtama.setBackground(new java.awt.Color(51, 51, 51));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Pesanan Berlangsung");

        tablePesananBerlangsung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Kamera", "Jumlah", "Lensa", "Jumlah", "Lama", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePesananBerlangsung);

        tablePesananSelesai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Kamera", "Jumlah", "Lensa", "Jumlah", "Lama", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablePesananSelesai);

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Pesanan Selesai");

        btnSelesaiTransaksi.setBackground(new java.awt.Color(102, 102, 102));
        btnSelesaiTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btnSelesaiTransaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelesaiTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelesaiTransaksiMouseClicked(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setLabelFor(btnSelesaiTransaksi);
        jLabel27.setText("SELESAIKAN TRANSAKSI");

        javax.swing.GroupLayout btnSelesaiTransaksiLayout = new javax.swing.GroupLayout(btnSelesaiTransaksi);
        btnSelesaiTransaksi.setLayout(btnSelesaiTransaksiLayout);
        btnSelesaiTransaksiLayout.setHorizontalGroup(
            btnSelesaiTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSelesaiTransaksiLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(54, 54, 54))
        );
        btnSelesaiTransaksiLayout.setVerticalGroup(
            btnSelesaiTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSelesaiTransaksiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelTransaksiUtamaLayout = new javax.swing.GroupLayout(PanelTransaksiUtama);
        PanelTransaksiUtama.setLayout(PanelTransaksiUtamaLayout);
        PanelTransaksiUtamaLayout.setHorizontalGroup(
            PanelTransaksiUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaksiUtamaLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(btnSelesaiTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelTransaksiUtamaLayout.createSequentialGroup()
                .addGroup(PanelTransaksiUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTransaksiUtamaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel26))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelTransaksiUtamaLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel25)))
                .addGap(0, 908, Short.MAX_VALUE))
        );
        PanelTransaksiUtamaLayout.setVerticalGroup(
            PanelTransaksiUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTransaksiUtamaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelesaiTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        PanelTengah.add(PanelTransaksiUtama, "card3");

        PanelAkunUtama.setBackground(new java.awt.Color(51, 51, 51));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/admin logo grey.png"))); // NOI18N

        txtNamaAdmin.setEditable(false);
        txtNamaAdmin.setBackground(new java.awt.Color(51, 51, 51));
        txtNamaAdmin.setForeground(new java.awt.Color(255, 255, 255));

        txtUsernameAdmin.setEditable(false);
        txtUsernameAdmin.setBackground(new java.awt.Color(51, 51, 51));
        txtUsernameAdmin.setForeground(new java.awt.Color(255, 255, 255));

        btnKeluarAdmin.setBackground(new java.awt.Color(102, 102, 102));
        btnKeluarAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluarAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeluarAdminMouseClicked(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setLabelFor(btnKeluarAdmin);
        jLabel29.setText("KELUAR");

        javax.swing.GroupLayout btnKeluarAdminLayout = new javax.swing.GroupLayout(btnKeluarAdmin);
        btnKeluarAdmin.setLayout(btnKeluarAdminLayout);
        btnKeluarAdminLayout.setHorizontalGroup(
            btnKeluarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKeluarAdminLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(85, 85, 85))
        );
        btnKeluarAdminLayout.setVerticalGroup(
            btnKeluarAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKeluarAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Nama");

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Username");

        javax.swing.GroupLayout PanelAkunUtamaLayout = new javax.swing.GroupLayout(PanelAkunUtama);
        PanelAkunUtama.setLayout(PanelAkunUtamaLayout);
        PanelAkunUtamaLayout.setHorizontalGroup(
            PanelAkunUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAkunUtamaLayout.createSequentialGroup()
                .addGroup(PanelAkunUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAkunUtamaLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel28))
                    .addGroup(PanelAkunUtamaLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btnKeluarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAkunUtamaLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(PanelAkunUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAkunUtamaLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAkunUtamaLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsernameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(1077, Short.MAX_VALUE))
        );
        PanelAkunUtamaLayout.setVerticalGroup(
            PanelAkunUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAkunUtamaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addGroup(PanelAkunUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamaAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(PanelAkunUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsernameAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnKeluarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        PanelTengah.add(PanelAkunUtama, "card2");

        javax.swing.GroupLayout AdminMenuLayout = new javax.swing.GroupLayout(AdminMenu);
        AdminMenu.setLayout(AdminMenuLayout);
        AdminMenuLayout.setHorizontalGroup(
            AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMenuLayout.createSequentialGroup()
                .addComponent(MenuAdminLeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTengah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        AdminMenuLayout.setVerticalGroup(
            AdminMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuAdminLeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MainPanel.add(AdminMenu, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        OpeningPage open = new OpeningPage();
        open.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void MasukButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasukButtonMouseClicked
        // TODO add your handling code here:
        adminLogin();
    }//GEN-LAST:event_MasukButtonMouseClicked

    private void txtKameraAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKameraAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKameraAddActionPerformed

    private void txtLensaAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLensaAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLensaAddActionPerformed

    private void ButtonTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTambahMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelTambahUtama);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonTambah.setBackground(new Color(51,51,51));
        ButtonHapus.setBackground(Color.black);
        ButtonTampil.setBackground(Color.black);
        ButtonTransaksi.setBackground(Color.black);
        ButtonAkun.setBackground(Color.black);
        
        KameraBoxUbah.removeAllItems();
        LensaBoxUbah.removeAllItems();
        
        KameraBoxUbah.addItem("- Pilih Kamera -");
        List<Kamera> userDataKamera = KC.showDataKamera();
        for(int i=0;i<userDataKamera.size();i++){
            KameraBoxUbah.addItem(userDataKamera.get(i).getNama());
        }
        
        LensaBoxUbah.addItem("- Pilih Lensa -");
        List<Lensa> userDataLensa = LC.showDataLensa();
        for(int i=0;i<userDataLensa.size();i++){
            LensaBoxUbah.addItem(userDataLensa.get(i).getNama());
        }
    }//GEN-LAST:event_ButtonTambahMouseClicked

    private void ButtonHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonHapusMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelHapusUtama);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonTambah.setBackground(Color.black);
        ButtonHapus.setBackground(new Color(51,51,51));
        ButtonTampil.setBackground(Color.black);
        ButtonTransaksi.setBackground(Color.black);
        ButtonAkun.setBackground(Color.black);
        
        KameraBoxHapus.removeAllItems();
        LensaBoxHapus.removeAllItems();
        
        KameraBoxHapus.addItem("- Pilih Kamera -");
        List<Kamera> userDataKamera = KC.showDataKamera();
        for(int i=0;i<userDataKamera.size();i++){
            KameraBoxHapus.addItem(userDataKamera.get(i).getNama());
        }
        LensaBoxHapus.addItem("- Pilih Lensa -");
        List<Lensa> userDataLensa = LC.showDataLensa();
        for(int i=0;i<userDataLensa.size();i++){
            LensaBoxHapus.addItem(userDataLensa.get(i).getNama());
        }
    }//GEN-LAST:event_ButtonHapusMouseClicked

    private void ButtonTampilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTampilMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelTampilUtama);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonTambah.setBackground(Color.black);
        ButtonHapus.setBackground(Color.black);
        ButtonTampil.setBackground(new Color(51,51,51));
        ButtonTransaksi.setBackground(Color.black);
        ButtonAkun.setBackground(Color.black);
        
        deleteTableKamera();
        List<Kamera> km = KC.showDataKamera();
        for(int i=0;i<km.size();i++)
        {
            addTableKameraRow(km.get(i).getNama(), km.get(i).getJumlah(), km.get(i).getHarga());
        }
        deleteTableLensa();
        List<Lensa> ls = LC.showDataLensa();
        for(int i=0;i<ls.size();i++)
        {
            addTableLensaRow(ls.get(i).getNama(), ls.get(i).getJumlah(), ls.get(i).getHarga());
        }
    }//GEN-LAST:event_ButtonTampilMouseClicked

    private void ButtonTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTransaksiMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelTransaksiUtama);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonTambah.setBackground(Color.black);
        ButtonHapus.setBackground(Color.black);
        ButtonTampil.setBackground(Color.black);
        ButtonTransaksi.setBackground(new Color(51,51,51));
        ButtonAkun.setBackground(Color.black);
        
        deleteTablePBerlangsung();
        deleteTablePSelesai();
        List<Pesanan> list = PC.showPesanan();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getStatus()==0)
            {
                addTablePBerlangsungRow(list.get(i).getId(),list.get(i).getUsername(),list.get(i).getNamaKamera(),
                        list.get(i).getJumlahKamera(),list.get(i).getNamaLensa(),list.get(i).getJumlahLensa(),
                        list.get(i).getLamaSewa(),list.get(i).getTotalHarga());
            }else
            {
                addTablePSelesaiRow(list.get(i).getId(),list.get(i).getUsername(),list.get(i).getNamaKamera(),
                        list.get(i).getJumlahKamera(),list.get(i).getNamaLensa(),list.get(i).getJumlahLensa(),
                        list.get(i).getLamaSewa(),list.get(i).getTotalHarga());
            }
        }
    }//GEN-LAST:event_ButtonTransaksiMouseClicked

    private void ButtonAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAkunMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelAkunUtama);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonTambah.setBackground(Color.black);
        ButtonHapus.setBackground(Color.black);
        ButtonTampil.setBackground(Color.black);
        ButtonTransaksi.setBackground(Color.black);
        ButtonAkun.setBackground(new Color(51,51,51));
        
        txtNamaAdmin.setText(admin.getNama());
        txtUsernameAdmin.setText(admin.getUsername());
    }//GEN-LAST:event_ButtonAkunMouseClicked

    private void btnAddItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddItemMouseClicked
        // TODO add your handling code here:
        int count=0;
        try{
            if(txtKameraAdd.getText().length()!=0 || txtLensaAdd.getText().length()!=0)
            {
                if(txtKameraAdd.getText().equalsIgnoreCase("")==false)
                {
                    cekNamaKamera(txtKameraAdd.getText());
                    cekKameraAda(txtKameraAdd.getText());
                    Kamera K = new Kamera(txtKameraAdd.getText(),Integer.parseInt(spinAddKamera.getValue().toString()),
                                Integer.parseInt(txtAddHargaKamera.getText()));
                    KC.insertKamera(K);
                    count=count+1;
                    KameraBoxUbah.removeAllItems();
                    KameraBoxUbah.addItem("- Pilih Kamera -");
                    List<Kamera> userDataKamera = KC.showDataKamera();
                    for(int i=0;i<userDataKamera.size();i++){
                        KameraBoxUbah.addItem(userDataKamera.get(i).getNama());
                    }
                }
                if(txtLensaAdd.getText().equalsIgnoreCase("")==false)
                {
                    cekNamaLensa(txtLensaAdd.getText());
                    cekLensaAda(txtLensaAdd.getText());
                    Lensa L = new Lensa(txtLensaAdd.getText(),Integer.parseInt(spinAddLensa.getValue().toString()),
                                Integer.parseInt(txtAddHargaLensa.getText()));
                    LC.insertLensa(L);
                    count=count+2;
                    LensaBoxUbah.removeAllItems();
                    LensaBoxUbah.addItem("- Pilih Lensa -");
                    List<Lensa> userDataLensa = LC.showDataLensa();
                    for(int i=0;i<userDataLensa.size();i++){
                        LensaBoxUbah.addItem(userDataLensa.get(i).getNama());
                    }
                }
                txtKameraAdd.setText("");
                txtLensaAdd.setText("");
                txtAddHargaKamera.setText("");
                txtAddHargaLensa.setText("");
                txtUbahHargaKamera.setText("");
                txtUbahHargaLensa.setText("");
                if(count==1)
                    JOptionPane.showMessageDialog(this, "Kamera berhasil ditambah!");  
                else if(count==2)
                    JOptionPane.showMessageDialog(this, "Lensa berhasil ditambah!");
                else if(count==3)
                    JOptionPane.showMessageDialog(this, "Kamera dan Lensa berhasil ditambah!");
            }else
            {
                JOptionPane.showMessageDialog(this, "Tidak ada Kamera atau Lensa yang akan ditambah!");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Harga harus diisi dengan angka!");
        }catch(ExceptionNamaKamera NK){
            JOptionPane.showMessageDialog(this, NK.showMessageInvalid());
        }catch(ExceptionNamaLensa NL){
            JOptionPane.showMessageDialog(this, NL.showMessageInvalid());
        }catch(ExceptionKameraAda e){
            JOptionPane.showMessageDialog(this, e.showMessage());
        }catch(ExceptionLensaAda e){
            JOptionPane.showMessageDialog(this, e.showMessage());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnAddItemMouseClicked

    private void KameraBoxUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KameraBoxUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KameraBoxUbahActionPerformed

    private void btnUbahItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahItemMouseClicked
        // TODO add your handling code here:
        try{
            int count=0;
            if(KameraBoxUbah.getItemAt(KameraBoxUbah.getSelectedIndex()).equalsIgnoreCase("- Pilih Kamera -")==false){
                Kamera K = new Kamera(KameraBoxUbah.getItemAt(KameraBoxUbah.getSelectedIndex()),
                        Integer.parseInt(spinKameraUbah.getValue().toString()),Integer.parseInt(txtUbahHargaKamera.getText()));
                KC.editKamera(K, KameraBoxUbah.getItemAt(KameraBoxUbah.getSelectedIndex()));
                count=count+1;
            }
            if(LensaBoxUbah.getItemAt(LensaBoxUbah.getSelectedIndex()).equalsIgnoreCase("- Pilih Lensa -")==false){
                Lensa L = new Lensa(LensaBoxUbah.getItemAt(LensaBoxUbah.getSelectedIndex()),
                        Integer.parseInt(spinLensaUbah.getValue().toString()),Integer.parseInt(txtUbahHargaLensa.getText()));
                LC.editLensa(L, LensaBoxUbah.getItemAt(LensaBoxUbah.getSelectedIndex()));
                count=count+2;
            }
            
                
            if(count==0)
            {
                JOptionPane.showMessageDialog(this, "Pilih Kamera atau Lensa Terlebih dahulu!");
            }else if(count==1)
            {
                JOptionPane.showMessageDialog(this, "Kamera Berhasil Diedit!");
            }else if(count==2)
            {
                JOptionPane.showMessageDialog(this, "Lensa Berhasil Diedit!");
            }else if(count==3)
            {
                JOptionPane.showMessageDialog(this, "Kamera dan Lensa Berhasil Diedit!");
            }
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Harga harus diisi dengan angka!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnUbahItemMouseClicked

    private void btnDeleteItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteItemMouseClicked
        // TODO add your handling code here:
        int count=0;
        if(KameraBoxHapus.getItemAt(KameraBoxHapus.getSelectedIndex()).equalsIgnoreCase("- Pilih Kamera -")==false){
            KC.deleteKamera(KameraBoxHapus.getItemAt(KameraBoxHapus.getSelectedIndex()));
            count=count+1;
        }
        if(LensaBoxHapus.getItemAt(LensaBoxHapus.getSelectedIndex()).equalsIgnoreCase("- Pilih Lensa -")==false){
            LC.deleteLensa(LensaBoxHapus.getItemAt(LensaBoxHapus.getSelectedIndex()));
            count=count+2;
        }
        if(count==0)
        {
            JOptionPane.showMessageDialog(this, "Pilih Kamera atau Lensa Terlebih dahulu!");
        }else if(count==1)
        {
            JOptionPane.showMessageDialog(this, "Kamera Berhasil Dihapus!");
        }else if(count==2)
        {
            JOptionPane.showMessageDialog(this, "Lensa Berhasil Dihapus!");
        }else if(count==3)
        {
            JOptionPane.showMessageDialog(this, "Kamera dan Lensa Berhasil Dihapus!");
        }
        
        KameraBoxHapus.removeAllItems();
        LensaBoxHapus.removeAllItems();
        
        KameraBoxHapus.addItem("- Pilih Kamera -");
        List<Kamera> userDataKamera = KC.showDataKamera();
        for(int i=0;i<userDataKamera.size();i++){
            KameraBoxHapus.addItem(userDataKamera.get(i).getNama());
        }
        LensaBoxHapus.addItem("- Pilih Lensa -");
        List<Lensa> userDataLensa = LC.showDataLensa();
        for(int i=0;i<userDataLensa.size();i++){
            LensaBoxHapus.addItem(userDataLensa.get(i).getNama());
        }
    }//GEN-LAST:event_btnDeleteItemMouseClicked

    private void btnKeluarAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeluarAdminMouseClicked
        // TODO add your handling code here:
        int jawab = JOptionPane.showOptionDialog(this, "Ingin Keluar?", "Keluar", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);

        if(jawab == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Keluar Akun");
            MainPanel.removeAll();
            MainPanel.repaint();
            MainPanel.revalidate();

            MainPanel.add(PanelMasuk);
            MainPanel.repaint();
            MainPanel.revalidate();
            admin=null;
            txtUsername.setText("");
            txtPassword.setText("");
        }    
    }//GEN-LAST:event_btnKeluarAdminMouseClicked

    private void btnSelesaiTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelesaiTransaksiMouseClicked
        // TODO add your handling code here:
        try{
            String inputan;
            Pesanan P;
            int j = tablePesananBerlangsung.getSelectedRow();
            double totalHarga = Double.parseDouble(tabelPBerlangsungModel.getValueAt(j, 7).toString());
            P = PC.searchPesananAdmin(Integer.parseInt(tabelPBerlangsungModel.getValueAt(j, 0).toString()));
            
            do{
            inputan = JOptionPane.showInputDialog(this, "Selesaikan Transaksi?\n"
                            + "Uang yang harus anda bayarkan "+totalHarga+"\nMasukan jumlah Uang");
                if(Double.parseDouble(inputan)<totalHarga)
                {
                    JOptionPane.showMessageDialog(this, "Jumlah Uang Kurang!");
                }
            }while(Double.parseDouble(inputan)<totalHarga);
            JOptionPane.showMessageDialog(this, "Jumlah Kembalian : "+(Double.parseDouble(inputan)-totalHarga));
            
            PC.editPesananAdmin(P, P.getUsername(), P.getId());
            
            deleteTablePBerlangsung();
            deleteTablePSelesai();
            List<Pesanan> list = PC.showPesanan();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getStatus()==0)
                {
                    addTablePBerlangsungRow(list.get(i).getId(),list.get(i).getUsername(),list.get(i).getNamaKamera(),
                            list.get(i).getJumlahKamera(),list.get(i).getNamaLensa(),list.get(i).getJumlahLensa(),
                            list.get(i).getLamaSewa(),list.get(i).getTotalHarga());
                }else
                {
                    addTablePSelesaiRow(list.get(i).getId(),list.get(i).getUsername(),list.get(i).getNamaKamera(),
                            list.get(i).getJumlahKamera(),list.get(i).getNamaLensa(),list.get(i).getJumlahLensa(),
                            list.get(i).getLamaSewa(),list.get(i).getTotalHarga());
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Tidak ada transaksi yang terpilih!");
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Masukan harus angka!");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSelesaiTransaksiMouseClicked

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            adminLogin();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminMenu;
    private javax.swing.JPanel ButtonAkun;
    private javax.swing.JPanel ButtonHapus;
    private javax.swing.JPanel ButtonTambah;
    private javax.swing.JPanel ButtonTampil;
    private javax.swing.JPanel ButtonTransaksi;
    private javax.swing.JComboBox<String> KameraBoxHapus;
    private javax.swing.JComboBox<String> KameraBoxUbah;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JComboBox<String> LensaBoxHapus;
    private javax.swing.JComboBox<String> LensaBoxUbah;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel MasukButton;
    private javax.swing.JPanel MenuAdminLeftPanel;
    private javax.swing.JPanel PanelAkunUtama;
    private javax.swing.JPanel PanelHapusUtama;
    private javax.swing.JPanel PanelMasuk;
    private javax.swing.JPanel PanelTambahUtama;
    private javax.swing.JPanel PanelTampilUtama;
    private javax.swing.JPanel PanelTengah;
    private javax.swing.JPanel PanelTransaksiUtama;
    private javax.swing.JPanel btnAddItem;
    private javax.swing.JPanel btnDeleteItem;
    private javax.swing.JPanel btnKeluarAdmin;
    private javax.swing.JPanel btnSelesaiTransaksi;
    private javax.swing.JPanel btnUbahItem;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spinAddKamera;
    private javax.swing.JSpinner spinAddLensa;
    private javax.swing.JSpinner spinKameraUbah;
    private javax.swing.JSpinner spinLensaUbah;
    private javax.swing.JTable tableKameraTampil;
    private javax.swing.JTable tableLensaTampil;
    private javax.swing.JTable tablePesananBerlangsung;
    private javax.swing.JTable tablePesananSelesai;
    private javax.swing.JTextField txtAddHargaKamera;
    private javax.swing.JTextField txtAddHargaLensa;
    private javax.swing.JTextField txtKameraAdd;
    private javax.swing.JTextField txtLensaAdd;
    private javax.swing.JTextField txtNamaAdmin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JLabel txtTitle;
    private javax.swing.JTextField txtUbahHargaKamera;
    private javax.swing.JTextField txtUbahHargaLensa;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsernameAdmin;
    // End of variables declaration//GEN-END:variables
}
