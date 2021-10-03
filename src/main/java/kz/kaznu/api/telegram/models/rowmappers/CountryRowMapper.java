package kz.kaznu.api.telegram.models.rowmappers;

import kz.kaznu.api.telegram.models.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryRowMapper implements RowMapper<List<Country>> {

    @Override
    public List<Country> mapRow(ResultSet rs, int rowNumber) throws SQLException {
        List<Country> countries = new ArrayList<>();

        countries.add(extractInfo(rs));
        while(rs.next()) {
            countries.add(extractInfo(rs));
        }

        return countries;
    }

    private Country extractInfo(ResultSet rs) throws SQLException {
        Country country = new Country();
        country.setId(rs.getLong("id"));
        country.setCode(rs.getString("code"));
        country.setName(rs.getString("name"));

        return country;
    }
}
