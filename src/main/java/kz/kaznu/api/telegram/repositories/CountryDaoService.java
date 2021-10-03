package kz.kaznu.api.telegram.repositories;

import kz.kaznu.api.telegram.models.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryDaoService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAll(Integer limit, Integer offset) {
        return countryRepository.findAll(limit, offset);
    }

    public void edit(String code, String name, Long id) {

        countryRepository.edit(code, name, id);
    }

    public Long add(String code, String name) {

        return countryRepository.insert(code, name);
    }
}
