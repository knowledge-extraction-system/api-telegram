package kz.kaznu.api.telegram.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
class CommonRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    Long getNextValForCountryIdSequence() {
        String query = "select nextval('country_id_seq')";

        return jdbcTemplate.queryForObject(
                query,
                Long.class);
    }
}
