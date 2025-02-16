package application.gym.restImpl;

import application.gym.POJO.Pack;
import application.gym.enums.PackDuration;
import application.gym.rest.PackRest;
import application.gym.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pack")
public class PackRestImpl implements PackRest {

    @Autowired
    private PackService packService;

    @Override
    public ResponseEntity<Pack> createPack(@RequestBody Pack pack) {
        return ResponseEntity.ok(packService.addPack(pack));
    }

    @Override
    public ResponseEntity<List<Pack>> getAllPacks() {
        return ResponseEntity.ok(packService.getAllPacks());
    }

    @Override
    public ResponseEntity<PackDuration> getPackDuration(@PathVariable Long packId) {
        return ResponseEntity.ok(packService.getPackDuration(packId));
    }
}
