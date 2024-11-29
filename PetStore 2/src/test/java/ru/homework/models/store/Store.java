package ru.homework.models.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Store{

	@JsonProperty("petId")
	private Integer petId;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("complete")
	private Boolean complete;

	@JsonProperty("status")
	private String status;
}