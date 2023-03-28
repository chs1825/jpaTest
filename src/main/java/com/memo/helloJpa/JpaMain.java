package com.memo.helloJpa;

import com.memo.entity.User;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            TypedQuery<User> query = em.createQuery("SELECT m FROM User m",User.class);
            List<User> list = query.getResultList();
//
            System.out.println("list반환: "+ list.toString());

            User findUser = em.find(User.class,"chs1825");
            System.out.println("여기:" + findUser);
            findUser.setPassword("3333");

            tx.commit();
            System.out.println("여기:" + findUser);
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }


        emf.close();


    }
}
