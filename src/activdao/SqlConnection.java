package activdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlConnection implements IBancoDTO{
    
    public Connection connection = null;
    public Statement smt;
    
     public SqlConnection()
    {
        // configurações do banco de dados
        
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=dao_activ;trustServerCertificate=true";

        try {
            Class.forName(DRIVER); // Carrega o Driver

            // Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(DATABASE_URL, "sa", "unip123");
            smt = connection.createStatement();
            System.out.println("Conectou com o banco de dados");

        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }  
    }
     
    @Override
    public void CadastrarCliente(Cliente c) {
       try{
        //Statement smt = connection.createStatement();
        smt.executeUpdate("insert into Cliente (id, cpf, nome) values ('" +  c.getId() + "', '" +  c.getCpf()+ "','" + c.getNome()+ "')");
        System.out.println("Inseriu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
   @Override
   public void ExcluirCliente(Cliente c) {
        try{
        
        smt.executeUpdate("delete from cliente where nome = '" + c.getNome() + "'");
        System.out.println("Excluiu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
   
   
    @Override
    public List<Cliente> ListarCliente() {
        List<Cliente> resultado = new ArrayList();
        
        try{
        //Statement smt = connection.createStatement();
        ResultSet resultSet = smt.executeQuery("select * from cliente");
        
        while (resultSet.next()) {
           // System.out.println(resultSet.getString("NOME"));
            
            Cliente c = new Cliente();
            c.setNome(resultSet.getString("nome"));
            c.setCpf(resultSet.getString("cpf"));

            resultado.add(c);
        }

        return resultado;
        
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
          return null;
        }
    } 
}
