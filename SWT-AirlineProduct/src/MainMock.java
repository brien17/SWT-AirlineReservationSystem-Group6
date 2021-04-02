public class MainMock extends Main {

    private boolean visible;

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
    }
}
