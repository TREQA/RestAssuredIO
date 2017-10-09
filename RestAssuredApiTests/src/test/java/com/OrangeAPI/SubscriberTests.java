package com.OrangeAPI;

import com.RestAssured.framework.InputData;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by razvan.rosescu on 10/3/2017.
 */
public class SubscriberTests {

    //--- RESPONSES ---///

    ResponseSpecification respPostpaid = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("POSTPAY")).
            expectBody("subscriberTypeDisplayName", Matchers.is("abonament")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("active")).
            expectBody("subscription.subscriptionName", Matchers.notNullValue()).
            expectBody("address", Matchers.nullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.notNullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.notNullValue()).
            build();

    ResponseSpecification respPrepay = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("PREPAY")).
            expectBody("subscriberTypeDisplayName", Matchers.is("cartela PrePay")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("active")).
            expectBody("subscription.subscriptionName", Matchers.notNullValue()).
            expectBody("address", Matchers.nullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.nullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.nullValue()).
            build();

    ResponseSpecification respHybrid = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("HYBRID")).
            expectBody("subscriberTypeDisplayName", Matchers.is("abonament de voce")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("active")).
            expectBody("subscription.subscriptionName", Matchers.notNullValue()).
            expectBody("address", Matchers.nullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.notNullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.notNullValue()).
            build();

    ResponseSpecification respDTH = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("DTH_LINE")).
            expectBody("subscriberTypeDisplayName", Matchers.is("abonament Orange TV")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("suspended")).
            expectBody("subscription.subscriptionName", Matchers.is("World HD")).
            expectBody("address", Matchers.notNullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.notNullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.notNullValue()).
            build();

    ResponseSpecification respFixedTV = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("Fixed_TV_Line")).
            expectBody("subscriberTypeDisplayName", Matchers.is("abonament Orange TV")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("active")).
            expectBody("subscription.subscriptionName", Matchers.is("optiunea Orange")).
            expectBody("address", Matchers.notNullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.notNullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.notNullValue()).
            build();

    ResponseSpecification respBroadband = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("Broadband")).
            expectBody("subscriberTypeDisplayName", Matchers.equalToIgnoringWhiteSpace("abonament de internet fix")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("active")).
            expectBody("subscription.subscriptionName", Matchers.is("optiunea Orange")).
            expectBody("address", Matchers.notNullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.notNullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.notNullValue()).
            build();

    ResponseSpecification respVoip = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectBody("subscriberType", Matchers.is("Fixed_VoIP")).
            expectBody("subscriberTypeDisplayName", Matchers.equalToIgnoringWhiteSpace("abonament de voce fixa")).
            expectBody("profileId", Matchers.notNullValue()).
            expectBody("status", Matchers.equalToIgnoringCase("active")).
            expectBody("subscription.subscriptionName", Matchers.is("Home Fix")).
            expectBody("address", Matchers.notNullValue()).
            expectBody("subscription.optionAmountEurWithVat", Matchers.notNullValue()).
            expectBody("subscription.optionAmountRonWithVat", Matchers.notNullValue()).
            build();

    ResponseSpecification resp404 = new ResponseSpecBuilder().
            expectStatusCode(404).
            expectBody("message", Matchers.equalToIgnoringCase("User doesn't have access to this profile")).
            build();

    ResponseSpecification resp400 = new ResponseSpecBuilder().
            expectStatusCode(400).
            expectBody("message", Matchers.equalToIgnoringCase("Invalid resource")).
            build();


    //--- REQUEST ---//

    public void subscriberIdAPI (String token, int subscriberID, ResponseSpecification responseSpec, String TestCaseTitle) {

        System.out.println("Test Case: " + TestCaseTitle);

        given().
                auth().preemptive().oauth2(token).
        when().
                get(InputData.DevEnv + InputData.SubscribersApi + subscriberID).
        then().
                log().all().
                body("subscriberId", Matchers.is(subscriberID)).
                spec(responseSpec);

    }


    //--- Test Cases ---//

    @Test (priority = 0)

    public void subscriberNotAdministratedByUser(){

        System.out.println("Subscriber NOT Administrated by User");

        given().
                auth().preemptive().oauth2(InputData.authTokenVasileNume).
        when().
                get(InputData.DevEnv + InputData.SubscribersApi + InputData.postpaidSubscriberID).
        then().
                log().all().
                spec(resp404);
    }


    @Test (priority = 1)

    public void postpaidSubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.postpaidSubscriberID, respPostpaid, "Postpaid Subscriber Administrated by User");
    }


    @Test (priority = 2)

    public void prepaySubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.prepaySubscriberID, respPrepay, "PrePay Subscriber Administrated by User");
    }


    @Test (priority = 3)

    public void hybridSubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.hybridSubscriberID, respHybrid, "Hybrid Subscriber Administrated by User");
    }


    @Test (priority = 4)

    public void dthSubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.dthSubscriberID, respDTH, "DTH Subscriber Administrated by User");
    }


    @Test (priority = 5)

    public void FixTvSubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.fixTvSubscriberID, respFixedTV, "Fixed_TV_Line Subscriber Administrated by User");
    }


    @Test (priority = 6)

    public void FixBroadBandSubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.fixBroadbandSubscriberID, respBroadband, "Fix Broadband Subscriber Administrated by User");
    }


    @Test (priority = 7)

    public void voipSubscriberAdministratedByUser(){

        subscriberIdAPI(InputData.authTokenFaraObligatii, InputData.voipSubscriberID, respVoip, "VoIP Subscriber Administrated by User");
    }


    @Test (priority = 8)
    public void subscriberIdIsStringOfChars() {

        System.out.println("Subscriber Id is a string of characters");

        given().
                auth().preemptive().oauth2(InputData.authTokenFaraObligatii).
        when().
                get(InputData.DevEnv + InputData.SubscribersApi + "aaa").
        then().
                log().all().
                spec(resp400);
    }


    @Test (priority = 9)
    public void noSubscriberId() {

        System.out.println("No Subscriber ID");

        given().
                auth().preemptive().oauth2(InputData.authTokenFaraObligatii).
        when().
                get(InputData.DevEnv + InputData.SubscribersApi + "").
        then().
                log().body().
                statusCode(200).
                root("msisdnList").
                body("subscriberId.size()", Matchers.is(40), "subscriberId", Matchers.notNullValue()).
                body("msisdn.size()", Matchers.is(40), "msisdn", Matchers.notNullValue()).
                body("profileId.size()", Matchers.is(40), "profileId", Matchers.notNullValue()).
                body("status.size()", Matchers.is(40), "status", Matchers.notNullValue()).
                body("subscriberTypeDisplayName.size()", Matchers.is(40), "subscriberTypeDisplayName", Matchers.notNullValue()).
                body("subscriberType.size()", Matchers.is(40), "subscriberType", Matchers.notNullValue());
    }

    @Test (priority = 10)
    public void noBearer() {

        System.out.println("Test Case: No Oauth Token Subscriber ID request");

        given().
        when().
                get(InputData.DevEnv + InputData.SubscribersApi + InputData.postpaidSubscriberID).
        then().
                log().body().statusCode(401).body("message", Matchers.equalToIgnoringCase("Unauthorized api call"));

    }

    @Test (priority = 11)
    public void noScopOauthToken() {

        System.out.println("Tesst Case: No Scope Oauth Token Subscriber ID request");

        given().
                auth().preemptive().oauth2(InputData.authTokenNoScopeFaraObligatii).
        when().
                get(InputData.DevEnv + InputData.SubscribersApi + InputData.postpaidSubscriberID).
        then().
                log().body().statusCode(401);

    }
}
