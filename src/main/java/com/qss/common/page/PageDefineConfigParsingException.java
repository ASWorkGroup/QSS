package com.qss.common.page;

/**
 * Created by yuanaiqing on 27/1/18.
 */
public class PageDefineConfigParsingException extends RuntimeException {

    public PageDefineConfigParsingException(){
        super();
    }

    public PageDefineConfigParsingException(String msg){
        super(msg);
    }

    public PageDefineConfigParsingException(String message, Throwable cause){
        super(message, cause);
    }

    public PageDefineConfigParsingException(Throwable cause){
        super(cause);
    }
}
