package practiceA.BusinessCardManagerDao.service;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import practiceA.BusinessCardManagerDao.domain.Card;
import practiceA.BusinessCardManagerDao.repository.CardRepository;

import java.util.List;

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
        if(cardRepository.findByName(card.getName()).size() > 0) throw new IllegalStateException("동일한 회원이 이미 존재합니다");
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

    public void deleteCard(Integer id) {
        cardRepository.deleteCard(id);
    }
}
