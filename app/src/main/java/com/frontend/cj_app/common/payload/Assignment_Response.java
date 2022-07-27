package com.frontend.cj_app.common.payload;

import com.frontend.cj_app.common.model.AssingMentList;

public class Assignment_Response {
    private AssingMentList first;
    private AssingMentList mid;
    private AssingMentList end;
    private String REPL_CD;
    private String REPL_MSG;

    public Assignment_Response(){}

    public Assignment_Response(AssingMentList first, AssingMentList mid, AssingMentList end, String REPL_CD, String REPL_MSG) {
        this.first = first;
        this.mid = mid;
        this.end = end;
        this.REPL_CD = REPL_CD;
        this.REPL_MSG = REPL_MSG;
    }

    public AssingMentList getFirst() {
        return first;
    }

    public void setFirst(AssingMentList first) {
        this.first = first;
    }

    public AssingMentList getMid() {
        return mid;
    }

    public void setMid(AssingMentList mid) {
        this.mid = mid;
    }

    public AssingMentList getEnd() {
        return end;
    }

    public void setEnd(AssingMentList end) {
        this.end = end;
    }

    public String getREPL_CD() {
        return REPL_CD;
    }

    public void setREPL_CD(String REPL_CD) {
        this.REPL_CD = REPL_CD;
    }

    public String getREPL_MSG() {
        return REPL_MSG;
    }

    public void setREPL_MSG(String REPL_MSG) {
        this.REPL_MSG = REPL_MSG;
    }
}
