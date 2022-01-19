import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class connectionManager {
    static final String jdbcUrl = "jdbc:mariadb://localhost/db1";
    static final String jdbcDriver = "org.mariadb.jdbc.Driver";
    String userName, password;
    Connection con;
    Statement st;

    public connectionManager() {
        userName = "root";
        password = "@MayMaria4862";
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(jdbcUrl, userName, password);
            st = con.createStatement();
            System.out.println("Connection is successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String[]> getqueryall() throws SQLException {
        String sql = "Select * from shapes";
        ResultSet rst;
        rst = st.executeQuery(sql);
        ArrayList<String[]> result = new ArrayList<String[]>();
        while (rst.next()) {
            String[] q = { rst.getString("object"), rst.getString("location"), rst.getString("shape"),
                    rst.getString("param1"), rst.getString("param2"), rst.getString("param3"), rst.getString("color") };
            result.add(q);
        }
        return result;

    }
}
