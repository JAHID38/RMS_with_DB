
package def;
import java.sql.*;
import javax.swing.JOptionPane;

public class connect {
    
    public static Connection connect() {
        
        Connection c = null;
        String reg, url;

        String user = "RMS";
        String password = "Oracle_1";
        
        reg = "oracle.jdbc.OracleDriver";
        url = "jdbc:oracle:thin:@localhost:1521:orcl";

        try {
            Class.forName(reg);
            c = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
        }
        
        return c;
    } 
}