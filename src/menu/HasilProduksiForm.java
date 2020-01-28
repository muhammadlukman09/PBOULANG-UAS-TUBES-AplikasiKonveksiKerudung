/*
 * //==============================================================//
 * // by lukman                                                    //
 * //==============================================================//
 */
package menu;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import utility.Koneksi;

/**
 *
 * @author lukman
 */
public class HasilProduksiForm extends javax.swing.JInternalFrame {
    ArrayList<Integer> idBahanArr = new ArrayList<>();
    ArrayList<Integer> idProdukArr = new ArrayList<>();
    
    int idBahan,idProduk, w, h, mode;
    JDesktopPane desktop;
    String QUERY_CODE, QUERY_SAVE;
    
    
    
    /**
     * Creates new form HasilProduksi
     */
    public HasilProduksiForm() {
        initComponents();
        setComboBahan();
        setComboProduk();
    }
    
    public void setDeskop(JDesktopPane desktop, int w, int h){
        this.desktop = desktop;
        this.w = w;
        this.h = h;
    }
     
    public void setField(String mode, int id){   
        switch (mode){
            case "ADD" :
                try{
                    Connection c = Koneksi.configDB();
                    Statement s = c.createStatement();
                    ResultSet rs=s.executeQuery(QUERY_CODE);
                    if(rs.first()==false){
                        idProdField.setText("1");
                    }else{
                        rs.last();
                        int no=rs.getInt(1)+1;
                        String idNumb = Integer.toString(no);
                        idProdField.setText(idNumb);
                    }
                }catch(SQLException e){
                    System.out.println("Error :" +e.getMessage());
                }
            break;
            case "EDIT" :
                try{
                    Connection Conn = (Connection) Koneksi.configDB();
                    Statement st = Conn.createStatement();
                    ResultSet res = st.executeQuery(QUERY_CODE);
                    while(res.next()){
                        idProdField.setText(res.getString(1));
                        setSelectedBahan(res.getInt(3), res.getString(4));
                        setSelectedProduk(res.getInt(2));
                        qtyField.setText(res.getString("qty"));
                        ukuranField.setText(res.getString("ukuran"));
                        
                    }
                }catch (SQLException e){
                    System.out.println(e.getMessage());
                } 
            break;
        }        
    }
    
    public void setMode(String mode, int id){
        switch (mode){
            case "ADD" :
                setTitle("ADD DATA PRODUKSI");
                QUERY_CODE = "SELECT id_produksi FROM produksi ORDER BY id_produksi ASC";
                setField(mode, id);
                this.mode = 0;
                break;
            case "EDIT" :
                idProdField.setEnabled(false);
                setTitle("EDIT DATA PRODUKSI");
                QUERY_CODE = "SELECT * FROM produksi WHERE id_produksi = '"+id+"'";
                setField(mode, id);
                this.mode = 1;
                break;
        }
    }
    
    private void setComboProduk(){
        produkCombo.addItem("pilih");
        try{
            Connection c = Koneksi.configDB();
            String sql="SELECT * FROM produk ORDER BY name ASC";
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                produkCombo.addItem(res.getString("name"));  
                idProdukArr.add(res.getInt("id_produk"));
            }
        }catch(SQLException e){
            System.out.println("Error" +e.getMessage());
        }
    }
    
    private void setSelectedProduk(int id){
        try{
            Connection c = Koneksi.configDB();
            String sql="SELECT name FROM produk WHERE id_produk = '"+id+"'";
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                produkCombo.setSelectedItem(res.getString("name"));
            }
            this.idProduk = id;
        }catch(SQLException e){
            System.out.println("Error" +e.getMessage());
        }
    }
    
    private void setComboBahan(){
        bahanCombo.addItem("pilih");
        try{
            Connection c = Koneksi.configDB();
            String sql="SELECT * FROM bahanbaku_kain ORDER BY name ASC";
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                bahanCombo.addItem(res.getString("name"));
                idBahanArr.add(res.getInt("id_kain"));
            }
        }catch(SQLException e){
            System.out.println("Error" +e.getMessage());
        }
    }
    
    private void setSelectedBahan(int id, String warna){
        try{
            Connection c = Koneksi.configDB();
            String sql="SELECT name FROM bahanbaku_kain WHERE id_kain = '"+id+"'";
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);
            if(res.next()){
                bahanCombo.setSelectedItem(res.getString(1));
                setComboWarna(id, warna);
            }  
            this.idBahan = id;
        }catch(SQLException e){
            System.out.println("Error" +e.getMessage());
        }
    }
    
    private void setComboWarna(Integer id, String warna) {
        String color;
        try{
            Connection c = Koneksi.configDB();
            String sql="SELECT color FROM bahanbaku_kain WHERE id_kain = '"+id+"'";
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                color = res.getString("color");
                String[] colorArr = color.split(",");
                warnaCombo.setModel(new DefaultComboBoxModel(colorArr));
            }
            if (!warna.isEmpty()){
                setSelectedWarna(id, warna);
            }
        }catch(SQLException e){
            System.out.println("Error" +e.getMessage());
        }
    }
    
    private void setSelectedWarna(Integer id, String warna) {
        String color;
        try{
            Connection c = Koneksi.configDB();
            String sql="SELECT color FROM bahanbaku_kain WHERE id_kain = '"+id+"'";
            Statement s = c.createStatement();
            ResultSet res = s.executeQuery(sql);
            while(res.next()){
                color = res.getString("color");
                String[] colorArr = color.split(",");
                warnaCombo.setModel(new DefaultComboBoxModel(colorArr));
            }
            if (!warna.isEmpty()){
                warnaCombo.setSelectedItem(warna);
            }
        }catch(SQLException e){
            System.out.println("Error" +e.getMessage());
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

        bahanCombo = new javax.swing.JComboBox<>();
        warnaCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        produkCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idProdField = new javax.swing.JTextField();
        qtyField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ukuranField = new javax.swing.JTextField();

        bahanCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bahanComboActionPerformed(evt);
            }
        });

        warnaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih" }));
        warnaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warnaComboActionPerformed(evt);
            }
        });

        jLabel1.setText("id produksi");

        jLabel2.setText("produk");

        jLabel3.setText("bahan");

        produkCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produkComboActionPerformed(evt);
            }
        });

        jLabel4.setText("warna");

        jLabel5.setText("QTY");

        saveButton.setText("SAVE");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("CANCEL");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Ukuran");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bahanCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(warnaCombo, 0, 214, Short.MAX_VALUE)
                            .addComponent(produkCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idProdField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ukuranField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idProdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(produkCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bahanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(warnaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(qtyField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ukuranField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bahanComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bahanComboActionPerformed
        if(bahanCombo.getSelectedItem() != null && idBahanArr.size() > 0){
            int id = bahanCombo.getSelectedIndex()-1;
            idBahan = idBahanArr.get(id);
            setComboWarna(idBahanArr.get(id), "");
        }
    }//GEN-LAST:event_bahanComboActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
    String id = idProdField.getText();
    String qty = qtyField.getText();
    String ukuran = ukuranField.getText();
    String warna = warnaCombo.getSelectedItem().toString();

    
    if (id.equals("") || produkCombo.getSelectedItem().equals("pilih") || bahanCombo.getSelectedItem().equals("pilih")
            || warnaCombo.getSelectedItem().equals("pilih") || qty.equals("")){
        JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
    }else{
        try{     
            if ( mode == 0){
                
                QUERY_SAVE = "INSERT INTO `produksi` (`id_produksi`, `id_produk`, `id_kain`, `warna`, `qty`, `ukuran` ) "
                        + "VALUES ('"+id+"', '"+idProduk+"', '"+idBahan+"', '"+warna+"', '"+qty+"', '"+ukuran+"')";
            } else {
                QUERY_SAVE = "UPDATE `produksi` SET `id_produk` = '"+idProduk+"', "
                        + "`id_kain` = '"+idBahan+"', "
                        + "`warna` = '"+warna+"', "
                        + "`qty` = '"+qty+"', "
                        + "`ukuran` = '"+ukuran+"', "
                        + "WHERE `produksi`.`id_produksi` = '"+id+"'";
            }

            Connection Conn = (Connection) Koneksi.configDB();
            PreparedStatement sql = Conn.prepareStatement(QUERY_SAVE);
            sql.execute();
            JOptionPane.showMessageDialog(null, "SUKSES");
            this.dispose();
            HasilProduksi p= new HasilProduksi();
            desktop.add(p);
            p.setDeskop(desktop, w, h);
            p.setLocation((w - p.getSize().width)/2, (h-p.getSize().height)/2);
            p.toFront();
            p.setVisible(true);
            this.dispose();            
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void warnaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warnaComboActionPerformed
        
    }//GEN-LAST:event_warnaComboActionPerformed

    private void produkComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produkComboActionPerformed
        if(idProdukArr.size() > 0){
            int id = produkCombo.getSelectedIndex()-1;
            idProduk = idProdukArr.get(id);
        }
    }//GEN-LAST:event_produkComboActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        HasilProduksi p= new HasilProduksi();
        desktop.add(p);
        p.setDeskop(desktop, w, h);
        p.setLocation((w - p.getSize().width)/2, (h-p.getSize().height)/2);
        p.toFront();
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_cancelButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bahanCombo;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField idProdField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> produkCombo;
    private javax.swing.JTextField qtyField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField ukuranField;
    private javax.swing.JComboBox<String> warnaCombo;
    // End of variables declaration//GEN-END:variables

    
}
