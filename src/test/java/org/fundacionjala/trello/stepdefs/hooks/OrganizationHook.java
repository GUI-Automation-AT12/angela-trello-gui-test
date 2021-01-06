package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.api.OrganizationHookHelper;
import org.fundacionjala.trello.trello.config.EnvironmentApi;
import org.fundacionjala.trello.trello.utils.Authentication;
import org.json.JSONObject;

public class OrganizationHook {
    private Context context;
    private OrganizationHookHelper organizationHookHelper;

    /**
     * Initializes an instance of Context class.
     *
     * @param sharedContext
     */
    public OrganizationHook(final Context sharedContext) {
        this.context = sharedContext;
        organizationHookHelper = new OrganizationHookHelper();
    }

    /**
     * Creates thee board before execute the step with the createBoard tag.
     */
    @Before(value = "@CreateOrganization", order = 0)
    public void createOrganizationApi() {
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi() + "/organizations/";
        JSONObject json = new JSONObject();
        json.put("displayName", "teamTestName");
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        Response response = RequestManager.post(endpoint, json.toString());
        context.saveDataCollection("organization", response.jsonPath().getMap(""));
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @After(value = "@DeleteOrganization", order = 1)
    public void deleteOrganizationApi() {
        String idOrganization = context.getDataCollection("organization").get("id");
        organizationHookHelper.deleteOrganization(idOrganization);
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @After(value = "@DeleteTeam", order = 1)
    public void deleteOrganization() {
        String url = context.getValueData("organization");
        String nameTeam = url.substring(url.lastIndexOf("/") + 1);
        organizationHookHelper.deleteOrganization(nameTeam);
    }
}
