package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Oshana.entity.*;
import project.Oshana.entity.keys.KeyOrderItem;
import project.Oshana.payload.request.OrderRequest;
import project.Oshana.repository.OrderItemRepository;
import project.Oshana.repository.OrderRepository;
import project.Oshana.service.imp.OrderServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceImp {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public boolean insertOrder(OrderRequest orderRequest) {
        try{
            Orders orders = new Orders();
            Users users = new Users();
            users.setId(orderRequest.getUserID());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getRestaurantID());

            orders.setUsers(users);
            orders.setRestaurant(restaurant);

            orderRepository.save(orders);

            List<OrderItem> orderItemList = new ArrayList<>();
            for (int foodID : orderRequest.getFoodID()){
                OrderItem orderItem = new OrderItem();
                KeyOrderItem keyOrderItem = new KeyOrderItem(orders.getId(), foodID);
                orderItem.setKeyOrderItem(keyOrderItem);

                orderItemList.add(orderItem);
            }

            orderItemRepository.saveAll(orderItemList);
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }


    }
}
