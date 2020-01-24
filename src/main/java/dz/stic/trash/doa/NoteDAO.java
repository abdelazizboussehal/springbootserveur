package dz.stic.trash.doa;


import dz.stic.trash.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDAO extends BaseDAO<Note> {

    @Autowired
    SessionFactory sessionFactory;


    public NoteDAO() {
        super(Note.class, "Note");
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
