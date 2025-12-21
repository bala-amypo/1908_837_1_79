@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weightKg;
    private LocalDate scheduledDate;

    public Shipment() {}

    public Location getPickupLocation() { return pickupLocation; }
    public Location getDropLocation() { return dropLocation; }
    public Double getWeightKg() { return weightKg; }
    public LocalDate getScheduledDate() { return scheduledDate; }

    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setPickupLocation(Location pickupLocation) { this.pickupLocation = pickupLocation; }
    public void setDropLocation(Location dropLocation) { this.dropLocation = dropLocation; }
}
