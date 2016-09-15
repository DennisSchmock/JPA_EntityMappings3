/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entity.Customer;
import Entity.DiscountFixed;
import Entity.DiscountQuantity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dennis
 */
public class Tester {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        Customer cus1 = new Customer();
        Customer cus2 = new Customer();

        DiscountFixed discF1 = new DiscountFixed();
        DiscountQuantity discQ1 = new DiscountQuantity();

        cus1.addDiscount(discQ1);
        cus1.addDiscount(discF1);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cus1);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
