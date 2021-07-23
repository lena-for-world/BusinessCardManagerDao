package practiceA.BusinessCardManagerDao.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import practiceA.BusinessCardManagerDao.domain.Card;
import practiceA.BusinessCardManagerDao.service.CardService;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/card/new")
    public String create() {
        return "card/cardForm";
    }

    @PostMapping("/card/new")
    public String saveCard(@Valid Card card, BindingResult rs, Model model) {
        if(rs.hasErrors()) {
            return "/card/cardForm";
        }
        try {
            cardService.save(card);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "동일한 회원이 존재합니다");
            return "/card/cardForm";
        }
        return "main";
    }

    @GetMapping("/card/search")
    public String search() {
        return "card/searchCard";
    }

    @GetMapping("/card/search/AllCards")
    public String searchAllCard(Model model) {
        // repository에서 전체 명함을 가져옴
        // model에 넣어서 전달
        List<Card> results = cardService.findCards();
        model.addAttribute("results", results);
        return "card/cardResult";
    }

    @GetMapping("/card/search/oneCard")
    public String searchACardByName(String name, Model model) {
        // repository에서 전체 명함을 가져옴
        // model에 넣어서 전달
        List<Card> list = cardService.findCard(name);
        model.addAttribute("results", list);
        return "card/cardResult";
    }

    @GetMapping("/card/delete")
    public String delete(Integer id) {
        cardService.deleteCard(id);
        return "card/searchCard";
    }

}
