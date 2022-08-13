package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

import static onlineShop.common.constants.OutputMessages.COMPONENT_TO_STRING;

public abstract class BaseComponent extends BaseProduct implements Component {
    //derived class from BaseProduct and a base class for any components

    //Child Classes
    //There are several specific types of components, where the overall performance has a different multiplier:
    //•	CentralProcessingUnit - the multiplier is 1.25
    //•	Motherboard – the multiplier is 1.25
    //•	PowerSupply – the multiplier is 1.05
    //•	RandomAccessMemory – the multiplier is 1.20
    //•	SolidStateDrive – the multiplier is 1.20
    //•	VideoCard – the multiplier is 1.15
    //Example: If we create the CentralProcessingUnit with overallPerformance – 50 from the constructor,
    //and multiplier 1.25, the overallPerformance should be 62.50.

    //Data
    //•	generation – int

    private int generation;

    //Constructor
    //A product should take the following values upon initialization:
    //(int id, String manufacturer, String model, double price, double overallPerformance, int generation)

    public BaseComponent(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return generation;
    }

    //Override toString() method in the format:
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id}) Generation: {generation}"

    @Override
    public String toString() {
        return super.toString() + String.format(COMPONENT_TO_STRING, generation);
    }

}
