import java.sql.*;
import java.util.ArrayList;

/*
comment line is for mariaDB
I also add my example sql query file in database folder if you want to use mariaDB or Others.
 */
public class connectionManager {
    //static final String jdbcUrl = "jdbc:mariadb://localhost:3306/database";
    static final String jdbcUrl = "jdbc:sqlite:./database/shapeDatabase.sqlite3";
    //static final String jdbcDriver = "org.mariadb.jdbc.Driver";
    String userName, password;
    Connection con;
    Statement st;

    public connectionManager() {
        //userName = "root";
        //password = "password";
        try {
            //Class.forName(jdbcDriver);
            //con = DriverManager.getConnection(jdbcUrl, userName, password);
            con = DriverManager.getConnection(jdbcUrl);
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
            String[] q = {rst.getString("object"), rst.getString("location"), rst.getString("shape"),
                    rst.getString("param1"), rst.getString("param2"), rst.getString("param3"), rst.getString("color")};
            result.add(q);
        }
        return result;

    }
}
