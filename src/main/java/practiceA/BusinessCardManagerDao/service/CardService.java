package practiceA.BusinessCardManagerDao.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import practiceA.BusinessCardManagerDao.domain.Card;
import practiceA.BusinessCardManagerDao.resopitory.CardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public void save(Card card) throws Exception {
        // check if it's already in db -- if exists, return error
        // add to db
        validateDuplicateCard(card);
        cardRepository.add(card);
    }

    private void validateDuplicateCard(Card card) {
        if(cardRepository.checkByName(card.getName()) == true) throw new IllegalStateException("동일한 회원이 이미 존재합니다");
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
