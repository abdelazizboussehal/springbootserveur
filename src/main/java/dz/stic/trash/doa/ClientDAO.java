package dz.stic.trash.doa;



import dz.stic.trash.model.Client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAO extends BaseDAO<Client> {

    @Autowired
    SessionFactory sessionFactory;


    public ClientDAO() {
        super(Client.class, "Client");
    }

    public Session openCurrentSession() {
        currentSession = sessionFactory.openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = sessionFactory.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public List<Client> auth(Client client) {
        openCurrentSessionwithTransaction();
        String username="userName";
        String password="password";
        Query query=currentSession.createSQLQuery("SELECT * FROM Client where username = ? and password= ?").addEntity(Client.class);
        query.setString(1,client.getUserName());
        query.setString(2,client.getPassword());
        List<Client> clients=query.list();
        return clients;
    }


}
