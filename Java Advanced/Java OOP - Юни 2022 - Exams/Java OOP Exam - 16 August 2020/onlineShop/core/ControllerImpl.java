package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Collection<Computer> computers;
    private Collection<Peripheral> peripherals;
    private Collection<Component> components;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.peripherals = new ArrayList<>();
        this.components = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = getComputer(id);

        if(computer != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }

        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;

            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }

        computers.add(computer);

        return String.format(ADDED_COMPUTER, id);
    }

    private Computer getComputer(int id) {
        return computers.stream().
                filter(s -> s.getId() == id).findFirst().
                orElse(null);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = getComputer(computerId);

        nonExistingComputer(computer);

        if(peripherals.stream().anyMatch(s -> s.getId() == id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }

        computer.addPeripheral(peripheral);
        peripherals.add(peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    private void nonExistingComputer(Computer computer) {
        if(computer == null ){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = getComputer(computerId);

        nonExistingComputer(computer);

        Peripheral peripheral = computer.removePeripheral(peripheralType);
        peripherals.remove(peripheral);

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = getComputer(computerId);

        nonExistingComputer(computer);

        if(components.stream().anyMatch(s -> s.getId() == id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }

        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }

        computer.addComponent(component);
        components.add(component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = getComputer(computerId);

        nonExistingComputer(computer);

        Component component = computer.removeComponent(componentType);
        components.remove(component);

        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = getComputer(id);

        nonExistingComputer(computer);

        computers.remove(computer);

        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = computers.stream().
                filter(s -> s.getPrice() <= budget).
                max(Comparator.comparingDouble(Computer::getOverallPerformance)).
                orElse(null);

        if(computer == null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }

        computers.remove(computer);

        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = getComputer(id);

        nonExistingComputer(computer);

        return computer.toString();
    }
}
