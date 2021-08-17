package pkutepov.com.view.IU;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import pkutepov.com.view.component.*;

public class Index extends UI {


    private MedicineGrid medicineGrid = new MedicineGrid(false);
    private BasketGrid basketGrid;
    private GeneratedOrders generatedOrders = new GeneratedOrders(true);
    private CommonView commonView;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        long startTime1 = System.currentTimeMillis();
        long startTime4 = System.currentTimeMillis();
        for (int i=0;i<100;i++) {
            MedicineGrid medicineGrid2 = new MedicineGrid(false);
        }
        long endTime1 = System.currentTimeMillis();
        long duration = (endTime1 - startTime1);  //divide by 1000000 to g
            System.out.println("Время выполнения запроса 1: " + duration);

        long startTime2 = System.currentTimeMillis();
        for (int i=0;i<100;i++) {
            GeneratedOrders generatedOrders3 = new GeneratedOrders(true);

        }
        long endTime2 = System.currentTimeMillis();
        long duration2 = (endTime2 - startTime2);  //divide by 1000000 to g
            System.out.println("Время выполнения запроса2: " + duration2);

        long startTime3 = System.currentTimeMillis();
        for (int i=0;i<100;i++) {
            UserInfoGrid userInfoGrid  =  new UserInfoGrid();
        }
        long endTime3 = System.currentTimeMillis();

        long duration3 = (endTime3 - startTime3);  //divide by 1000000 to g
        System.out.println("Время выполнения запроса 3: " + duration3);


        long endTime4 = System.currentTimeMillis();
        long duration4 = (endTime4 - startTime4);  //divide by 1000000 to g
            System.out.println("Время выполнения запроса: " + duration4);

        medicineGrid.getOrderList();
        basketGrid = new BasketGrid(medicineGrid.getOrderList());
        commonView = new CommonView(medicineGrid, basketGrid, generatedOrders);
        setSizeFull();
        setContent(commonView);
    }


}

