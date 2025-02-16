package application.gym.dao;

import application.gym.POJO.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackDao extends JpaRepository<Pack, Long> {
}
