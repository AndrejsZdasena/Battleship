package net.gamedev.battleship.model;

public class Game {
    public static final String ATTR = "game";
    private Player player1;
    private Player player2;
    private GameStatus status = GameStatus.INCOMPLETE;
    private boolean player1turn = true;
    private GameResult result = GameResult.NOT_FINISHED;

    public Game(Player player1) {
        this.player1 = player1;
    }

    public void start(Player player2){
        if(this.status != GameStatus.INCOMPLETE){
            throw new IllegalStateException("Status" + this.status);
        }
        this.player2 = player2;
        this.status = GameStatus.SETTING_UP;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public GameStatus getStatus() {
        return status;
    }

    public Player opponentOf(Player player) {
        if (player == player1){
            return player2;
        }else{
            return player1;
        }
    }

    public void checkGameStart() {
        if (player1.isPlayerFieldValid() && player2.isPlayerFieldValid()){
            status = GameStatus.IN_PROGRESS;
        }
    }
    public Player getCurrentPlayer(){
        if (player1turn){
            return player1;
        }else {
            return player2;
        }
    }
    private Player getAwaitPlayer(){
        if (player1turn){
            return player2;
        }else {
            return player1;
        }
    }
    public void fire(String addr){
        var cur = getCurrentPlayer();
        var await = getAwaitPlayer();
        var attackCellStatus = await.getPlayerFieldCell(addr);

        switch (attackCellStatus){
            case SHIP:
                cur.setOpponentViewCell(addr, CellStatus.HIT);
                await.setPlayerFieldCell(addr, CellStatus.HIT);
                if (!await.hasMoreShips()){
                    status = GameStatus.FINISHED;
                    if(player1turn){
                        this.result = GameResult.PLAYER1_WON;
                    }else{
                        this.result = GameResult.PLAYER2_WON;
                    }
                }
                break;
            case EMPTY:
                cur.setOpponentViewCell(addr, CellStatus.MISS);
                await.setPlayerFieldCell(addr, CellStatus.MISS);
                player1turn = !player1turn;
                break;
            case HIT:
            case MISS:
                player1turn = !player1turn;
                break;
        }
    }
    public boolean isWinner(Player player){
        if((result == GameResult.PLAYER1_WON || result == GameResult.PLAYER2_SURRENDERED) && player == player1) {
            return true;
        }else if((result == GameResult.PLAYER2_WON || result == GameResult.PLAYER1_SURRENDERED) && player == player2){
            return true;
        }
        return false;
    }

     void surrender(Player player) {
        status = GameStatus.FINISHED;
        result = player == player1 ? GameResult.PLAYER1_SURRENDERED : GameResult.PLAYER2_SURRENDERED;
    }
}
