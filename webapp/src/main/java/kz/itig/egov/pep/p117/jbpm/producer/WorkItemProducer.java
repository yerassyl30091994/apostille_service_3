package kz.itig.egov.pep.p117.jbpm.producer;

//import kz.inessoft.egov.pep.app.p3501.jbpm.commands.*;

import kz.inessoft.egov.pep.jbpm.config.AppWorkItemHandlerProducer;
import kz.inessoft.egov.pep.jbpm.config.AsyncWorkItemHandlerProduceHelper;
import kz.inessoft.egov.pep.jbpm.executor.command.NotifyUserAboutGeneratedResultsCommand;
import kz.inessoft.egov.pep.jbpm.executor.command.ProcessGoResponseCommand;
import kz.inessoft.egov.pep.jbpm.executor.command.ProcessSignedAppNotificationCommand;
import kz.inessoft.egov.pep.jbpm.executor.command.SendApplicationToGoAsynchronouslyCommand;
import kz.inessoft.egov.pep.jbpm.executor.command.annotation.TaskName;
import org.kie.api.runtime.process.WorkItemHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Map;

/**
 * @author Ablay.Oshakbaev
 */
@ApplicationScoped
public class WorkItemProducer implements AppWorkItemHandlerProducer {

    private static final Logger LOG = LoggerFactory.getLogger(WorkItemProducer.class);

    private static Class<?>[] processCommands;
    private static Class<?>[] processWorkItemHandlers;

    @Inject
    private AsyncWorkItemHandlerProduceHelper asyncWorkItemHandlerProduceHelper;

    static {
        //J-- CHECKSTYLE:OFF
        processCommands = new Class<?>[]{
                SendApplicationToGoAsynchronouslyCommand.class,
                //StartApproveProcessCommand.class,
                NotifyUserAboutGeneratedResultsCommand.class,
//                CheckSignedApprovalResponseCommand.class,
//                ChangeStatusToWaitingApprovalCommand.class,
//                UpdateApprovalStatusCommand.class,
                ProcessGoResponseCommand.class,
//                StatusForSignCommand.class,
                ProcessSignedAppNotificationCommand.class,
//                PrepareForOnlinePayCommand.class,
//                RequestsStateViewCommand.class,
//                RejectCommand.class
//                StartProcess.class,
//                TaskTest.class,
//                GetInformation.class,
                GetInformationFromTask.class
        };

        processWorkItemHandlers = new Class<?>[]{
        };
        //J++ CHECKSTYLE:ON
    }

    @Override
    public Map<String, WorkItemHandler> getWorkItemHandlers() {
        Map<String, WorkItemHandler> result = asyncWorkItemHandlerProduceHelper.getAsyncWorkItemHandlers(processCommands);

        for (Class<?> workItemClass : processWorkItemHandlers) {
            try {
                result.put(workItemClass.getAnnotation(TaskName.class).value(), (WorkItemHandler) workItemClass.newInstance());
            } catch (IllegalAccessException | InstantiationException e) {
                LOG.error("can not create instance of " + workItemClass.getName(), e);
                throw new RuntimeException(e.getMessage(), e);
            }
        }
        return result;
    }
}
