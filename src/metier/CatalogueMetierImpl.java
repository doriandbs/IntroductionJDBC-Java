package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogueMetierImpl implements ICatalogueMetier{
    @Override
    public List<Client> clientByKeyword(String kw){
        List<Client> clients = new ArrayList<Client>();
        try {
            Connection conn= conn();
            PreparedStatement ps = conn.prepareStatement("select * from clients where NOM like ?");
            ps.setString(1, "%" + kw + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Client c = new Client();
                c.setIdClient(rs.getInt("ID"));
                c.setNomClient(rs.getString("NOM"));
                c.setPrenomClient(rs.getString("PRENOM"));
                clients.add(c);
            }
            ps.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public void addClient(Client c){
        try{
            Connection conn= conn();
            PreparedStatement ps = conn.prepareStatement("insert into clients(NOM,PRENOM) values (?,?)");
            ps.setString(1,c.getNomClient());
            ps.setString(2,c.getPrenomClient());

            int nb = ps.executeUpdate();
            ps.close();
            conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private Connection conn() throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxdbbanque", "root", "");
            return conn;

    }
}
