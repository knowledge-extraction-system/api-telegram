package kz.kaznu.api.telegram.repositories;

import kz.kaznu.api.telegram.models.TelegramUser;
import kz.kaznu.api.telegram.models.rowmappers.TelegramUserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TelegramUserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TelegramUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<TelegramUser> findAll(Integer limit, Integer offset) {
        final String query = "select * " +
                "from telegram_user " +
                "order by id " +
                "limit ? offset ?";
        return jdbcTemplate.queryForObject(query, new Object[]{limit, offset}, new TelegramUserRowMapper());
    }

    void edit(Long countryId, String gender, Long id) {
        final String query = "update telegram_user " +
                "set country_id   = ?, " +
                "    gender       = ? " +
                "where id = ?";

        jdbcTemplate.update(
                query,
                countryId, gender, id);
    }
}
