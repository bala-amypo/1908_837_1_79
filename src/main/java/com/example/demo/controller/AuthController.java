@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
