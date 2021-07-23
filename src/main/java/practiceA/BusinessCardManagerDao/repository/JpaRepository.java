package practiceA.BusinessCardManagerDao.repository;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import practiceA.BusinessCardManagerDao.domain.Card;

import javax.persistence.EntityManager;

import java.util.List;

@Primary
@Repository
@Transactional
@RequiredArgsConstructor
public class JpaRepository implements CardRepository {

    private final EntityManager em;

    @Override
    public void add(Card card) {
        em.persist(card);
    }

    @Override
    public List<Card> findAll() {
        return em.createQuery("select c from Card c", Card.class)
                .getResultList();
    }

    @Override
    public List<Card> findByName(String name) {
        return em.createQuery("select c from Card c where c.name = :name", Card.class)
                .setParameter("name", name)
                .getResultList();
    }

    @Override
    public void deleteCard(Integer id) {
        em.createQuery("delete from Card c where c.id= :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
