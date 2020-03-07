package com.example.messenger.dao.impl;

import com.example.messenger.dao.CityDao;
import com.example.messenger.model.City;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;
import static com.example.messenger.jooqData.tables.City.CITY;

@Repository
@RequiredArgsConstructor
public class CityDaoImpl implements CityDao {
    private final DSLContext dslContext;

    @Override
    public boolean saveCity(City city) {
        return isUpdated(dslContext.insertInto(CITY)
                .set(CITY.NAME, city.getName())
                .set(CITY.COUNTRY_ID, city.getCountryId())
                .execute());
    }

    @Override
    public boolean updateCity(City city) {
        return isUpdated(dslContext.update(CITY)
                .set(CITY.NAME, city.getName())
                .set(CITY.COUNTRY_ID, city.getCountryId())
                .execute());
    }

    @Override
    public boolean deleteCity(int id) {
        return isUpdated(dslContext.deleteFrom(CITY)
                .where(CITY.ID.eq(id))
                .execute());
    }

    @Override
    public Optional<City> getCity(int id) {
        return dslContext.selectFrom(CITY)
                .where(CITY.ID.eq(id))
                .fetchOptionalInto(City.class);
    }

    @Override
    public Optional<City> getCity(String name) {
        return dslContext.selectFrom(CITY)
                .where(CITY.NAME.eq(name))
                .fetchOptionalInto(City.class);
    }

    @Override
    public List<City> getCities(int country) {
        return dslContext.selectFrom(CITY)
                .where(CITY.COUNTRY_ID.eq(country))
                .fetchInto(City.class);
    }

    @Override
    public List<City> getCities() {
        return dslContext.selectFrom(CITY)
                .fetchInto(City.class);
    }
}
