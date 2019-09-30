package kz.itig.egov.pep.p117.jbpm.producer;

import kz.inessoft.egov.pep.jbpm.executor.command.AbstractCommand;
import kz.inessoft.egov.pep.jbpm.executor.command.annotation.TaskName;
import kz.inessoft.egov.pep.jbpm.executor.command.util.CommandUtils;
import org.kie.internal.executor.api.CommandContext;
import org.kie.internal.executor.api.ExecutionResults;


@TaskName("GetInformation")
public class GetInformation extends AbstractCommand {
    @Override
    protected ExecutionResults doExecute(CommandContext commandContext) throws Exception {
        Long summ = CommandUtils.findParameter(commandContext, "input1");
        ExecutionResults executionResults = new ExecutionResults();
        executionResults.setData("output1",summ);
        return executionResults;
    }
}

//@TaskName("TaskForBill")
//public class InformationAboutBill extends AbstractCommand {
//    @Override
//    protected ExecutionResults doExecute(CommandContext commandContext) throws Exception {
//        Long bill = CommandUtils.findParameter(commandContext,"input1");
//        ExecutionResults executionResults = new ExecutionResults();
//        executionResults.setData("output1",bill);
//        return  executionResults;
//    }
//}