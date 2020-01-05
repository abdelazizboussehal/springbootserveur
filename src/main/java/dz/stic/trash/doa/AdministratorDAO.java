package dz.stic.trash.doa;

import dz.stic.trash.model.Administrator;
import dz.stic.trash.model.Photo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratorDAO extends BaseDAO<Administrator> {

    @Autowired
    SessionFactory sessionFactory;


    public AdministratorDAO() {
        super(Administrator.class, "Administrator");
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


}
