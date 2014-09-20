package persistence.simple.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMain {


    public static void main(String[] args) throws SQLException {
//        String connectionUrl = "jdbc:h2:~/training-test-jdbc.db";

        String connectionUrl = "jdbc:h2:mem:training-test-jdbc.db";

        // No need for Class.forName() with newer JDBC versions
        try (Connection conn = DriverManager.getConnection(connectionUrl, "sa", "")) {

            Statement statement = conn.createStatement();
            statement.execute("drop table t1 if exists ");
            statement.execute("create table t1(id int primary key, name char)");
            statement.execute("insert into t1(id,name) values (1,'jdbc')");
            statement.execute("insert into t1(id,name) values (2,'java')");
            statement.execute("insert into t1(id,name) values (3,'trainig')");
            statement.execute("insert into t1(id,name) values (4,'persistence')");

            ResultSet resultSet = statement.executeQuery("select * from t1");

            printResults(resultSet);
        }
    }

    private static void printResults(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("Found record: " + id + " " + name);
        }
    }
}
