package practiceA.BusinessCardManagerDao.resopitory;

import org.springframework.stereotype.Repository;
import practiceA.BusinessCardManagerDao.domain.Card;

import java.util.List;

public class JPARepository implements CardRepository {
    @Override
    public void add(Card card) {

    }

    @Override
    public List<Card> findAll() {
        return null;
    }

    @Override
    public List<Card> findByName(String name) {
        return null;
    }

    @Override
    public void deleteCard(int id) {

    }
}
