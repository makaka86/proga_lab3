import actions.*;
import enums.*;
import features.ThinkFeature;
import person.Alice;
import world.items.Key;
import world.place.AbstractDoor;
import world.place.Dungeon;
import world.place.place.part.DoorWithLock;
import world.place.place.part.Lamp;
import world.place.place.part.Table;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        Alice alice = new Alice();
        Dungeon dungeon = new Dungeon("подземелье", alice);
        dungeon.applyFeature(Length.LONG);
        dungeon.applyFeature(Height.LOW);
        for (int j = 0; j < 10; j++) {
            DoorWithLock door1 = new DoorWithLock("дверь " + j, "ключ " + j);
            dungeon.addPartPlace(door1);
        }

        for (int j = 0; j < 10; j++) {
            Lamp lamp1 = new Lamp("лампа" + j);
            dungeon.addPartPlace(lamp1);
        }

        DoorWithLock door2 = new DoorWithLock("дверь за шторкой", "ключик");
        dungeon.addPartPlace(door2);
        Key key = door2.getKey();

        key.applyFeature(Material.GOLD);
        key.applyFeature(Size.TINY);

        Table table = new Table("Стол");
        table.transferItem(key);
        table.applyFeature(Material.GLASS);
        dungeon.addPartPlace(table);

        ActionSequenceHelper scenario = new ActionSequenceHelper(alice);
        List<AbstractDoor> placePartByType = dungeon.getPlacePartByType("door");
        for (int i = 0; i < placePartByType.size(); i++) {
            scenario.addNextAction(new MoveAction(placePartByType.get(i)));
            scenario.addNextAction(new InteractAction(placePartByType.get(i)));

        }
        scenario.addNextAction(new EmoteAction(new ThinkFeature("удостоверилась")));
        scenario.addNextAction(new EmoteAction(Emote.SAD));


        scenario.addNextAction(new RandomAction(new MoveAction(table), new MoveAction("зад"), new MoveAction("перед")));

        scenario.addNextAction(new EmoteAction(Emote.JOYFUL));
        scenario.addNextAction(new PickUpAction(table, "ключик"));

        for (int i = 0; i < placePartByType.size(); i++) {
            scenario.addNextAction(new MoveAction(placePartByType.get(i)));
            scenario.addNextAction(new InteractWithItem(placePartByType.get(i), "ключик"));
        }
        scenario.play();

    }
}