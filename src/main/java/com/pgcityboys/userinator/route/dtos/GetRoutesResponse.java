package com.pgcityboys.userinator.route.dtos;

import com.pgcityboys.userinator.route.Route;

import java.util.List;

public record GetRoutesResponse(List<Route> routes) {
}
