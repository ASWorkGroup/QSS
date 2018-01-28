package com.qss.common.page;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public class ListItemDefine {
    private String id;
    private boolean display;
    private String displayTextResourceId;
    private String displayText;
    private int size;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayTextResourceId() {
        return displayTextResourceId;
    }

    public void setDisplayTextResourceId(String displayTextResourceId) {
        this.displayTextResourceId = displayTextResourceId;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }
}
