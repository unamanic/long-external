package org.flowable.example.vanitypress.delegates;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.example.vanitypress.config.VanityConfig;
import org.springframework.stereotype.Component;

@Component
public class PrintServicePrep implements JavaDelegate {

    private final VanityConfig vanityConfig;

    public PrintServicePrep(VanityConfig vanityConfig) {
        this.vanityConfig = vanityConfig;
    }

    @Override
    public void execute(DelegateExecution execution) {
        String callbackUrl = String.format("%s/print/%s", vanityConfig.getBaseUrl(), execution.getProcessInstanceId());
        execution.setVariable("callbackUrl", callbackUrl);
        execution.setVariable("printUrl", vanityConfig.getPrintUrl());
    }
}
