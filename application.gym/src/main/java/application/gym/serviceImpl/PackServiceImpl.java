package application.gym.serviceImpl;

import application.gym.dao.PackDao;
import application.gym.POJO.Pack;
import application.gym.enums.PackDuration;
import application.gym.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PackServiceImpl implements PackService {

    @Autowired
    private PackDao packDao;

    @Override
    public Pack addPack(Pack pack) {
        return packDao.save(pack);
    }

    @Override
    public List<Pack> getAllPacks() {
        return packDao.findAll();
    }

    @Override
    public PackDuration getPackDuration(Long packId) {
        Pack pack = packDao.findById(packId).orElseThrow(() -> new RuntimeException("Pack not found"));
        return pack.getDuration();
    }
}
