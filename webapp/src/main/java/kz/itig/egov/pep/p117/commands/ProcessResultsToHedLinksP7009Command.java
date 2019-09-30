//package kz.itig.egov.pep.p117.commands;
//
//import kz.inessoft.egov.pep.jbpm.executor.command.AbstractCommand;
//import kz.inessoft.egov.pep.jbpm.executor.command.annotation.TaskName;
//import org.kie.internal.executor.api.CommandContext;
//import org.kie.internal.executor.api.ExecutionResults;
//
//
//@TaskName("ProcessResultsToHedLinksP117")
//public class ProcessResultsToHedLinksP7009Command extends AbstractCommand {
//    @Override
//    protected ExecutionResults doExecute(CommandContext ctx) throws Exception {
//        new ProcessResultsToHedLinksEvent().handle(ctx);
//        return contextResults(ctx);
//    }
//}
