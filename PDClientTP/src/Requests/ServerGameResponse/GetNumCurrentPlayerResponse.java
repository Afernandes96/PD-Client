/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;

/**
 *
 * @author henri
 */
public class GetNumCurrentPlayerResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final int numCurPlayer;

    public GetNumCurrentPlayerResponse(int numCurPlayer) {
        this.numCurPlayer = numCurPlayer;
    }

    public int getNumCurPlayer() {
        return numCurPlayer;
    }
}
