package bo;

import bo.Impl.*;

/** Factory design pattern */

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){
    }

    public static BoFactory getBoFactory(){
        if (boFactory==null){
            boFactory=new BoFactory();
        }
        return boFactory;
    }

    public enum BoTypes {
        CUSTOMER,CUSTOMER_REPORT,DAILY_INCOME,ITEM,LOWEST_MOVABLE,MODIFY_ITEM,
        MONTHLY_INCOME,MOST_MOVABLE,NEW_ITEM,PLACE_ORDER,REMOVE_ITEM,YEARLY_INCOME;
    }

    public SuperBo getBo(BoTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case DAILY_INCOME:
                return new DailyIncomeBoImpl();
            case ITEM:
                return new ItemBOImpl();
            case LOWEST_MOVABLE:
                return new LowestMovableBoImpl();
            case MODIFY_ITEM:
                return new ModifyItemBoImpl();
            case MONTHLY_INCOME:
                return new MonthlyIncomeBoImpl();
            case MOST_MOVABLE:
                return new MostMovableItemBoImpl();
            case NEW_ITEM:
                return new NewItemBoImpl();
            case PLACE_ORDER:
                return new PlaceOrderB0Impl();
            case REMOVE_ITEM:
                return new RemoveItemBoImpl();
            case YEARLY_INCOME:
                return new YearlyIncomeBoImpl();
            case CUSTOMER_REPORT:
                return new CustomerReportBoImpl();
            default:
                return null;
        }
    }


}
