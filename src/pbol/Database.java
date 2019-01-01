/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbol;
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.Properties; 
import javax.swing.JOptionPane; 
/**
 *
 * @author Hanif-Nisrina
 */
public class Database {
    public Properties Koneksi; 
    private String BukaKoneksi; 
        public Database (){ 
        } 
        public String SettingPanel(String mnpanel){ 
            try { 
                Koneksi=new Properties(); 
                Koneksi.load(new FileInputStream("./dist/lib/Settingdb.ini")); 
                BukaKoneksi=Koneksi.getProperty(mnpanel); 
            } catch (IOException e){ 
                JOptionPane.showMessageDialog(null,"tidak ada konesi dengan database","error",
                        JOptionPane.INFORMATION_MESSAGE); 
                System.err.println(e.getMessage()); 
                System.exit(0); 
                return BukaKoneksi; 
            } 
                return BukaKoneksi; 
        }
}
