package Dao;

import Common.HibernateUtil;
import Dao.GenericDao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID,T> {
  private Class<T> persistanceClass;

  public AbstractDao(){
    this.persistanceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }

  public String getPersistanceClassName(){
    return persistanceClass.getSimpleName();
  }

   public List<T> findAll(){
    List<T> list = new ArrayList<T>();
    Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction = session.beginTransaction();
     try {
       transaction = session.beginTransaction();
       StringBuilder sql = new StringBuilder("from ");
       sql.append(this.getPersistanceClassName());
       Query query = session.createQuery(sql.toString());
       list = query.list();
       transaction.commit();
     }catch (HibernateException e){
       System.out.println(e.getMessage());
       transaction.rollback();
     }
        return  list;
   }

  public T update(T entity) {
      T result = null;
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction transaction= session.beginTransaction();
    try{
      Object object =session.merge(entity);
      result = (T) object;
      transaction.commit();
    }catch (HibernateException e){
      transaction.rollback();
      System.out.println(e.getMessage());
    }finally {
      session.close();
    }
    return result;
  }

  public void save(T entity) {
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction = session.beginTransaction();
    try{
         session.persist(entity);
         transaction.commit();
    }catch (HibernateException e){
      transaction.rollback();
      System.out.println(e.getMessage());
    }finally {
      session.close();
    }
  }

  public T findById(ID id) {
     T result = null;
     Session session = HibernateUtil.getSessionFactory().openSession();
     Transaction transaction = session.beginTransaction();
     try{
           result =  (T) session.get(persistanceClass,id);
           if(result != null){
             throw new ObjectNotFoundException("not found T" + id, null);
           }
     }catch (HibernateException e){
       transaction.rollback();
       System.out.println(e.getMessage());
     }finally {
       session.close();
     }
     return result ;


  }

  public Integer delete(List<ID> ids) {
    Integer count = 0;
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    try{
     for(ID item : ids){
       T t = (T) session.get(persistanceClass, item);
       session.delete(t);
       count ++;
     }
     transaction.commit();


    }catch (HibernateException e){
      transaction.rollback();
      System.out.println(e.getMessage());
    }finally {
      session.close();
    }
    return null;
  }


}
