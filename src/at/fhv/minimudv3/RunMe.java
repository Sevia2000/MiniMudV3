package at.fhv.minimudv3;

import at.fhv.minimudv3.game.Player;
import at.fhv.minimudv3.map.Field;

/**
 * Created by Oliver H on 18.04.2017.
 */
public class RunMe {
    public static void main(String[] args) {
        System.out.println(new Field("", "").toString());


        Player player = new Player("hi", null);
        player.setPlayerOutstream((System.out::println));

    }


}
