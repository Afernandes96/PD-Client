/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;

public class GetCurrentPlayerNameResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String fellowName;

    public GetCurrentPlayerNameResponse(String fellowName) {
        this.fellowName = fellowName;
    }

    public String getFellowName() {
        return fellowName;
    }
}
