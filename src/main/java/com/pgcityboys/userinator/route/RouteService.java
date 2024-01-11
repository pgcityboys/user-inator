package com.pgcityboys.userinator.route;

import com.pgcityboys.userinator.route.dtos.RoutesStatsResponse;
import com.pgcityboys.userinator.route.dtos.SaveRouteRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.RowId;
import java.util.List;

@Service
@AllArgsConstructor
public class RouteService {

	private final RouteRepository routeRepository;

	public List<Route> getRoutes(String email, Integer amount) {
		List<Route> result = routeRepository.findRoutesByEmailOrderByDateTimeDesc(email);
		int amountToReturn = amount == null
				? result.size()
				: amount;

		return result.subList(0, Math.min(result.size(), amountToReturn));
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

	public RoutesStatsResponse getStats(String email) {
		List<Route> routes = routeRepository.findRoutesByEmailOrderByDateTimeDesc(email);
		final float COST_PER_KM = 0.4f;
		final float CAR_CO2_PER_KM = 0.161f;
		final float SCOOTER_CO2_PER_KM = 0.127f;
		final float CO2_PER_KM = CAR_CO2_PER_KM - SCOOTER_CO2_PER_KM;

		int totalDistance = routes.stream()
				.map(Route::getDistance)
				.mapToInt(Integer::intValue)
				.sum();
		float totalCost = (float) totalDistance / 1000 * COST_PER_KM ;
		float totalCO2 = (float) totalDistance / 1000 * CO2_PER_KM;

		return new RoutesStatsResponse(totalCO2, totalCost);
	}
}
