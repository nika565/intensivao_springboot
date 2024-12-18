package tech.nathan.btgpactual.orderms.dto;

import java.util.List;

public record ApiResponse<T>(
        List<T> data,
        PaginationResponse paginationResponse

) {
}
