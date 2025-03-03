package Infra.Drivers.DB;

import Infra.Api.Drivers.DbDriver;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mysql implements DbDriver
{
    protected Connection conn = null;
    protected PreparedStatement statement;
    protected Dotenv env;

    public Mysql(Dotenv env)
    {
        this.env = env;
    }

    /**
     * Connect to driver and database
     */
    public void connect()
    {
        String host = this.env.get("DB_HOST");
        String database = this.env.get("DB_DATABASE");
        String user = this.env.get("DB_USER");
        String password = this.env.get("DB_PASSWORD");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Erro a fazer conexão com a lib");
            System.exit(0);
        }

        try {
            this.conn =  DriverManager.getConnection(
                "jdbc:mysql://" + host + "/" + database
                    + "?user=" + user
                    + "&password=" + password
            );
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            System.exit(0);
        }
    }

    /**
     * Query db
     *
     * @param query String
     * @return DbDriver
     */
    @Override
    public DbDriver query(String query)
    {
        try {
            this.statement = this.conn.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            System.exit(0);
        }

        return this;
    }

    /**
     * Get select data
     *
     * @return String[]
     */
    @Override
    public List<String[]> get()
    {
        try {
            List<String[]> data = new ArrayList<>();
            ResultSet result = this.statement.executeQuery();
            ResultSetMetaData resulMetadata = result.getMetaData();
            int columnsCount = resulMetadata.getColumnCount();
            while(result.next()) {
                String[] row = new String[columnsCount];
                for(int i = 0; i < columnsCount; i++) {
                    row[i] = result.getString(i + 1);
                }
                data.add(row);
            }

            return data;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            System.exit(0);
        }
        return null;
    }

    /**
     * Get select first
     *
     * @return String[]
     */
    @Override
    public String[] first() {
        try {
            List<String[]> data = new ArrayList<>();
            ResultSet result = this.statement.executeQuery();
            ResultSetMetaData resulMetadata = result.getMetaData();
            int columnsCount = resulMetadata.getColumnCount();
            result.next();

            String[] row = new String[columnsCount];
            for(int i = 0; i < columnsCount; i++) {
                row[i] = result.getString(i + 1);
            }
            return row;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            System.exit(0);
        }
        return null;
    }

    /**
     * Close connection
     */
    @Override
    public void close() {
        try {
           this.conn.close();
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            System.exit(0);
        }
    }
}