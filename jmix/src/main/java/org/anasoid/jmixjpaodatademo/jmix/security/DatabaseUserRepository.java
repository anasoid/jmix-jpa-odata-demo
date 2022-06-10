package org.anasoid.jmixjpaodatademo.jmix.security;

import org.anasoid.jmixjpaodatademo.jmix.entity.User;
import io.jmix.securitydata.user.AbstractDatabaseUserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Primary
@Component("jmix_UserRepository")
public class DatabaseUserRepository extends AbstractDatabaseUserRepository<User> {

    @Override
    protected Class<User> getUserClass() {
        return User.class;
    }

    @Override
    protected void initSystemUser(User systemUser) {
        Collection<GrantedAuthority> authorities = getGrantedAuthoritiesBuilder()
                .addResourceRole(FullAccessRole.CODE)
                .build();
        systemUser.setAuthorities(authorities);
    }

    @Override
    protected void initAnonymousUser(User anonymousUser) {
    }
}