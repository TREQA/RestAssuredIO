package com.RestAssured.framework;

/**
 * Created by razvan.rosescu on 5/15/2017.
 */

//import com.RestAssured.framework.TCapiData;

public class InputData {


    //01 ----- Test environments -----
    public static String DevEnv = "https://www-dev.orange.ro/myaccount2";
    public static String UatEnv = "https://www-dev.orange.ro/myaccount";


    //02 ----- Authorization tokens by user
        // user: testare2
    public static String authToken = "IAAAANsOSnF-oRV_V1fghpdOYvUcpRdMfXRx2em-6IiXmW0TsQAAAAEqRCoJZaAtkaFFDYP1X4WpUipq7WNh6uPOLCR-fHo7nM1fZUBmuIHPsrGDqLPszcLZH8DDAM15Mz4pXJFYpHpmFPpmxCqhlhWJxbN_fsndGfiMgy8-Cs7pcL462ZrYxq1_eVXtS5lNRdx_-IEqd2NIkIRUIwSHnlnI3ahs4rPbUwbq31RxZzATyckNovIk9kCj0gQExcPwOvkg0sRDKEpoqM1VXAVCg-zyRR5DSx9Rtg";
    public static String authTokenNoScope = "IAAAAKqadKEDwNENCFKAXVvsDu4wz6xQ7FVTdolwtEnsCYqGsQAAAAGGC_dsYUXuL4mlfGdNrLB6iIkx_Tm4Mx-866b2SymLvEom8vaE7N0yBAn6rET4Sc6-OcgkM-RlPMosNhgiG0gZjmEO3S6DDmcFgroXT6M3llNaWQZ-Pgi2I0aVupftMOHZGV6vsnHo2wAVSVnxr0wm3Ova_j_yOBoL_sgk-8oAv9kBBxPuE91oBVz8jL9j-fIhtm9FHvUsgDbR2nQdXFV7sUBI5eiGgB1m8nxALg-3Vg";
        // user: vasile.nume
    public static String authTokenVasileNume = "IAAAAKvH6xWz4u7Ff52dgiPn0YLup0hDnjFJgAT3rfhqv684sQAAAAF57tD8ifk1bCyWCPVoQFhquBIzgydMk-jRUPUp7TSYhKCFdhrWWfSRN8xtf6IxZtCkdpej1D1TwfjZQ6_QvHvAOjq49kpt5xUcoW0jslZSmnSDlxqVB4XGMKESFohu9579YmA0sBxofPQWtHW0TOvrrDeCgLB34_3OMdlp9BF3I56hEZEnA6I7-KsHuuLI1GtoJPvnZ9buAr_WpvYer2Xi6Y46PikHIaDkG90OrvlykQ";
        // fara-obligatii
    public static String authTokenFaraObligatii = "IAAAAPA1ku3gnXnM1gKCYs-VUSwtIVdM5tGGt5d32gT5hwtVsQAAAAE6rM6Uda0QXpdncyEeXuvPn38x5dbyipP8m-B3vY2ylzEwo7kx44q9ax7JO0pKsoZtk7KTJoyk68Nkr6X8ruhoIn8q4BKCt8XDuTC3J8_3bp1E3W1aPS-FI1nSsNyoe6z6FEkEogDYybRGTuujzjmYycM54TvAskxD23C-UUfChX6PoRQgHPUdyhr9Y11QPvUUUjcR1JRCwq-YuKemBvpuvKmZqaE1-k1OknZJyj9jwA";
    public static String authTokenNoScopeFaraObligatii = "IAAAAPJPrdstNoSMspW1-1YVRwXV3prPzIL-P6PqCwVoU3DvsQAAAAE42plPchJ7FWjK-4V3r9vfktMRDBzqDkKxEGPnWzB74KJxKzAk3hmcQSrEorXr3yid8l5s2fEwtByV_adVvpa5qWbulRIn9KMBfT8wun5W0G_ZFPa1P5MChYzKRK7gjLIuiGdHydmwQ5Ayi2dgR9jIArPwbFK-ci8BobY_y0qiB0cxZoVi0C4Bc1TBWY7xhUjVrQ5NrAQ73AxaleQiaitKcqpjlOx4yItPYG-j-XrC_A";

        // user: test_oauth_66
    public static String authToken1profile = "IAAAABjRV32q5_XDbIIIiz89FMk-jS76uYKzqbg1WpDKQq65sQAAAAGMPRYjNQ17wBLgkyZ7V6wlecI_4Qbo_r9ChPYECoqLGsytzcYrArOTAVZ2kNsqC7TCi3oGYUr2ctBGcwshlHrjyBqGSy-_v-omrPguXj1xOXGBpzWbZV8C4auOfFXxDr2q5V6mMcmDcpt6b685-ZkMQwukMBJtcRz9FZmcdOPQtgUW9sqlOvKfHjpnQI39F4fecmg0O_aHet4d7WKyN6azYkIkj4csQ-XKI2fzUipSrQ";
        // user: suport tremend
    public static String authToken0profile = "";


    //03 ----- promoLocation API input data -----

    public static String promoBaseURL = DevEnv + "/api/v3/me/msisdns/";
    public static String promoEndURL = "/promoLocations/MyAccountMobile_SubscriptionMigrationTab/offers";

        // *** User testare2 MSISDNs ***
    public static String EligibleMsisdn = "0747272489";
    public static String MigratedMsisdn = "0744544362"; //Cererea de schimbare abonament initiata in data 24/04/2017 a fost realizata in data de 24/04/2017
    public static String NotEligibleMsisdn = "0744565031";
    public static String hasOffersSuspededMsisdn = "0356131100";
    public static String noOffersSuspendedMsisdn = "0311309932";
    public static String prepayMsisdn = "0747547257";
    public static String mobileInternetMsisdn = "0754056469";
    public static String userRightsMsisdn = "0744542615"; //""0754056604";
    public static String adminRightsMsisdn = "0747272483";
    public static String notValidMsisdn = "021";
    public static String otherUserMSISDN = "0753389616"; // msisdn from totul-inclus user
    public static String primaryMSISDN = "0754056604";


    //04 ----- InProgress API input data -----
    public static String inProgressURL = DevEnv + "/api/v3/me/operations/inprogress";



    //05 ----- Cronos API input data -----

    public static String cronosPostpaid = "0744544362";
    public static String cronosPostpaidImsi = "226108001537190";
    public static String cronosPrepay = "0747547257";
    public static String cronosPrepayImsi = "226105020029374";
    public static String cronosSuspended = "0356131100";
    public static String cronosSuspendedImsi = "226102600251464";
    public static String cronosInternetMobile = "0754056461";
    public static String cronosInternetMobileImsi = "226102100300517";
    public static String cronosInvalidMsisdn = "112";
    public static String cronosInvalidImsi = "977";
    public static String cronosHybrid = "0751186833";
    public static String cronosHybridImsi = "226101720003999";

    //public static String cronosAPIbaseURL = "http://cronostest.cloud.orange.intra:8080/CronosInterface/rest/CronosData/v1/subscriber/sweetPlan/";
    public static String cronosAPIbaseURL = "http://cronos.crm.orange.intra/CronosInterface/rest/CronosData/v1/subscriber/sweetPlan/";
    public static String cronosAPIname = "rest";
    public static String cronosAPIpassword = "rest123";

    public static String cronosBaseURL = "https://www-dev.orange.ro/myaccount2/deg/api/";
    public static String cronosMidURL = "?imsi=";
    public static String cronosEndURL = "&plans=true&networkUsage=true&carrierApps=true";
    public static String cronosUsername = "network-server";
    public static String cronosPassword = "network-server-secret";
    //public static String cronosURL = InputVariables.cronosBaseURL + InputVariables.cronosMSISDN + InputVariables.cronosMidURL + InputVariables.cronosImsi + InputVariables.cronosEndURL;


    // Get Available Options
    public static String getAvailableOptionsToken = "IAAAAEXS-R5FHfNDbpnTLm4yOM1UNN9cT2FpTrVOgNQaKUl9sQAAAAEjn9wSEdhu34Wp9XZ9o8YFfLBgSww4e370_BK2sOXbarg5hPcgtlCFQvgGNu3XsshOqHFDR4k3eJfbGtfpBp_TMtZVBr_OgHnn-szsJD2OLUe0755qhKQMVSXKjuovp5hvALF8BNqX80w_u0jHZ4BtWaQ6vMeNnmyzrBHysDhXEsJfFDS2VFgXmEg2S8PDNZvZyl48XTzbS8coCY9VCzBkMmujKCzE4BUIDM82umfXqA";
    public static String getGetAvailableOptionsURL = "https://www-dev.orange.ro/myaccount/api/v3/getAvailableOptions/";
    public static String getAvailableOptionsID = "52599807";



    // Activate Option DEG
    public static String getActivateOptionMSISDN = "0745648585";
    public static String activateOptionURL = "https://www-dev.orange.ro/myaccount/api/v3/deg/api/";
    public static String activateOptionDegBody = "{ \"msisdn\" : \"" + getActivateOptionMSISDN + "\", \"imsi\" : \"226102601491780\", \"plan-id\" : 2338, \"update-time\" : \"2018-01-05T21%3A59%3A59Z\" }";


    //06 ----- Msisdn Resources input data -----
    public static String profileIdOneMsisdn = "174"; // profile ID for OCN with one MSISDN
    public static String profileIdManyMsisdn = "172"; // profile ID for OCN with 12 MSISDNs
    public static int NoOfMsisdn = 12;
    public static String msisdnResourcesUrlBase = "/api/v3/";
    public static String msisdnResourcesUrlEnd = "/msisdnResource";
    public static String otherUserProfileId = "141"; // from totul-inclus user;
    public static String invalidProfileId = "000";


    //07 ----- Contract Details API input data ----- https://jira.orange.ro/browse/MACC-4414
    public static String contractDetailsBaseURL = "/api/v3/me/contractDetails/";
    public static String contractDetailsURL = DevEnv + contractDetailsBaseURL;
    public static String contractDetailsPostpaid = "0747272489";
    public static String contractDetailsSuspended = "0356131100";
    public static String contractDetailsJustMigrated = "";
    public static String dateFormat = "[0-3][0-9]-[0-1][0-2]-[1-2][0-9][0-9][0-9]";


    //08 ----- Redeem API input data -----
    public static String redeemBaseUrl = "https://www-dev.orange.ro/myaccount2/api/v3/offers/";
    public static String redeemEndUrl = "/redeem";
    public static String redeemPrepay = "";
    public static String redeemPostpaid = "";
    public static String redeemWithOffersPostpaid = "";
    public static String redeemPostpaidOfferId = "VAL_OME25_V4";
    public static String redeemNoOffers = "";
    public static String redeemSuspended = "";
    public static String redeemInternetMobile = "";
    public static String redeemInternetMobileOfferId = "";
    public static String redeemMigratedMsisdn = "";
    public static String redeemJustMigratedMsisdn = "";
    public static String redeemInvalidOfferId = "VAL-99";
    public static String redeemOtherMsisdnOffer = "";


    //09 ----- User Profiles API input data -----
    public static String UserProfilesEndPoint = "/api/v3/profiles";


    //10 ----- Subscriber ID API input data -----
    public static String SubscribersApi = "/api/v3/subscribers/";

        // user: fara-obligatii
    public static int postpaidSubscriberID = 208963155;
    public static int prepaySubscriberID = 1246;
    public static int hybridSubscriberID = 4054857;
    public static int dthSubscriberID = 846;
    public static int fixTvSubscriberID = 7599;
    public static int fixBroadbandSubscriberID = 7600;
    public static int voipSubscriberID = 7573;


    //11 ----- Customer Info API input data
    public static String CustomerInfoApi = "/api/v3/{profileID}/customerInfo";

    public static String PrivateProfileID = "4054856";
    public static String StaffProfileID = "61352";
    public static String PrepayProfileID = "208050022";
    public static String NotAdminOnProfileID = "173";
    public static String BusinessProfileID = "13961";
    public static String NotAdministeredProfileID = "227";

}

