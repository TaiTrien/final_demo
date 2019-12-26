package DAL;

import java.sql.*;

public class InitConnection {
    public Connection InitConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLPT;integratedSecurity=true;"); //kết nối với SQL Server offline, cần copy sqljdbc_auth.dll vào sdk's bin folder
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        return connection;
    }
}
