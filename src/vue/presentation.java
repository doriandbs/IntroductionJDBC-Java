package vue;

import metier.CatalogueMetierImpl;
import metier.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class presentation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        CatalogueMetierImpl metier = new CatalogueMetierImpl();
       /* System.out.println("Ajouter un client :");
        System.out.println("Tapez le nom du client");
        String name = br.readLine().toUpperCase();
        System.out.println("Tapez le prenom du client");
        String firstname = br.readLine().toUpperCase();

        Client customer = new Client(name, firstname);
        metier.addClient(customer);*/
        System.out.println("Tapez le mot clé");
        String kw = br.readLine();
        List<Client> clients = metier.clientByKeyword(kw);
        for(Client c : clients){
            System.out.println(c.getIdClient() + "\t" + c.getNomClient() + "\t" +  c.getPrenomClient());

        }
    }
}
