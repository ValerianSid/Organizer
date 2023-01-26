package by.itstep.organizaer.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

public class BillDto {
    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class BillDto {


        String accountName;
        @NotNull
        Long id;
        @NotNull
        Currency currency;

        LocalDateTime transactionDate;

        @NotNull
        Float amount;
    }
}
