package io.hackages.learning.dao;

import io.hackages.learning.model.CustomerOrder;
import io.hackages.learning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerOrderDao {

    public Integer saveCustomerOrder(CustomerOrder customerOrder) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the customerOrder object
            Integer id = (Integer) session.save(customerOrder);
            // commit transaction
            transaction.commit();

            return id;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public List< CustomerOrder > getCustomerOrders() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from CustomerOrder", CustomerOrder.class).list();
        }
    }

    public CustomerOrder getCustomerOrder(Integer orderId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(CustomerOrder.class, orderId);
        }
    }
}
