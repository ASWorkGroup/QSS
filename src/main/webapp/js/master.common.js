/**
 * Created by yuanaiqing on 27/1/18.
 */


var createRowDiv= function(parentDiv, id, style){
    var newdiv=$('<div></div>');
    newdiv.attr('id',id);
    if (style != null) {
        newdiv.addClass(style);
    }
    else {
        newdiv.addClass("row");
    }

    parentDiv.append(newdiv);
    return newdiv;
}

var createColumnDiv= function(parentDiv, id, style){
    var newdiv=$('<div></div>');
    newdiv.attr('id',id);
    if (style != null) {
        newdiv.addClass(style);
    }

    parentDiv.append(newdiv);
    return newdiv;
}

var createTextbox= function(parentDiv, id, name, style){
    var newTextbox=$('<input></input>');
    newTextbox.attr('id',id);
    newTextbox.attr('name',name);
    if (style != null) {
        newTextbox.addClass(style);
    }

    parentDiv.append(newTextbox);
    return newTextbox;
}

var createSpan= function(parentDiv, text, style) {
    var newspan = $('<span></span>');
    newspan.html(text + ":&nbsp;");
    if (style != null) {
        newspan.addClass(style);
    }

    parentDiv.append(newspan);
    return newspan;
}

$(document).ready(function(){
    $.get("/master/sysuser/portal/define/searchcondition.do", function (data, textStatus, jqXHR){
        var searchConditionSize = data.length;
        var i=0;
        $.each(data, function(id, define){
            if (define.type == "string"){
                var parentDiv = $("#searchCondition");
                var rowDiv = createColumnDiv(parentDiv, "row"+ i, "row")
                var txtDiv = createColumnDiv(rowDiv, define.id, "col-md-1")
                var itemDiv = createColumnDiv(rowDiv, define.id, "col-md-1")
                createSpan(txtDiv, define.displayText);
                createTextbox(itemDiv, define.id, define.id);
            }

            i++;
        });
    }, "json");
});


function doQuery(){
    $.post("/master/sysuser/portal/list/query.do", $('form1').serialize(), function (data, textStatus, jqXHR){
        alert('aa');
    });
}