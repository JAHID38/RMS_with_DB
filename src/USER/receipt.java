
package USER;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class receipt extends javax.swing.JFrame {


    Connection conn = null;
    Statement s = null;
    ResultSet r = null;
    PreparedStatement ps = null;
    String time, date;
    Calendar Time = Calendar.getInstance();
        
    String name;
        
        SimpleDateFormat set_Time = new SimpleDateFormat ("HH: mm: ss a");
        SimpleDateFormat set_Date = new SimpleDateFormat ("dd MMM yyyy");
    public receipt() {
        initComponents();
        conn = def.connect.connect();
        
        Time.getTime();
        date = set_Date.format(Time.getTime());
        time = set_Time.format(Time.getTime());
        
        method();
        database();
    }
    
    public void database(){
        try{
            
            String sql;
            int c, u, p;
            String food;

            
            s = conn.createStatement();
            sql = "SELECT * FROM INSTANT";
            
            r = s.executeQuery(sql);
            while (r.next())
            {
                c = r.getInt(1);
                food = r.getString(2);
                u = r.getInt(3);
                p = r.getInt(4);
                
                receipt.append(""+c+"\t"+food+"\t\t"+u+"\t"+p+"\n"
                        + "");
            }
        } catch (Exception e){
            
        }
        receipt.append(
                "--------------------------------------------------------\n"+
                "Grand Total :\t\t\t"+Payment.bill.getText()+
                "\n\n\n\t\t\tTHANK YOU!\n\t\t\t**********"
        );
    }

    
    public void method(){
        
        name = CustomerData.customer.getText().toUpperCase();
        String add = CustomerData.address.getText().toUpperCase();
        String phone = CustomerData.mobile.getText();
        
        
  
        
        receipt.append("========================================================"
                + "\n\t\t\tRECEIPT\n"
                +"========================================================"
                +"\nDate: "+date+"\t\t"
                        +"Time: "+time
                +"\n\nCustomer Name: "+name+"\n"
                        +"Customer Address: " +add+ "\n"
                                +"Mobile No: " +phone+ "\n"
                                        +"========================================================"
                +"\n"
                +"CODE\tFOOD_NAME\tUNIT\tPRICE\n"
                +"========================================================\n"          
        );
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        receipt = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        receipt.setEditable(false);
        receipt.setColumns(20);
        receipt.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        receipt.setLineWrap(true);
        receipt.setRows(5);
        jScrollPane2.setViewportView(receipt);

        jLabel5.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("RESTAURANT MANAGEMENT SYSTEM");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 51, 255)));

        jButton1.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(165, 165, 165)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(421, 421, 421)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String sql, insert;
        
        insert = "INSERT INTO customer (code, food, unit, total) SELECT * FROM instant";
        try {
            sql = "DROP TABLE instant";
            s.executeUpdate(insert);
            s.executeUpdate(sql);
            new def.welcome().setVisible(true);
            dispose();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea receipt;
    // End of variables declaration//GEN-END:variables
}
