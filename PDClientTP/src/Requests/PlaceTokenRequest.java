/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

import java.io.Serializable;

/**
 *
 * @author Nawie
 */
public class PlaceTokenRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final int row;
    private final int col;
    private final String name;

    public PlaceTokenRequest(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
    }

    public String getUsername() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
