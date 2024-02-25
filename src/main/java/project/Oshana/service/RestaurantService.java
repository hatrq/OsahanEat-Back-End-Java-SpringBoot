package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project.Oshana.dto.CategoryDTO;
import project.Oshana.dto.MenuRestaurantDTO;
import project.Oshana.dto.RestaurantDTO;
import project.Oshana.entity.Food;
import project.Oshana.entity.MenuRestaurant;
import project.Oshana.entity.RatingRestaurant;
import project.Oshana.entity.Restaurant;
import project.Oshana.repository.RestaurantRepository;
import project.Oshana.service.imp.FileServiceImp;
import project.Oshana.service.imp.RestaurantServiceImp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeShip, String address, String openDate) {
        boolean isSuccess = false;
        try{
            boolean isFileSuccess = fileServiceImp.saveFile(file);
            if (isFileSuccess){
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeShip(isFreeShip);
                restaurant.setAddress(address);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                restaurant.setOpenDate(dateFormat.parse(openDate));

                restaurantRepository.save(restaurant);

                isSuccess = true;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<RestaurantDTO> getHomePageRestaurant() {
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageRequest);
        List<RestaurantDTO> dtoList = new ArrayList<>();

        for (Restaurant restaurant : restaurantPage){
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setTitle(restaurant.getTitle());
            restaurantDTO.setSubtitle(restaurant.getSubtitle());
            restaurantDTO.setImage(restaurant.getImage());
            restaurantDTO.setFreeShip(restaurant.isFreeShip());
            restaurantDTO.setDescription(restaurant.getDescription());
            restaurantDTO.setRate(ratingRestaurang(restaurant.getRatingRestaurantSet()));
            dtoList.add(restaurantDTO);
        }
        return dtoList;
    }

    // calculate rating point of each restaurant
    private double ratingRestaurang(Set<RatingRestaurant> ratingRestaurantSet){
        double point = 0;
        for (RatingRestaurant ratingRestaurant : ratingRestaurantSet){
            point += ratingRestaurant.getRatePoint();
        }
        return point/ratingRestaurantSet.size();
    }

    @Override
    public RestaurantDTO getDetailRestaurant(int id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if (restaurant.isPresent()){
            restaurantDTO.setTitle(restaurant.get().getTitle());
            restaurantDTO.setSubtitle(restaurant.get().getSubtitle());
            restaurantDTO.setImage(restaurant.get().getImage());
            restaurantDTO.setRate(ratingRestaurang(restaurant.get().getRatingRestaurantSet()));
            restaurantDTO.setFreeShip(restaurant.get().isFreeShip());

            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            for (MenuRestaurant menuRestaurant : restaurant.get().getMenuRestaurantSet()){
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setName(menuRestaurant.getCategory().getName());
                List<MenuRestaurantDTO> menuRestaurantDTOList = new ArrayList<>();
                for (Food food : menuRestaurant.getCategory().getFoodSet()){
                    MenuRestaurantDTO menuRestaurantDTO = new MenuRestaurantDTO();
                    menuRestaurantDTO.setImage(food.getImage());
                    menuRestaurantDTO.setTitle(food.getTitle());
                    menuRestaurantDTOList.add(menuRestaurantDTO);
                }
                categoryDTO.setMenuRestaurantDTOList(menuRestaurantDTOList);
                categoryDTOList.add(categoryDTO);
            }
            restaurantDTO.setCategoryDTO(categoryDTOList);
        }
        return restaurantDTO;
    }
}
