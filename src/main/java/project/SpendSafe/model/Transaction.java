package project.SpendSafe.model;


        import java.time.LocalDate;



        import com.fasterxml.jackson.annotation.JsonFormat;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

        import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;
    private String transactionType;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private LocalDate  transactionDate;
    private double amount;

    @JsonIgnore
    @ManyToOne(cascade  = CascadeType.ALL)
    private Wallet wallet;

}