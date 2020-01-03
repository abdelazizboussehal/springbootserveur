package dz.stic.trash.doa;

import dz.stic.trash.model.Admin;
import dz.stic.trash.model.Photo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class PhotoDAO extends BaseDAO<Photo> {

    @Autowired
    SessionFactory sessionFactory;


    public PhotoDAO() {
        super(Photo.class, "Photo");
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
