package com.pgcityboys.userinator.route;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String startAddress;
	private String endAddress;
	private int duration;
	private int distance;
	private String email;
	private LocalDateTime dateTime;

	public Route(String startAddress, String endAddress, int duration, int distance, String email) {
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		this.duration = duration;
		this.distance = distance;
		this.email = email;
		this.dateTime = LocalDateTime.now();
	}
}
