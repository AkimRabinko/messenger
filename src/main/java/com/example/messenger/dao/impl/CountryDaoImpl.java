package com.example.messenger.dao.impl;

import com.example.messenger.dao.CountryDao;
import com.example.messenger.model.Country;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;
import static com.example.messenger.jooqData.tables.Country.COUNTRY;

@Repository
@RequiredArgsConstructor
public class CountryDaoImpl implements CountryDao {
    private final DSLContext dslContext;

    @Override
    public boolean saveCountry(Country country) {
        return isUpdated(dslContext.insertInto(COUNTRY)
                .set(COUNTRY.NAME, country.getName())
                .execute());
    }

    @Override
    public boolean updateCountry(Country country) {
        return isUpdated(dslContext.update(COUNTRY)
                .set(COUNTRY.NAME, country.getName())
                .where(COUNTRY.ID.eq(country.getId()))
                .execute());
    }

    @Override
    public boolean deleteCountry(int id) {
        return isUpdated(dslContext.deleteFrom(COUNTRY)
                .where(COUNTRY.ID.eq(id))
                .execute());
    }

    @Override
    public Optional<Country> getCountry(int id) {
        return dslContext.selectFrom(COUNTRY)
                .where(COUNTRY.ID.eq(id))
                .fetchOptionalInto(Country.class);
    }

    @Override
    public List<Country> getCountries() {
        return dslContext.selectFrom(COUNTRY)
                .fetchInto(Country.class);
    }
}
