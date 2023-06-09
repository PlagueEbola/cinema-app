package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService,
                           RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role roleUser = new Role();
        roleUser.setRole(Role.RoleName.USER);
        roleService.add(roleUser);
        User userBob = new User();
        userBob.setRoles(Set.of(roleUser));
        userBob.setEmail("bob@gmail.com");
        userBob.setPassword("1234");
        userService.add(userBob);

        Role roleAdmin = new Role();
        roleAdmin.setRole(Role.RoleName.ADMIN);
        roleService.add(roleAdmin);
        User adminAlice = new User();
        adminAlice.setRoles(Set.of(roleAdmin));
        adminAlice.setEmail("alice@gmail.com");
        adminAlice.setPassword("4321");
        userService.add(adminAlice);
    }
}
