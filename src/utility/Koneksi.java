/*
 * //==============================================================//
 * // 
 * // Nama    :
 * // NPM     :
 * // Jurusan :
 * // Tugas   :
 * //==============================================================//
 */
package utility;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author fahru
 */
public class Koneksi {
    private static Connection mysqlconfig;
    
    
    public static Connection configDB()throws SQLException{
        try{
            String url="jdbc:mysql://localhost/konveksi_kerudung";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = (Connection) DriverManager.getConnection(url, user, pass);
            
            //uncoment kode dibawah ini untuk testing koneksi 
//            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi Database Gagal");
        }
        return mysqlconfig;
    }
}
