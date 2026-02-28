package tripease.example.TripEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tripease.example.TripEase.entity.Cab;

public interface CabRepository extends JpaRepository<Cab,Integer> {


    @Query("select c from Cab c where c.available = true order by rand() limit 1")
    Cab getAvailableCab();
}
