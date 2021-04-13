package net.gamedev.battleship.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Player {
    public static final String ATTR = "player";
    private String name;
    private final Map<String, CellStatus> playerField = new HashMap<>();
    private boolean playerFieldValid = false;
    private final Map<String, CellStatus> opponentView = new HashMap<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, CellStatus> getPlayerField() {
        return playerField;
    }

    public Map<String, CellStatus> getOpponentView() {
        return opponentView;
    }

    public boolean isPlayerFieldValid() {
        return playerFieldValid;
    }

    public void setShips(Set<String> addresses){
        if (playerFieldValid ){
            throw new IllegalStateException("Filed is already set");
        }
        playerField.clear();
        for (var addr : addresses) {
            playerField.put(addr, CellStatus.SHIP);
        }
        playerFieldValid = playerField.size() >= 3;
    }
    public void setPlayerFieldCell(String addr, CellStatus status){
        playerField.put(addr, status);
    }

    public CellStatus getPlayerFieldCell(String addr){
        return playerField.getOrDefault(addr, CellStatus.EMPTY);
    }
    public void setOpponentViewCell(String addr, CellStatus status){
        opponentView.put(addr, status);
    }
    public boolean hasMoreShips(){
        return playerField.containsValue(CellStatus.SHIP);
    }
}
