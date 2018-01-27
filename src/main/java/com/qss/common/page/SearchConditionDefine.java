package com.qss.common.page;

/**
 * Created by yuanaiqing on 26/1/18.
 */
public class SearchConditionDefine {
    private String id;
    private String displayTextResourceId;
    private String displayText;
    private String type;
    private int size;
    private boolean isList;
    private String listSource;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isList() {
        return isList;
    }

    public void setList(boolean list) {
        isList = list;
    }

    public String getListSource() {
        return listSource;
    }

    public void setListSource(String listSource) {
        this.listSource = listSource;
    }
}
