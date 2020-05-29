package USER;

import ADMIN.TableModel;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class user extends javax.swing.JFrame {

    Connection conn = null;
    Statement s = null;
    ResultSet r = null;
    PreparedStatement ps = null;

    String imgPath = null;

    public user() {

        conn = def.connect.connect();
        createTable();
        initComponents();
    }

    public ArrayList<food> getMenu() {

        ArrayList<food> menu = new ArrayList<food>();
        //conn = def.connect.connect();
        String sql = "SELECT * FROM food";
        food obj;

        try {
            s = conn.createStatement();
            r = s.executeQuery(sql);

            while (r.next()) {
                obj = new food(
                        r.getInt("CODE"),
                        r.getString("CATEGORY"),
                        r.getString("FOOD"),
                        r.getInt("PRICE"),
                        r.getString("DATES"),
                        r.getBytes("IMAGE")
                );
                menu.add(obj);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return menu;
    }

    public void showTable() {

        ArrayList<food> table = getMenu();

        String[] columnName = {"CODE", "CATEGORY", "FOOD_NAME", "PRICE", "DATES", "IMAGE"};
        Object[][] record = new Object[table.size()][6];

        for (int i = 0; i < table.size(); i++) {
            record[i][0] = table.get(i).getCode();
            record[i][1] = table.get(i).getCategory();
            record[i][2] = table.get(i).getFood();
            record[i][3] = table.get(i).getPrice();
            record[i][4] = table.get(i).getDate();
            ImageIcon image = new ImageIcon(new ImageIcon(table.get(i).getImage()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
            record[i][5] = image;

            TableModel model = new TableModel(record, columnName);
            jtable.setModel(model);
            jtable.setRowHeight(130);
            jtable.getColumnModel().getColumn(5).setPreferredWidth(200);

        }
    }

    public void showOrderTable() {

        ArrayList<food> table = getMenu();

        String[] columnName = {"CODE", "FOOD_NAME", "PRICE"};
        Object[][] record = new Object[table.size()][3];

        for (int i = 0; i < table.size(); i++) {
            record[i][0] = table.get(i).getCode();
            record[i][1] = table.get(i).getFood();
            record[i][2] = table.get(i).getPrice();

            TableModel model = new TableModel(record, columnName);
            order.setModel(model);
            order.setRowHeight(30);

        }
    }

    public void createTable() {
        String sql;

        sql = "CREATE TABLE instant ("
                + "code int not null, food varchar (50), unit int, total int, "
                + "primary key (code) )";
        try {
            s = conn.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {

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

        jLabel1 = new javax.swing.JLabel();
        welcome = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jprice = new javax.swing.JTextField();
        jfood = new javax.swing.JTextField();
        jcode = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        order = new javax.swing.JTable();
        show = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        unit = new javax.swing.JTextField();
        orderBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RESTAURANT MANAGEMENT SYSTEM");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 51, 255)));

        welcome.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        welcome.setText("WELCOME");
        welcome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Script MT Bold", 1, 30)); // NOI18N
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        jLabel3.setText("WELCOME TO RESTAURANT MANAGEMENT SYSTEM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jtable.setBackground(new java.awt.Color(0, 204, 204));
        jtable.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODE", "CATEGORY", "FOOD_NAME", "PRICE", "DATE", "IMAGE"
            }
        ));
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", jPanel2);

        jLabel2.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N
        jLabel2.setText("Code");

        jLabel4.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N
        jLabel4.setText("Food Name");

        jLabel5.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N
        jLabel5.setText("Unit Price");

        jprice.setEditable(false);
        jprice.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N

        jfood.setEditable(false);
        jfood.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N

        jcode.setEditable(false);
        jcode.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N

        reset.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        order.setBackground(new java.awt.Color(0, 204, 204));
        order.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        order.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(order);

        show.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        show.setText("Show");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N
        jLabel6.setText("  Unit");

        unit.setFont(new java.awt.Font("Constantia", 0, 20)); // NOI18N

        orderBtn.setFont(new java.awt.Font("Monotype Corsiva", 1, 24)); // NOI18N
        orderBtn.setText("Order");
        orderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jprice, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jfood, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcode, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(273, 273, 273))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jfood, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jprice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(show, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Order", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcome)
                .addGap(299, 299, 299)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void welcomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeActionPerformed

        new def.welcome().setVisible(true);
        dispose();
    }//GEN-LAST:event_welcomeActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed

        int opt = JOptionPane.showConfirmDialog(this, "Confirm to Exit", "EXIT", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_exitActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        showTable();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:

        jcode.setText(null);

        jfood.setText(null);
        jprice.setText(null);
        unit.setText(null);

    }//GEN-LAST:event_resetActionPerformed

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked

    }//GEN-LAST:event_jtableMouseClicked

    private void orderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderMouseClicked
        // TODO add your handling code here:

        TableModel model = (TableModel) order.getModel();
        int row = order.getSelectedRow();

        jcode.setText(model.getValueAt(row, 0).toString());
        jfood.setText(model.getValueAt(row, 1).toString());
        jprice.setText(model.getValueAt(row, 2).toString());
    }//GEN-LAST:event_orderMouseClicked

    private void showActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showActionPerformed
        // TODO add your handling code here:
        showOrderTable();
    }//GEN-LAST:event_showActionPerformed

    private void orderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderBtnActionPerformed
        // TODO add your handling code here:\
        int Price = Integer.parseInt(jprice.getText());
        int Unit = Integer.parseInt(unit.getText());
        int sum = Price * Unit;

        String sql = "INSERT INTO instant VALUES(?, ?, ?, ?)";

        try {
                        
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(jcode.getText()));
            ps.setString(2, jfood.getText());
            ps.setInt(3, Integer.parseInt(unit.getText()));
            ps.setInt(4, sum);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        JOptionPane.showMessageDialog(null, "Item has been ordered");
        int opt = JOptionPane.showConfirmDialog(this, "Do you want to order more", "Order", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            jcode.setText(null);
            jfood.setText(null);
            jprice.setText(null);
            unit.setText(null);
        } else {
            new CustomerData().setVisible(true);
            dispose();
        }

    }//GEN-LAST:event_orderBtnActionPerformed

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jcode;
    private javax.swing.JTextField jfood;
    private javax.swing.JTextField jprice;
    private javax.swing.JTable jtable;
    private javax.swing.JTable order;
    private javax.swing.JButton orderBtn;
    private javax.swing.JButton reset;
    private javax.swing.JButton show;
    private javax.swing.JTextField unit;
    private javax.swing.JButton welcome;
    // End of variables declaration//GEN-END:variables
}
