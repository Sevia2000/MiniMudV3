package at.fhv.minimudv3;

import at.fhv.minimudv3.game.Directions;
import at.fhv.minimudv3.game.Player;
import at.fhv.minimudv3.items.Key;
import at.fhv.minimudv3.map.Field;
import at.fhv.minimudv3.map.SingleSupplyField;

/**
 * Created by Oliver H on 18.04.2017.
 */
public class RunMe {
    public static void main(String[] args) {
        System.out.println(new Field("", "").toString());


        Player player = new Player("hi", null);
        player.setPlayerOutstream((System.out::println));
        player.outStream("Hallo wie geht es");


        Field[] fields = new Field[20];
        fields[0] = new SingleSupplyField(new Key(122,"sDK","lDK"),
                "sDF","lDF");
        fields[1] = new SingleSupplyField(new Key(122,"sDK","lDK"),
                "sDF","lDF");

        fields[0].addBinding(Directions.NORTH, fields[1]);

        player = new Player("Hi", fields[0]);
        player.move(Directions.NORTH);
    }


}
