/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;
import threeinrow.logic.Token;

/**
 *
 * @author henri
 */
public class GetTokenResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final Token token;

    public GetTokenResponse(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
