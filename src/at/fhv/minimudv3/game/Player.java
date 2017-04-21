package at.fhv.minimudv3.game;

import at.fhv.minimudv3.items.Item;
import at.fhv.minimudv3.map.Field;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Oliver H on 21.04.2017.
 */
public class Player {
    private static final int _maxWeight = 200;
    private static final int _maxHealth = 100;

    private String _name;
    private int _health;
    private Field _position;
    private List<Item> _carry;
    private IPlayerOutstream _playerOutstream;

    public Player(String name, Field position) {
        _name = name;
        _health = _maxHealth;
        _position = position;
        _carry = new LinkedList<>();
    }

    //Getter /Setter
    public String getName() {
        return _name;
    }

    // Inventory Action
    public List<Item> getAllItemsfromType(Class Item) {
        List<Item> returnList = new LinkedList<>();
        for (Item item : _carry) {
            if (Item.isInstance(item)) {
                returnList.add(item);
            }
        }
        return Collections.unmodifiableList(returnList);
    }

    public void deleteFromInventory(Item item) {
        _carry.remove(item);
    }

    public void addToInventorry(Item supplyOf) {
        int weight = supplyOf.getWeight();
        for (Item item : _carry) {
            weight += item.getWeight();
        }
        if (weight <= _maxWeight) {
            _carry.add(supplyOf);
        }
    }

    // Player Stats
    public void healthIncrease(int of) {
        _health += of;
        if (_health > _maxHealth) {
            _health = _maxHealth;
        }
    }

    public void healthReduction(int of) {
        _health -= of;
    }

    // Player Possibility's
    public void move(Directions direction) {
        _position = _position.getPossibleWalkDirections().get(direction).enter(this);
    }

    public Field currPosition() {
        return _position;
    }

    public void setPlayerOutstream(IPlayerOutstream playerOutstream) {
        _playerOutstream = playerOutstream;
    }

    public void outStream(String s) {
        if (_playerOutstream != null) {
            _playerOutstream.print(s);
        } else {
            System.out.println(s);
        }
    }
}
