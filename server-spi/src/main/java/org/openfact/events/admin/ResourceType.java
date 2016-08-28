package org.openfact.events.admin;

/**
 * Represents Keycloak resource types for which {@link AdminEvent AdminEvent's} can be triggered.
 */
public enum ResourceType {

    /**
     *
     */
    REALM

    /**
     *
     */
    , REALM_ROLE

    /**
     *
     */
    , REALM_ROLE_MAPPING

    /**
     *
     */
    , REALM_SCOPE_MAPPING

    /**
     *
     */
    , AUTH_FLOW

    /**
     *
     */
    , AUTH_EXECUTION_FLOW

    /**
     *
     */
    , AUTH_EXECUTION

    /**
     *
     */
    , AUTHENTICATOR_CONFIG

    /**
     *
     */
    , REQUIRED_ACTION

    /**
     *
     */
    , IDENTITY_PROVIDER

    /**
     *
     */
    , IDENTITY_PROVIDER_MAPPER

    /**
     *
     */
    , PROTOCOL_MAPPER

    /**
     *
     */
    , USER

    /**
     *
     */
    , USER_LOGIN_FAILURE

    /**
     *
     */
    , USER_SESSION

    /**
     *
     */
    , USER_FEDERATION_PROVIDER

    /**
     *
     */
    , USER_FEDERATION_MAPPER

    /**
     *
     */
    , GROUP

    /**
     *
     */
    , GROUP_MEMBERSHIP

    /**
     *
     */
    , CLIENT

    /**
     *
     */
    , CLIENT_INITIAL_ACCESS_MODEL

    /**
     *
     */
    , CLIENT_REGISTRATION_TRUSTED_HOST_MODEL

    /**
     *
     */
    , CLIENT_ROLE

    /**
     *
     */
    , CLIENT_ROLE_MAPPING

    /**
     *
     */
    , CLIENT_TEMPLATE

    /**
     *
     */
    , CLIENT_SCOPE_MAPPING

    /**
     *
     */
    , CLUSTER_NODE;
}
