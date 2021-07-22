package practiceA.BusinessCardManagerDao.resopitory;

import practiceA.BusinessCardManagerDao.domain.Card;

import java.util.List;

public interface CardRepository {
    public void add(Card card);
    public List<Card> findAll();
    public List<Card> findByName(String name);
    public void deleteCard(int id);
}
