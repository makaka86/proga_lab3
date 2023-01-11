package person;

import world.MyObject;

public class Alice extends AbstractPerson {
    public Alice() {
        super("Алиса");
    }

    @Override
    public void moveTo(String locName) {
        System.out.println(this.toString() + " пошла в " + locName);
    }

    @Override
    public void moveTo(MyObject myObject) {
        System.out.println(this.toString() + " подошла к " + myObject.toString());
    }
}
