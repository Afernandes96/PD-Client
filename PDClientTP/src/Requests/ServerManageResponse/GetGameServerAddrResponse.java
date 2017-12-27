/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.clientmngresponses;

import java.io.Serializable;

/**
 *
 * @author henri
 */
public class GetGameServerAddrResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String address;
    private final int port;

    public GetGameServerAddrResponse(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }
    
    
}
