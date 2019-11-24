/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.twitter.feed.util;

/**
 * @author f3121097
 */
public class ConstantUtil {

    public static final String BATCH_APP = "CST_BATCH";
    public static final String SLEEP_TIMER = "sleep_timer";
    public static final String SEPARATOR_REPRESENTATION = "<\\|>";
    public static final String SEPARATOR_LITERAL = "<|>";
    public static final String CHANNELID = "CIABATCH";
    public static final String POO_CHANNEL_ID = "POOBATCH";
    public static final String TRAILER_TAG = "9";
    public static final String DATA_TAG = "5";
    public static final String HEADER_TAG = "1";
    public static final String SUCCESS_VARIABLE = "SUCCESS";
    // POR Batch
    public static final String POR_BATCH = "PORBATCH";
    public static final String CO_ID = "15";
    public static final int RECORD_TYPE = 0;
    public static final int CUSTOMER_TYPE = 1; // Becomes position 2 after TransactionID is added to the line.
    public static final int JURISTIC_UCN = 2;
    public static final int JURISTIC_NAME = 3;
    public static final int COMPANY_REG_NUMBER = 4;

    public static final String DIRECTOR_STATUS_ACTIVE = "A";
    public static final String POA_BATCH = "POA";
    public static final String POOA_BATCH = "POOA";

    // RespnseCodes
    public static final String ERROR_WS_REQ_FAILED = "500";
    public static final String SERVICE_NOT_AVAILABLE = "503";
    public static final String TMS_ERROR = "406";
    public static final String EXPIRED_SESSION = "408";


}
