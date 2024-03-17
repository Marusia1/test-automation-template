package delivery.dto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import delivery.utils.RandomDataGenerator;

@Builder
@Getter
@Setter
public class OrderDtoBuilderAndFactory {
    private String status;
    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;
    private int id;

    public static OrderDtoBuilderAndFactory createRandomOrder() {
        // builder
        return OrderDtoBuilderAndFactory.builder()
                .status("OPEN")
                .courierId(0)
                .customerName(RandomDataGenerator.generateName())
                .customerPhone("12343456")
                .comment("comment")
                .id(1)
                .build();
    }
}
