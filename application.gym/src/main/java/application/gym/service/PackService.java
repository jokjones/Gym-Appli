package application.gym.service;

import application.gym.POJO.Pack;
import application.gym.enums.PackDuration;
import java.util.List;

public interface PackService {
    Pack addPack(Pack pack);
    List<Pack> getAllPacks();
    PackDuration getPackDuration(Long packId);
}
