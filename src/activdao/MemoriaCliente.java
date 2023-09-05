package activdao;

import java.util.ArrayList;
import java.util.List;

public class MemoriaCliente implements IBancoDTO{
    
    private List<Cliente> bancoMemoria;
    
    public MemoriaCliente()
    {
        bancoMemoria = new ArrayList<Cliente>();
    }

    @Override
    public void CadastrarCliente(Cliente c) {
        bancoMemoria.add(c);
    }

    @Override
    public void ExcluirCliente(Cliente c) {
        bancoMemoria.remove(c);
    }

    @Override
    public List<Cliente> ListarCliente() {
        return bancoMemoria;
    }   
}
