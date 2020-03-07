package com.example.messenger.dao.impl;

import com.example.messenger.dao.UserDao;
import com.example.messenger.dto.UserRegisterDto;
import com.example.messenger.model.User;
import com.example.messenger.model.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.messenger.dao.impl.DaoUtils.isUpdated;
import static com.example.messenger.jooqData.tables.User.USER;
import static com.example.messenger.jooqData.tables.UserRoles.USER_ROLES;


@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDao {
    private final DSLContext dslContext;

    @Override
    public int saveUser(UserRegisterDto user) {
        Record record = dslContext.insertInto(USER)
                .set(USER.BIRTHDAY, user.getBirthday())
                .set(USER.FIRST_NAME, user.getFirstName())
                .set(USER.LAST_NAME, user.getLastName())
                .set(USER.CITY, user.getCityId())
                .set(USER.COUNTRY, user.getCountryId())
                .set(USER.EMAIL, user.getEmail())
                .set(USER.PASSWORD, user.getPassword())
                .returning(USER.ID)
                .fetchOptional()
                .orElseThrow();
        return record.getValue(USER.ID);
    }

    @Override
    public boolean saveRole(int userId, UserRole role) {
        return isUpdated(dslContext.insertInto(USER_ROLES)
                .set(USER_ROLES.USER_ID, userId)
                .set(USER_ROLES.ROLE, role.name())
                .execute());
    }

    @Override
    public boolean updateUser(User user) {
        return isUpdated(dslContext.update(USER)
                .set(USER.BIRTHDAY, user.getBirthday())
                .set(USER.FIRST_NAME, user.getFirstName())
                .set(USER.LAST_NAME, user.getLastName())
                .set(USER.CITY, user.getCity().getId())
                .set(USER.COUNTRY, user.getCountry().getId())
                .where(USER.ID.eq(user.getId()))
                .execute());
    }

    @Override
    public Optional<User> getUser(int id) {
        return dslContext.selectFrom(USER)
                .where(USER.ID.eq(id))
                .fetchOptionalInto(User.class);
    }

    @Override
    public boolean deleteUser(int id) {
        return isUpdated(dslContext.deleteFrom(USER)
                .where(USER.ID.eq(id))
                .execute());
    }
}
