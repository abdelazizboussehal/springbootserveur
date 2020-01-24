package dz.stic.trash.doa;


import dz.stic.trash.model.Challenge;
import dz.stic.trash.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    public List<Challenge> myChallenge(int id) {
        openCurrentSessionwithTransaction();
        Query query=currentSession.createSQLQuery("SELECT * FROM Challenge where  id_user= ?").addEntity(Challenge.class);
        query.setInteger(1,id);
        List<Challenge> challenges=query.list();
        closeCurrentSessionwithTransaction();
        currentSession.clear();
        return challenges;
    }

}
