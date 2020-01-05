package dz.stic.trash.doa;


import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAO extends BaseDAO<Comment> {

    @Autowired
    SessionFactory sessionFactory;


    public CommentDAO() {
        super(Comment.class, "Commentt");
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
