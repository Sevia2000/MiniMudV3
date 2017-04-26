package at.fhv.minimudv3.map;

import at.fhv.minimudv3.game.Player;
import at.fhv.minimudv3.items.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Describes a single supply field
 *
 * Created by Oliver Heil on 26.04.2017.
 */
public class SingleSupplyField extends Field implements IExecutable,IAccessible{
    private static final String _DESCRIPSHORT = "Oo here is a ";
    private static final String _DESCRIPLONG = "There is a beautifull ";
    private static final String _SUCESSDESCR = "You got ";
    private static final String _ALREADYGOT = "There is nothing left for you...";
    private static final String _FAILDESCR = "You cant do this here...";

    private Item _supplyOf;
    private List<Player> _playerEx;

    public SingleSupplyField(Item aItem) {
        this(aItem, _DESCRIPSHORT + aItem.getShortDescription(),
                _DESCRIPLONG + aItem.getShortDescription() );
    }

    public SingleSupplyField(Item aItem, String shortDescription, String longDescription) {
        super(shortDescription, longDescription);
        _supplyOf = aItem;
        _playerEx = new LinkedList<>();
    }

    private void giveItemTo(Player player) {
        addToInventorry(player);
        _playerEx.add(player);
    }

    private void addToInventorry(Player player) {
        player.addToInventory(Item.clone(_supplyOf));
    }

    private boolean gotAlreadyItem(Player enterPlayer) {
        for (Player player : _playerEx) {
            if (player == enterPlayer) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void execude(Player player, ActionFunctions actionFunctions) {
        if (actionFunctions == ActionFunctions.PICKUP) {
            if (!gotAlreadyItem(player)) {
                giveItemTo(player);
                player.outStream(_SUCESSDESCR + _supplyOf.getShortDescription());
            } else {
                player.outStream(_ALREADYGOT);
            }
        } else {
            player.outStream(_FAILDESCR);
        }
    }

    @Override
    public Field enter(Player player) {
        return this;
    }
}
