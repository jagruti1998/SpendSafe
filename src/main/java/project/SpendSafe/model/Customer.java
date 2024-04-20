package project.SpendSafe.model;




        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

        import jakarta.persistence.*;
        import jakarta.validation.constraints.NotEmpty;
        import jakarta.validation.constraints.NotNull;
        import jakarta.validation.constraints.Pattern;
        import jakarta.validation.constraints.Size;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @NotEmpty(message = "Name could not be null")
    private String name;

    @Pattern(regexp = "[789]{1}[0-9]{9}")
    private String mobileNumber;

    @NotNull(message = "Password  could not be null")
    @Size(min=4,max=10,message ="Password size min 4 and max 10 required")
    private String password;


    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;





}