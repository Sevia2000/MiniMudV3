package at.fhv.minimudv3.map;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 *  Describes a Field on the Map. You can get his description, bind it, enter it and get his Neighbors.
 *
 * Created by Oliver H on 18.04.2017.
 */
public class Field implements IField{
    private static int nextID;

    private String _description;
    private int _iD;
    private IFieldFunction _function;
    private Map<Directions, Field> _bindings;

    /**
     * Creates a new field with the given description.
     *
     * @param description - The description for this Field
     */
    public Field(String description) {
        _description = description;
        _bindings = new EnumMap<>(Directions .class);
        _iD = nextID++;
    }

    /**
     * Enter this field
     *
     * @param player - The direction where you come from.
     * @return - The new position or null if you not allowed to enter
     */
    @Override
    public Field enter(Player player) {
        return _function.enter(player);
    }

    /**
     * Return the description of this Field in an formatted String
     *
     * @return - The description
     */
    @Override
    public String description() {
        return _description;
    }

    /**
     * Return the possible direction of this Field.
     *
     * @return - All directions of this field
     */
    @Override
    public Map<Directions , Field> possibleDirections() {
        return Collections.unmodifiableMap(_bindings);
    }

    /**
     * Implements the Function of this Field
     *
     * @param function - The new Function
     */
    @Override
    public void addFunction(IFieldFunction function) {
        _function = function;
    }

    /**
     * Bind this Field with a second one. Its only allowed to have one bind for each direction.
     * The entry in the field you want to bind its added automatically.
     *
     * @param direction - The direction for the binding
     * @param field - The field that you want to bind.
     */
    public void bindField(Directions  direction, Field field) {
        _bindings.put(direction,field);
        field._bindings.put(Directions.getReverse(direction), this);
    }

    /**
     * Return the given ID for this field. This ID its automatic generated.
     *
     * @return - The ID for this field;
     */
    public int getID() {
        return _iD;
    }
}
