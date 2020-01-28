/*
 * //==============================================================//
 * // by lukman                                                     //
 * //==============================================================//
 */
package menu;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utility.Koneksi;

/**
 *
 * @author lukman
 */
public class HasilProduksi extends javax.swing.JInternalFrame {
    ArrayList<Integer> idProdArr = new ArrayList<>();
    String produk, bahan, warna;
    int idProd, w, h;
    JDesktopPane desktop;
    
    /**
     * Creates new form HasilProduksi
     */
    public HasilProduksi() {
        initComponents();
        setDataToTable();
        setTitle("DATA HASIL PRODUKSI");
    }
    
    public void setDeskop(JDesktopPane desktop, int w, int h){
        this.desktop = desktop;
        this.w = w;
        this.h = h;
    }
    
    private void setDataToTable(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("Produk");
        tabel.addColumn("Bahan");
        tabel.addColumn("Warna");
        tabel.addColumn("QTY");
        tabel.addColumn("Ukuran");
       

        try{           
            String sql = "SELECT produksi.id_produksi, produksi.warna, produksi.qty, produk.name, bahanbaku_kain.name, produksi.ukuran FROM produksi "
                    + "INNER JOIN produk ON produksi.id_produk = produk.id_produk "
                    + "INNER JOIN bahanbaku_kain ON produksi.id_kain = bahanbaku_kain.id_kain ORDER BY produk.name ASC";
            java.sql.Connection Conn = (Connection) Koneksi.configDB();
            java.sql.Statement st = Conn.createStatement();
            java.sql.ResultSet res = st.executeQuery(sql);
            while(res.next()){
                tabel.addRow(new Object[]{
                    res.getString(4),res.getString(5),res.getString(2),res.getString(3),res.getString(6)
                });
                idProdArr.add(res.getInt(1));
            }
            hasilProdTable.setModel(tabel);
        }catch (SQLException e){
            System.out.println(e.getMessage());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        hasilProdTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);

        hasilProdTable.setModel(new javax.swing.table.DefaultTableModel(
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
        hasilProdTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hasilProdTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(hasilProdTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(189, 189, 189))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HasilProduksiForm p= new HasilProduksiForm();
        desktop.add(p);
        p.setDeskop(desktop, w, h);
        p.setLocation((w - p.getSize().width)/2, (h-p.getSize().height)/2);
        p.setMode("ADD", 0);
        p.toFront();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void hasilProdTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hasilProdTableMouseClicked
       int baris = hasilProdTable.rowAtPoint(evt.getPoint());
       idProd = idProdArr.get(baris);
       produk = hasilProdTable.getValueAt(baris, 0).toString();
       bahan = hasilProdTable.getValueAt(baris, 1).toString();
       warna = hasilProdTable.getValueAt(baris, 2).toString();
     
    }//GEN-LAST:event_hasilProdTableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (idProd > 0){
            HasilProduksiForm p= new HasilProduksiForm();
            desktop.add(p);
            p.setDeskop(desktop, w, h);
            p.setLocation((w - p.getSize().width)/2, (h-p.getSize().height)/2);
            p.setMode("EDIT", idProd);
            p.toFront();
            p.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di edit");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (idProd > 0){
            int a;
            a=JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus \n"+produk.toUpperCase()+" "+bahan.toUpperCase()+" "+warna.toUpperCase()+"\ndari daftar Hasil Produksi?", "HAPUS", JOptionPane. YES_NO_OPTION);
            if(a == JOptionPane.YES_OPTION){
                try{
                    String del = "DELETE FROM produksi WHERE id_produksi = '"+idProd+"'";
                    java.sql.Connection Conn = (Connection) Koneksi.configDB();
                    java.sql.PreparedStatement sql = Conn.prepareStatement(del);
                    sql.execute();
                    JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
                    setDataToTable();
                }catch (HeadlessException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Hapus Gagal..!!");
                    System.out.println(e.getMessage());
                }
            }        
        }else{
            JOptionPane.showMessageDialog(null, "Silahkan pilih data yang akan di edit");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable hasilProdTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
