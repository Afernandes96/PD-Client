/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.messages.clientmngresponses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author henri
 */
public class GetMessagesResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> messages;

    public GetMessagesResponse(List<String> messages) {
        this.messages = new ArrayList<>(messages);
    }

    public List<String> getMessages() {
        return messages;
    }
}
