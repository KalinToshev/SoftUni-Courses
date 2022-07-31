package fairyShop.models;

public class ShopImpl implements Shop {
    @Override
    public void craft(Present present, Helper helper) {
        while (present.isDone() || helper.canWork()) {
            for (Instrument instrument : helper.getInstruments()) {
                while (!instrument.isBroken()) {
                    instrument.use();
                    present.getCrafted();
                    helper.work();
                    if (present.isDone()) {
                        break;
                    }
                }
                if (present.isDone()) {
                    break;
                }
            }
            if (present.isDone()) {
                break;
            }
        }
    }
}
