//package kz.itig.egov.pep.p117.commands;
//
//import kz.gov.pki.kalkan.util.encoders.Base64;
//import kz.inessoft.egov.pep.core.model.Status;
//import kz.inessoft.egov.pep.hed.documents.info.HedDocumentsInfoService;
//import kz.inessoft.egov.pep.hed.documents.info.response.DocInfo;
//import kz.inessoft.egov.pep.hed.upload.DocFileInfo;
//import kz.inessoft.egov.pep.hed.upload.DocUploadRequest;
//import kz.inessoft.egov.pep.hed.upload.DocUploadResponse;
//import kz.inessoft.egov.pep.hed.upload.HedUploadService;
//import kz.inessoft.egov.pep.history.model.ApplicationInfo;
//import kz.inessoft.egov.pep.history.model.HedLink;
//import kz.inessoft.egov.pep.history.model.StatusHistory;
//import kz.inessoft.egov.pep.history.repository.HedLinkRepository;
//import kz.inessoft.egov.pep.history.service.HistoryService;
//import kz.inessoft.egov.pep.jbpm.executor.command.event.history.UpdatingHistoryEvent;
//import kz.inessoft.egov.pep.jbpm.executor.command.util.CommandUtils;
//import kz.inessoft.egov.pep.jbpm.process.CommonProcessData;
//import kz.inessoft.egov.pep.jbpm.process.Constants;
//import kz.inessoft.egov.pep.jbpm.service.BeanFactory;
//import kz.inessoft.egov.pep.util.serialization.JAXBObjectSerializer;
//import kz.itig.egov.pep.p117.GetConfirmationResponse;
//import org.kie.internal.executor.api.CommandContext;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProcessResultsToHedLinksEvent implements UpdatingHistoryEvent {
//
//    private static Logger logger = LoggerFactory.getLogger(ProcessResultsToHedLinksEvent.class);
//
//    @Override
//    public void handle(CommandContext ctx) {
//        CommonProcessData processData = CommandUtils.findParameter(ctx, Constants.PARAM_PROCESS_DATA);
//        HistoryService historyService = BeanFactory.getInstance().getHistoryService();
//        ApplicationInfo applicationInfo = historyService.findByRequestNumber(processData.getRequestNumber());
//
//        if (!applicationInfo.getStatusHistories().isEmpty()) {
//            List<StatusHistory> statusHistories = applicationInfo.getStatusHistories();
//            for (StatusHistory sh: statusHistories) {
//                if (!sh.getSignedXml().isEmpty()) {
//                    String s = sh.getSignedXml();
//                    GetConfirmationResponse response = JAXBObjectSerializer.deserialize(s
//                            .replaceAll("<data>", "")
//                            .replaceAll("</data>", ""), GetConfirmationResponse.class);
//                    DocInfo docInfo = getDocInfoFromResponseDocuments(response, processData.getRequestNumber());
//                    if (docInfo != null) {
//                        HedLinkRepository hedLinkRepository = BeanFactory.getInstance().getHedLinkRepository();
//                        List<HedLink> hedLinks = toHedLinks(docInfo, sh);
//                        for (HedLink hedLink: hedLinks) {
//                            hedLinkRepository.persist(hedLink);
//                        }
//                    } else {
//                        sh.setStatus(Status.TECH_ERROR);
//                    }
//                    historyService.updateStatusHistory(sh);
//                    break;
//                }
//            }
//        }
//
//    }
//
////    ********************************************************************************************************
//
//    private DocInfo getDocInfoFromResponseDocuments(GetConfirmationResponse responseData, String requestNumber) {
//        DocUploadRequest request;
//        logger.info(String.format("ProcessResultsToHedLinksEvent->getDocInfoFromResponseDocuments(): %s", responseData.getApostilledDocument().getName()));
//        try {
//            logger.info(String.format("ProcessResultsToHedLinksEvent->getDocInfoFromResponseDocuments() RequestNumber: %s", requestNumber));
//            request = getFile(responseData.getApostilledDocument().getName(), requestNumber);
//            if (request != null) {
//                HedUploadService hedUploadService = BeanFactory.getInstance().getHedUploadService();
//                DocUploadResponse docUploadResponse = hedUploadService.uploadDoc(request);
//                if (docUploadResponse != null) {
//                    if (docUploadResponse.getProcessStatus().getStatus().equalsIgnoreCase("Success")) {
//                        HedDocumentsInfoService hedDocumentsInfoService = BeanFactory.getInstance().getHedDocumentsInfoService();
//                        return hedDocumentsInfoService.getDocumentBy(docUploadResponse.getDocumentId());
//                    }
//                }
//            }
//        } catch (IOException e) {
//            logger.error("ProcessResultsToHedLinksEvent->getDocInfoFromResponseDocuments() ERROR:", e);
//        }
//        return null;
//    }
//
//
////    *****************************************************************************************************************
//
//    private DocUploadRequest getFile(String attachmentContent, String requestNumber) throws IOException {
//        try {
//            byte[] fileContent = Base64.decode(attachmentContent);
//            if (fileContent.length > 0) {
//                List<DocFileInfo> files = new ArrayList<>();
//                DocFileInfo docFileInfo = new DocFileInfo();
//                docFileInfo.setContent(fileContent);
//                docFileInfo.setOrderNum(1);
//                files.add(docFileInfo);
//                DocUploadRequest request = new DocUplo adRequest();
//                request.setFiles(files);
//                request.setDocumentName(String.format("%s_%s.pdf", ConstantsP117.APP_CODE, requestNumber));
//                request.setDocumentType(P117Constants.HED_DOCUMENT_TYPE);
//                return request;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            logger.error("ProcessResultsToHedLinksEvent->getFile() ERROR:", ex);
//            return new DocUploadRequest();
//        }
//        return null;
//    }
//
//
////    ***********************************************************************************************************************
//
//    private static List<HedLink> toHedLinks(DocInfo docInfo, StatusHistory statusHistory) {
//        List<HedLink> hedLinksEntity = new ArrayList<>();
//        HedLink hedLink = new HedLink();
//        hedLink.setStatusHistory(statusHistory);
//        hedLink.setCode(null);
//        hedLink.setDownloadUrl(docInfo.getDownloadUrl());
//        hedLink.setNameEn(docInfo.getDocumentName());
//        hedLink.setNameKz(docInfo.getDocumentName());
//        hedLink.setNameRu(docInfo.getDocumentName());
//        hedLinksEntity.add(hedLink);
//        return hedLinksEntity;
//    }
//
//}
