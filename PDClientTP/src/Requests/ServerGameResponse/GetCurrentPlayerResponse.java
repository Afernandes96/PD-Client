/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;
import three_in_row.logic.Player;

public class GetCurrentPlayerResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final Player CurrentPlayer;

    public GetCurrentPlayerResponse(Player CurrentPlayer) {
        this.CurrentPlayer = CurrentPlayer;
    }

    public Player getCurrentPlayer() {
        return CurrentPlayer;
    }
}
