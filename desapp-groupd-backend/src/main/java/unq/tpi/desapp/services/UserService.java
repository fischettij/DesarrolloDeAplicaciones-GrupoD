package unq.tpi.desapp.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.model.manager.ProductManager;
import unq.tpi.desapp.model.manager.RouteManager;
import unq.tpi.desapp.model.manager.VehicleManager;
import unq.tpi.desapp.repositories.ProductRepository;
import unq.tpi.desapp.repositories.UserRepository;

public class UserService implements Serializable  {

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
		return new ArrayList<Vehicle>(user.managerImplementing(VehicleManager.class).getVehicles());
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
	public 	List<User> getUsersLike(String userName){
		return this.getRepository().getUsersLike(userName);
	}

	@Transactional
	public void addNewRoute(Long id, Route route) {
		User user = this.getRepository().findById(id);
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
	public void removeProduct(Long id,Product product){
		User user = this.getRepository().findById(id);
		user.managerImplementing(ProductManager.class).remove(product);
	}
	
	
}
