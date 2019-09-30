package kz.itig.egov.pep.p117.jbpm.producer;

import kz.inessoft.egov.pep.jbpm.config.AppAssetProducer;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

/**
 * @author Ablay.Oshakbaev
 */
@ApplicationScoped
public class AssetProducer implements AppAssetProducer {

    @Override
    public List<String> provideAssets() {
        return Collections.singletonList("test.bpmn");
    }
}
