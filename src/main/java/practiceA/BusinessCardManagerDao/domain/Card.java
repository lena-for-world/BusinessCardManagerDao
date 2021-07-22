package practiceA.BusinessCardManagerDao.domain;

import javax.validation.constraints.Size;

public class Card {

    private Integer id;
    private String name;
    @Size(min=11, max=11, message="번호는 11글자여야 합니다")
    private String phone;
    private String company;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCompany() {
        return company;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
