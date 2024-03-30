package delivery.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import delivery.utils.RandomDataGenerator;
@Builder
@Getter
@Setter
public class OrderDto {
    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    private int id;


    public static OrderDto createRandomOrder() {
        // builder
        return OrderDto.builder()
                .status("OPEN")
                .courierId(0)
                .customerName(RandomDataGenerator.generateName())
                .customerPhone("12343456")
                .comment("comment")
                .id(1)
                .build();
    }
}


