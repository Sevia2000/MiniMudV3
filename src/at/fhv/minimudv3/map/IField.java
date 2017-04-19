package at.fhv.minimudv3.map;


import java.util.Map;

/**
 * Created by Oliver H on 19.04.2017.
 */
public interface IField {

    Field enter(Player player);

    String description();

    Map<Directions  ,Field> possibleDirections();

    void addFunction(IFieldFunction function);
}
