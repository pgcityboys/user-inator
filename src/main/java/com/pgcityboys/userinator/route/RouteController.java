package com.pgcityboys.userinator.route;

import com.pgcityboys.userinator.route.dtos.GetRoutesResponse;
import com.pgcityboys.userinator.route.dtos.RoutesStatsResponse;
import com.pgcityboys.userinator.route.dtos.SaveRouteRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
@AllArgsConstructor
public class RouteController {

	private final RouteService routeService;

	@GetMapping("/{email}")
	public ResponseEntity<GetRoutesResponse> getRoutes(@PathVariable String email, @RequestParam(name = "limit", required = false) Integer limit) {
		List<Route> routes = routeService.getRoutes(email, limit);
		GetRoutesResponse response = new GetRoutesResponse(routes);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Route> saveRoute(@RequestBody SaveRouteRequest saveRouteRequest) {
		Route savedRoute = routeService.saveRoute(saveRouteRequest);

		return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
	}

	@GetMapping("/{email}/stats")
	public ResponseEntity<RoutesStatsResponse> getStats(@PathVariable String email) {
		RoutesStatsResponse response = routeService.getStats(email);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
