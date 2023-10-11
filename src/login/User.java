package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Daniel Ohata
 *
 * Classe contém métodos de conexão com MySQL DB e verificação de usuário.
 */
public class User {

    /**
     *
     * Método para a realização da conexão com banco de dados.
     *
     * @return Conexão.
     */
    public Connection conectarBD() {
        /**
         * Inicialização de variável de conexão.
         */
        Connection conn = null;

        try {
            //Tentativa de conexão com o driver JDBC.
            Class.forName("com.mysql.Driver.Manager").newInstance();

            //Tentativa de conexão com o banco de dados a partir do driver.
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        }catch  (Exception e) {
            //Bloco de tratamento de excessão
        }
        return conn;}

    /**
     * Inicialização de variável para verificar nome do usuário.
     */
    public String nome="";

    /**
     * Inicialização de variável para verificar existência do usuário.
     */
    public boolean result = false;

    /**
     *
     * Método para verificação de existência do usuário.
     *
     * @param login Verificação de username do usuário.
     * @param senha Verificação da senha do usuário.
     * @return Existência do usuário (verdadeiro ou falso).
     */

    public boolean verificarUsuario(String login, String senha) {
        /**
         * Inicialização das variáveis para realizar conexão
         * com o banco de dados.
         */
        String sql = "";
        Connection conn = conectarBD();

        //Instruções para consulta SQL.
        sql += "select nome from usuarios ";
        sql +="where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try{
            //Tentativa da realização de consulta no banco de dados.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //Verificação das informações retornadas pelo banco de dados.
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");}
        }catch (Exception e) {
            //Bloco de tratamento de excessão.
        }
        return result; }
} //Fechamento da classe User.