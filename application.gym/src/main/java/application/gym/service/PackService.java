package application.gym.service;

import application.gym.POJO.Pack;
import java.util.List;

public interface PackService {
    Pack addPack(Pack pack);
    List<Pack> getAllPacks();
}
