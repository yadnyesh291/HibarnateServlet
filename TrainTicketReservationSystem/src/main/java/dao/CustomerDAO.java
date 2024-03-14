package dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Customer;
import util.DatabaseUtil;
public class CustomerDAO {
	public boolean addCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = DatabaseUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

}
