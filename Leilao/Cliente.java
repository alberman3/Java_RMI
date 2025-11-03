import java.rmi.*;
import java.util.Map; // Importar java.util.Map

class Cliente {
    public static void main (String args[]){
        try{
            String nomeObjetoRemoto = "rmi://localhost:5000/Interface_CLI_SERV"; 

            // 1. Acessa o objeto remoto.
            Interface_CLI_SERV objRemoto = (Interface_CLI_SERV) Naming.lookup(nomeObjetoRemoto);
            System.out.println("Conexão com o servidor RMI estabelecida.");

            //  Teste  método listarLances 
            System.out.println("\n--- 1. Testando listarLances() (Inicial) ---");
            // retorno para Map<String, Integer>
            Map<String, Integer> lancesAtuais = objRemoto.listarLances();
            
            System.out.println("Lances atuais recebidos do servidor:");
            for (Map.Entry<String, Integer> entry : lancesAtuais.entrySet()) {
                System.out.println("  Código: " + entry.getKey() + ", Lance: " + entry.getValue());
            }

            //  Teste  metodo OfertarLance 
            System.out.println("\n Testando OfertarLance()");
            
            // Exemplo de Oferta )
            String codigoTeste1 = "NB67"; 
            int valorTeste1 = 9500;
            System.out.println("Tentando ofertar: Código: " + codigoTeste1 + ", Valor: " + valorTeste1);
            objRemoto.OfertarLance(codigoTeste1, valorTeste1);
            
            String codigoTeste2 = "AS21"; 
            int valorTeste2 = 3000;
            System.out.println("Tentando ofertar: Código: " + codigoTeste2 + ", Valor: " + valorTeste2);
            objRemoto.OfertarLance(codigoTeste2, valorTeste2);
            

            // --- Verificando os Lances Atualizados (Sua linha da imagem corrigida) ---
            System.out.println("\n--- 3. Verificando listarLances() após ofertas ---");
            
            //  Muda para Map<String, Integer>
            Map<String, Integer> lancesAtualizados = objRemoto.listarLances();
            
            System.out.println("Lances atualizados recebidos do servidor:");
            for (Map.Entry<String, Integer> entry : lancesAtualizados.entrySet()) {
                System.out.println("  Código: " + entry.getKey() + ", Lance: " + entry.getValue());
            }

            System.out.println("\n--- 4. Testando maiorlance() ---");
            Map.Entry<String, Integer> maiorLance = objRemoto.maiorlance();
            if (maiorLance != null) {
                System.out.println("Maior lance recebido do servidor:");
                System.out.println("  Código: " + maiorLance.getKey() + ", Lance: " + maiorLance.getValue());
            } else {
                System.out.println("Nenhum lance encontrado no servidor.");
            }

        } catch(Exception e ) {
            System.err.println("Exceção no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}