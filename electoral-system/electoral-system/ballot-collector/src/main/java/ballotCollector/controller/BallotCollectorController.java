package ballotCollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ballotCollector.entity.BallotCollector;
import ballotCollector.service.BallotCollectorService;

@RestController
@RequestMapping("/ballotcollector")
public class BallotCollectorController {

    @Autowired BallotCollectorService ballotCollectorService;

    @PostMapping
    public BallotCollector postBallotCollector(@RequestBody BallotCollector ballotCollector) {
        return ballotCollectorService.addBallotCollector(ballotCollector);
    }

    @GetMapping
    public List<BallotCollector> getAllBallotCollectors(){
        return ballotCollectorService.findAllBallotCollectors();
    }

    @GetMapping("/id/{id}")
    public BallotCollector getBallotCollectorByID(@PathVariable("id") String id){
        return ballotCollectorService.findBallotCollectorByID(id);
    }

    @GetMapping("/Region/")
    public BallotCollector getBallotCollectorByRegion(@PathVariable("region") String region){
        return ballotCollectorService.findBallotCollectorByRegion(region);
    }

    @PutMapping("/id/{id}")
    public BallotCollector putBallotCollectorByID(@PathVariable("id") String id, @RequestBody BallotCollector ballotCollector) {
        return ballotCollectorService.replaceBallotCollectorByID(id, ballotCollector);
    }

    @DeleteMapping
    public void deleteAllballotCollectors() {
        ballotCollectorService.removeAllBallotCollectors();
    }

    @DeleteMapping("/id/{id}")
    public BallotCollector deleteballotCollectorByID(@PathVariable("id") String id) {
        return ballotCollectorService.removeBallotCollectorByID(id);
    }

    @DeleteMapping("/Region/{Region}")
    public BallotCollector deleteballotCollectorByRegion(@PathVariable("region") String region) {
        return ballotCollectorService.removeBallotCollectorByRegion(region);
    }
}
