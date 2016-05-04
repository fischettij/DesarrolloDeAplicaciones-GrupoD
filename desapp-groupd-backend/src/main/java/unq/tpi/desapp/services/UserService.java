package unq.tpi.desapp.services;

import org.springframework.transaction.annotation.Transactional;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;

public class UserService extends GenericService<User> {

    @Transactional
    public void addRouteToUser(User user, Route route) {
        user.addRoute(route);
        this.update(user);
    }
}
