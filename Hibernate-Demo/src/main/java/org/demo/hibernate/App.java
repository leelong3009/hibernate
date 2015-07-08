package org.demo.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.demo.hibernate.dto.Address;
import org.demo.hibernate.dto.UserDetails;
import org.demo.hibernate.dto.UserDetails_OnetoOne;
import org.demo.hibernate.dto.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        UserDetails user = new UserDetails();
//        user.setUserId(1);
//        user.setUserName("First User");
//        user.setJoinedDate(new Date());
//        user.setDescription("this is the first user");
        
        
//        Address address = new Address();
//        address.setCity("Singapore");
//        address.setPinCode("1234");
//        address.setState("state");
//        address.setStreet("bedok");
//        user.setHomeAddress(address);
//        
//        Address address2 = new Address();
//        address2.setCity("Singapore");
//        address2.setPinCode("1234");
//        address2.setState("state 2");
//        address2.setStreet("bedok 2");
//        user.setOfficeAddress(address2);
//        
//        user.getListOfAddress().add(address);
//        user.getListOfAddress().add(address2);
        
    	Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");
        
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("bycle");
        
        UserDetails_OnetoOne user = new UserDetails_OnetoOne();
        user.setUserName("First User");
        user.getVehicle().add(vehicle);
        user.getVehicle().add(vehicle2);
        vehicle.setUser(user);
        vehicle2.setUser(user);
        
//      create session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
//        session.save(vehicle);
//        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();
        
        System.exit(1);
    }
}
