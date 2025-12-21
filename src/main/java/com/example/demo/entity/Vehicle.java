@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;

    public Vehicle() {}

    public Double getCapacityKg() { return capacityKg; }
    public Double getFuelEfficiency() { return fuelEfficiency; }

    public void setUser(User user) { this.user = user; }
}
