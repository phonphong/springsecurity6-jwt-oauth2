package security.jwt.oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.jwt.oauth2.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
