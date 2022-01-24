package com.glanner.api.queryrepository;

import com.glanner.core.domain.glanner.QUserGlanner;
import com.glanner.core.domain.user.QSchedule;
import com.glanner.core.domain.user.QUser;
import com.glanner.core.domain.user.User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class UserQueryRepositoryImpl implements UserQueryRepository{
    private final JPAQueryFactory query;

    private QUser user = new QUser("user1");
    private QSchedule schedule = new QSchedule("schedule1");
    private QUserGlanner userGlanner = new QUserGlanner("userGlanner1");

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(query
                .select(user)
                .from(user)
                .leftJoin(user.schedule, schedule).fetchJoin()
                .leftJoin(user.userGlanners, userGlanner)
                .where(userEmailEq(email))
                .fetchFirst());
    }

    private BooleanExpression userEmailEq(String userEmail) {
        return userEmail != null ? user.email.eq(userEmail) : null;
    }
}
