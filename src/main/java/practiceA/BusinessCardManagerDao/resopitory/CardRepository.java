package practiceA.BusinessCardManagerDao.resopitory;

import practiceA.BusinessCardManagerDao.domain.Card;

import java.util.List;
import java.util.Optional;

public interface CardRepository {
    public void add(Card card);
    public List<Card> findAll();
    public List<Card> findByName(String name);
    public boolean checkByName(String name);
    public boolean deleteCard(Integer id);
}
