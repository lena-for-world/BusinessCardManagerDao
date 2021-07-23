package practiceA.BusinessCardManagerDao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
public class Card {

    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private String name;
    @Size(min=11, max=11, message="번호는 11글자여야 합니다")
    private String phone;
    private String company;

}
