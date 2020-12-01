package ballotCollector.service;

import ballotCollector.entity.BallotCollector;
import ballotCollector.repository.BallotCollectorRepo;
import exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BallotCollectorService {
    @Autowired BallotCollectorRepo BallotCollectorRepo;

    /*@Autowired
    public BallotCollectorService(@Qualifier("BallotCollectorRepo") BallotCollectorRepo BallotCollectorRepo) {
        this.BallotCollectorRepo = BallotCollectorRepo;
    }*/

    public BallotCollector addBallotCollector(BallotCollector BallotCollector) {
        if(!BallotCollectorRepo.existsByRegion(BallotCollector.getRegion()))
            return BallotCollectorRepo.save(BallotCollector);
        else
            throw new ApiRequestException("This BallotCollector already exists in the database");
    }

    public BallotCollector findBallotCollectorByID(String id) {
        return BallotCollectorRepo.findById(id).orElseThrow(() ->
                new ApiRequestException("Cannot find BallotCollector with this ID"));
    }

    public BallotCollector findBallotCollectorByRegion(String Region) {
        return BallotCollectorRepo.findByRegion(Region).orElseThrow(() ->
                new ApiRequestException("Cannot find BallotCollector with this ID"));
    }

    public BallotCollector replaceBallotCollectorByID(String id, BallotCollector BallotCollector) {
        BallotCollectorRepo.findById(id).orElseThrow(() ->
                new ApiRequestException("Cannot find member with this ID"));
        BallotCollector.setId(id);
        BallotCollectorRepo.save(BallotCollector);

        return BallotCollector;
    }

    public List<BallotCollector> findAllBallotCollectors() {
        return BallotCollectorRepo.findAll();
    }

    public BallotCollector removeBallotCollectorByID(String id) {
        BallotCollector BallotCollector = findBallotCollectorByID(id);
        BallotCollectorRepo.deleteById(id);
        return BallotCollector;
    }

    public BallotCollector removeBallotCollectorByRegion(String Region) {
        BallotCollector BallotCollector = findBallotCollectorByRegion(Region);
        BallotCollectorRepo.deleteByRegion(Region);
        return BallotCollector;
    }

    public void removeAllBallotCollectors() {
        BallotCollectorRepo.deleteAll();
    }
}
