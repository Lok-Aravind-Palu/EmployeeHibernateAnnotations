package com.apptrics.employeedetails.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.apptrics.employeedetails.pojo.EmployeePOJO;


@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static String parent = System.getenv("CATALINA_HOME")+"/webapps/PMS/";
	public static String parentPath="resources/files";

        //public static String parent = System.getenv("CATALINA_HOME")+"/webapps/SonnenSizingTool/";
        //public static String parentPath="resources/files/";
       // public static String parent = System.getenv("CATALINA_HOME")+"/webapps/OFL/";
       // public static String parentPath="resources/files/";
        public HibernateUtil(){
        	  try{
        		   Configuration configuration =  new AnnotationConfiguration();
        		 
        	       
        	        configuration.addAnnotatedClass (EmployeePOJO.class);
//        	        configuration.addAnnotatedClass (BookParking.class);
//        	        configuration.addAnnotatedClass (User.class);
//        	        configuration.addAnnotatedClass(Account.class);
        	        
        	        
        	        //jdbc:sqlite:D:\Contents\apache-tomcat-7.0.68\webapps\PMS\resources\files\IMS.db
        	        configuration.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        	        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://"+"localhost"+":"+"3306"+"/sample1");   //192.168.10.168                             
        	        configuration.setProperty("hibernate.connection.username", "root");     
        	        configuration.setProperty("hibernate.connection.password", "");
        	        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        	        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        	        configuration.setProperty("hibernate.show_sql", "true");
        	        configuration.setProperty("hibernate.connection.pool_size", "10");

        	        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        	        sessionFactory = configuration.buildSessionFactory();
                System.out.println("Session factory loaded");
          }catch (Exception e) {
                  e.printStackTrace();
          }
        }
        
        public static SessionFactory getSessionFactory() {
                return sessionFactory;
        }

        public static void shutdown(){
                getSessionFactory().close();
        }
        
        @SuppressWarnings("unchecked")
        public static final ThreadLocal session = new ThreadLocal();
        
        @SuppressWarnings("unchecked")
        public static Session currentSession(){
                Session s = (Session)session.get();
                if(s == null){
                        s = sessionFactory.openSession();
                        session.set(s);
                }
                return s;
        }
        
        @SuppressWarnings("unchecked")
        public static void closeSession(){
                Session s = (Session)session.get();
                if(s != null)
                        s.close();
                session.set(null);
        }
        
 
}