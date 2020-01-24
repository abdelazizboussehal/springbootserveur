package dz.stic.trash.doa;


import dz.stic.trash.model.Comments;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO extends BaseDAO<Comments> {

    @Autowired
    SessionFactory sessionFactory;


    public CommentDAO() {
        super(Comments.class, "Comments");
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
