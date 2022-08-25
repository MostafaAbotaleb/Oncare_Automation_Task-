package org.oncare.restassured.utils;

import static org.oncare.restassured.apis.scenarios.id;





public class payload {
    public static String addPayload() {

        return "{\r\n"
                + "  \"id\": 0,\r\n"
                + "  \"petId\": 0,\r\n"
                + "  \"quantity\": 0,\r\n"
                + "  \"shipDate\": \"2022-08-25T19:22:14.149Z\",\r\n"
                + "  \"status\": \"placed\",\r\n"
                + "  \"complete\": true\r\n"
                + "}";

    }


    public static String addPayloadForUpdate() {
        return "{\r\n"
                + "  \"id\":\""+id+"\",\r\n"
                + "  \"petId\": 0,\r\n"
                + "  \"quantity\": 2,\r\n"
                + "  \"shipDate\": \"2022-08-25T19:22:14.149Z\",\r\n"
                + "  \"status\": \"placed\",\r\n"
                + "  \"complete\": true\r\n"
                + "}";

    }
}
