package team2.elearningapplication.dto.response.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetTotalRevenueResponse {
    @NotNull
    private double totalRevenue;
}
