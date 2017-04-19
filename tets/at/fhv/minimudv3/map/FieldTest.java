package at.fhv.minimudv3.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Class for the Field Class
 *
 * Created by Oliver H on 19.04.2017.
 */
class FieldTest {


    private Field _f0;
    private Field _f1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        _f0 = new Field("Test Desc0");
        _f1 = new Field("Test Desc1");

    }

    @org.junit.jupiter.api.Test
    void enter() {
        _f0.addFunction(new IFieldFunction() {
            @Override
            public Field enter(Player player) {
                return _f1;
            }
        });

        assertTrue(_f0.enter(new Player()) == _f1);

        _f0.addFunction(new IFieldFunction() {
            @Override
            public Field enter(Player player) {
                return _f0;
            }
        });

        assertTrue(_f0.enter(new Player()) == _f0);
    }

    @org.junit.jupiter.api.Test
    void description() {
        assertTrue("Test Desc0" == _f0.description());
        assertTrue("Test Desc1" == _f1.description());
    }

    @org.junit.jupiter.api.Test
    void possibleDirections() {
        _f1.bindField(Directions .NORTH, _f0);
        assertTrue(_f0.possibleDirections().size() == 1);
        assertTrue(_f1.possibleDirections().size() == 1);

        assertTrue(_f0.possibleDirections().containsKey(Directions.SOUTH));
        assertTrue(_f1.possibleDirections().containsKey(Directions.NORTH));

        assertTrue(_f0.possibleDirections().get(Directions.SOUTH) == _f1);
        assertTrue(_f1.possibleDirections().get(Directions.NORTH) == _f0);

        _f0.bindField(Directions .WEST, _f1);
        assertTrue(_f0.possibleDirections().size() == 2);
        assertTrue(_f1.possibleDirections().size() == 2);

        assertTrue(_f0.possibleDirections().containsKey(Directions.WEST));
        assertTrue(_f1.possibleDirections().containsKey(Directions.EAST));

        assertTrue(_f0.possibleDirections().get(Directions.WEST) == _f1);
        assertTrue(_f1.possibleDirections().get(Directions.EAST) == _f0);
    }

    @Test
    void getID() {
        assertTrue(_f0.getID() == 0);
        assertTrue(_f1.getID() == 1);
    }

}