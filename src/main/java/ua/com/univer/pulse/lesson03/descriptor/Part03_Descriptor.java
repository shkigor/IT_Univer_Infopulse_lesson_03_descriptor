package ua.com.univer.pulse.lesson03.descriptor;

import org.hibernate.SessionFactory;
import ua.com.univer.pulse.lesson03.descriptor.entity.Address;
import ua.com.univer.pulse.lesson03.descriptor.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Mapping Address в БД с помощью hibernate
 * Как работать со сложными типами, которые изначально в hibernate не описаны
 */
public class Part03_Descriptor {
    public static void main(String[] args) {

        SessionFactory sessionFactory =
                (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager em = sessionFactory.createEntityManager();

        em.getTransaction().begin();

        User user = new User();
        user.setName("vasya");

        Address address = new Address();
        address.setStreet("Maydan Nezalegnosti");
        address.setCity("Kyiv");

        user.setAddress(address);

        em.persist(user);

        em.getTransaction().commit();
        em.close();
        sessionFactory.close();

    }

}
