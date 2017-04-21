package at.fhv.minimudv3.map;

import at.fhv.minimudv3.game.Player;
import at.fhv.minimudv3.map.Field;
import at.fhv.minimudv3.map.IAccessible;

/**
 * A TestClass for the Interface IAccessible and some funktions in Field
 *
 * Created by Oliver H on 21.04.2017.
 */
public class TestIAccessibleField extends Field implements IAccessible {

    public TestIAccessibleField() {
        super("","");
    }

    @Override
    public Field enter(Player player) {
        throw new IllegalArgumentException("Test");
    }
}
