package interfaces;

import world.MyObject;

public interface IMove {
    void moveTo(String locName);
    void moveTo(MyObject myObject);
}
