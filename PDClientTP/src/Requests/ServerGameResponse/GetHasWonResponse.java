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
public class GetHasWonResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final boolean hasWon;

    public GetHasWonResponse(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean hasWon() {
        return hasWon;
    } 
}
