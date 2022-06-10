package org.anasoid.jmixjpaodatademo.jmix.screen.user;

import org.anasoid.jmixjpaodatademo.jmix.entity.User;
import io.jmix.ui.navigation.Route;
import io.jmix.ui.screen.*;

@UiController("jmix_User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@Route("users")
public class UserBrowse extends StandardLookup<User> {
}