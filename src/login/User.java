package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.Driver.Manager").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);

        //6
        }catch  (Exception e) { }
        return conn;}

    //1
    public String nome="";
    public boolean result = false;

    //2
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";

        //3
        Connection conn = conectarBD();
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        //4
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //5
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");}

        //6
        }catch (Exception e) { }

        //7
        return result; }
}