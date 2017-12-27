/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;

public class GetNumPlayersResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final int numPlayers;

    public GetNumPlayersResponse(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getNumPlayers() {
        return numPlayers;
    }
}
