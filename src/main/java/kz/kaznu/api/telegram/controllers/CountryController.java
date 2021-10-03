package kz.kaznu.api.telegram.controllers;

import kz.kaznu.api.telegram.models.Country;
import kz.kaznu.api.telegram.models.requests.CountryAddRequest;
import kz.kaznu.api.telegram.models.requests.CountryEditRequest;
import kz.kaznu.api.telegram.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Country> getAllCountries(@RequestParam("page") Integer page,
                                             @RequestParam("size") Integer size) throws IOException {

        return countryService.getAll(page, size);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public void edit(CountryEditRequest request){
        countryService.edit(request);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Long add(CountryAddRequest request) {
        return countryService.add(request);
    }

}
