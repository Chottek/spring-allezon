package pl.fox.allezon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.fox.allezon.model.Auction;
import pl.fox.allezon.service.AuctionService;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    private AuctionService service;

    @Autowired
    public AuctionController(AuctionService service){
        this.service = service;
    }

    @GetMapping
    public List<Auction> getAllAuctions(){
        return service.getAllAuctions();
    }

    @GetMapping(value = "/get")
    public Auction getById(@RequestParam Integer id) { return service.getById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Auction a){
        service.saveAuction(a);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteAuction(id);
    }

}
