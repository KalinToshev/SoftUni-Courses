package onlineShop.models.products.peripherals;

import onlineShop.models.products.BaseProduct;

import static onlineShop.common.constants.OutputMessages.PERIPHERAL_TO_STRING;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    //derived class from BaseProduct and a base class for any peripherals

    //Child Classes
    //There are several concrete types of peripherals:
    //•	Headset
    //•	Keyboard
    //•	Monitor
    //•	Mouse

    //Data
    //•	connectionType – String

    private String connectionType;

    //Constructor
    //A product should take the following values upon initialization:
    //(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType)

    public BasePeripheral(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return connectionType;
    }

    //Override toString() method in the format:
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id}) Connection Type: {connection type}"

    @Override
    public String toString() {
        return super.toString() + String.format(PERIPHERAL_TO_STRING, connectionType);
    }

}
