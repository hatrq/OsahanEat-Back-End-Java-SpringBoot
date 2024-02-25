package project.Oshana.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    Boolean insertMenu(MultipartFile file, String title, String timeShip, boolean isFreeShip, double price, int cateID);
}
