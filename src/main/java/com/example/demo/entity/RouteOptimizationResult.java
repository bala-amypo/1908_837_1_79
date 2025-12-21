@Entity
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;

    public RouteOptimizationResult() {}

    public void setShipment(Shipment shipment) { this.shipment = shipment; }
    public void setOptimizedDistanceKm(Double d) { this.optimizedDistanceKm = d; }
    public void setEstimatedFuelUsageL(Double f) { this.estimatedFuelUsageL = f; }
    public void setGeneratedAt(LocalDateTime t) { this.generatedAt = t; }
}
