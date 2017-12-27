/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;

public class GetIsOverResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final boolean isOver;

    public GetIsOverResponse(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isOver() {
        return isOver;
    }
}
