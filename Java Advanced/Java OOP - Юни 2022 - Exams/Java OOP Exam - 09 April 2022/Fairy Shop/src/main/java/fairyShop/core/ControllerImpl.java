package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;

    //Empty constructor
    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        //Create helper or throw exception
        Helper helper;
        switch (type) {
            case "Happy":
                helper = new Happy(helperName);
                break;
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }

        //Add helper to the repository
        helperRepository.add(helper);

        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        //Try to find the helper or thor exception
        Helper helper = helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        //Create the instrument
        Instrument instrument = new InstrumentImpl(power);
        //Add the instrument to the helper's collection
        helper.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helper.getName());
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        //Create present
        Present present = new PresentImpl(presentName, energyRequired);

        //Add the present to the corresponded repository
        presentRepository.add(present);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        //Create a Shop to craft the present
        Shop shop = new ShopImpl();

        //Create a list of suitable helpers (if there is anyone suitable)
        List<Helper> suitableHelpers = new ArrayList<>();

        //Initialize present object
        Present present1 = null;

        //Fill the list of suitable helpers
        for (Helper model : this.helperRepository.getModels()) {
            if (model.getEnergy() > 50) {
                suitableHelpers.add(model);
            }
        }

        //Initialize variable to hold the count of instruments
        int instrumentsCount = 0;

        //If there is no suitable helpers - throws exception
        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        //Iter through the present models and find the one we have to craft
        //based on what is the given present name
        for (Present present : this.presentRepository.getModels()) {
            if (present.getName().equals(presentName)) {
                present1 = present;
                //Go through every suitable helper and make then craft
                //the present
                for (Helper suitableHelper : suitableHelpers) {
                    shop.craft(present, suitableHelper);
                }
                //Go through every suitable helper and through every instrument
                //he has, and if the instrument is broken - the instrument count variable
                //is increased with 1
                for (Helper suitableHelper : suitableHelpers) {
                    for (Instrument instrument : suitableHelper.getInstruments()) {
                        if (instrument.isBroken()) {
                            instrumentsCount++;
                        }
                    }
                }
            }
        }

        //Output based on the fact if the present is done or not
        assert present1 != null;
        if (present1.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, instrumentsCount);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, instrumentsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        //Variable to count done presents
        int countPresents = 0;
        //Variable to count instruments, who is not broken
        int instrumentCount = 0;
        //Go through every present and check if the current present is
        //done, then the presents count is increased with 1
        for (Present model : this.presentRepository.getModels()) {
            if(model.isDone()){
                countPresents++;
            }
        }

        sb.append(String.format("%d presents are done!", countPresents)).
                append(System.lineSeparator()).
                append("Helpers info:").
                append(System.lineSeparator());

        for (Helper helper : this.helperRepository.getModels()) {
            sb.append(String.format("Name: %s", helper.getName())).
                    append(System.lineSeparator()).
                    append(String.format("Energy: %d", helper.getEnergy())).
                    append(System.lineSeparator());
            //For every helper count the non-broken instruments he has
            for (Instrument instrument : helper.getInstruments()) {
                if (!instrument.isBroken()) {
                    instrumentCount++;
                }
            }
            sb.append(String.format("Instruments: %d not broken left", instrumentCount)).
                    append(System.lineSeparator());
            //Reset the non-broken instruments counter
            instrumentCount = 0;
        }

        return sb.toString().trim();
    }
}
