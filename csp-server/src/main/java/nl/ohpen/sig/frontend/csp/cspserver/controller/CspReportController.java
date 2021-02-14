package nl.ohpen.sig.frontend.csp.cspserver.controller;

import nl.ohpen.sig.frontend.csp.cspserver.model.CspViolationReport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/csp-report")
@RestController
public class CspReportController {

    private static final Logger logger = LoggerFactory.getLogger(CspReportController.class);

    @PostMapping
    public CspViolationReport receiveCspViolationReport(@RequestBody CspViolationReport report) {
        logger.info("==================================");
        logger.info("document-uri: {}", report.getDocumentUri());
        logger.info("referrer: {}", report.getReferrer());
        logger.info("violated-directive: {}", report.getViolatedDirective());
        logger.info("effective-directive: {}", report.getEffectiveDirective());
        logger.info("original-policy: {}", report.getOriginalPolicy());
        logger.info("disposition: {}", report.getDisposition());
        logger.info("blocked-uri: {}", report.getBlockedUri());
        logger.info("status-code: {}", report.getStatusCode());
        logger.info("script-sample: {}", report.getScriptSample());

        return report;
    }
}
