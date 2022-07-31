package fairyShop.models;

import fairyShop.common.ExceptionMessages;

public class InstrumentImpl implements Instrument {
    private static final int POWER_DECREASER = 10;

    //The power of an instrument.
    private int power;

    public InstrumentImpl(int power) {
        this.setPower(power);
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.power -= 10;
        if(this.power < 0){
            this.power = 0;
        }
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
