import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Servidor extends UnicastRemoteObject implements Interface_CLI_SERV {
private static final long serialVersionUID = 1L;

private Map<String, Integer> lances = new ConcurrentHashMap<>();



    public Servidor  (  ) throws RemoteException {
     super(); // importante para UnicastRemoteObject
    InicializarLances();
        

    }

   public  void  InicializarLances(){

       lances.put( "Cl34" , 5000);
       lances.put( "AS21" , 3450);
       lances.put( "NB67" , 8000);
       lances.put( "VF54" , 7000);
       lances.put( "HJ31" , 5700);
       lances.put( "GD54" , 5000);
       lances.put( "DS45" , 5000);
       lances.put( "AD29" , 5000);


    }

    
    @Override
     public  boolean  OfertarLance(String codigoOfertado, int valorOfertado ){
        if (codigoOfertado == null) return false;


        String chave = codigoOfertado.trim().toUpperCase();; 
        // armazena o codigo ofertado em uma variavel 

        Integer valorAtual = lances.get(chave);
        //O Java vai procurar dentro do Map lances pela chave "CL34".
        //Como ela existe (foi criada no inicializarLances()),
        //ele encontra o valor por ex 5000 e guarda na variável:
        
         
          if(valorAtual == null){
             System.out.println("Código inválido: " + chave);
            return false;
         }
         int lanceatual = valorAtual + valorAtual*5/100;
         System.out.println("Lance mínimo para " + chave + " é: " + lanceatual);
         if (valorOfertado>lanceatual){
            lances.put(chave,valorOfertado);
            System.out.println("Lance atualizado! " + chave + " = " + valorOfertado);
            return true;
         } else {
            System.out.println("Lance recusado. Valor menor que o atual (" + valorAtual + ")");
            return false;
        }

     }

     public int TempoLeilao (  int tempo ) {
        if ( tempo > 0 && tempo < 5  ) {
            System.out.println("Leilão iniciado por " + tempo + " segundos.");
            try {
                Thread.sleep(tempo * 60000); // Converte segundos para minutos
            } catch (InterruptedException e) {
                System.out.println("Leilão interrompido.");
                return -1;
            }
            System.out.println("Leilão encerrado após " + tempo + " segundos.");
            return 1;
        }
        return 0;
     }


  @Override
public Map<String, Integer> listarLances (){
    // Retorna o Map completo de códigos e lances
    return this.lances;
}

public Map.Entry<String, Integer> maiorlance(){
    // Retorna o Map completo de códigos e lances
    Map.Entry<String, Integer> maior = null;
    for (Map.Entry<String, Integer> lanceAtual : lances.entrySet()) {
        
        if(maior == null || lanceAtual .getValue() > maior.getValue()){ 
            maior = lanceAtual;
        }
    }
    if(maior != null){
        System.out.println("Maior lance atual:" + maior);
        System.out.println("Código: " + maior.getKey() + ", Lance: " + maior.getValue());
    }else{
        System.out.println("Nenhum lance encontrado.");
    }
    return  maior;
}
//Map.Entry é um item do mapa, que contém uma chave (key) e um valor (value).
//Quando você quer percorrer todos os itens de um Map, você usa o método .entrySet():
//Map.Entry<String, Integer> é o tipo do item (um par chave/valor).
//entrada.getKey() → devolve a chave.
//entrada.getValue() → devolve o valor.

    @Override
    public boolean Cadastro(String cpf, String senha, boolean admin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Cadastro'");
    }

    @Override
    public boolean Login(String cpf, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Login'");
    }

    @Override
    public boolean Logout(boolean sair) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Logout'") ;
    }

   



    public Map<String, Integer> getValorlance(String codigo) {
        return lances;
    }




   

   






}
