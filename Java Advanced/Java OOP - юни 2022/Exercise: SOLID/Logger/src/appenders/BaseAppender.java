package appenders;

import layouts.Layout;

public abstract class BaseAppender implements Appender {

    private Layout layout;
    protected int counter;

    protected BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

    @Override
    public int getMessagesCount() {
        return counter;
    }

}
