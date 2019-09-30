package kz.itig.egov.pep.p117.jbpm.producer;

import kz.inessoft.egov.pep.jbpm.executor.command.AbstractCommand;
import kz.inessoft.egov.pep.jbpm.executor.command.annotation.TaskName;
import kz.inessoft.egov.pep.jbpm.executor.command.util.CommandUtils;
import org.kie.internal.executor.api.CommandContext;
import org.kie.internal.executor.api.ExecutionResults;

@TaskName("TaskForHaveSppDocument")
public class GetInformationFromTask extends AbstractCommand {
    @Override
    protected ExecutionResults doExecute(CommandContext commandContext) throws Exception {
        String sppDocumentId = CommandUtils.findParameter(commandContext,"sppDocumentId");
        String sppDocumentCode = CommandUtils.findParameter(commandContext,"sppDocumentCode");
        ExecutionResults executionResults = new ExecutionResults();
        executionResults.setData("sppDocumentId",sppDocumentId);
        executionResults.setData("sppDocumentCode",sppDocumentCode);
        return  executionResults;
    }
}
