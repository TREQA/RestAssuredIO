package com.RestAssured.framework;

/**
 * Created by razvan.rosescu on 7/3/2017.
 */
public class TCapiData extends InputData{

    // ----- Plans & Network Usage API

    /* ----- Look in DEG_SERVICE_STATUS table to get DEG_STATUS
        SQL queries:
        select * from DEG_SERVICE_STATUS order by DATE_UPDATED desc;
        select * from DEG_TC_UUID order by DATE_CREATED desc;
        select DEG_SERVICE_STATUS.msisdn, DEG_SERVICE_STATUS.SUBSCRIBER_ID, DEG_SERVICE_STATUS.DEG_STATUS, DEG_TC_UUID.uuid, DEG_TC_UUID.SUBSCRIBER
        from DEG_SERVICE_STATUS JOIN DEG_TC_UUID ON DEG_SERVICE_STATUS.MSISDN = DEG_TC_UUID.MSISDN ORDER BY DEG_SERVICE_STATUS.MSISDN;
     */

    public static String userTc = "network-tc-server";
    public static String passwordTc = "network-server-tc-secret";

    public static String msisdnStatusTcNotAccepted = "0746078958";
    public static String msisdnStatusEnabled = "0754056695";
    public static String msisdnStatusEnabledPrePrepay = "0741762754";
    public static String msisdnStatusDisabled = "0744246567";
    public static String msisdnNotExists = "0741orangeTest";
    public static String msisdnNotInTable = "";
    public static String msisdnWithExpiredUuid = "";



    // ----- Get new iml ----
    public static String uuid = "0745164437_9614511532000";
    public static String uuidDisabled = "0745164437_9614511532000";
    public static String uuidEnabled = "0745164437_9614511532000";
    public static String uuidNotAccepted = "";

    public static String UuidEnabledSubscriber = "";
    public static String UuidDisabledSubscriber = "";
    public static String UuidNotAcceptedSubscriber = "";

}
