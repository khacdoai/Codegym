package org.arthur.ss11_mvc.repository.impl;

import org.arthur.ss11_mvc.DB.DBConnection;
import org.arthur.ss11_mvc.model.Country;
import org.arthur.ss11_mvc.repository.ICountryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryRepo implements ICountryRepo {
    private static final String SELECT_ALL_COUNTRY = " select * from country order by id asc";
    private  static  final String INSERT_COUNTRY_SQL="insert into country(name) values (?);";

    @Override
    public List<Country> getListCountry() {
        List<Country> countryList = new ArrayList<>();
        try(Connection connection= DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRY)){
           ResultSet resultSet= preparedStatement.executeQuery();
           while (resultSet.next()){
              int id= resultSet.getInt("id");
              String name= resultSet.getString("name");
               Country country = new Country(id, name);
               countryList.add(country);
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countryList;
    }

    @Override
    public boolean add(Country country) {
        try(Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY_SQL)) {
        preparedStatement.setString(1,country.getName());
        preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return  false;
        }
        return true;
    }
}
