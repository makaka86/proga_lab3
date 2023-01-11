package world.items;

import java.util.Objects;
import java.util.UUID;

public class Key extends Item {

    private final String keyCode = UUID.randomUUID().toString();
    public Key(String objectName) {
        super(objectName);
    }

    @Override
    public String getType() {
        return "key";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Key key = (Key) o;
        return Objects.equals(keyCode, key.keyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), keyCode);
    }
}
