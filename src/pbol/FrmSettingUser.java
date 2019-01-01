package pbol;


import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import sun.security.provider.MD5;
import pbol.MainMenu;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hanif-Nisrina
 */
public class FrmSettingUser extends javax.swing.JFrame {

    /**
     * Creates new form FrmSettingUser
     */
    DefaultListModel pilih;
    public FrmSettingUser() {
        initComponents();
        pilih=new DefaultListModel();
        MainMenu n=new MainMenu();
        lisuser.setModel(pilih);
        int i=0;
        int a=0;
        for (i=0; i<n.jMenuBar1.getMenuCount()-1; i++){
            for (a=0; a<n.jMenuBar1.getMenu(i).getItemCount();a++){
                pilih.addElement(n.jMenuBar1.getMenu(i).getItem(a).getText().toString());
            }
        }
        bersih();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lisuser = new javax.swing.JList<>();
        mnsimpan = new javax.swing.JButton();
        txtuser = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(lisuser);

        mnsimpan.setText("Simpan");
        mnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnsimpanActionPerformed(evt);
            }
        });

        txtuser.setText("jTextField1");

        txtpassword.setText("jTextField2");

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mnsimpan)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtuser, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                                    .addComponent(txtpassword))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(mnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bersih(){
        txtpassword.setText("");
        txtuser.setText("");
        lisuser.clearSelection();
}
    private void mnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnsimpanActionPerformed
        String stracak;
        String strhak="";
        String pwd="";
        char s;
        for (int i=0; i<lisuser.getVisibleRowCount()-1;i++){
            if(lisuser.isSelectedIndex(i)==true){
            //JOptionPane.showMessageDialog(null, lisuser.getModel().getElementAt(i).toString());
            int a=i+67;
            s=(char)a;
            strhak=strhak+s;
            }
            
          //JOptionPane.showMessageDialog(null, strhak);  
        }
        
        try { 
            Class.forName(MainMenu.driver); 
            Connection konek = DriverManager.getConnection(MainMenu.database, MainMenu.user, MainMenu.pass); 
            Statement  stt =  konek.createStatement();
            ResultSet res = stt.executeQuery("select md5("+txtpassword.getText()+") as a");
            
            while (res.next()){
                pwd=res.getString("a");
            }
            res.close();
            String str="Insert into tbuser (dtuser, passwd, hakakses) values ('" + txtuser.getText().toString()+"', '"+pwd+"', '"+strhak+"')";
            //JOptionPane.showMessageDialog(null, str);
            stt.execute(str);
           // res.close();  
            konek.close(); 
            
        } catch(Exception exc){ 
            System.err.println(exc.getMessage()); 
            JOptionPane.showMessageDialog(null, exc); 
        }
    }//GEN-LAST:event_mnsimpanActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSettingUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSettingUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSettingUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSettingUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSettingUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lisuser;
    private javax.swing.JButton mnsimpan;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}