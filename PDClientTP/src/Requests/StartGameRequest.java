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
public class StartGameRequest implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String username;

    public StartGameRequest(String username) {
        this.username = username;
    }
}
