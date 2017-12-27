/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;
import three_in_row.logic.Player;

public class GetPlayer1Response implements Serializable{
    private static final long serialVersionUID = 1L;
    private final Player player1;

    public GetPlayer1Response(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer1() {
        return player1;
    }
}
