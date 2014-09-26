package nl.r0b3rtk.jmoribus.spring.steps;

import org.springframework.stereotype.Repository;

@Repository
public class MonitorBean {
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public boolean isC() {
        return c;
    }

    public void setC(boolean c) {
        this.c = c;
    }
}
