package net.gamedev.battleship.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class GameManager {
    public static final String ATTR = "gameManager";
    private BlockingQueue <Game> pendingQueue = new LinkedBlockingQueue<>();

    public  Game join (Player player){
        var pending = pendingQueue.poll();
        Game result;
        if(pending == null){
            pending = new Game(player);
            result = pending;
            pendingQueue.add(pending);
        }else{
            result = pending;
            result.start(player);
        }
        return result;
    }

    public synchronized void surrender(Game game, Player player) {
        if (game.getStatus() == GameStatus.FINISHED){
            return;
        }
        game.surrender(player);
    }
}
