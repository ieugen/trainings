package persistence.simple.jdbc;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceMain {

    public static void main(String[] args) throws SQLException {

        JdbcDataSource dataSource = new JdbcDataSource();
//        dataSource.setUrl("jdbc:h2:~/datasource-test.db");
        dataSource.setUrl("jdbc:h2:mem:test");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        statement.execute("drop table t1 if exists ");
        statement.execute("create table t1(id int primary key, name char)");
        statement.execute("insert into t1(id,name) values (1,'jdbc')");
        statement.execute("insert into t1(id,name) values (2,'java')");
        statement.execute("insert into t1(id,name) values (3,'trainig')");
        statement.execute("insert into t1(id,name) values (4,'persistence')");

        ResultSet resultSet = statement.executeQuery("select * from t1");

        printResults(resultSet);
    }

    private static void printResults(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("Found record: " + id + " " + name);
        }
    }

}
