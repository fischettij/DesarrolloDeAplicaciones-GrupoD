package unq.tpi.desapp.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.ProductManager;
import unq.tpi.desapp.model.manager.ScoreManager;
import unq.tpi.desapp.repositories.ProductRepository;
import unq.tpi.desapp.repositories.UserRepository;
import unq.tpi.desapp.services.request.GenericRequest;

public class ProductService implements Serializable {

	private static final long serialVersionUID = -775821483792565189L;

	private ProductRepository productRepository;
	private UserRepository userRepository;

	public UserRepository getUserRepository() {
		return this.userRepository;
	}

	public ProductRepository getProductRepository() {
		return this.productRepository;
	}

	public void setUserRepository(final UserRepository repository) {
		this.userRepository = repository;
	}

	public void setProductRepository(final ProductRepository repository) {
		this.productRepository = repository;
	}

	@Transactional
	public List<Product> getProducts(Integer page, Integer quantity) {
		return this.getProductRepository().getProducts(page, quantity);
	}

	@Transactional
	public void purchaseProduct(Long userId, Long productId) {
		User user = this.getUserRepository().findById(userId);
		Product product = this.getProductRepository().findById(productId);
		ScoreManager scoreManager = user.managerImplementing(ScoreManager.class);
		scoreManager.purchaseProduct(product);
	}

	@Transactional
	public void updateProduct(Long productId, GenericRequest<Product> request) {
		User requestUser = getUserRepository().findById(request.getRequestedBy());
		requestUser.managerImplementing(ProductManager.class);

		getProductRepository().saveOrUpdate(request.getRequestObject());
	}

	@Transactional
	public Integer getCountProducts(Integer quantity) {
		return getProductRepository().getCountProducts(quantity);
	}
}
