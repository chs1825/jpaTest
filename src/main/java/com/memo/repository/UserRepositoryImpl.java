package com.memo.repository;

import com.memo.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{


    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();

//    @PersistenceContext(unitName = "jpaTest")
//    private EntityManager em;

    public void save(User user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public User readById(String id) {
        try {
            System.out.println(em.find(User.class, "chs1825"));
            return em.find(User.class, "chs1825");
        } catch (IllegalArgumentException e) {
            // PK 값이 null인 경우 처리
            return null;
        } catch (EntityNotFoundException e) {
            // 해당 엔티티가 존재하지 않는 경우 처리
            return null;
        } catch (PersistenceException e) {
            // 데이터베이스 연결 오류 등의 예외 발생 시 처리
            return null;
        }



    }

    public List<User> readAll() {
        TypedQuery<User> query = em.createQuery("Select m from User m", User.class);
        return query.getResultList();
    }


}
