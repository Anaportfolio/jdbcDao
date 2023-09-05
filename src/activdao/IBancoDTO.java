package activdao;

import java.util.List;

public interface IBancoDTO {
    void CadastrarCliente(Cliente c);
    void ExcluirCliente(Cliente c);
    List<Cliente> ListarCliente(); 
}
