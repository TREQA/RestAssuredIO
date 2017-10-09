package com.OrangeAPI;

import com.RestAssured.framework.InputData;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by razvan.rosescu on 10/5/2017.
 */
public class CustomerInfoAPI {

    //--- RESPONSES ---///

    ResponseSpecification respPrivate = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType("application/json").
            expectBody("customerType", Matchers.equalToIgnoringCase("private")).
            expectBody("prepayInfo", Matchers.nullValue()).
            expectBody("customerNumber", Matchers.notNullValue()).
            expectBody("invoiceInfo.type", Matchers.isOneOf("PAPER", "ELECTRONIC")).
            build();

    ResponseSpecification respStaff = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType("application/json").
            expectBody("customerType", Matchers.equalToIgnoringCase("staff")).
            expectBody("prepayInfo", Matchers.nullValue()).
            expectBody("customerNumber", Matchers.notNullValue()).
            expectBody("invoiceInfo.type", Matchers.isOneOf("PAPER", "ELECTRONIC")).
            build();

    ResponseSpecification respPrepay = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType("application/json").
            expectBody("customerType", Matchers.equalToIgnoringCase("prepay")).
            expectBody("prepayInfo", Matchers.notNullValue()).
            expectBody("invoice", Matchers.nullValue()).
            expectBody("invoiceInfo", Matchers.nullValue()).
            build();

    ResponseSpecification respNotAdminOnProfile = new ResponseSpecBuilder().
            expectStatusCode(403).
            expectContentType("application/json").
            expectBody("message", Matchers.equalToIgnoringCase("User does not have ADMIN role on Profile")).
            build();

    ResponseSpecification respProfileNotAdmisteredByUser = new ResponseSpecBuilder().
            expectStatusCode(404).
            expectContentType("application/json").
            expectBody("message", Matchers.equalToIgnoringWhiteSpace("Profile not found by id")).
            build();

    ResponseSpecification respBusiness = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType("application/json").
            expectBody("customerType", Matchers.equalToIgnoringCase("business")).
            expectBody("prepayInfo", Matchers.nullValue()).
            expectBody("customerNumber", Matchers.notNullValue()).
            expectBody("invoiceInfo.type", Matchers.isOneOf("PAPER", "ELECTRONIC")).
            build();


    //--- REQUEST ---//

    public void customerInfoAPI (String token, String profileID, ResponseSpecification response, String TestCaseTitle) {

        System.out.println("Test Case: " + TestCaseTitle);

        given().
                auth().preemptive().oauth2(token).
                pathParam("profileID", profileID).
        when().
                get(InputData.DevEnv + InputData.CustomerInfoApi).
        then().
                log().all().
                spec(response);
    }


    //--- Test Cases ---//

    @Test (priority =4)

    public void userAdministratesPrivateProfile () {

        customerInfoAPI(InputData.authTokenFaraObligatii, InputData.PrivateProfileID, respPrivate, "User administers Private Profile");
    }


    @Test (priority =1)

    public void userAdministratesStaffProfile () {

        customerInfoAPI(InputData.authTokenFaraObligatii, InputData.StaffProfileID, respStaff, "User administers Staff Profile");
    }


    @Test (priority =2)

    public void userAdministratesPrepayProfile () {

        customerInfoAPI(InputData.authTokenFaraObligatii, InputData.PrepayProfileID, respPrepay, "User administers Prepay Profile");
    }


    @Test (priority =3)

    public void userAdministratesBusinessProfile () {

        customerInfoAPI(InputData.authTokenVasileNume, InputData.BusinessProfileID, respBusiness, "User administers Business Profile");
    }

    @Test

    public void profileNotAdministeredByUser () {

        customerInfoAPI(InputData.authTokenVasileNume, InputData.NotAdministeredProfileID, respProfileNotAdmisteredByUser, "Profile is not Admministered by User");
    }


    @Test (priority =5)

    public void userIsNotAdminOnProfile () {

        customerInfoAPI(InputData.authTokenFaraObligatii, InputData.NotAdminOnProfileID, respNotAdminOnProfile, "User is not Admin on profile");
    }


    @Test (priority =6)

    public void customerInfoRequestWithoutOauthToken () {

        System.out.println("Test Case: No Oauth Token Customer Info Request");

        given().
                pathParam("profileID", InputData.PrivateProfileID).
        when().
                get(InputData.DevEnv + InputData.CustomerInfoApi).
        then().
                log().all().
                statusCode(401).
                contentType("application/json").
                body("message", Matchers.equalToIgnoringCase("Unauthorized api call"));
    }


    @Test (priority =7)

    public void profileIdIsAnyString () {

        System.out.println("Test Case: Customer Info Request When Profile ID is any string");

        given().
                auth().preemptive().oauth2(InputData.authTokenFaraObligatii).
                pathParam("profileID", "aaa").
        when().
                get(InputData.DevEnv + InputData.CustomerInfoApi).
                then().
                log().all().
                statusCode(400).
                body("message", Matchers.equalToIgnoringCase("Invalid resource"));
    }


    @Test (priority =8)

    public void customerInfoRequestWithNoScopeOauthToken () {

        System.out.println("Test Case: Customer Info Request With No Scope Oauth Token");

        given().
                auth().preemptive().oauth2(InputData.authTokenNoScopeFaraObligatii).
                pathParam("profileID", InputData.PrivateProfileID).
                when().
                get(InputData.DevEnv + InputData.CustomerInfoApi).
                then().
                log().all().
                statusCode(401);
    }


    @Test (priority =9)

    public void customerInfoRequestWithNoProfileID () {

        System.out.println("Test Case: Customer Info Request With No Profile ID");

        given().
                auth().preemptive().oauth2(InputData.authTokenNoScopeFaraObligatii).
                pathParam("profileID", "").
        when().
                get(InputData.DevEnv + InputData.CustomerInfoApi).
        then().
                log().all().
                statusCode(401);
    }

}
