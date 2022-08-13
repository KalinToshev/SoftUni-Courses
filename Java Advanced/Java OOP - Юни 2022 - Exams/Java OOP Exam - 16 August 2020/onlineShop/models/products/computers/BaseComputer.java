package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    //derived class from BaseProduct and a base class for any computers

    //Child Classes
    //There are several specific types of computers, where the overall performance has a different value:
    //•	DesktopComputer – overall performance is 15
    //•	Laptop – overall performance is 10
    //Child classes should not receive an overall performance as a parameter from the constructor.

    //Data
    //•	components – List
    //•	peripherals – List

    private List<Component> components;
    private List<Peripheral> peripherals;

    //Constructor
    //A product should take the following values upon initialization:
    //(int id, String manufacturer, String model, double price, double overallPerformance)

    public BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return peripherals;
    }

    //If the components collection contains a component with the same component type,
    //throw an IllegalArgumentException with the message
    //"Component {component type} already exists in {computer type} with Id {id}."
    //Otherwise, add the component to the components collection.

    @Override
    public void addComponent(Component component) {
        if(getComponent(component) != null){
            throw new IllegalArgumentException(String.format(EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), getClass().getSimpleName(), getId()));
        }

        components.add(component);
    }

    private Component getComponent(Component component) {
        return components.stream()
                .filter(s -> s.getClass().getSimpleName().equals(component.getClass().getSimpleName()))
                .findFirst()
                .orElse(null);
    }

    //If the components collection is empty or does not have a component of that type,
    //throw an IllegalArgumentException with the message
    //"Component {component type} does not exist in {computer type} with Id {id}."
    //Otherwise, remove the component of that type and return it.

    @Override
    public Component removeComponent(String componentType) {
        Component component = components.stream()
                .filter(s -> s.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);

        if(component == null) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                    componentType,
                    getClass().getSimpleName(),
                    getId()));
        }

        components.remove(component);

        return component;
    }

    //If the peripherals collection contains a peripheral with the same peripheral type,
    //throw an IllegalArgumentException with the message
    //"Peripheral {peripheral type} already exists in {computer type} with Id {id}."
    //Otherwise, add the peripheral to the peripherals collection.

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if(peripherals.stream()
                .filter(s -> s.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))
                .findFirst()
                .orElse(null) != null) {

            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(),
                    getClass().getSimpleName(),
                    getId()));
        }

        peripherals.add(peripheral);
    }

    //If the peripherals collection is empty or does not have a peripheral of that type,
    //throw an IllegalArgumentException with the message
    //"Peripheral {peripheral type} does not exist in {computer type} with Id {id}."
    //Otherwise, remove the peripheral of that type and return it.

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = peripherals.stream()
                .filter(s -> s.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);

        if(peripheral == null){
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL,
                    peripheralType,
                    getClass().getSimpleName(),
                    getId()));
        }

        peripherals.remove(peripheral);

        return peripheral;
    }

    //Override the base functionality (if the components collection is empty,
    //it should return only the computer overall performance,
    //otherwise return the sum of the computer overall performance and the average overall performance
    //from all components)

    @Override
    public double getOverallPerformance() {
        double componentsOverallPerformance = 0;

        if(components.size() > 0) {
            componentsOverallPerformance = components.stream().mapToDouble(Product::getOverallPerformance).average().orElse(0.00);
        }

        return super.getOverallPerformance() + componentsOverallPerformance;
    }

    //Override the base functionality (The price is equal to the total sum of the
    //computer price with the sum of all component prices and the sum of all peripheral prices)

    @Override
    public double getPrice() {
        double componentsPrice = components.stream().mapToDouble(Component::getPrice).sum();
        double peripheralPrice = peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        return super.getPrice() + componentsPrice + peripheralPrice;
    }

    //Override toString() method in the format:
    //"Overall Performance: {overall performance}. Price: {price} - {product type}: {manufacturer} {model} (Id: {id})"
    //" Components ({components count}):"
    //"  {component one}"
    //"  {component two}"
    //"  {component n}"
    //" Peripherals ({peripherals count}); Average Overall Performance ({average overall performance peripherals}):"
    //"  {peripheral one}"
    //"  {peripheral two}"
    //"  {peripheral n}"
    //Note: Be careful, some of the rows have one or two whitespaces at the beginning of the sentences!

    @Override
    public String toString() {
        double averageOverallPerformancePeripherals = peripherals.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average()
                .orElse(0.00);

        return String.format(PRODUCT_TO_STRING,
                getOverallPerformance(), getPrice(), getClass().getSimpleName(), getManufacturer(), getModel(), getId()) + System.lineSeparator() +
                " " + String.format(COMPUTER_COMPONENTS_TO_STRING, components.size()) + System.lineSeparator() +
                ((components.size() == 0) ? "" :
                        "  " + components.stream().map(Component::toString).collect(Collectors.joining(System.lineSeparator() + "  ")) + System.lineSeparator()) +
                " " + String.format(COMPUTER_PERIPHERALS_TO_STRING, peripherals.size(), averageOverallPerformancePeripherals) +
                ((peripherals.size() == 0) ? "" : System.lineSeparator() +
                        "  " + peripherals.stream().map(Peripheral::toString).collect(Collectors.joining(System.lineSeparator() + "  ")));
    }

}
