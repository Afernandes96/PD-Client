/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;
import threeinrow.logic.Player;

/**
 *
 * @author henri
 */
public class GetNotCurrentPlayerResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final Player notCurPlayer;

    public GetNotCurrentPlayerResponse(Player notCurPlayer) {
        this.notCurPlayer = notCurPlayer;
    }

    public Player getNotCurPlayer() {
        return notCurPlayer;
    }
}
