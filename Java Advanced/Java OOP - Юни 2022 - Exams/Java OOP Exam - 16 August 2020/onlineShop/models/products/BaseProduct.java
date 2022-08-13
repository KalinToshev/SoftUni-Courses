package onlineShop.models.products;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.PRODUCT_TO_STRING;

public abstract class BaseProduct implements Product {
    //base class for components, peripherals, and computers

    //Child Classes
    //There are several concrete types of products:
    //•	Component
    //•	Peripheral
    //•	Computer

    //Data
    //•	id – int
        //cannot be less than or equal to 0. In that case,
        //throw IllegalArgumentException with the message "Id can not be less or equal than 0."
    //•	manufacturer – String
        //cannot be null or whitespace. In that case,
        //throw IllegalArgumentException with the message "Manufacturer can not be empty."
    //•	model – String
        //cannot be null or whitespace. In that case,
        //throw IllegalArgumentException with the message "Model can not be empty."
    //•	price – double
        //cannot be less than or equal to 0. In that case,
        //throw IllegalArgumentException with the message "Price can not be less or equal than 0."
    //•	overallPerformance – double
        //cannot be less than or equal to 0. In that case,
        //throw IllegalArgumentException with the message "Overall Performance can not be less or equal than 0."

    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    //Constructor
    //A product should take the following values upon initialization:
    //(int id, String manufacturer, String model, double price, double overallPerformance)

    public BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    protected void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(INVALID_PRODUCT_ID);
        }
        this.id = id;
    }

    protected void setManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_MANUFACTURER);
        }
        this.manufacturer = manufacturer;
    }

    protected void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_MODEL);
        }
        this.model = model;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    protected void setOverallPerformance(double overallPerformance) {
        if (overallPerformance <= 0) {
            throw new IllegalArgumentException(INVALID_OVERALL_PERFORMANCE);
        }
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getOverallPerformance() {
        return overallPerformance;
    }

    //Override toString() method in the format:
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"

    @Override
    public String toString() {
        return String.format(PRODUCT_TO_STRING,
                overallPerformance, price, getClass().getSimpleName(), manufacturer, model, id);
    }

}
