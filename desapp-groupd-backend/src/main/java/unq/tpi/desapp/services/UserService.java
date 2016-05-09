package unq.tpi.desapp.services;

import org.springframework.transaction.annotation.Transactional;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.RouteManager;

public class UserService extends GenericService<User> {

    @Transactional
    public void addRouteToUser(User user, Route route) {
        user.managerImplementing(RouteManager.class).add(route);
        this.update(user);
    }
}
