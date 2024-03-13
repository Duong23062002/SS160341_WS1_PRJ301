package Context;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBContext {

    
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +
                ";databaseName="+dbName;//+"; integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
        return DriverManager.getConnection(url, userID, password);

    }

    public DBContext() {

    }

    public DBContext(String u, String p) {
        userID = u;
        password = p;
    }
    
    private final String serverName = "localhost";
    private final String dbName = "MyStock";
    private final String portNumber = "1433";
    private String userID = "sa";
    private String password = "123";

    public static void main(String[] args) {
        try {
            new DBContext().getConnection();
            System.out.println("Ket noi thanh cong");
        } catch (Exception e) {
            System.out.println("Ket noi that bai" + e.getLocalizedMessage());
        }
    }
}
