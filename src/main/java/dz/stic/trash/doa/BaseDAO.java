package dz.stic.trash.doa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class BaseDAO<T> {


    private Class<T> tClass;
    private String tableName;

    public BaseDAO(Class<T> tClass, String tableName) {
        this.tClass = tClass;
        this.tableName = tableName;
    }


    protected Session currentSession;
    protected Transaction currentTransaction;


    public abstract Session openCurrentSession();

    public abstract Session openCurrentSessionwithTransaction();

    public final void closeCurrentSession() {
        currentSession.close();
    }

    public final void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        //currentSession.close();
    }


    public final Session getCurrentSession() {
        return currentSession;
    }

    public final void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public final Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public final void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }


    public void persist(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().save(entity);
        closeCurrentSessionwithTransaction();
    }

    public void update(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().update(entity);
        closeCurrentSessionwithTransaction();
    }

    public void delete(T entity) {
        openCurrentSessionwithTransaction();
        getCurrentSession().delete(entity);
        closeCurrentSessionwithTransaction();
    }

    public T findById(Integer id) {
        openCurrentSession();
        T record = (T) getCurrentSession().get(tClass, id);
        closeCurrentSession();

        return record;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        openCurrentSession();
        List<T> list = (List<T>) getCurrentSession().createQuery(String.format("from %s", tableName)).list();
        closeCurrentSession();
        return list;
    }

    @SuppressWarnings("unchecked")
    public void deleteAll() {
        openCurrentSessionwithTransaction();
        List<T> list = (List<T>) getCurrentSession().createQuery(String.format("from %s", tableName)).list();
        for (T entity : list) {
            currentSession.delete(entity);
        }
        closeCurrentSessionwithTransaction();
    }
}
