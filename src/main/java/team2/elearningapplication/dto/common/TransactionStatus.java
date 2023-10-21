package team2.elearningapplication.dto.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionStatus implements Serializable {
    private String status;
    private String message;
    private String data;
}
