package tech.nathan.btgpactual.orderms.dto;

import tech.nathan.btgpactual.orderms.entity.OrderEntity;

import java.math.BigDecimal;

public record OrderResponse(
        Long orderId,
        Long customerId,
        BigDecimal total
) {
    public static OrderResponse fromEntity(OrderEntity entity){
        return new OrderResponse(entity.getId(), entity.getCustomerId(), entity.getTotal());
    }
}
