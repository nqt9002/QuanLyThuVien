package phanmemquanlythuvien.dto;

import javax.annotation.Generated;

/**
 * TraceXeEventMap is a Querydsl bean type
 */
@Generated("com.querydsl.codegen.BeanSerializer")
public class TraceXeEventMap {

    private String packageName;

    private Short traceEventId;

    private String xeEventName;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Short getTraceEventId() {
        return traceEventId;
    }

    public void setTraceEventId(Short traceEventId) {
        this.traceEventId = traceEventId;
    }

    public String getXeEventName() {
        return xeEventName;
    }

    public void setXeEventName(String xeEventName) {
        this.xeEventName = xeEventName;
    }

}

