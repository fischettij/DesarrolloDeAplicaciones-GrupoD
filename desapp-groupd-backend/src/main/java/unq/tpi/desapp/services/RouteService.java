package unq.tpi.desapp.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.request.RequestRoute;
import unq.tpi.desapp.repositories.RouteRepository;

public class RouteService{
	
	private RouteRepository repository;

	public RouteRepository getRepository() {
		return repository;
	}

	public void setRepository(RouteRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public List<Route> lookForRoutes(RequestRoute requestRoute) {
		return this.getRepository().lookForRoutes(requestRoute);
	}
	
}
