/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author Smith
 */
import javax.swing.JOptionPane;
import Control.*;
import Entity.*;
import Exception.*;
import com.sun.glass.events.KeyEvent;
import java.util.regex.*;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class FormRegisterLogin extends javax.swing.JFrame {
    /**
     * Creates new form FormRegisterLogin
     */
    PenggunaControl PC;
    KameraControl KC;
    LensaControl LC;
    PesananControl PES;
    Pengguna user=null;
    
    DefaultTableModel tabelEditModel, tabelTampilModel;
    
    public FormRegisterLogin() {
        initComponents();
        PC = new PenggunaControl();
        KC = new KameraControl();
        LC = new LensaControl();
        PES = new PesananControl();
        tabelEditModel = (DefaultTableModel) tabelEditPesanan.getModel();
        tabelTampilModel = (DefaultTableModel) tabelTampilPesanan.getModel();
    }
    
    //All might Exception
    public void cekUsername(String username) throws ExceptionUsername {
        if (PC.cekUsername(username) == true) {
            throw new ExceptionUsername();
        }
    }
    
    public void cekUserLength(String u) throws ExceptionUserLength {
        if(u.length()<5 || 15<u.length()){
            throw new ExceptionUserLength();
        } else {
        }
    }
    
    public void cekNameLength(String n) throws ExceptionNameLength {
        if(n.length()<3){
            throw new ExceptionNameLength();
        }
    }

    public void cekPasswordKrg(String password) throws ExceptionPasswordKurang{
        if(password.length() < 8) {
            throw new ExceptionPasswordKurang();
        }
    }
    
    public void cekPasswordGcocok(String password, String password2) throws ExceptionPasswordTidakSesuai{
        if(!password.equals(password2)) {
            throw new ExceptionPasswordTidakSesuai();
        }
    }
    
    public void cekDigitTelepon(String t) throws ExceptionTelepon{
        String regex = "^08[0-9]{9,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);
        if(!matcher.matches()){
            throw new ExceptionTelepon();
        }
    }
    
    public void cekAlamatLength(String al) throws ExceptionAlamatLength{
        if(5>al.length()){
            throw new ExceptionAlamatLength();
        }
    }
    
    public void cekMinUmur(String umur) throws ExceptionMinUmur{
        if(Integer.parseInt(umur)<16){
            throw new ExceptionMinUmur();
        }
    }
    
    public void cekEmailValid(String emel) throws ExceptionEmailValid{
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emel);
        if(!matcher.matches()){
            throw new ExceptionEmailValid();
        }
    }
       
    public void ExceptionLoginSalah(Pengguna P) throws ExceptionLoginSalah {
        if (P == null) {
            throw new ExceptionLoginSalah();
        }else if(InputUsername.getText().equalsIgnoreCase(P.getUsername())==false || 
                InputPassword.getText().equals(P.getPassword())==false)
        {
            throw new ExceptionLoginSalah();
        }
    }
    
    public void cekLamaSewa(int lamaSewa) throws ExceptionLamaSewa{
        if(lamaSewa<1 || 7<lamaSewa)
        {    
            throw new ExceptionLamaSewa();
        }
    }
    
    public void cekPesananKosong(int kamera, int lensa) throws ExceptionPesananKosong{
        if(kamera==0 && lensa==0)
        {
            throw new ExceptionPesananKosong();
        }
    }
    
    private void dataHarusFull() throws ExceptionFieldFull{
        if(TxtUsername.getText().length()==0){
            TxtUsername.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtName.getText().length()==0){
            TxtName.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtPassword.getText().length()==0){
            TxtPassword.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtUmur.getText().length()==0){
            TxtUmur.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtTelepon.getText().length()==0){
            TxtTelepon.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtEmail.getText().length()==0){
            TxtEmail.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtAlamat.getText().length()==0){
            TxtAlamat.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtPassword2.getText().length()==0){
            TxtPassword2.requestFocus();
            throw new ExceptionFieldFull();
        }
    }
    
    private void dataEditHarusFull() throws ExceptionFieldFull{
        if(TxtUsernameEdit.getText().length()==0){
            TxtUsernameEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtNameEdit.getText().length()==0){
            TxtNameEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtPasswordEdit.getText().length()==0){
            TxtPasswordEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtUmurEdit.getText().length()==0){
            TxtUmurEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtTeleponEdit.getText().length()==0){
            TxtTeleponEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtEmailEdit.getText().length()==0){
            TxtEmailEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtAlamatEdit.getText().length()==0){
            TxtAlamatEdit.requestFocus();
            throw new ExceptionFieldFull();
        }else if(TxtPassword2Edit.getText().length()==0){
            TxtPassword2Edit.requestFocus();
            throw new ExceptionFieldFull();
        }
    }
    
    private void addTableEditRow(int id, String namaK, int jumlahK, String namaL, int jumlahL, int lamaSewa, float totalHarga)
    {
        
        Vector data = new Vector();
        data.add(id);
        data.add(namaK);
        data.add(jumlahK);
        data.add(namaL);
        data.add(jumlahL);
        data.add(lamaSewa);
        data.add(totalHarga);
        tabelEditModel.addRow(data);
    }
    
    private void deleteTableEdit(){
        while(tabelEditModel.getRowCount()!=0)
        {    
            tabelEditModel.removeRow(tabelEditModel.getRowCount()-1);
        }
    }
    
    private void addTableTampilRow(int id, String namaK, int jumlahK, String namaL, int jumlahL, int lamaSewa, float totalHarga)
    {
        
        Vector data = new Vector();
        data.add(id);
        data.add(namaK);
        data.add(jumlahK);
        data.add(namaL);
        data.add(jumlahL);
        data.add(lamaSewa);
        data.add(totalHarga);
        tabelTampilModel.addRow(data);
    }
    
    private void deleteTableTampil(){
        while(tabelTampilModel.getRowCount()!=0)
        {    
            tabelTampilModel.removeRow(tabelTampilModel.getRowCount()-1);
        }
    }
    
    public void userLogin(){
        try{
            user=PC.cekLogin(InputUsername.getText(),InputPassword.getText());
            ExceptionLoginSalah(user);
            
            if(user!=null)
            {
                JOptionPane.showMessageDialog(this, "Login Sukses!");
                MainPanel.removeAll();
                MainPanel.repaint();
                MainPanel.revalidate();

                MainPanel.add(UserMenu);
                MainPanel.repaint();
                MainPanel.revalidate();
                
                PanelTengah.removeAll();
                PanelTengah.repaint();
                PanelTengah.revalidate();
                
                PanelTengah.add(PanelPesan);
                PanelTengah.repaint();
                PanelTengah.revalidate();
                
                ButtonPesan.setBackground(new Color(51,51,51));
                ButtonEdit.setBackground(Color.black);
                ButtonTampil.setBackground(Color.black);
                ButtonAkun.setBackground(Color.black);
                
                KameraAddBox.removeAllItems();
                LensaAddBox.removeAllItems();
                List<Kamera> userDataKamera = KC.showDataKamera();
                for(int i=0;i<userDataKamera.size();i++){
                    KameraAddBox.addItem(userDataKamera.get(i).getNama());
                }
                List<Lensa> userDataLensa = LC.showDataLensa();
                for(int i=0;i<userDataLensa.size();i++){
                    LensaAddBox.addItem(userDataLensa.get(i).getNama());
                }
            }    
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }catch(ExceptionLoginSalah LS) {
            JOptionPane.showMessageDialog(this, LS.showMessageSalah());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public void buatAkun(){
        try{
            dataHarusFull();
            cekNameLength(TxtName.getText());
            cekDigitTelepon(TxtTelepon.getText());
            cekMinUmur(TxtUmur.getText());
            cekAlamatLength(TxtAlamat.getText());
            cekEmailValid(TxtEmail.getText());
            cekUsername(TxtUsername.getText());
            cekUserLength(TxtUsername.getText());
            cekPasswordKrg(TxtPassword.getText());
            cekPasswordGcocok(TxtPassword.getText(),TxtPassword2.getText());
            Pengguna p = new Pengguna(TxtUsername.getText(), TxtName.getText(), TxtPassword.getText(), 
                        Integer.parseInt(TxtUmur.getText()), TxtTelepon.getText(), TxtEmail.getText(), TxtAlamat.getText());
            PC.createPengguna(p);
            JOptionPane.showMessageDialog(this, "Akun Berhasil dibuat!");
            clearFieldDaftar();
            InputUsername.requestFocus();
        }catch(NumberFormatException FE) {
            JOptionPane.showMessageDialog(this, "Umur kok ga angka?");
        }catch(ExceptionUsername U) {
            JOptionPane.showMessageDialog(this, U.showMessageTerdaftar());
        }catch(ExceptionEmailValid EV) {
            JOptionPane.showMessageDialog(this, EV.showMessageInvalid());
        }catch(ExceptionPasswordKurang PK) {
            JOptionPane.showMessageDialog(this, PK.showMessageKurang());
        }catch(ExceptionPasswordTidakSesuai PTS) {
            JOptionPane.showMessageDialog(this, PTS.showMessageTSesuai());
        }catch(ExceptionFieldFull FF){
            JOptionPane.showMessageDialog(this, FF.showMessageKosong());
        }catch(ExceptionTelepon ET){
            JOptionPane.showMessageDialog(this, ET.showMessagePanjang());
        } catch (ExceptionUserLength EL) {
            JOptionPane.showMessageDialog(this, EL.showMessageInvalid());
        } catch (ExceptionNameLength NL) {
            JOptionPane.showMessageDialog(this, NL.showMessageInvalid());
        } catch (ExceptionMinUmur MinUm) {
             JOptionPane.showMessageDialog(this, MinUm.showMessageInvalid());
        } catch (ExceptionAlamatLength AlmLeng) {
            JOptionPane.showMessageDialog(this, AlmLeng.showMessageInvalid());
        }
    }
    
    public void editAkun(){
        try{
            dataEditHarusFull();
            cekNameLength(TxtNameEdit.getText());
            cekDigitTelepon(TxtTeleponEdit.getText());
            cekMinUmur(TxtUmurEdit.getText());
            cekAlamatLength(TxtAlamatEdit.getText());
            cekEmailValid(TxtEmailEdit.getText());
            cekUserLength(TxtUsernameEdit.getText());
            cekPasswordKrg(TxtPasswordEdit.getText());
            cekPasswordGcocok(TxtPasswordEdit.getText(),TxtPassword2Edit.getText());
            Pengguna P = new Pengguna(TxtUsernameEdit.getText(), TxtNameEdit.getText(), 
                            TxtPasswordEdit.getText(), Integer.parseInt(TxtUmurEdit.getText()), 
                            TxtTeleponEdit.getText(), TxtEmailEdit.getText(), TxtAlamatEdit.getText());
            TxtPasswordEdit.setText("");
            TxtPassword2Edit.setText("");
            TxtPasswordEdit.requestFocus();
            PC.editPengguna(P, user.getUsername());
            JOptionPane.showMessageDialog(this, "Data Berhasil Diedit!");
            user=P;
        }catch(ExceptionFieldFull FF){
            JOptionPane.showMessageDialog(this, FF.showMessageKosong());
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(this, "Kolom tidak boleh kosong!");
        }catch(ExceptionPasswordKurang PK) {
            JOptionPane.showMessageDialog(this, PK.showMessageKurang());
        }catch(ExceptionPasswordTidakSesuai PTS) {
            JOptionPane.showMessageDialog(this, PTS.showMessageTSesuai());
        }catch(ExceptionTelepon ET){
            JOptionPane.showMessageDialog(this, ET.showMessagePanjang());
        }catch (ExceptionUserLength EL) {
            JOptionPane.showMessageDialog(this, EL.showMessageInvalid());
        }catch (ExceptionNameLength NL) {
            JOptionPane.showMessageDialog(this, NL.showMessageInvalid());
        }catch(ExceptionEmailValid EV) {
            JOptionPane.showMessageDialog(this, EV.showMessageInvalid());
        }catch (ExceptionAlamatLength AlmLeng) {
            JOptionPane.showMessageDialog(this, AlmLeng.showMessageInvalid());
        }catch (ExceptionMinUmur MinUm) {
             JOptionPane.showMessageDialog(this, MinUm.showMessageInvalid());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    public float totalHargaBarang(int jumlah, Barang B){
        return jumlah*B.getHarga();
    }
    
    public float hitungTotal(int hargaKamera, int jumlahKamera, int hargaLensa, int jumlahLensa, int lamaSewa){
        return ((hargaKamera*jumlahKamera)+(hargaLensa*jumlahLensa))*lamaSewa;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        PanelMasuk = new javax.swing.JPanel();
        LeftPanel = new javax.swing.JPanel();
        BuatAkun = new javax.swing.JLabel();
        TxtUsername = new Placeholder.username();
        TxtName = new Placeholder.nama();
        TxtUmur = new Placeholder.umur();
        TxtAlamat = new Placeholder.alamat();
        TxtTelepon = new Placeholder.telepon();
        TxtEmail = new Placeholder.email();
        TxtPassword = new Placeholder.password();
        TxtPassword2 = new Placeholder.password2();
        BuatAkunButton = new javax.swing.JPanel();
        BtnTxtBuatAkun = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Masuk = new javax.swing.JLabel();
        InputUsername = new Placeholder.username();
        InputPassword = new Placeholder.password();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        MasukButton = new javax.swing.JPanel();
        BtnTxtMasuk = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        UserMenu = new javax.swing.JPanel();
        LeftMenuPanel = new javax.swing.JPanel();
        ButtonPesan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ButtonAkun = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ButtonTampil = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ButtonEdit = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        PanelTengah = new javax.swing.JPanel();
        PanelWelcome = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        PanelPesan = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        KameraAddBox = new javax.swing.JComboBox<>();
        LensaAddBox = new javax.swing.JComboBox<>();
        spinAddKamera = new javax.swing.JSpinner();
        spinAddLensa = new javax.swing.JSpinner();
        txtTampilHargaKamera = new javax.swing.JTextField();
        txtTampilHargaLensa = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        spinAddLamaSewa = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        PesanBtn = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        PanelEdit = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        tabelEdit = new javax.swing.JScrollPane();
        tabelEditPesanan = new javax.swing.JTable();
        KameraBoxEdit = new javax.swing.JComboBox<>();
        LensaBoxEdit = new javax.swing.JComboBox<>();
        spinEditKamera = new javax.swing.JSpinner();
        spinEditLensa = new javax.swing.JSpinner();
        txtHargaKameraEdit = new javax.swing.JTextField();
        txtHargaLensaEdit = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        spinEditLamaSewa = new javax.swing.JSpinner();
        EditPesananButton = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        HapusPesananButton = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        PanelTampil = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTampilPesanan = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        PanelAkun = new javax.swing.JPanel();
        TxtUsernameEdit = new Placeholder.username();
        TxtPassword2Edit = new Placeholder.password2();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        EditAkunButton = new javax.swing.JPanel();
        BtnTxtEditAkun = new javax.swing.JLabel();
        TxtAlamatEdit = new Placeholder.alamat();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        TxtTeleponEdit = new Placeholder.telepon();
        TxtNameEdit = new Placeholder.nama();
        TxtPasswordEdit = new Placeholder.password();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        EditAkun = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        TxtUmurEdit = new Placeholder.umur();
        TxtEmailEdit = new Placeholder.email();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        HapusAkunButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        KeluarButton = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        MainPanel.setLayout(new java.awt.CardLayout());

        PanelMasuk.setBackground(new java.awt.Color(51, 51, 51));
        PanelMasuk.setPreferredSize(new java.awt.Dimension(700, 530));

        LeftPanel.setBackground(new java.awt.Color(38, 38, 38));

        BuatAkun.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        BuatAkun.setForeground(new java.awt.Color(255, 255, 255));
        BuatAkun.setText("Buat Akun");

        TxtUsername.setBackground(new java.awt.Color(38, 38, 38));
        TxtUsername.setForeground(new java.awt.Color(255, 255, 255));
        TxtUsername.setBorder(null);

        TxtName.setBackground(new java.awt.Color(38, 38, 38));
        TxtName.setForeground(new java.awt.Color(255, 255, 255));
        TxtName.setBorder(null);
        TxtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNameActionPerformed(evt);
            }
        });

        TxtUmur.setBackground(new java.awt.Color(38, 38, 38));
        TxtUmur.setForeground(new java.awt.Color(255, 255, 255));
        TxtUmur.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtUmur.setBorder(null);

        TxtAlamat.setBackground(new java.awt.Color(38, 38, 38));
        TxtAlamat.setForeground(new java.awt.Color(255, 255, 255));
        TxtAlamat.setBorder(null);

        TxtTelepon.setBackground(new java.awt.Color(38, 38, 38));
        TxtTelepon.setForeground(new java.awt.Color(255, 255, 255));
        TxtTelepon.setBorder(null);
        TxtTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTeleponActionPerformed(evt);
            }
        });

        TxtEmail.setBackground(new java.awt.Color(38, 38, 38));
        TxtEmail.setForeground(new java.awt.Color(255, 255, 255));
        TxtEmail.setBorder(null);

        TxtPassword.setBackground(new java.awt.Color(38, 38, 38));
        TxtPassword.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword.setBorder(null);

        TxtPassword2.setBackground(new java.awt.Color(38, 38, 38));
        TxtPassword2.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword2.setBorder(null);
        TxtPassword2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPassword2KeyPressed(evt);
            }
        });

        BuatAkunButton.setBackground(new java.awt.Color(102, 102, 102));
        BuatAkunButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuatAkunButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuatAkunButtonMouseClicked(evt);
            }
        });

        BtnTxtBuatAkun.setForeground(new java.awt.Color(255, 255, 255));
        BtnTxtBuatAkun.setText("BUAT AKUN");

        javax.swing.GroupLayout BuatAkunButtonLayout = new javax.swing.GroupLayout(BuatAkunButton);
        BuatAkunButton.setLayout(BuatAkunButtonLayout);
        BuatAkunButtonLayout.setHorizontalGroup(
            BuatAkunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuatAkunButtonLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(BtnTxtBuatAkun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BuatAkunButtonLayout.setVerticalGroup(
            BuatAkunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuatAkunButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnTxtBuatAkun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jika belum mempunyai akun, maka buat");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("akun terlebih dahulu.");

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LeftPanelLayout.createSequentialGroup()
                            .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtTelepon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TxtUmur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator8)
                        .addComponent(TxtPassword2)
                        .addComponent(jSeparator7)
                        .addComponent(TxtAlamat)
                        .addComponent(jSeparator4)
                        .addComponent(TxtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BuatAkunButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtUsername)
                        .addComponent(TxtEmail)
                        .addComponent(TxtName, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(LeftPanelLayout.createSequentialGroup()
                            .addComponent(BuatAkun)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jSeparator1)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(16, 16, 16)))
                .addGap(35, 35, 35))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(BuatAkun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(BuatAkunButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        Masuk.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        Masuk.setForeground(new java.awt.Color(255, 255, 255));
        Masuk.setText("Masuk");

        InputUsername.setBackground(new java.awt.Color(51, 51, 51));
        InputUsername.setForeground(new java.awt.Color(255, 255, 255));
        InputUsername.setBorder(null);
        InputUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputUsernameActionPerformed(evt);
            }
        });

        InputPassword.setBackground(new java.awt.Color(51, 51, 51));
        InputPassword.setForeground(new java.awt.Color(255, 255, 255));
        InputPassword.setBorder(null);
        InputPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InputPasswordKeyPressed(evt);
            }
        });

        MasukButton.setBackground(new java.awt.Color(102, 102, 102));
        MasukButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MasukButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasukButtonMouseClicked(evt);
            }
        });

        BtnTxtMasuk.setForeground(new java.awt.Color(255, 255, 255));
        BtnTxtMasuk.setText("MASUK");
        BtnTxtMasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnTxtMasukMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MasukButtonLayout = new javax.swing.GroupLayout(MasukButton);
        MasukButton.setLayout(MasukButtonLayout);
        MasukButtonLayout.setHorizontalGroup(
            MasukButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MasukButtonLayout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(BtnTxtMasuk)
                .addGap(98, 98, 98))
        );
        MasukButtonLayout.setVerticalGroup(
            MasukButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasukButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnTxtMasuk)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Masuk dengan akun anda.");

        javax.swing.GroupLayout PanelMasukLayout = new javax.swing.GroupLayout(PanelMasuk);
        PanelMasuk.setLayout(PanelMasukLayout);
        PanelMasukLayout.setHorizontalGroup(
            PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMasukLayout.createSequentialGroup()
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMasukLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MasukButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(InputPassword)
                                .addComponent(InputUsername)
                                .addComponent(jSeparator9)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel7)
                    .addComponent(Masuk))
                .addGap(0, 128, Short.MAX_VALUE))
        );
        PanelMasukLayout.setVerticalGroup(
            PanelMasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelMasukLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Masuk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(60, 60, 60)
                .addComponent(InputUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MasukButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainPanel.add(PanelMasuk, "card2");

        UserMenu.setBackground(new java.awt.Color(51, 51, 51));

        LeftMenuPanel.setBackground(new java.awt.Color(0, 153, 255));

        ButtonPesan.setBackground(new java.awt.Color(25, 25, 25));
        ButtonPesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonPesanMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesan Kamera");

        javax.swing.GroupLayout ButtonPesanLayout = new javax.swing.GroupLayout(ButtonPesan);
        ButtonPesan.setLayout(ButtonPesanLayout);
        ButtonPesanLayout.setHorizontalGroup(
            ButtonPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPesanLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        ButtonPesanLayout.setVerticalGroup(
            ButtonPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonPesanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ButtonAkun.setBackground(new java.awt.Color(25, 25, 25));
        ButtonAkun.setPreferredSize(new java.awt.Dimension(135, 45));
        ButtonAkun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonAkunMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kelola Akun");

        javax.swing.GroupLayout ButtonAkunLayout = new javax.swing.GroupLayout(ButtonAkun);
        ButtonAkun.setLayout(ButtonAkunLayout);
        ButtonAkunLayout.setHorizontalGroup(
            ButtonAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonAkunLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        ButtonAkunLayout.setVerticalGroup(
            ButtonAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonAkunLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ButtonTampil.setBackground(new java.awt.Color(25, 25, 25));
        ButtonTampil.setPreferredSize(new java.awt.Dimension(135, 45));
        ButtonTampil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonTampilMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tampil Pesanan");

        javax.swing.GroupLayout ButtonTampilLayout = new javax.swing.GroupLayout(ButtonTampil);
        ButtonTampil.setLayout(ButtonTampilLayout);
        ButtonTampilLayout.setHorizontalGroup(
            ButtonTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTampilLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        ButtonTampilLayout.setVerticalGroup(
            ButtonTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonTampilLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        ButtonEdit.setBackground(new java.awt.Color(25, 25, 25));
        ButtonEdit.setPreferredSize(new java.awt.Dimension(135, 45));
        ButtonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonEditMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Edit Pesanan");

        javax.swing.GroupLayout ButtonEditLayout = new javax.swing.GroupLayout(ButtonEdit);
        ButtonEdit.setLayout(ButtonEditLayout);
        ButtonEditLayout.setHorizontalGroup(
            ButtonEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonEditLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        ButtonEditLayout.setVerticalGroup(
            ButtonEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LeftMenuPanelLayout = new javax.swing.GroupLayout(LeftMenuPanel);
        LeftMenuPanel.setLayout(LeftMenuPanelLayout);
        LeftMenuPanelLayout.setHorizontalGroup(
            LeftMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ButtonAkun, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ButtonTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        LeftMenuPanelLayout.setVerticalGroup(
            LeftMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftMenuPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(ButtonPesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonTampil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonAkun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelTengah.setBackground(new java.awt.Color(51, 51, 51));
        PanelTengah.setLayout(new java.awt.CardLayout());

        PanelWelcome.setBackground(new java.awt.Color(51, 51, 51));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/welkam.png"))); // NOI18N

        javax.swing.GroupLayout PanelWelcomeLayout = new javax.swing.GroupLayout(PanelWelcome);
        PanelWelcome.setLayout(PanelWelcomeLayout);
        PanelWelcomeLayout.setHorizontalGroup(
            PanelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelWelcomeLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        PanelWelcomeLayout.setVerticalGroup(
            PanelWelcomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelWelcomeLayout.createSequentialGroup()
                .addComponent(jLabel29)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        PanelTengah.add(PanelWelcome, "card2");

        PanelPesan.setBackground(new java.awt.Color(51, 51, 51));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Masukan kamera dan lensa yang akan anda sewa");

        KameraAddBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        KameraAddBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KameraAddBoxItemStateChanged(evt);
            }
        });

        LensaAddBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spinAddKamera.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        spinAddKamera.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinAddKameraStateChanged(evt);
            }
        });

        spinAddLensa.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        spinAddLensa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinAddLensaStateChanged(evt);
            }
        });

        txtTampilHargaKamera.setEditable(false);
        txtTampilHargaKamera.setBackground(new java.awt.Color(51, 51, 51));
        txtTampilHargaKamera.setForeground(new java.awt.Color(255, 255, 255));
        txtTampilHargaKamera.setBorder(null);
        txtTampilHargaKamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTampilHargaKameraActionPerformed(evt);
            }
        });

        txtTampilHargaLensa.setEditable(false);
        txtTampilHargaLensa.setBackground(new java.awt.Color(51, 51, 51));
        txtTampilHargaLensa.setForeground(new java.awt.Color(255, 255, 255));
        txtTampilHargaLensa.setBorder(null);
        txtTampilHargaLensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTampilHargaLensaActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Kamera");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Lensa");

        spinAddLamaSewa.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Lama Penyewaan (hari)");

        PesanBtn.setBackground(new java.awt.Color(102, 102, 102));
        PesanBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PesanBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PesanBtnMouseClicked(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PESAN");

        javax.swing.GroupLayout PesanBtnLayout = new javax.swing.GroupLayout(PesanBtn);
        PesanBtn.setLayout(PesanBtnLayout);
        PesanBtnLayout.setHorizontalGroup(
            PesanBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PesanBtnLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(83, 83, 83))
        );
        PesanBtnLayout.setVerticalGroup(
            PesanBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PesanBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Jumlah");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Harga");

        javax.swing.GroupLayout PanelPesanLayout = new javax.swing.GroupLayout(PanelPesan);
        PanelPesan.setLayout(PanelPesanLayout);
        PanelPesanLayout.setHorizontalGroup(
            PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPesanLayout.createSequentialGroup()
                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPesanLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(PesanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPesanLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(PanelPesanLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(31, 31, 31)
                                .addComponent(spinAddLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelPesanLayout.createSequentialGroup()
                                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addGap(26, 26, 26)
                                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KameraAddBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LensaAddBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPesanLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel25))
                                    .addGroup(PanelPesanLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spinAddKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spinAddLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelPesanLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTampilHargaLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPesanLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel26))
                                    .addGroup(PanelPesanLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTampilHargaKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        PanelPesanLayout.setVerticalGroup(
            PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPesanLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(KameraAddBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinAddKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTampilHargaKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LensaAddBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinAddLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTampilHargaLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(48, 48, 48)
                .addGroup(PanelPesanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinAddLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(116, 116, 116)
                .addComponent(PesanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        PanelTengah.add(PanelPesan, "card2");

        PanelEdit.setBackground(new java.awt.Color(51, 51, 51));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Edit Pesanan Anda");

        tabelEditPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kamera", "Jumlah", "Lensa", "Jumlah", "Lama Sewa", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelEdit.setViewportView(tabelEditPesanan);
        if (tabelEditPesanan.getColumnModel().getColumnCount() > 0) {
            tabelEditPesanan.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        KameraBoxEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        LensaBoxEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spinEditKamera.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        spinEditKamera.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinEditKameraStateChanged(evt);
            }
        });

        spinEditLensa.setModel(new javax.swing.SpinnerNumberModel(0, 0, 5, 1));
        spinEditLensa.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinEditLensaStateChanged(evt);
            }
        });

        txtHargaKameraEdit.setEditable(false);
        txtHargaKameraEdit.setBackground(new java.awt.Color(51, 51, 51));
        txtHargaKameraEdit.setForeground(new java.awt.Color(255, 255, 255));

        txtHargaLensaEdit.setEditable(false);
        txtHargaLensaEdit.setBackground(new java.awt.Color(51, 51, 51));
        txtHargaLensaEdit.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Kamera");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Lensa");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Lama Penyewaan (hari)");

        spinEditLamaSewa.setModel(new javax.swing.SpinnerNumberModel(0, 0, 7, 1));

        EditPesananButton.setBackground(new java.awt.Color(102, 102, 102));
        EditPesananButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditPesananButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditPesananButtonMouseClicked(evt);
            }
        });

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("EDIT");

        javax.swing.GroupLayout EditPesananButtonLayout = new javax.swing.GroupLayout(EditPesananButton);
        EditPesananButton.setLayout(EditPesananButtonLayout);
        EditPesananButtonLayout.setHorizontalGroup(
            EditPesananButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditPesananButtonLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(71, 71, 71))
        );
        EditPesananButtonLayout.setVerticalGroup(
            EditPesananButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPesananButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HapusPesananButton.setBackground(new java.awt.Color(102, 102, 102));
        HapusPesananButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HapusPesananButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HapusPesananButtonMouseClicked(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("HAPUS");

        javax.swing.GroupLayout HapusPesananButtonLayout = new javax.swing.GroupLayout(HapusPesananButton);
        HapusPesananButton.setLayout(HapusPesananButtonLayout);
        HapusPesananButtonLayout.setHorizontalGroup(
            HapusPesananButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HapusPesananButtonLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(65, 65, 65))
        );
        HapusPesananButtonLayout.setVerticalGroup(
            HapusPesananButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HapusPesananButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Jika ingin menghapus pesanan.");

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Jumlah");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Harga");

        javax.swing.GroupLayout PanelEditLayout = new javax.swing.GroupLayout(PanelEdit);
        PanelEdit.setLayout(PanelEditLayout);
        PanelEditLayout.setHorizontalGroup(
            PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEditLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(EditPesananButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HapusPesananButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEditLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(72, 72, 72))
            .addGroup(PanelEditLayout.createSequentialGroup()
                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEditLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel16))
                    .addGroup(PanelEditLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelEditLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(spinEditLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelEditLayout.createSequentialGroup()
                                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LensaBoxEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KameraBoxEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelEditLayout.createSequentialGroup()
                                        .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(spinEditKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spinEditLensa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(53, 53, 53)
                                        .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHargaKameraEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHargaLensaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PanelEditLayout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel28))))
                            .addComponent(tabelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelEditLayout.setVerticalGroup(
            PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEditLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelEditLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHargaKameraEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEditLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinEditKamera, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KameraBoxEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addGap(18, 18, 18)
                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHargaLensaEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LensaBoxEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addComponent(spinEditLensa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(spinEditLamaSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HapusPesananButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditPesananButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        PanelTengah.add(PanelEdit, "card3");

        PanelTampil.setBackground(new java.awt.Color(51, 51, 51));

        tabelTampilPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Kamera", "Jumlah", "Lensa", "Jumlah Lensa", "Lama Sewa", "Total Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelTampilPesanan);
        if (tabelTampilPesanan.getColumnModel().getColumnCount() > 0) {
            tabelTampilPesanan.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Daftar Pesanan Anda");

        javax.swing.GroupLayout PanelTampilLayout = new javax.swing.GroupLayout(PanelTampil);
        PanelTampil.setLayout(PanelTampilLayout);
        PanelTampilLayout.setHorizontalGroup(
            PanelTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTampilLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(PanelTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PanelTampilLayout.setVerticalGroup(
            PanelTampilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTampilLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel23)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        PanelTengah.add(PanelTampil, "card4");

        PanelAkun.setBackground(new java.awt.Color(51, 51, 51));

        TxtUsernameEdit.setEditable(false);
        TxtUsernameEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtUsernameEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtUsernameEdit.setBorder(null);
        TxtUsernameEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtUsernameEditMouseClicked(evt);
            }
        });

        TxtPassword2Edit.setBackground(new java.awt.Color(51, 51, 51));
        TxtPassword2Edit.setForeground(new java.awt.Color(255, 255, 255));
        TxtPassword2Edit.setBorder(null);
        TxtPassword2Edit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPassword2EditKeyPressed(evt);
            }
        });

        EditAkunButton.setBackground(new java.awt.Color(102, 102, 102));
        EditAkunButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditAkunButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditAkunButtonMouseClicked(evt);
            }
        });

        BtnTxtEditAkun.setForeground(new java.awt.Color(255, 255, 255));
        BtnTxtEditAkun.setText("EDIT AKUN");

        javax.swing.GroupLayout EditAkunButtonLayout = new javax.swing.GroupLayout(EditAkunButton);
        EditAkunButton.setLayout(EditAkunButtonLayout);
        EditAkunButtonLayout.setHorizontalGroup(
            EditAkunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditAkunButtonLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(BtnTxtEditAkun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        EditAkunButtonLayout.setVerticalGroup(
            EditAkunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditAkunButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnTxtEditAkun)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TxtAlamatEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtAlamatEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtAlamatEdit.setBorder(null);

        TxtTeleponEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtTeleponEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtTeleponEdit.setBorder(null);
        TxtTeleponEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtTeleponEditActionPerformed(evt);
            }
        });

        TxtNameEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtNameEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtNameEdit.setBorder(null);
        TxtNameEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNameEditActionPerformed(evt);
            }
        });

        TxtPasswordEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtPasswordEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtPasswordEdit.setBorder(null);

        EditAkun.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        EditAkun.setForeground(new java.awt.Color(255, 255, 255));
        EditAkun.setText("Edit Akun");

        TxtUmurEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtUmurEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtUmurEdit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TxtUmurEdit.setBorder(null);

        TxtEmailEdit.setBackground(new java.awt.Color(51, 51, 51));
        TxtEmailEdit.setForeground(new java.awt.Color(255, 255, 255));
        TxtEmailEdit.setBorder(null);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Masukan data diri yang baru.");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/user logo.png"))); // NOI18N

        HapusAkunButton.setBackground(new java.awt.Color(102, 102, 102));
        HapusAkunButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HapusAkunButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HapusAkunButtonMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HAPUS AKUN");

        javax.swing.GroupLayout HapusAkunButtonLayout = new javax.swing.GroupLayout(HapusAkunButton);
        HapusAkunButton.setLayout(HapusAkunButtonLayout);
        HapusAkunButtonLayout.setHorizontalGroup(
            HapusAkunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HapusAkunButtonLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(45, 45, 45))
        );
        HapusAkunButtonLayout.setVerticalGroup(
            HapusAkunButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HapusAkunButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        KeluarButton.setBackground(new java.awt.Color(102, 102, 102));
        KeluarButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KeluarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KeluarButtonMouseClicked(evt);
            }
        });

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("KELUAR");

        javax.swing.GroupLayout KeluarButtonLayout = new javax.swing.GroupLayout(KeluarButton);
        KeluarButton.setLayout(KeluarButtonLayout);
        KeluarButtonLayout.setHorizontalGroup(
            KeluarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KeluarButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(56, 56, 56))
        );
        KeluarButtonLayout.setVerticalGroup(
            KeluarButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KeluarButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelAkunLayout = new javax.swing.GroupLayout(PanelAkun);
        PanelAkun.setLayout(PanelAkunLayout);
        PanelAkunLayout.setHorizontalGroup(
            PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAkunLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAkunLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelAkunLayout.createSequentialGroup()
                        .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAkunLayout.createSequentialGroup()
                                .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtTeleponEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtUmurEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator18)
                            .addComponent(TxtPassword2Edit)
                            .addComponent(jSeparator17)
                            .addComponent(TxtAlamatEdit)
                            .addComponent(jSeparator14)
                            .addComponent(TxtPasswordEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditAkunButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtUsernameEdit)
                            .addComponent(TxtEmailEdit)
                            .addComponent(TxtNameEdit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelAkunLayout.createSequentialGroup()
                                .addComponent(EditAkun)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator11)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(62, 62, 62)
                        .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(PanelAkunLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(HapusAkunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(KeluarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(68, 68, 68))))
        );
        PanelAkunLayout.setVerticalGroup(
            PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAkunLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(EditAkun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAkunLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(TxtNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTeleponEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtUmurEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelAkunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator12)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtAlamatEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtEmailEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtUsernameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtPasswordEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtPassword2Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAkunLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(HapusAkunButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(KeluarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(EditAkunButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        PanelTengah.add(PanelAkun, "card5");

        javax.swing.GroupLayout UserMenuLayout = new javax.swing.GroupLayout(UserMenu);
        UserMenu.setLayout(UserMenuLayout);
        UserMenuLayout.setHorizontalGroup(
            UserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserMenuLayout.createSequentialGroup()
                .addComponent(LeftMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserMenuLayout.setVerticalGroup(
            UserMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LeftMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelTengah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MainPanel.add(UserMenu, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNameActionPerformed

    private void InputUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputUsernameActionPerformed

    private void TxtTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTeleponActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:\
        OpeningPage open = new OpeningPage();
        open.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void BuatAkunButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuatAkunButtonMouseClicked
        // TODO add your handling code here:
        buatAkun();
    }//GEN-LAST:event_BuatAkunButtonMouseClicked
    
    private void clearFieldDaftar(){
        TxtUsername.setText("");
        TxtName.setText("");
        TxtPassword.setText("");
        TxtUmur.setText("");
        TxtTelepon.setText("");
        TxtEmail.setText("");
        TxtAlamat.setText("");
        TxtPassword2.setText("");
    }
    private void BtnTxtMasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnTxtMasukMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BtnTxtMasukMouseClicked

    private void MasukButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasukButtonMouseClicked
        // TODO add your handling code here:
        userLogin();
    }//GEN-LAST:event_MasukButtonMouseClicked

    private void TxtNameEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNameEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNameEditActionPerformed

    private void TxtTeleponEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtTeleponEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtTeleponEditActionPerformed

    private void EditAkunButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditAkunButtonMouseClicked
        // TODO add your handling code here:
        editAkun();
    }//GEN-LAST:event_EditAkunButtonMouseClicked

    private void ButtonPesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPesanMouseClicked
        // TODO add your handling code here:
        
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelPesan);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonPesan.setBackground(new Color(51,51,51));
        ButtonEdit.setBackground(Color.black);
        ButtonTampil.setBackground(Color.black);
        ButtonAkun.setBackground(Color.black);
        KameraBoxEdit.removeAllItems();
        LensaBoxEdit.removeAllItems();
        List<Kamera> userDataKamera = KC.showDataKamera();
        for(int i=0;i<userDataKamera.size();i++){
            KameraBoxEdit.addItem(userDataKamera.get(i).getNama());
        }
        List<Lensa> userDataLensa = LC.showDataLensa();
        for(int i=0;i<userDataLensa.size();i++){
            LensaBoxEdit.addItem(userDataLensa.get(i).getNama());
        }
    }//GEN-LAST:event_ButtonPesanMouseClicked

    private void ButtonEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEditMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelEdit);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonPesan.setBackground(Color.black);
        ButtonEdit.setBackground(new Color(51,51,51));
        ButtonTampil.setBackground(Color.black);
        ButtonAkun.setBackground(Color.black);
        
        deleteTableEdit();
        List<Pesanan> p = PES.showPesananUser(user.getUsername());
        for(int i=0;i<p.size();i++)
        {
            if(p.get(i).getStatus()==0)
            {
                addTableEditRow(p.get(i).getId(), p.get(i).getNamaKamera(), p.get(i).getJumlahKamera(),
                                p.get(i).getNamaLensa(), p.get(i).getJumlahLensa(), p.get(i).getLamaSewa(),
                                p.get(i).getTotalHarga());
            }
        }
        
        KameraBoxEdit.removeAllItems();
        LensaBoxEdit.removeAllItems();
        List<Kamera> userDataKamera = KC.showDataKamera();
        for(int i=0;i<userDataKamera.size();i++){
            KameraBoxEdit.addItem(userDataKamera.get(i).getNama());
        }
        List<Lensa> userDataLensa = LC.showDataLensa();
        for(int i=0;i<userDataLensa.size();i++){
            LensaBoxEdit.addItem(userDataLensa.get(i).getNama());
        }
    }//GEN-LAST:event_ButtonEditMouseClicked

    private void ButtonTampilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonTampilMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelTampil);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonPesan.setBackground(Color.black);
        ButtonEdit.setBackground(Color.black);
        ButtonTampil.setBackground(new Color(51,51,51));
        ButtonAkun.setBackground(Color.black);
        
        deleteTableTampil();
        List<Pesanan> p = PES.showPesananUser(user.getUsername());
        for(int i=0;i<p.size();i++)
        {
            if(p.get(i).getStatus()==0)
            {
                addTableTampilRow(p.get(i).getId(), p.get(i).getNamaKamera(), p.get(i).getJumlahKamera(),
                                p.get(i).getNamaLensa(), p.get(i).getJumlahLensa(), p.get(i).getLamaSewa(),
                                p.get(i).getTotalHarga());
            }
        }
    }//GEN-LAST:event_ButtonTampilMouseClicked

    private void ButtonAkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonAkunMouseClicked
        // TODO add your handling code here:
        PanelTengah.removeAll();
        PanelTengah.repaint();
        PanelTengah.revalidate();

        PanelTengah.add(PanelAkun);
        PanelTengah.repaint();
        PanelTengah.revalidate();
        
        ButtonPesan.setBackground(Color.black);
        ButtonEdit.setBackground(Color.black);
        ButtonTampil.setBackground(Color.black);
        ButtonAkun.setBackground(new Color(51,51,51));
        
        TxtNameEdit.setText(user.getNama());
        TxtTeleponEdit.setText(user.getTelepon());
        TxtUmurEdit.setText(String.valueOf(user.getUmur()));
        TxtAlamatEdit.setText(String.valueOf(user.getAlamat()));
        TxtEmailEdit.setText(user.getEmail());
        TxtUsernameEdit.setText(user.getUsername()); 
    }//GEN-LAST:event_ButtonAkunMouseClicked

    private void EditPesananButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditPesananButtonMouseClicked
        // TODO add your handling code here:
        try{
            int i = tabelEditPesanan.getSelectedRow();
            Kamera K = KC.searchKamera(KameraBoxEdit.getItemAt(KameraBoxEdit.getSelectedIndex()));
            Lensa L = LC.searchLensa(LensaBoxEdit.getItemAt(LensaBoxEdit.getSelectedIndex()));
            int lamaSewa = Integer.parseInt(spinEditLamaSewa.getValue().toString());
            int jmlLensa = Integer.parseInt(spinEditLensa.getValue().toString());
            int jmlKamera = Integer.parseInt(spinEditKamera.getValue().toString());
            int id = Integer.parseInt(tabelEditModel.getValueAt(i, 0).toString());
            cekPesananKosong(jmlKamera, jmlLensa);
            cekLamaSewa(lamaSewa);
            
            Pesanan P = new Pesanan(user.getUsername(),KameraBoxEdit.getItemAt(KameraBoxEdit.getSelectedIndex()),
                            jmlKamera, LensaBoxEdit.getItemAt(LensaBoxEdit.getSelectedIndex()),
                            jmlLensa, lamaSewa, hitungTotal(K.getHarga(), jmlKamera, L.getHarga(), jmlLensa, 
                            lamaSewa), 0);
            
            PES.editPesananPengguna(P, user.getUsername(), id);
            
            JOptionPane.showMessageDialog(this, "Berhasil Mengedit!");
            deleteTableEdit();
            List<Pesanan> p = PES.showPesananUser(user.getUsername());
            for(int j=0;j<p.size();j++)
            {
                if(p.get(j).getStatus()==0)
                {
                    addTableEditRow(p.get(j).getId(), p.get(j).getNamaKamera(), p.get(j).getJumlahKamera(),
                                    p.get(j).getNamaLensa(), p.get(j).getJumlahLensa(), p.get(j).getLamaSewa(),
                                    p.get(j).getTotalHarga());
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Pilih pesanan telebih dahulu!");
        }catch(ExceptionPesananKosong e){
            JOptionPane.showMessageDialog(this, e.showMessage());
        }catch(ExceptionLamaSewa e){
            JOptionPane.showMessageDialog(this, e.showMessageInvalid());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_EditPesananButtonMouseClicked

    private void HapusPesananButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusPesananButtonMouseClicked
        // TODO add your handling code here:
        try{
            int j = tabelEditPesanan.getSelectedRow();
            int id = Integer.parseInt(tabelEditModel.getValueAt(j, 0).toString());
            
            PES.deletePesananPengguna(user.getUsername(), id);
            JOptionPane.showMessageDialog(this, "Pesanan Berhasil Dihapus!");
            deleteTableEdit();
            List<Pesanan> p = PES.showPesananUser(user.getUsername());
            for(int i=0;i<p.size();i++)
            {
                if(p.get(i).getStatus()==0)
                {
                    addTableEditRow(p.get(i).getId(), p.get(i).getNamaKamera(), p.get(i).getJumlahKamera(),
                                    p.get(i).getNamaLensa(), p.get(i).getJumlahLensa(), p.get(i).getLamaSewa(),
                                    p.get(i).getTotalHarga());
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "Pilih pesanan telebih dahulu!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_HapusPesananButtonMouseClicked

    private void HapusAkunButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusAkunButtonMouseClicked
        // TODO add your handling code here:
        try{
            int jawab = JOptionPane.showOptionDialog(this, "Yakin Hapus Akun?", "Hapus Akun", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(jawab == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(this, "Akun Terhapus");
                PC.deletePengguna(user.getUsername());
                user=null;
                MainPanel.removeAll();
                MainPanel.repaint();
                MainPanel.revalidate();

                MainPanel.add(PanelMasuk);
                MainPanel.repaint();
                MainPanel.revalidate();
                
                InputUsername.setText("");
                InputPassword.setText("");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_HapusAkunButtonMouseClicked

    private void KeluarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KeluarButtonMouseClicked
        // TODO add your handling code here:
        int jawab = JOptionPane.showOptionDialog(this, "Ingin Keluar?", "Keluar", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
        if(jawab == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(this, "Keluar Akun");
            user=null;
            MainPanel.removeAll();
            MainPanel.repaint();
            MainPanel.revalidate();

            MainPanel.add(PanelMasuk);
            MainPanel.repaint();
            MainPanel.revalidate();
            InputUsername.setText("");
            InputPassword.setText("");
        }
    }//GEN-LAST:event_KeluarButtonMouseClicked

    private void spinEditKameraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinEditKameraStateChanged
        // TODO add your handling code here:
        txtHargaKameraEdit.setText("");
        Kamera K = KC.searchKamera(KameraBoxEdit.getItemAt(KameraBoxEdit.getSelectedIndex()));
        float total=totalHargaBarang(Integer.parseInt(spinEditKamera.getValue().toString()),K);
        txtHargaKameraEdit.setText(String.valueOf(total));
    }//GEN-LAST:event_spinEditKameraStateChanged

    private void spinEditLensaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinEditLensaStateChanged
        // TODO add your handling code here:
        txtHargaLensaEdit.setText("");
        Lensa L = LC.searchLensa(LensaBoxEdit.getItemAt(LensaBoxEdit.getSelectedIndex()));
        float total=totalHargaBarang(Integer.parseInt(spinEditLensa.getValue().toString()),L);
        txtHargaLensaEdit.setText(String.valueOf(total));
    }//GEN-LAST:event_spinEditLensaStateChanged

    private void PesanBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PesanBtnMouseClicked
        // TODO add your handling code here:
        try{
            Kamera K = KC.searchKamera(KameraAddBox.getItemAt(KameraAddBox.getSelectedIndex()));
            Lensa L = LC.searchLensa(LensaAddBox.getItemAt(LensaAddBox.getSelectedIndex()));
            int lamaSewa = Integer.parseInt(spinAddLamaSewa.getValue().toString()); 
            int jmlLensa = Integer.parseInt(spinAddLensa.getValue().toString());
            int jmlKamera = Integer.parseInt(spinAddKamera.getValue().toString());
            cekPesananKosong(jmlKamera, jmlLensa);
            cekLamaSewa(lamaSewa);
            

            Pesanan P = new Pesanan(user.getUsername(),KameraAddBox.getItemAt(KameraAddBox.getSelectedIndex()),
                jmlKamera, LensaAddBox.getItemAt(LensaAddBox.getSelectedIndex()),
                jmlLensa, lamaSewa, hitungTotal(K.getHarga(), jmlKamera, L.getHarga(), jmlLensa,
                    lamaSewa), 0);

            PES.insertPesanan(P);
            JOptionPane.showMessageDialog(this, "Pesanan Berhasil Ditambahkan!");
        }catch(ExceptionPesananKosong e){
            JOptionPane.showMessageDialog(this, e.showMessage());
        }catch(ExceptionLamaSewa LamSew) {
            JOptionPane.showMessageDialog(this, LamSew.showMessageInvalid());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_PesanBtnMouseClicked

    private void txtTampilHargaLensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTampilHargaLensaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTampilHargaLensaActionPerformed

    private void txtTampilHargaKameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTampilHargaKameraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTampilHargaKameraActionPerformed

    private void spinAddLensaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinAddLensaStateChanged
        // TODO add your handling code here:
        txtTampilHargaLensa.setText("");
        Lensa L = LC.searchLensa(LensaAddBox.getItemAt(LensaAddBox.getSelectedIndex()));
        float total=totalHargaBarang(Integer.parseInt(spinAddLensa.getValue().toString()),L);
        txtTampilHargaLensa.setText("Rp. "+String.valueOf(total));
    }//GEN-LAST:event_spinAddLensaStateChanged

    private void spinAddKameraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinAddKameraStateChanged
        // TODO add your handling code here:
        txtTampilHargaKamera.setText("");
        Kamera K = KC.searchKamera(KameraAddBox.getItemAt(KameraAddBox.getSelectedIndex()));
        float total=totalHargaBarang(Integer.parseInt(spinAddKamera.getValue().toString()),K);
        txtTampilHargaKamera.setText("Rp. "+String.valueOf(total));
    }//GEN-LAST:event_spinAddKameraStateChanged

    private void KameraAddBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KameraAddBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_KameraAddBoxItemStateChanged

    private void InputPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            userLogin();
        }
    }//GEN-LAST:event_InputPasswordKeyPressed

    private void TxtPassword2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPassword2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            buatAkun();
        }
    }//GEN-LAST:event_TxtPassword2KeyPressed

    private void TxtUsernameEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtUsernameEditMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Username tidak dapat diedit!");
    }//GEN-LAST:event_TxtUsernameEditMouseClicked

    private void TxtPassword2EditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPassword2EditKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            editAkun();
        }
    }//GEN-LAST:event_TxtPassword2EditKeyPressed
    
   
    
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
            java.util.logging.Logger.getLogger(FormRegisterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegisterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegisterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegisterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegisterLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnTxtBuatAkun;
    private javax.swing.JLabel BtnTxtEditAkun;
    private javax.swing.JLabel BtnTxtMasuk;
    private javax.swing.JLabel BuatAkun;
    private javax.swing.JPanel BuatAkunButton;
    private javax.swing.JPanel ButtonAkun;
    private javax.swing.JPanel ButtonEdit;
    private javax.swing.JPanel ButtonPesan;
    private javax.swing.JPanel ButtonTampil;
    private javax.swing.JLabel EditAkun;
    private javax.swing.JPanel EditAkunButton;
    private javax.swing.JPanel EditPesananButton;
    private javax.swing.JPanel HapusAkunButton;
    private javax.swing.JPanel HapusPesananButton;
    private javax.swing.JPasswordField InputPassword;
    private javax.swing.JTextField InputUsername;
    private javax.swing.JComboBox<String> KameraAddBox;
    private javax.swing.JComboBox<String> KameraBoxEdit;
    private javax.swing.JPanel KeluarButton;
    private javax.swing.JPanel LeftMenuPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JComboBox<String> LensaAddBox;
    private javax.swing.JComboBox<String> LensaBoxEdit;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel Masuk;
    private javax.swing.JPanel MasukButton;
    private javax.swing.JPanel PanelAkun;
    private javax.swing.JPanel PanelEdit;
    private javax.swing.JPanel PanelMasuk;
    private javax.swing.JPanel PanelPesan;
    private javax.swing.JPanel PanelTampil;
    private javax.swing.JPanel PanelTengah;
    private javax.swing.JPanel PanelWelcome;
    private javax.swing.JPanel PesanBtn;
    private javax.swing.JTextField TxtAlamat;
    private javax.swing.JTextField TxtAlamatEdit;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtEmailEdit;
    private javax.swing.JTextField TxtName;
    private javax.swing.JTextField TxtNameEdit;
    private javax.swing.JPasswordField TxtPassword;
    private javax.swing.JPasswordField TxtPassword2;
    private javax.swing.JPasswordField TxtPassword2Edit;
    private javax.swing.JPasswordField TxtPasswordEdit;
    private javax.swing.JTextField TxtTelepon;
    private javax.swing.JTextField TxtTeleponEdit;
    private javax.swing.JTextField TxtUmur;
    private javax.swing.JTextField TxtUmurEdit;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JTextField TxtUsernameEdit;
    private javax.swing.JPanel UserMenu;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner spinAddKamera;
    private javax.swing.JSpinner spinAddLamaSewa;
    private javax.swing.JSpinner spinAddLensa;
    private javax.swing.JSpinner spinEditKamera;
    private javax.swing.JSpinner spinEditLamaSewa;
    private javax.swing.JSpinner spinEditLensa;
    private javax.swing.JScrollPane tabelEdit;
    private javax.swing.JTable tabelEditPesanan;
    private javax.swing.JTable tabelTampilPesanan;
    private javax.swing.JTextField txtHargaKameraEdit;
    private javax.swing.JTextField txtHargaLensaEdit;
    private javax.swing.JTextField txtTampilHargaKamera;
    private javax.swing.JTextField txtTampilHargaLensa;
    // End of variables declaration//GEN-END:variables
}
