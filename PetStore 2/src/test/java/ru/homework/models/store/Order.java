package ru.homework.models.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	@JsonProperty("petId")
	private Integer petId;

	@JsonProperty("quantity")
	private Integer quantity;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("shipDate")
	private String shipDate;

	@JsonProperty("complete")
	private Boolean complete;

	@JsonProperty("status")
	private String status;

	//нужно потому что shipdate отличается при отправке запроса и при получения ответы этого же класса
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(petId, order.petId) && Objects.equals(quantity, order.quantity) && Objects.equals(id, order.id) && Objects.equals(complete, order.complete) && Objects.equals(status, order.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(petId, quantity, id, shipDate, complete, status);
	}
}