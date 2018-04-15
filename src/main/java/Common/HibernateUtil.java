package Common;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
   private static final SessionFactory  sessionFactory(){
     try{
       return new Configuration().configure().buildSessionFactory();
     }catch (Throwable e){
       System.out.println(e.getMessage());
       throw new ExceptionInInitializerError(e);
     }
   }
   public static SessionFactory getSessionFactory(){
     return sessionFactory();
   }
}
