package hu.elte.VallalatiTODOProject.security;

import hu.elte.VallalatiTODOProject.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
@Data
@NoArgsConstructor
public class AuthenticatedUser {
    private User user;
}
