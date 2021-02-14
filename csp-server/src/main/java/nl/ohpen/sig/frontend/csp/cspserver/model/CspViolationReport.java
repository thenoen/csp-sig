package nl.ohpen.sig.frontend.csp.cspserver.model;

import com.fasterxml.jackson.annotation.*;

@JsonRootName("csp-report")
@JsonSubTypes({
        @JsonSubTypes.Type(value =  CspViolationReport.class, name = "csp-report")})
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class CspViolationReport {


    @JsonProperty("document-uri")
    private String documentUri;

    private String referrer;

    @JsonProperty("violated-directive")
    private String violatedDirective;

    @JsonProperty("effective-directive")
    private String effectiveDirective;

    @JsonProperty("original-policy")
    private String originalPolicy;
    
    private String disposition;
    
    @JsonProperty("blocked-uri")
    private String blockedUri;
    
    @JsonProperty("status-code")
    private Integer statusCode;
    
    @JsonProperty("script-sample")
    private String scriptSample;


    public String getDocumentUri() {
        return documentUri;
    }

    public void setDocumentUri(String documentUri) {
        this.documentUri = documentUri;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getViolatedDirective() {
        return violatedDirective;
    }

    public void setViolatedDirective(String violatedDirective) {
        this.violatedDirective = violatedDirective;
    }

    public String getEffectiveDirective() {
        return effectiveDirective;
    }

    public void setEffectiveDirective(String effectiveDirective) {
        this.effectiveDirective = effectiveDirective;
    }

    public String getOriginalPolicy() {
        return originalPolicy;
    }

    public void setOriginalPolicy(String originalPolicy) {
        this.originalPolicy = originalPolicy;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getBlockedUri() {
        return blockedUri;
    }

    public void setBlockedUri(String blockedUri) {
        this.blockedUri = blockedUri;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getScriptSample() {
        return scriptSample;
    }

    public void setScriptSample(String scriptSample) {
        this.scriptSample = scriptSample;
    }
}
