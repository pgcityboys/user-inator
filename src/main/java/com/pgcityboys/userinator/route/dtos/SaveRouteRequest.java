package com.pgcityboys.userinator.route.dtos;

public record SaveRouteRequest(String startAddress, String endAddress, int duration, int distance, String email) {
}
