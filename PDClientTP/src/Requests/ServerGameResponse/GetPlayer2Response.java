/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;
import three_in_row.logic.Player;

public class GetPlayer2Response implements Serializable{
    private static final long serialVersionUID = 1L;
    private final Player player2;

    public GetPlayer2Response(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer2() {
        return player2;
    }
}
