package pl.fox.allezon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.fox.allezon.model.Auction;
import pl.fox.allezon.model.User;
import pl.fox.allezon.repository.AuctionRepository;
import pl.fox.allezon.utils.ConsoleColors;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AuctionService {

    private static Logger LOG = LoggerFactory.getLogger(AuctionService.class);
    private static final String LOG_COLOR = ConsoleColors.BLUE_BOLD;

    private AuctionRepository repository;

    @Autowired
    public AuctionService(AuctionRepository repository) {
        this.repository = repository;
    }

    public List<Auction> getAllAuctions() {
        return repository.findAll();
    }

    public Auction getById(Integer id){
        return repository.getOne(id);
    }

    public void saveAuction(Auction a) {
        repository.save(a);
        LOG.info(LOG_COLOR + "Saved {}" + ConsoleColors.RESET, a.toString());
    }

    public void deleteAuction(Integer id) {
        repository.deleteById(id);
        LOG.info(LOG_COLOR + "Deleted Auction with id {}" + ConsoleColors.RESET, id);
    }

    @PostConstruct
    public void countAuctions(){
        LOG.info(LOG_COLOR + "There are {} auctions in database" + ConsoleColors.RESET, repository.count());
    }

}
