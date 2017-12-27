package managerRequests;

import java.io.Serializable;

/**
 * requestId 
 * 1 - GetAnyMakeGroupRequestResponse
 * 2 - GetAuthenticatedUsersResponse
 * 3 - GetGameServerAddrResponse
 * 4 - GetHasOpponentResponse
 * 5 - GetHistoryGameResponse
 * 6 - GetIsLoggedInResponse
 * 7 - GetMakeGroupAnswerRequestResponse
 * 8 - GetMessagesResponse
 * 9 - GetNotFinishedGamesResponse
 */

public class ManagerRequests implements Serializable{
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int requestId;

    public ManagerRequests(String name, int requestId) {
        this.name = name;
        this.requestId = requestId;
    }

    public String getUsername() {
        return name;
    }

    public int getRequestId() {
        return requestId;
    } 
}
