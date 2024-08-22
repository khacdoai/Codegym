package org.arthur.ss11_mvc.repository;

import org.arthur.ss11_mvc.model.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryRepo {
    List<Country> getListCountry();
    boolean add(Country country) throws SQLException;
}
