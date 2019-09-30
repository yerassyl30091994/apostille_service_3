package kz.itig.egov.pep.p117.config;

import kz.inessoft.egov.pep.core.config.ApplicationVerificationType;
import kz.inessoft.egov.pep.core.config.PaymentType;
import kz.inessoft.egov.pep.core.config.SmsSigningType;
import kz.inessoft.egov.pep.service.shep2.channel.common.ShepOptions;
import kz.inessoft.egov.pep.util.LocalizedResource;
import kz.inessoft.egov.pep.util.LocalizedValues;
import kz.inessoft.egov.pep.util.Options;

import java.util.HashSet;
import java.util.Set;

public class AppProperties  extends kz.inessoft.egov.pep.core.config.AppProperties {

    private static final LocalizedResource APP_CONFIG_BUNDLE = new LocalizedResource("app-p1-17-config");

    @Override
    public String getAppCode() {
        return "P1.17";
    }

    @Override
    public LocalizedValues getName() {
        return APP_CONFIG_BUNDLE.getResource("app.name");
    }

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.FREE;
    }

    @Override
    public String getGoTargetServiceName() {
        return null;
    }

    @Override
    public String getHedDocTemplateName() {
        return "P1.17";
    }

    @Override
    public String getHedStatusDocGeneratorRouteId() {
        return "R_P1.17";
    }


    @Override
    public String getHedDocTemplateVersion() {
        return null;
    }


    @Override
    public boolean isSendingToGoSync() {
        return false;
    }

    @Override
    public SmsSigningType getSmsSigningType() {
        return SmsSigningType.UNSIGNED;
    }

    @Override
    public boolean isSendToEmail() {
        return false;
    }

    @Override
    public Set<ApplicationVerificationType> getVerificationTypes() {
        return null;
    }

    @Override
    public Options getShepOptions() {
        return null;
    }

    @Override
    public String getMSignRouteId() {
        return null;
    }

    @Override
    protected void addProperties() {
        getProperties().put(AppProperties.PARAM_SKIP_SIGNING_NOTIFICATION, true);
        getProperties().put(AppProperties.SEND_THROUGH_SHEP2, true);
    }

    @Override
    public boolean saveInOldHistory() {
        return false;
    }

    @Override
    public boolean isUnAuthorizedAccessAllowed() {
        return true;
    }
}
