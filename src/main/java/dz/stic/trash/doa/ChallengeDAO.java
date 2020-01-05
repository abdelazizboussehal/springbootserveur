package dz.stic.trash.doa;


import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChallengeDAO extends BaseDAO<Challenge> {

    @Autowired
    SessionFactory sessionFactory;


    public ChallengeDAO() {
        super(Challenge.class, "Challenge");
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
