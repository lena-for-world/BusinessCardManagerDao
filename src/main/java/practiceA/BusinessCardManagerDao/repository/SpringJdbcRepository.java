package practiceA.BusinessCardManagerDao.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import practiceA.BusinessCardManagerDao.domain.Card;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class SpringJdbcRepository implements CardRepository {

    private final JdbcTemplate jdbcTemplate;

    public SpringJdbcRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void add (Card card) {
        this.jdbcTemplate.update("insert into card(company, name, phone) values(?,?,?)",
                card.getCompany(), card.getName(), card.getPhone());
    }

    @Override
    public List<Card> findAll() {
        List<Card> list = new ArrayList<>();
        list = this.jdbcTemplate.query("select * from card order by id",
                new RowMapper<Card>() {
                    @Override
                    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Card card = new Card();
                        card.setId(rs.getInt("id"));
                        card.setName(rs.getString("name"));
                        card.setPhone(rs.getString("phone"));
                        card.setCompany(rs.getString("company"));
                        return card;
                    }
                });
        return list;
    }

    @Override
    public List<Card> findByName(String name) {
        List<Card> list = this.jdbcTemplate.query("select * from card where name like ?",
                new Object[] {"%" + name + "%"},
                new RowMapper<Card>() {
                    @Override
                    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Card card = new Card();
                        card.setId(rs.getInt("id"));
                        card.setName(rs.getString("name"));
                        card.setPhone(rs.getString("phone"));
                        card.setCompany(rs.getString("company"));
                        return card;
                    }
                });
        return list;
    } // findbyname으로 수정

    public void deleteCard(Integer id) {
        this.jdbcTemplate.update("delete from card where id = ?", id);
    }
}
