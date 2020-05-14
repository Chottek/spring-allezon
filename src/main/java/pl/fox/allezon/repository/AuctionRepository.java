package pl.fox.allezon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fox.allezon.model.Auction;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

}
