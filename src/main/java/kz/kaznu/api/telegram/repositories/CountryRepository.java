package kz.kaznu.api.telegram.repositories;

import kz.kaznu.api.telegram.models.Country;
import kz.kaznu.api.telegram.models.rowmappers.CountryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CommonRepository commonRepository;

    @Autowired
    public CountryRepository(JdbcTemplate jdbcTemplate, CommonRepository commonRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.commonRepository = commonRepository;
    }

    List<Country> findAll(Integer limit, Integer offset) {
        final String query = "select * " +
                "from country " +
                "order by id " +
                "limit ? offset ?";
        return jdbcTemplate.queryForObject(query, new Object[]{limit, offset}, new CountryRowMapper());
    }

    void edit(String code, String name, Long id) {
        final String query = "update country " +
                "set code   = ?, " +
                "    name   = ? " +
                "where id = ?";

        jdbcTemplate.update(
                query,
                code, name, id);
    }

    Long insert(String code, String name) {
        String query = "insert into country (id, code, name) " +
                "values (?, ?, ?)";

        Long id = commonRepository.getNextValForCountryIdSequence();

        jdbcTemplate.update(query,
                id, code, name);

        return id;
    }
}
