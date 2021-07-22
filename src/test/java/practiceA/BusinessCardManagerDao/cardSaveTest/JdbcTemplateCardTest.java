package practiceA.BusinessCardManagerDao.cardSaveTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import practiceA.BusinessCardManagerDao.domain.Card;
import practiceA.BusinessCardManagerDao.resopitory.CardRepository;
import practiceA.BusinessCardManagerDao.resopitory.SpringJDBCRepository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class JdbcTemplateCardTest {

    @Autowired DataSource dataSource;
    @Autowired CardRepository cardRepository;

    @Test
    @DisplayName("jdbc template insert and get all results")
    public void AddandGetAll() {
        // given
        Card card = new Card();
        card.setName("Hamging");
        card.setPhone("01012345678"); card.setCompany("samsung");
        Card card1 = new Card();
        card1.setName("Hamging22");
        card1.setPhone("01000000000"); card1.setCompany("naver");
        // when
        cardRepository.add(card);
        cardRepository.add(card1);
        List<Card> list = cardRepository.findAll();
        //then
        assertThat(card.getName()).isEqualTo(list.get(0).getName());
        for(Card temp : list) {
            System.out.println("id = " + temp.getId() +" name = " + temp.getName()+" phone = "+temp.getPhone() + " company = " + temp.getCompany());
        }
    }

    @Test
    @DisplayName("jdbc template insert and find by name")
    public void findByName() {
        // given
        Card card = new Card();
        card.setName("Hamging");
        card.setPhone("01012345678"); card.setCompany("samsung");
        Card card1 = new Card();
        card1.setName("Hamging22");
        card1.setPhone("01000000000"); card1.setCompany("naver");
        // when
        cardRepository.add(card);
        cardRepository.add(card1);
        List<Card> cards = cardRepository.findByName("Hamging22");
        //then
        assertThat("Hamging22").isEqualTo(cards.get(0).getName());
        System.out.println("Hamging22? = " + cards.get(0).getName());
    }
}