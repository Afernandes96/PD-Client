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
public class GetGrelhaToStringResponse implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String grelhaToString;

    public GetGrelhaToStringResponse(String grelhaToString) {
        this.grelhaToString = grelhaToString;
    }

    public String getGrelhaToString() {
        return grelhaToString;
    }
}
