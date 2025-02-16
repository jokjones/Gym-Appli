package application.gym.rest;

import application.gym.POJO.Pack;
import application.gym.enums.PackDuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pack")
public interface PackRest {

    @PostMapping("/create")
    ResponseEntity<Pack> createPack(@RequestBody Pack pack);

    @GetMapping("/all")
    ResponseEntity<List<Pack>> getAllPacks();

    @GetMapping("/{packId}/duration")
    ResponseEntity<PackDuration> getPackDuration(@PathVariable Long packId);
}
