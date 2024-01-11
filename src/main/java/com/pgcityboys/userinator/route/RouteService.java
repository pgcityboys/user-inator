package com.pgcityboys.userinator.route;

import com.pgcityboys.userinator.route.dtos.SaveRouteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {

	private final RouteRepository routeRepository;

	public List<Route> getRoutes(String email, int amount) {
		List<Route> result = routeRepository.findRoutesByEmailOrderByDateTime(email);
		return result.subList(0, Math.min(result.size(), amount));
	}

	public Route saveRoute(SaveRouteRequest request) {
		Route routeToSave = new Route(
				request.startAddress(),
				request.endAddress(),
				request.duration(),
				request.distance(),
				request.email()
		);
		return routeRepository.save(routeToSave);
	}

}
