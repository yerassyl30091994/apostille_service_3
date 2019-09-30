package kz.itig.egov.pep.p117.rest;

import kz.inessoft.egov.pep.jbpm.process.ApplicationProcessStarter;
import kz.inessoft.egov.pep.service.shep2.channel.common.SendMessageRequest;
import kz.inessoft.egov.pep.service.shep2.channel.common.ShepOptions;
import kz.inessoft.egov.pep.service.shep2.channel.sync.SyncShep2Service;
import kz.inessoft.egov.pep.util.Options;
import kz.itig.egov.pep.p117.GetConfirmation;
import kz.itig.egov.pep.p117.GetConfirmationResponse;
import org.kie.api.runtime.KieSession;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.HashMap;
import java.util.Map;


@Path("/app")
public class TestRest {

    @Inject
    private SyncShep2Service syncShep2Service;

    @Inject
    private ApplicationProcessStarter applicationProcessStarter;

//    @GET
//    @Path("/restProcess")
//
//    public GetConfirmationResponse test(@QueryParam("id") String id, @QueryParam("code") String code) {
//
//        GetConfirmation confirmation = new GetConfirmation();
//
//        confirmation.setApostilleCode(code);
//        confirmation.setSppApostilledDocumentId(id);
//
//        SendMessageRequest sendMessageRequest = new SendMessageRequest();
//        sendMessageRequest.setData(confirmation);
//        sendMessageRequest.setTargetService("ApostilPEPServiceSync");
//
//        Options shepOptions = new ShepOptions.Builder().wrapByTagData().build();
//
//        GetConfirmationResponse response = syncShep2Service.sendMessage(sendMessageRequest, GetConfirmationResponse.class, shepOptions);
//        return response;
//    }

//    @GET
//    @Path("/jbpm")
//    public void testJbpm(@QueryParam(value = "price") Long price) {
//        KieSession kieSession = applicationProcessStarter.getKieSession();
//        Map<String,Object> params = new HashMap<>();
//        params.put("price",price);
//        kieSession.startProcess("test.TestProcess",params);
//
//    }

//    @GET
//    @Path("/jbpm")
//    public void testJbpm(@QueryParam(value = "price") Long price) {
//        KieSession kieSession = applicationProcessStarter.getKieSession();
//        Map<String, Object> params = new HashMap<>();
//        params.put("price", price);
//        kieSession.startProcess("defaultPackage.New_Process", params);
//    }


    @GET
    @Path("/jbpm")

    public void testJbpm(@QueryParam("id") String id, @QueryParam("code") String code) {
        KieSession kieSession = applicationProcessStarter.getKieSession();
        Map<String, Object> params = new HashMap<>();
        params.put("sppDocumentId", id);
        params.put("sppDocumentCode", code);
        kieSession.startProcess("defaultPackage.New_Process", params);


    }


}
