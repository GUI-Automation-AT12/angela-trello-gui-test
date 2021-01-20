package org.fundacionjala.trello.trello.api;

import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.trello.config.EnvironmentApi;

public class OrganizationHelper {
    /**
     * Constructor.
     */
    public OrganizationHelper() { }

    /**
     * Delete an organization.
     * @param id of organization
     */
    public void deleteOrganization(final String id) {
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/organizations/").concat(id);
        RequestManager.delete(endpoint);
    }
}
