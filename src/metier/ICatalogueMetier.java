package metier;

import java.util.List;

public interface ICatalogueMetier {
    public List<Client> clientByKeyword (String kw);
    public void addClient(Client c);


}
