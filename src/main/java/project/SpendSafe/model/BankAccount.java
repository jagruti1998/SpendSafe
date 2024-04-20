package project.SpendSafe.model;



        import jakarta.persistence.Entity;
        import jakarta.persistence.Id;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BankAccount {

    @Id
    private long accountNo;
    private String ifscCode;
    private String bankname;
    private double balance;


}