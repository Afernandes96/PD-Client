/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

import java.io.Serializable;

/**
 *  1- GetCurrentPlayerNameResponse
 *  2- GetCurrentPlayerResponse
 *  3- GetGrelh3aToStringResponse
 *  4- GetGridToStringResponse
 *  5- GetHasWonResponse
 *  6- GetIsOverResponse
 *  7- GetNotCurrentPlayerResponse
 *  8- GetNumCurrentPlayerResponse
 *  9- GetNumPlayersResponse
 *  10- GetPlayer1Response
 *  11- GetPlayer2Response
 *  12- GetStateResponse
 *  13- GetTokenResponse
 * @author Nawie
 */
public class GetGameRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String username;
    private final int requestId;

    public GetGameRequest(String username, int requestId) {
        this.username = username;
        this.requestId = requestId;
    }

    public String getUsername() {
        return username;
    }

    public int getRequestId() {
        return requestId;
    } 
}
