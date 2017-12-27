/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests.ServerGameResponse;

import java.io.Serializable;

public class GetGridToStringResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String StringGrid;

    public GetGridToStringResponse(String StringGrid) {
        this.StringGrid = StringGrid;
    }

    public String getStringGrid() {
        return StringGrid;
    }
}
