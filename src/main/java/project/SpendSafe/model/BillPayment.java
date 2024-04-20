package project.SpendSafe.model;


        import java.time.LocalDate;



        import com.fasterxml.jackson.annotation.JsonIgnore;

        import jakarta.persistence.*;
        import jakarta.validation.constraints.NotNull;
        import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billid;


    private String billtype;

    @NotNull
    private Double amount;
    private LocalDate billdate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Wallet wallet;
}