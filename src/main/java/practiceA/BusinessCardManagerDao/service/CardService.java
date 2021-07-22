package practiceA.BusinessCardManagerDao.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import practiceA.BusinessCardManagerDao.domain.Card;
import practiceA.BusinessCardManagerDao.resopitory.CardRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public void save(Card card) {
        // check if it's already in db -- if exists, return error
        // add to db
        cardRepository.add(card);
    }

    public List<Card> findCards() {
        List<Card> list = cardRepository.findAll();
        return list;
    }

    public List<Card> findCard(String name) {
        // find with name
        List<Card> list = cardRepository.findByName(name);
        return list;
    }

    public boolean deleteCard(Integer id) {
        return cardRepository.deleteCard(id);
    }
}
