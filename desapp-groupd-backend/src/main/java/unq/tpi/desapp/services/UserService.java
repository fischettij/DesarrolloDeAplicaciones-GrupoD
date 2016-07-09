package unq.tpi.desapp.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.transaction.annotation.Transactional;

import unq.tpi.desapp.builders.RouteBuilder;
import unq.tpi.desapp.exception.NotFoundException;
import unq.tpi.desapp.model.Comment;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.model.inscription.InscriptionPending;
import unq.tpi.desapp.model.manager.CommentManager;
import unq.tpi.desapp.model.manager.InscriptionManager;
import unq.tpi.desapp.model.manager.ProductManager;
import unq.tpi.desapp.model.manager.RouteManager;
import unq.tpi.desapp.model.manager.ScoreManager;
import unq.tpi.desapp.model.manager.VehicleManager;
import unq.tpi.desapp.model.subscription.SubscriptionPending;
import unq.tpi.desapp.repositories.UserRepository;
import unq.tpi.desapp.services.request.CommentRequest;
import unq.tpi.desapp.services.request.CommentedPointRequest;
import unq.tpi.desapp.services.request.RequestRoute;
import unq.tpi.desapp.services.request.UserProfile;

public class UserService implements Serializable {

	private static final long serialVersionUID = -1374589536025018037L;

	private UserRepository repository;

	public UserRepository getRepository() {
		return this.repository;
	}

	public void setRepository(final UserRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void delete(final User object) {
		this.getRepository().delete(object);
	}

	@Transactional(readOnly = true)
	public List<User> retriveAll() {
		return this.getRepository().findAll();
	}

	@Transactional
	public void save(final User object) {
		this.getRepository().save(object);
	}

	@Transactional
	public void update(final User object) {
		this.getRepository().update(object);
	}

	@Transactional
	public void addRouteToUser(Long id, Route route) {
		User user = this.getRepository().findById(id);
		user.managerImplementing(RouteManager.class).add(route);
		this.update(user);
	}

	@Transactional
	public User getUser(Long id) {
		return this.getRepository().findById(id);
	}

	@Transactional
	public List<Vehicle> getVehicles(Long id, Integer page, Integer quantity) {
		User user = this.getRepository().findById(id);
		return this.getRepository().getVehicles(user.managerImplementing(VehicleManager.class).getId(), page, quantity);
	}

	@Transactional
	public void addNewVehicle(Long id, Vehicle vehicle) throws Exception {
		User user = this.getRepository().findById(id);
		user.managerImplementing(VehicleManager.class).add(vehicle);
		this.update(user);
	}

	@Transactional
	public void addNewProduct(Long id, Product product) throws Exception {
		User user = this.getRepository().findById(id);
		user.managerImplementing(ProductManager.class).add(product);
		this.update(user);
	}

	@Transactional
	public List<User> getUsersLike(String userName) {
		return this.getRepository().getUsersLike(userName);
	}

	@Transactional
	public void addNewRoute(Long id, RequestRoute requestRoute) throws NotFoundException {
		User user = this.getRepository().findById(id);
		Vehicle vehicle = user.managerImplementing(VehicleManager.class).find(requestRoute.getIdVehicle());
		Route route = new RouteBuilder().buildWith(requestRoute, vehicle, user);
		user.managerImplementing(RouteManager.class).add(route);
		this.update(user);
	}

	@Transactional
	public List<Route> getRoutes(Long id, Integer page, Integer quantity) {
		User user = this.getRepository().findById(id);
		return new ArrayList<Route>(user.managerImplementing(RouteManager.class).getRoutes());
	}

	@Transactional
	public List<Product> getProducts(Long id, Integer page, Integer quantity) {
		User user = this.getRepository().findById(id);
		return new ArrayList<Product>(user.managerImplementing(ProductManager.class).getProducts());
	}

	@Transactional
	public void subscribeToRoute(Long id, Long idRoute, Long idOwner) throws Exception {
		User user = this.getRepository().findById(id);
		User owner = this.getRepository().findById(idOwner);
		Route realRoute = owner.managerImplementing(RouteManager.class).find(idRoute);
		user.managerImplementing(InscriptionManager.class).add(new Inscription(realRoute, new InscriptionPending()));
		realRoute.addSubscriptionRequest(new SubscriptionRequest(user, new SubscriptionPending()));
		this.update(user);
		this.update(owner);
	}

	@Transactional
	public void removeProduct(Long id, Product product) throws Exception {
		User user = this.getRepository().findById(id);
		user.managerImplementing(ProductManager.class).remove(product.getId());
		this.getRepository().saveOrUpdate(user);
	}

	@Transactional
	public UserProfile getUserProfile(Long id) {
		return new UserProfile(getUser(id));
	}

	@Transactional
	public void rateUser(long id, CommentedPointRequest commentedPointForUser) {
		User userCommented = getUser(id);
		User guestUser = getUser(commentedPointForUser.getUserId());
		CommentedPoint commentedPoint = new CommentedPoint(guestUser, commentedPointForUser.getIsNegative(),
				commentedPointForUser.getComment());
		userCommented.managerImplementing(ScoreManager.class).add(commentedPoint);
		this.update(userCommented);
	}

	@Transactional
	public List<CommentedPointRequest> getCommentedPointRequests(Long id, Integer page, Integer quantity) {
		User user = this.getRepository().findById(id);
		List<CommentedPoint> commentedPoints = user.managerImplementing(ScoreManager.class).getCommentedPoints();
		
		List<CommentedPointRequest> returnCollection = new ArrayList<CommentedPointRequest>();
		for (CommentedPoint commentedPoint : commentedPoints) {
			returnCollection.add(new CommentedPointRequest(commentedPoint));
		}
		return returnCollection;
	}
	

	@Transactional
	public void commentUser(long id, CommentRequest commentRequest) {
		User userCommented = getUser(id);
		User guestUser = getUser(commentRequest.getUserId());
		Comment comment = new Comment(guestUser, commentRequest.getMessage(), DateTime.now());
		userCommented.managerImplementing(CommentManager.class).add(comment);
		this.update(userCommented);
	}

	@Transactional
	public List<CommentRequest> getCommentRequests(Long id, Integer page, int i) {
		User user = this.getRepository().findById(id);
		List<Comment> comments = user.managerImplementing(CommentManager.class).getComments();

		List<CommentRequest> returnCollection = new ArrayList<CommentRequest>();

		for (Comment comment : comments) {
			returnCollection.add(new CommentRequest(comment));
		}
		return returnCollection;
	}

	@Transactional
	public void denyRequest(Long id, Long routeID, Long subscriptionID) throws NotFoundException {
		User user = this.getRepository().findById(id);
		user.managerImplementing(RouteManager.class).find(routeID).canceledSubscriptionRequest(subscriptionID);
		this.update(user);
	}

	@Transactional
	public void acceptedRequest(Long id, Long routeID, Long subscriptionID) throws NotFoundException {
		User user = this.getRepository().findById(id);
		user.managerImplementing(RouteManager.class).find(routeID).acceptedSubscriptionRequest(subscriptionID);
		this.update(user);
	}
	
	@Transactional
	public Integer getCountVehiclesFor(Long id, Integer quantity) {
		User user = this.getRepository().findById(id);
		return this.getRepository().getCountVehiclesFor(user.managerImplementing(VehicleManager.class).getId(), quantity);
	}
	
}
