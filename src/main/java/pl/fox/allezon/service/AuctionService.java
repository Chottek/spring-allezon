package pl.fox.allezon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fox.allezon.model.Auction;
import pl.fox.allezon.repository.AuctionRepository;

import java.util.List;

@Service
public class AuctionService {

    private AuctionRepository repository;

    @Autowired
    public AuctionService(AuctionRepository repository){
        this.repository = repository;
    }

    public List<Auction> getAllAuctions(){
        return repository.findAll();
    }

    public Auction saveAuction(Auction a){
        return repository.save(a);
    }


}
