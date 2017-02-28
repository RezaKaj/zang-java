package com.zang.api.restproxies;

import com.zang.api.domain.SmsMessage;
import com.zang.api.domain.enums.HttpMethod;
import com.zang.api.domain.list.SmsMessageList;
import org.jboss.resteasy.client.ClientResponse;

import javax.ws.rs.*;

public interface SmsProxy {
    @GET
    @Path("Accounts/{AccountSid}/SMS/Messages/{SMSMessageSid}.json")
    @Produces("application/json")
    ClientResponse<SmsMessage> getSmsMessage(@PathParam("AccountSid") String accountSid,
                                             @PathParam("SMSMessageSid") String smsMessageSid);

    @GET
    @Path("Accounts/{AccountSid}/SMS/Messages.json")
    @Produces("application/json")
    ClientResponse<SmsMessageList> getSmsMessageList(
            @PathParam("AccountSid") String accountSid,
            @QueryParam(value = "To") String to,
            @QueryParam(value = "From") String from,
            @QueryParam(value = "DateSent>") String dateSentGte,
            @QueryParam(value = "DateSent<") String dateSentLt,
            @QueryParam(value = "Page") Long page,
            @QueryParam(value = "PageSize") Long pageSize
    );

    @POST
    @Path("Accounts/{AccountSid}/SMS/Messages.json")
    @Produces("application/json")
    ClientResponse<SmsMessage> sendSmsMessage(
            @PathParam("AccountSid") String accountSid,
            @FormParam(value = "To") String to,
            @FormParam(value = "From") String from,
            @FormParam(value = "Body") String body,
            @FormParam(value = "StatusCallback") String statusCallback,
            @FormParam(value = "StatusCallbackMethod") HttpMethod statusCallbackMethod,
            @FormParam(value = "AllowMultiple") Boolean allowMultiple
    );

}

