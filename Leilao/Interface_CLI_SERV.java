import java.rmi.*;
import java.util.Map;
public interface Interface_CLI_SERV extends Remote{

    Map.Entry<String, Integer> maiorlance();
    // verificar o maior lance feito no leilao
    int TempoLeilao (  int tempo );
    // determinar tempo do leilao em minutos
    boolean Cadastro(String cpf, String senha, boolean admin)throws RemoteException;
    //cadastrar cpf e senha , perguntar se é adm
    boolean Login ( String cpf , String senha )throws RemoteException;
    //logar com cpf e senha 
    boolean Logout(boolean sair )throws RemoteException;
    // passar uma pergunta de deseja sair 

    boolean  OfertarLance(String codigoOfertado, int valorOfertado )throws RemoteException;
    Map<String, Integer> listarLances() throws RemoteException;
    // pensando em colocar o codigo do produto no primeiro interger e o valor no segundo 
    
    
    // uma lista de lances do usuario e depois verificar o maior no laço no arraylist



    // inicializar metodos 
}