@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;

    public Location() {}

    public Long getId() { return id; }

    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }

    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
