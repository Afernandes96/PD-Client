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
public class ReturnTokenRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String username;
    private final int row;
    private final int col;

    public ReturnTokenRequest(String username, int row, int col) {
        this.username = username;
        this.row = row;
        this.col = col;
    }

    public String getUsername() {
        return username;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
