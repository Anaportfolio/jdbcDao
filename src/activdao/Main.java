package activdao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       
        
       Cliente c1 = new Cliente();
       c1.setId(1);
       c1.setNome("Maria");
       c1.setCpf("12345678912");
       
       
       Cliente c2 = new Cliente();
       c2.setId(1);
       c2.setNome("Pedro");
       c2.setCpf("12345678913");
       
       IBancoDTO banco = new SqlConnection();
       
        banco.CadastrarCliente(c2);  
        banco.ExcluirCliente(c1);
        
        List<Cliente> clientes = banco.ListarCliente();
         
         for (int i = 0; i <= clientes.size()-1; i++)
         {
             System.out.println(clientes.get(i).getNome());
             System.out.println(clientes.get(i).getCpf());
         }  
    }
    
}
