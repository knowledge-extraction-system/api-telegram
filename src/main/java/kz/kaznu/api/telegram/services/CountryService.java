package kz.kaznu.api.telegram.services;

import kz.kaznu.api.telegram.models.Country;
import kz.kaznu.api.telegram.models.requests.CountryEditRequest;
import kz.kaznu.api.telegram.repositories.CountryDaoService;
import kz.kaznu.api.telegram.models.requests.CountryAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDaoService countryDaoService;

    public List<Country> getAll(Integer page, Integer size) {
        int limit = size;
        int offset = size * (page - 1);

        return countryDaoService.getAll(limit, offset);
    }

    public void edit(CountryEditRequest request) {
        Long id = request.getId();
        String code = request.getCode();
        String name = request.getName();

        countryDaoService.edit(code, name, id);
    }

    public Long add(CountryAddRequest request) {
        String code = request.getCode();
        String name = request.getName();

        return countryDaoService.add(code, name);
    }
}
