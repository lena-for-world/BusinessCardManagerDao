package practiceA.BusinessCardManagerDao.resopitory;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import practiceA.BusinessCardManagerDao.domain.Card;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpringJDBCRepository implements CardRepository {

    private final JdbcTemplate jdbcTemplate;

    public SpringJDBCRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource); // ?? how works
    }

    @Override
    public void add (Card card) {
        this.jdbcTemplate.update("insert into card(name, phone, company) values(?,?,?)",
                card.getName(), card.getPhone(), card.getCompany());
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
        List<Card> list = this.jdbcTemplate.query("select * from card where name = ?",
                new Object[] {name},
                new RowMapper<Card>() {
                    @Override
                    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Card card = new Card();
                        card.setName(rs.getString("name"));
                        card.setPhone(rs.getString("phone"));
                        card.setCompany(rs.getString("company"));
                        return card;
                    }
                });
        return list;
    } // findbyname으로 수정

    @Override
    public boolean checkByName(String name) {
        List<Card> list = this.jdbcTemplate.query("select * from card where name = ?",
                new Object[]{name},
                new RowMapper<Card>() {
                    @Override
                    public Card mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Card card = new Card();
                        card.setName(rs.getString("name"));
                        card.setPhone(rs.getString("phone"));
                        card.setCompany(rs.getString("company"));
                        return card;
                    }
                });
        return list.size() != 0;
    }

    @Override
    public boolean deleteCard(Integer id) {
        int result = this.jdbcTemplate.update("delete from card where id = ?", Integer.valueOf(id));
        return result == 1;
    }
}
