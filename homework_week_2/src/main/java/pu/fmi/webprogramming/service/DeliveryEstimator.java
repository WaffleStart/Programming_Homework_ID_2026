package pu.fmi.webprogramming.service;

import org.springframework.stereotype.Component;
import pu.fmi.webprogramming.model.Customer;
import pu.fmi.webprogramming.model.Delivery;
import pu.fmi.webprogramming.model.Warehouse;

import java.time.LocalDateTime;

@Component
public class DeliveryEstimator {

  public LocalDateTime estimateArrivalTime(Delivery delivery) {

    // В Delivery е добавено ново поле LocalDateTime estimatedArrivalAt
    // Този метод се използва в createDelivery на DeliveryService
    LocalDateTime currentDate = delivery.getCreatedAt();
    Warehouse wh = delivery.getWarehouse();
    if (wh == null){
      return null;
    }
    Customer cus = delivery.getCustomer();
    if (wh.getCity().equals(cus.getCity())){
      currentDate = currentDate.plusDays(1);
    }
    else{

      currentDate = currentDate.plusDays(3);
    }
    if (delivery.getCourier() == null)
    {
      currentDate = currentDate.plusDays(2);
    }

    return currentDate;


    // * Провери дали градовете на склада и клиента съвпадат:
    //   → При съвпадащи градове:
    //     - очаквана дата на доставка трябва да е 1 ден след датата на създаване на доставка
    //   → При различни градове между склада и този на клиента:
    //     - очаквана дата на доставка трябва да е 3 дни след датата на създаване на доставка
    //
    // * Провери и наличността на куриер:
    //   → Ако няма назначен куриер:
    //     - Добави още 2 дни закъснение към вече изчислената дата
    //
    // ВАЖНО:
    // * Всички предоставени Unit тестове (DeliveryServiceTest) трябва да минават успешно
    // * Не променяйте тестовете
    // * Не променяйте сигнатурата на метода


  }
}
