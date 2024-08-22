package org.arthur.ss11_mvc.service;

import org.arthur.ss11_mvc.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> getListCountry();
    boolean add(Country country);
}
